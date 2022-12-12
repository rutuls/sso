package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.GeneralOptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetryFailOpenFile {
    @JsonProperty("Tries")
    Integer tries;
    //@JsonFormat(pattern = "SECONDS", shape = JsonFormat.Shape.STRING)
    @JsonProperty("RetryInterval")
    String retryInterval;
    //@JsonFormat(pattern = "SECONDS", shape = JsonFormat.Shape.STRING)
    @JsonProperty("CancelAfterElapse")
    String cancelAfterElapse;
}
