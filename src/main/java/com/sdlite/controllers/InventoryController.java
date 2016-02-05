package com.sdlite.controllers;


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

import java.util.List;

@Controller
public class InventoryController {

    @Autowired
    InventoryPagingRepository inventoryRepository;

    @RequestMapping("/inventory")
    public String tickets(Model model, Pageable pageable) {
        return "redirect:/inventory/page/1";
    }

    @RequestMapping("/inventory/page/{pageNumber}")
    public String ticketsPaging(@PathVariable Integer pageNumber, Model model) {
        Page<InventoryItem> currentResults = inventoryRepository.findAll(new PageRequest(pageNumber - 1, 20));
        PagingHelper.newInstance().createPagingModel(model,currentResults);
        model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
        return "inventory";
    }

    @RequestMapping(value = "/inventory/{itemId}", method = RequestMethod.GET)
    public String showItem(@PathVariable Long itemId, Model model) {
        model.addAttribute("item", inventoryRepository.findOne(itemId));
        return "inventory_item";
    }

}
