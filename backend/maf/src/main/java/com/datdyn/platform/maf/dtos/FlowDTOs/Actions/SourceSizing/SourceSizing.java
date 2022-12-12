package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.SourceSizing;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SourceSizing {
    @JsonProperty("EnableSourceSizing")
    Boolean enableSourceSizing;
    @JsonProperty("Source")
    private String source; // TO BE DELTED
    @JsonProperty("Pause")
    Integer pause;
}
