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
public class ListAllFilesOptions {
    @JsonProperty("ShowChecksum")
    Boolean showChecksum;
    @JsonProperty("ShowOnlyChecksumMismatches")
    Boolean showOnlyChecksumMismatches;
    @JsonProperty("ShowSecurityInfo")
    Boolean showSecurityInfo;
    @JsonProperty("ShowACLInformation")
    Boolean showACLInformation;
}
