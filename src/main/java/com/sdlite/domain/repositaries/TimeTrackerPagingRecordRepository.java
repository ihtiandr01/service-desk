package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.TimeTrackerRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeTrackerPagingRecordRepository extends PagingAndSortingRepository<TimeTrackerRecord, Long> {
  Page<TimeTrackerRecord> findByUserId(long userId, Pageable pageable);
}
