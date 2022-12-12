package com.datdyn.platform.sxsdk.models.ReplicationOptions.NFSSecurityReplication;

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
    NFSSecurityGenericClass modeSetUid;
    @JsonProperty("ModeSetGid")
    NFSSecurityGenericClass modeSetGid;
    @JsonProperty("ModeStickyBit")
    NFSSecurityGenericClass modeStickyBit;
    @JsonProperty("ModeReadPermissionOwner")
    NFSSecurityGenericClass modeReadPermissionOwner;
    @JsonProperty("ModeReadPermissionGroup")
    NFSSecurityGenericClass modeReadPermissionGroup;
    @JsonProperty("ModeReadPermissionOther")
    NFSSecurityGenericClass ModeReadPermissionOther;
    @JsonProperty("ModeWritePermissionOwner")
    NFSSecurityGenericClass modeWritePermissionOwner;
    @JsonProperty("ModeWritePermissionGroup")
    NFSSecurityGenericClass modeWritePermissionGroup;
    @JsonProperty("ModeWritePermissionOther")
    NFSSecurityGenericClass modeWritePermissionOther;
    @JsonProperty("ModeExecutePermissionOwner")
    NFSSecurityGenericClass modeExecutePermissionOwner;
    @JsonProperty("ModeExecutePermissionGroup")
    NFSSecurityGenericClass modeExecutePermissionGroup;
    @JsonProperty("ModeExecutePermissionOther")
    NFSSecurityGenericClass modeExecutePermissionOther;
}
