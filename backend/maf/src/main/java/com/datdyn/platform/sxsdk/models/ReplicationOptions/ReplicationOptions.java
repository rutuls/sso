package com.datdyn.platform.sxsdk.models.ReplicationOptions;

import com.datdyn.platform.sxsdk.models.ReplicationOptions.CIFSAttributesReplication.CIFSAttributesReplication;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.CIFSSecurityReplication.CIFSSecurityReplication;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.GeneralOptions.GeneralOptions;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.NFSExtentedAttributes.NFSExtentedAttributes;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.NFSSecurityReplication.NFSSecurityReplication;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.ReplicationFilters.ReplicationFilters;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.ReplicationScripting.ReplicationScripting;
import com.datdyn.platform.sxsdk.models.ReplicationOptions.UniversalDataEngine.UniversalDataEngine;
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
