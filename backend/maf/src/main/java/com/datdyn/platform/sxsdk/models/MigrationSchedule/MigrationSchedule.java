package com.datdyn.platform.sxsdk.models.MigrationSchedule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MigrationSchedule {
    @JsonProperty("UseSchedule")
    Boolean useSchedule;
    @JsonProperty("Schedules")
    List<Schedule> schedules;
}