package com.datdyn.platform.sxsdk.models.PolicyRun;

import java.util.List;

import com.datdyn.platform.sxsdk.models.PolicyRun.Batch1.Batch1Menifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.Batch2.Batch2Menifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.CopyDataOnce.CopyDataOnceMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.CopyDataUntil.CopyDataUntilMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.PreventUserConnection.PreventUserConnectionMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.SourceSizing.SourceSizingMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.StopSharingSource.StopSharingSourceMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.UpdateAutomountOrDFS.UpdateAutomountOrDFSMenifest;
import com.datdyn.platform.sxsdk.models.PolicyRun.VerifyReplication.VerifyReplicationMenifest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manifests {
    @JsonProperty("Batch1")
    private List<Batch1Menifest> batch1;
    @JsonProperty("SourceSizing")
    private List<SourceSizingMenifest> sourceSizing;
    @JsonProperty("CopyDataOnce")
    private List<CopyDataOnceMenifest> copyDataOnce;
    @JsonProperty("CopyDataUntil")
    private List<CopyDataUntilMenifest> copyDataUntil;
    @JsonProperty("UpdateAutomountOrDFS")
    private List<UpdateAutomountOrDFSMenifest> updateAutomountOrDFS;
    @JsonProperty("PreventUserConnection")
    private List<PreventUserConnectionMenifest> preventUserConnection;
    @JsonProperty("VerifyReplication")
    private List<VerifyReplicationMenifest> verifyReplication;
    @JsonProperty("StopSharingSource")
    private List<StopSharingSourceMenifest> stopSharingResource;
    @JsonProperty("Batch2")
    private List<Batch2Menifest> batch2;
}
