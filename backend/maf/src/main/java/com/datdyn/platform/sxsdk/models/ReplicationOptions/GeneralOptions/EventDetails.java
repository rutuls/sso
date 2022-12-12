package com.datdyn.platform.sxsdk.models.ReplicationOptions.GeneralOptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDetails {
    @JsonProperty("EventOption")
    Integer eventOption;
    @JsonProperty("ListAllFilesOutputLocation")
    String listAllFilesOutputLocation;
    @JsonProperty("ListAlLFilesOptions")
    ListAllFilesOptions listAllFilesOptions;
}
