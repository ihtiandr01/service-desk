package com.sdlite.controllers;


import com.sdlite.configuration.ConfigurationStorage;
import com.sdlite.domain.entities.InventoryItem;
import com.sdlite.domain.repositaries.InventoryPagingRepository;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.sdlite.configuration.ConfigurationKeys.SD_CONF_DATE_TIME_MASK_KEY;

@Controller
public class InventoryController {

  @Autowired
  InventoryPagingRepository inventoryRepository;
  @Autowired
  private ConfigurationStorage configurationStorage;

  @RequestMapping("/inventory")
  public String tickets(Model model, Pageable pageable) {
    return "redirect:/inventory/page/1";
  }

  @RequestMapping("/inventory/page/{pageNumber}")
  public String ticketsPaging(@PathVariable Integer pageNumber, Model model) {
    Page<InventoryItem> currentResults = inventoryRepository.findAll(new PageRequest(pageNumber - 1, 20));
    PagingHelper.newInstance().createPagingModel(model, currentResults);
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "inventory/inventory";
  }

  @RequestMapping(value = "/inventory/{itemId}", method = RequestMethod.GET)
  public String showItem(@PathVariable Long itemId, Model model) {
    model.addAttribute("item", inventoryRepository.findOne(itemId));
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "inventory/inventory_item";
  }

}
