package com.datdyn.platform.sxsdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

  @JsonProperty("Id")
  Long ID;
  @JsonProperty("ProjectGroup")
  String projectGroup;
  @JsonProperty("ProjectName")
  String projectName;
  @JsonProperty("Name")
  String name;
  @JsonProperty("CreatedBy")
  String createdBy;
  @JsonProperty("ModifiedBy")
  String modifiedBy;
  @JsonProperty("UTCCreatedTime")
  String UTCCreatedTime;
  @JsonProperty("UTCModifiedTime")
  String UTCModifiedTime;
  @JsonProperty("LastRunStatus")
  String lastRunStatus;
}
