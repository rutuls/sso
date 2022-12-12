package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.CIFSSecurityReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslateSID {
    @JsonProperty("CreateLocalGroup")
    Boolean createlocalGroup;
    @JsonProperty("UnableToTranslate")
    Integer unableToTranslate;
}
