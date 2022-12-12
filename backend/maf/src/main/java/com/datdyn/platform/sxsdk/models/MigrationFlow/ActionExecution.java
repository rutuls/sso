package com.datdyn.platform.sxsdk.models.MigrationFlow;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionExecution {
    @JsonProperty("Order")
    Integer order;
    @JsonProperty("Action")
    String action;
}