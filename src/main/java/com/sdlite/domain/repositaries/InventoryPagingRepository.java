package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.InventoryItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InventoryPagingRepository extends PagingAndSortingRepository<InventoryItem, Long> {
}
