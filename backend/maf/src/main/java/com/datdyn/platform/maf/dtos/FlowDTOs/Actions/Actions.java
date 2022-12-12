package com.datdyn.platform.maf.dtos.FlowDTOs.Actions;

import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Batch1.Batch1;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.Batch2.Batch2;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataOnce.CopyDataOnce;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.CopyDataUntil.CopyDataUntil;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.PreventUserConnection.PreventUserConnection;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.SourceSizing.SourceSizing;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.StopSharingResource.StopSharingResource;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.UpdateAutomountOrDFS.UpdateAutomountOrDFS;
import com.datdyn.platform.maf.dtos.FlowDTOs.Actions.VerifyReplication.VerifyReplication;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actions {
    @JsonProperty("Batch1")
    Batch1 batch1;
    @JsonProperty("SourceSizing")
    SourceSizing sourceSizing;
    @JsonProperty("CopyDataOnce")
    CopyDataOnce copyDataOnce;
    @JsonProperty("CopyDataUntil")
    CopyDataUntil copyDataUntil;
    @JsonProperty("UpdateAutomountOrDFS")
    UpdateAutomountOrDFS updateAutomountOrDFS;
    @JsonProperty("PreventUserConnection")
    PreventUserConnection preventUserConnection;
    @JsonProperty("VerifyReplication")
    VerifyReplication verifyReplication;
    @JsonProperty("StopSharingSource")
    StopSharingResource stopSharingResource;
    @JsonProperty("Batch2")
    Batch2 batch2;
}