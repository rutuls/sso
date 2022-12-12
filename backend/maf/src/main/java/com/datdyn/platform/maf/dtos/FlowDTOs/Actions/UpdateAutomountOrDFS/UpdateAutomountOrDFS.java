package com.datdyn.platform.maf.dtos.FlowDTOs.Actions.UpdateAutomountOrDFS;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAutomountOrDFS {
    @JsonProperty("EnableUpdateAutomountOrDFS")
    Boolean enableUpdateAutomountOrDFS;
    @JsonProperty("UpdateMethod")
    Integer updateMethod;
    @JsonProperty("Pause")
    Integer pause;
    @JsonProperty("DFSNamespaces")
    List<String> dfsNamespaces;
    @JsonProperty("AutomountPaths")
    List<String> automountPaths;
}
