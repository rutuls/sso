package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Batch1;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch1 {
    @JsonProperty("EnableBatch")
    Boolean enableBatch;
    @JsonProperty("BatchFile")
    String batchFile;
    @JsonProperty("Pause")
    Integer pause;
}
