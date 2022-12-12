package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.NFSSecurityReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NFSSecurityGeneric {
    @JsonProperty("m_SO")
    Integer m_SO;
    @JsonProperty("m_bCompare")
    Boolean m_bCompare;
}
