package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataOnce;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CopyDataOnce {
    @JsonProperty("EnableCopyDataOnce")
    Boolean enableCopyDataOnce;
    @JsonProperty("Pause")
    Integer pause;
}
