package com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions;

import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.CIFSAttributesReplication.CIFSAttributesReplication;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.CIFSSecurityReplication.CIFSSecurityReplication;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.GeneralOptions.GeneralOptions;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.NFSExtentedAttributes.NFSExtentedAttributes;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.NFSSecurityReplication.NFSSecurityReplication;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationFilters.ReplicationFilters;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.ReplicationScripting.ReplicationScripting;
import com.datdyn.platform.maf.dtos.FlowDTOs.ReplicationOptions.UniversalDataEngine.UniversalDataEngine;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplicationOptions {
    @JsonProperty("GeneralOptions")
    GeneralOptions generalOptions;
    @JsonProperty("ReplicationFilters")
    ReplicationFilters replicationFilters;
    @JsonProperty("UniversalDataEngine")
    UniversalDataEngine universalDataEngine;
    @JsonProperty("ReplicationScripting")
    ReplicationScripting replicationScripting;
    @JsonProperty("CIFSSecurityReplication")
    CIFSSecurityReplication cIFSSecurityReplication;
    @JsonProperty("CIFSAttributesReplication")
    CIFSAttributesReplication cIFSAttributesReplication;
    @JsonProperty("NFSSecurityReplication")
    NFSSecurityReplication nFSSecurityReplication;
    @JsonProperty("NFSExtendedAttributes")
    NFSExtentedAttributes nFSExtentedAttributes;
}
