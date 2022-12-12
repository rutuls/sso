package com.datdyn.platform.sxsdk.models.Actions.StopSharingResource;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopSharingResource {
    @JsonProperty("EnableStopSharingSource")
    Boolean enableStopSharingResource;
    @JsonProperty("Pause")
    Integer pause;
}
