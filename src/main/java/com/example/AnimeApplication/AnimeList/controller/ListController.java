package com.example.AnimeApplication.AnimeList.controller;

import com.example.AnimeApplication.AnimeList.model.ListItem;
import com.example.AnimeApplication.AnimeList.service.ListItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/")
public class ListController {

    private final ListItemService listItemService;

    @Autowired
    public ListController(ListItemService listItemService) {
        this.listItemService = listItemService;
    }

    @GetMapping
    public String getIndex(Model model) {
        List<ListItem> items = listItemService.getAllItems();
        model.addAttribute("items", items);
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(ListItem listItem) {
        listItemService.saveItem(listItem);
        return "redirect:/?redirect=true";
    }

    @PostMapping("/removeItem/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        listItemService.deleteItem(itemId);
        return "redirect:/?redirect=true";
    }
}
