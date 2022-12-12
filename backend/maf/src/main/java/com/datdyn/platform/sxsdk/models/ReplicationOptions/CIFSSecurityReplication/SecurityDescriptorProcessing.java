package com.datdyn.platform.sxsdk.models.ReplicationOptions.CIFSSecurityReplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityDescriptorProcessing {
    @JsonProperty("ProcessSID")
    Boolean processSID;
    @JsonProperty("RemoveInvalidSIDs")
    Boolean removeInvalidSIDs;
    @JsonProperty("UseSIDMappingRules")
    Boolean useSIDMappingRules;
    @JsonProperty("HandleSID")
    Integer handleSID;
    @JsonProperty("TranslateSID")
    TranslateSID translateSID;
    @JsonProperty("AllowLossOfSecurity")
    Boolean allowLossOfSecurity;
}
