
package com.example.AnimeApplication.AnimeList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AnimeApplication.AnimeList.model.ListItem;
import com.example.AnimeApplication.AnimeList.repository.ListItemRepository;

import java.util.List;

@Service
public class ListItemService {

    private final ListItemRepository listItemRepository;

    @Autowired
    public ListItemService(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    public List<ListItem> getAllItems() {
        return listItemRepository.findAll();
    }

    public void saveItem(ListItem listItem) {
        listItemRepository.save(listItem);
    }

    public void deleteItem(Long itemId) {
        listItemRepository.deleteById(itemId);
    }
}