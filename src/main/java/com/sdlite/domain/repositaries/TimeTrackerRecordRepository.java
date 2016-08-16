package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.TimeTrackerRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeTrackerRecordRepository extends CrudRepository<TimeTrackerRecord, Long> {
  List<TimeTrackerRecord> findByName(String name);

}
