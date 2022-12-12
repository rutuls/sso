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
public class NFSSecurityReplication {
    @JsonProperty("ModeSetUid")
    NFSSecurityGeneric modeSetUid;
    @JsonProperty("ModeSetGid")
    NFSSecurityGeneric modeSetGid;
    @JsonProperty("ModeStickyBit")
    NFSSecurityGeneric modeStickyBit;
    @JsonProperty("ModeReadPermissionOwner")
    NFSSecurityGeneric modeReadPermissionOwner;
    @JsonProperty("ModeReadPermissionGroup")
    NFSSecurityGeneric modeReadPermissionGroup;
    @JsonProperty("ModeReadPermissionOther")
    NFSSecurityGeneric ModeReadPermissionOther;
    @JsonProperty("ModeWritePermissionOwner")
    NFSSecurityGeneric modeWritePermissionOwner;
    @JsonProperty("ModeWritePermissionGroup")
    NFSSecurityGeneric modeWritePermissionGroup;
    @JsonProperty("ModeWritePermissionOther")
    NFSSecurityGeneric modeWritePermissionOther;
    @JsonProperty("ModeExecutePermissionOwner")
    NFSSecurityGeneric modeExecutePermissionOwner;
    @JsonProperty("ModeExecutePermissionGroup")
    NFSSecurityGeneric modeExecutePermissionGroup;
    @JsonProperty("ModeExecutePermissionOther")
    NFSSecurityGeneric modeExecutePermissionOther;
}
