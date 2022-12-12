package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationFilters;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileAgeFilter {
    @JsonProperty("AgeFilterType")
    Integer ageFilterType;
    @JsonProperty("AgeFilterTimeType")
    Integer ageFilterTimeType;
    @JsonProperty("Days")
    Integer days;
}
