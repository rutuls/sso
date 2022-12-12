package com.datdyn.platform.maf.dtos.FlowDTOs.MigrationSchedule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {
    @JsonProperty("WeeklyInterval")
    Integer weeklyInterval;
    @JsonProperty("ActiveDays")
    List<Integer> activeDays;
    @JsonProperty("ScheduleType")
    String scheduleType;
    @JsonProperty("StartTime")
    String startTime;
    @JsonProperty("StopTime")
    String endTime;
    @JsonProperty("MinuteInterval")
    Integer minuteInterval;
    @JsonProperty("HourlyInterval")
    Integer hourlyInterval;
    @JsonProperty("DailyInterval")
    Integer dailyInterval;
}