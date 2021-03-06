package com.sdlite.controllers;


import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class PagingHelper {
  public void createPagingModel(Model model, Page currentResults) {
    model.addAttribute("currentResults", currentResults);
    int current = currentResults.getNumber() + 1;
    int begin = Math.max(1, current - 5);
    int end = Math.min(begin + 10, currentResults.getTotalPages());
    if(end == 0) end = 1;
    model.addAttribute("beginIndex", begin);
    model.addAttribute("endIndex", end);
    model.addAttribute("currentIndex", current);
  }

  public static PagingHelper newInstance() {
    PagingHelper helper = new PagingHelper();
    return helper;
  }
}
