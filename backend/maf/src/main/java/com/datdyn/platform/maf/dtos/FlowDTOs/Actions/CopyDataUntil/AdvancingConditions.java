package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataUntil;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvancingConditions {
    @JsonProperty("AdvanceToNextAction")
    Integer advanceToNextAction;
    @JsonProperty("AfterDateTime")
    LocalDateTime afterDateTime;
    @JsonProperty("DoNotAdvanceIfCopyDataHasErrors")
    Boolean doNotAdvanceIfCopyDataHasErrors;
}
