package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationScripting;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplicationScripting {
    @JsonProperty("Before")
    Before efore;
    @JsonProperty("After")
    After after;
}
