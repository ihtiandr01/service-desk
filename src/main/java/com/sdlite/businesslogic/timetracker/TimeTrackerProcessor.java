package com.sdlite.businesslogic.timetracker;

import com.sdlite.domain.entities.TimeTrackerRecord;
import com.sdlite.domain.repositaries.TimeTrackerRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

import static com.sdlite.businesslogic.timetracker.TimeRecordStatus.*;

@Component
public class TimeTrackerProcessor {

  @Autowired
  private TimeTrackerRecordRepository timeTrackerRecordRepository;

  public void startTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (NEW.getValue().equals(task.getStatus()) || PAUSED.getValue().equals(task.getStatus())) {
      task.setStatus(IN_PROGRESS.getValue());
      task.setStartDate(getCurrentTime());
      timeTrackerRecordRepository.save(task);
    }
  }

  public void pauseTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (IN_PROGRESS.getValue().equals(task.getStatus())) {
      task.setStatus(PAUSED.getValue());
      task.setEndDate(getCurrentTime());
      task.setDuration(getDuration(task));
      timeTrackerRecordRepository.save(task);
    }
  }

  public void endTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    task.setEndDate(getCurrentTime());
    if (IN_PROGRESS.getValue().equals(task.getStatus())) {
      task.setDuration(getDuration(task));
    }
    task.setStatus(ENDED.getValue());
    timeTrackerRecordRepository.save(task);
  }

  public void deleteTask(long taskId) {
    TimeTrackerRecord task = timeTrackerRecordRepository.findOne(taskId);
    if (ENDED.getValue().equals(task.getStatus())) {
      timeTrackerRecordRepository.delete(taskId);
    }
  }

  private Timestamp getCurrentTime() {
    return new Timestamp(System.currentTimeMillis());
  }

  private Timestamp getDuration(TimeTrackerRecord task) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.MILLISECOND, 0);
    long oldDuration = task.getDuration() != null ? task.getDuration().getTime() : cal.getTimeInMillis();
    long duration = oldDuration + task.getEndDate().getTime() - task.getStartDate().getTime();
    return new Timestamp(duration);
  }

}
