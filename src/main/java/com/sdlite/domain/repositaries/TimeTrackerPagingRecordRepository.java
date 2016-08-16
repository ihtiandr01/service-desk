package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.TimeTrackerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TimeTrackerPagingRecordRepository extends PagingAndSortingRepository<TimeTrackerRecord, Long> {

}
