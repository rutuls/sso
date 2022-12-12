package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataUntil;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CopyDataUntil {
    @JsonProperty("EnableCopyDataUntil")
    Boolean enableCopyDataUntil;
    @JsonProperty("AutoRun")
    Boolean autoRun;
    @JsonProperty("AdvancingConditions")
    AdvancingConditions advancingConditions;
}
