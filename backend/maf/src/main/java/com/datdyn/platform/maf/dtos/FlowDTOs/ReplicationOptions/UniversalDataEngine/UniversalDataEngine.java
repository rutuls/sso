package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.UniversalDataEngine;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversalDataEngine {
    @JsonProperty("DataEngineChoice")
    Integer dataEngineChoice;
    @JsonProperty("DataEngineGroup")
    String dataEngineGroup;
    @JsonProperty("DataEngineMachineName")
    String dataEngineMachineName;
}
