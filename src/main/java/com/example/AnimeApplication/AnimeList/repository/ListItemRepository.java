package com.example.AnimeApplication.AnimeList.repository;

import com.example.AnimeApplication.AnimeList.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {
}