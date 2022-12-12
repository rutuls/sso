package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationFilters;

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
public class ReplicationFilters {
    @JsonProperty("ExcludePaths")
    List<String> excludePaths;
    @JsonProperty("ExcludeFiles")
    List<String> excludeFiles;
    @JsonProperty("IncludePaths")
    List<String> includePaths;
    @JsonProperty("IncludeFiles")
    List<String> includeFiles;
    @JsonProperty("FileAgeFilter")
    FileAgeFilter fileAgeFilter;
}
