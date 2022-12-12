package com.datdyn.platform.sxsdk.models.Actions.PreventUserConnection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreventUserConnection {
    @JsonProperty("EnablePreventUserConnection")
    Boolean enablePreventUserConnection;
    @JsonProperty("RenameShare")
    Boolean renameShare;
    @JsonProperty("AppendMacro")
    String appendMacro;
    @JsonProperty("Pause")
    Integer pause;
}
