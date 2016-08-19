package com.sdlite.businesslogic.timetracker;

import com.sdlite.domain.entities.TimeTrackerRecord;
import com.sdlite.domain.repositaries.TimeTrackerRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.sdlite.businesslogic.timetracker.TimeRecordStatus.*;

@Component
public class TimeTrackerProcessor {

  @Autowired
  private TimeTrackerRecordRepository timeTrackerRecordRepository;

  public void startTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (NEW.getValue().equals(task.getStatus()) || PAUSED.getValue().equals(task.getStatus())) {
      task.setStatus(IN_PROGRESS.getValue());
      timeTrackerRecordRepository.save(task);
    }
  }

  public void pauseTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (IN_PROGRESS.getValue().equals(task.getStatus())) {
      task.setStatus(PAUSED.getValue());
      timeTrackerRecordRepository.save(task);
    }
  }

  public void endTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    task.setStatus(ENDED.getValue());
    timeTrackerRecordRepository.save(task);
  }

  public void deleteTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (ENDED.getValue().equals(task.getStatus())) {
      timeTrackerRecordRepository.delete(taskId);
    }
  }


}
