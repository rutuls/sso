package com.datdyn.platform.sxsdk.models.Actions.VerifyReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyReplication {
    @JsonProperty("EnableVerifyReplication")
    Boolean enableVerifyReplication;
    @JsonProperty("Pause")
    Integer pause;
}
