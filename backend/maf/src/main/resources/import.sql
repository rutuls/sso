-- INSERT TEMPLATES
--INSERT INTO PUBLIC.MAF_TEMPLATES(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL, TYPE) VALUES (GEN_RANDOM_UUID(), 'first template', 'deepakdaneva', CURRENT_TIMESTAMP(6) , 'template description', 'template label', 'deepakdaneva', CURRENT_TIMESTAMP(6) , '{"key1":"key1value"}', 'CUSTOM');
-- INSERT TEMPLATES
INSERT INTO PUBLIC.MAF_TEMPLATES(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL, TYPE) VALUES (GEN_RANDOM_UUID(), 'SMB to SMB', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'SMB to SMB', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{
	"Name": "Policy1",
	"Description": "Policy description ",
	"Source": "\\\\Source\\Share",
	"Destination": "\\\\Destination\\Share",
	"MigrationSchedule": {
		"UseSchedule": false,
		"Schedules": [{
			"WeeklyInterval": 1,
			"ActiveDays": [
				0
			],
			"ScheduleType": "WeeklySchedule",
			"StartTime": "2022-09-28T14:24:14.2327822-05: 00 ",
			"StopTime": "2023-09-28T14:24:14.2327822-05: 00 ",
			"HourlyInterval": 0,
			"DailyInterval": 0
		}]
	},
	"Actions": {
		"Batch1": {
			"EnableBatch": false,
			"BatchFile": "",
			"Pause": 1
		},
		"SourceSizing": {
			"EnableSourceSizing": true,
			"Pause": 1
		},
		"CopyDataOnce": {
			"EnableCopyDataOnce": true,
			"Pause": 1
		},
		"CopyDataUntil": {
			"EnableCopyDataUntil": true,
			"AutoRun": false,
			"AdvancingConditions": {
				"AdvanceToNextAction": 1,
				"AfterDateTime": "0001-01-01T00:00:00",
				"DoNotAdvanceIfCopyDataHasErrors ": false
			}
		},
		"UpdateAutomountOrDFS": {
			"EnableUpdateAutomountOrDFS ": false,
			"UpdateMethod": 1,
			"Pause": 1,
			"DFSNamespaces": [],
			"AutomountPaths": []
		},
		"PreventUserConnection": {
			"EnablePreventUserConnection": false,
			"RenameShare": false,
			"AppendMacro": "%DATE_TIME%",
			"Pause": 1
		},
		"VerifyReplication": {
			"EnableVerifyReplication": true,
			"Pause": 1
		},
		"StopSharingSource": {
			"EnableStopSharingSource": false,
			"Pause": 1
		},
		"Batch2": {
			"EnableBatch": false,
			"BatchFile": "",
			"Pause": 1
		}
	},
	"ReplicationOptions": {
		"GeneralOptions": {
			"IncludeSubFolders": true,
			"AllowStreamLoss": false,
			"DeleteOrphanFilesAndFolderOnDestination ": true,
			"EnableCopyInPlace": true,
			"OverrideTimeStamp": false,
			"PreserveLastAccessTimeOnSource": true,
			"CopyDirectoriesOnly": false,
			"HandleHardlinks": false,
			"CopyFiles": 2,
			"CopySecurity": 1,
			"RetryFailOpenFile": {
				"Tries": 3,
				"RetryInterval": "00:00:10",
				"CancelAfterElapse": "00:00:10"
			},
			"ReplicationDuration": {
				"UseReplicationDuration": false,
				"Minute": 4294967295
			},
			"EventDetails": {
				"EventOption": 1,
				"ListAllFilesOutputLocation": "",
				"ListAlLFilesOptions": {
					"ShowChecksum": false,
					"ShowOnlyChecksumMismatches": false,
					"ShowSecurityInfo": false,
					"ShowACLInformation": false
				}
			}
		},
		"ReplicationFilters": {
			"ExcludePaths": [],
			"ExcludeFiles": [],
			"IncludePaths": [],
			"IncludeFiles": [],
			"FileAgeFilter": {
				"AgeFilterType": 0,
				"AgeFilterTimeType": 0,
				"Days": 1
			}
		},
		"UniversalDataEngine": {
			"DataEngineChoice": 3,
			"DataEngineGroup": "",
			"DataEngineMachineName": ""
		},
		"ReplicationScripting": {
			"Before": {
				"RunScript": false,
				"File": ""
			},
			"After": {
				"RunScript": false,
				"File": ""
			}
		},
		"CIFSSecurityReplication": {
			"SecurityDescriptorProcessing": {
				"ProcessSID": true,
				"RemoveInvalidSIDs": false,
				"UseSIDMappingRules": false,
				"HandleSID": 2,
				"TranslateSID": {
					"CreateLocalGroup": true,
					"UnableToTranslate": 3
				},
				"AllowLossOfSecurity": false
			}
		},
		"CIFSAttributesReplication": {
			"Archive": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ReadOnly": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"Compressed": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"Hidden": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"System": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ExcludeOffline": false,
			"DoCopySparseFiles": false,
			"DoNotPreserveSparseFiles": false
		},
		"NFSSecurityReplication": {
			"ModeSetUid": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeSetGid": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeStickyBit": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeReadPermissionOwner": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeReadPermissionGroup": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeReadPermissionOther": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeWritePermissionOwner": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeWritePermissionGroup": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeWritePermissionOther": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeExecutePermissionOwner": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeExecutePermissionGroup": {
				"m_SO": 0,
				"m_bCompare": true
			},
			"ModeExecutePermissionOther": {
				"m_SO": 0,
				"m_bCompare": true
			}
		},
		"NFSExtendedAttributes": {
			"PreserveExtendedAttributes": false,
			"PosixNFSv4ACL": false,
			"UserMappingsEnabled": false,
			"UserMappingsCollection": [{
				"Key": "",
				"SourceParameter": "",
				"DestinationACE": ""
			}]
		}
	},
	"MigrationFlow": [{
			"Order": 2,
			"Action": "VerifyReplication"
		},
		{
			"Order": 1,
			"Action": "SourceSizing"
		}
	]
}', 'CUSTOM');



-- INSERT Components

INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Source', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Source', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"Source","key":"Source","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Destination', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Destination', '', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"Destination","key":"Destination","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Source Sizing', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Source Sizing', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "Source Sizing","Key": "SourceSizing","components": [{"key": "EnableSourceSizing","Type": "checkbox","Default": ""},{"key":"Pause","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'General Replication Options', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'General Replication Options', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"components": [{"label": "Delete Orphaned Files and Folders on the destination","key": "DeleteOrphanFilesAndFolderOnDestination","type": "checkbox","default": "FALSE"},{"label": "Allow loss of additional Security","key": "AllowStreamLoss","type": "checkbox","default": ""},{"label": "Override Comparison time stamp","key": "OverrideTimeStamp","type": "checkbox","default": ""},{"label": "Preserve Last Access time on Source","key": "PreserveLastAccessTimeOnSource","type": "checkbox","default": "TRUE"},{"label": "Copy Directories only","key": "CopyDirectoriesOnly","type": "checkbox","default": ""},{"label": "Assert backup/restore privileges","key": "","type": "checkbox","default": "TRUE"},{"label": "Replication Duration","key": "ReplicationDuration","components": [{"key": "UseReplicationDuration","type": "checkbox","default": ""},{"key": "Minute","type": "textbox"},{"type": "dropdown","options": [{"label": "HR","value": "HR"},{"label": "MIN","value": "MIN"}]}]},{"label": "Event Details","key": "EventDetails","components": [{"key": "EventOption","type":"dropdown","options": [{"label": "List Only Files With Errors","value": "1"},{"label": "List No Files","value": "2"},{"label": "List All Files","value": "3"}]},{"label":"List All Files Output Location","key":"ListAllFilesOutputLocation","type":"textbox"},{"label":"Show Checksum","key":"ShowChecksum","type":"checkbox"},{"label":"Show Only Checksum Mismatches","key":"ShowOnlyChecksumMismatches","type":"checkbox"},{"label":"Show Security Info","key":"ShowSecurityInfo","type":"checkbox"},{"label":"Show ACL Information","key":"ShowACLInformation","type":"checkbox"}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Advance Replication Options', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Advance Replication Options', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"components": [{"label": "Include Subfolders","key": "IncludeSubFolders","type": "checkbox","default": "TRUE"},{"label": "Enable Copy in place","key": "EnableCopyInPlace","type": "checkbox","default": "TRUE"},{"label": "Copy Files","key": "CopyFiles","type": "dropdown","options": [{"label": "If the destination file is different or missing","value": "2"},{"label": "If the destination file is Older or missing","value": "1"},{"label": "If the destination file is missing","value": "3"},{"label": "If the destination file is Older and exists","value": "4"}]},{"label": "Copy Security","key": "CopySecurity","type": "dropdown","options": [{"label": "Each time file or Folder is copied","value": "1"},{"label": "Only if the Target file or Folder does not exist","value": "2"},{"label": "Never","value": "3"},{"label": "Always","value": "4"}]},{"label": "Retry Failed files opens","key": "RetryFailOpenFile","components": [{"key": "Tries","type": "textbox","default": "3"},{"key": "RetryInterval","type": "textbox","default": "10"}]},{"label": "File Age Filter","key": "FileAgeFilter","components": [{"key": "AgeFilterTimeType","type": "dropdown","options": [{"label": "None","value": "0"},{"label": "Last Access","value": "2"},{"label": "Last Write","value": "3"}]},{"key": "AgeFilterType","type": "dropdown","options": [{"label": "None","value": "0"},{"label": "Older","value": "1"},{"label": "Newer","value": "2"}]},{"label": "Days","key": "Days","type": "textbox"}]},{"label": "Replication Filters","key": "ReplicationFilters","components": [{"label": "Exclude Paths","key": "ExcludePaths","type": "textbox"},{"label": "Exclude Files","key": "ExcludeFiles","type": "textbox"},{"label": "Include Paths","key": "IncludePaths","type": "textbox"},{"label": "Include Files","key": "IncludeFiles","type": "textbox"}]},{"label": "CIFS Security Replication","key": "CIFSSecurityReplication","components": [{"label": "Process Security Identifiers (SIDs) in security descriptor","key": "ProcessSID","type": "checkbox"},{"label": "Remove Invalid SIDs","key": "RemoveInvalidSIDs","type": "checkbox"},{"label": "Use SID mapping rules defined on the UDE","key": "UseSIDMappingRules","type": "checkbox"},{"key": "HandleSID","label":"Handling for SIDs corresponding to local trustees","type": "radio","options": [{"label": "Remove SID","value": "1"},{"label": "Translate SID","value": "2"}]},{"label": "Create Local Groups on the destination if not found","key": "CreateLocalGroup","type": "checkbox"},{"key": "UnableToTranslate","label":"If Unable To Translate SID","type": "radio","options": [{"label": "Leave it as is","value": "1"},{"label": "Remove it from the security descriptor","value": "2"},{"label": "Translate it to the local Administrators Group","value": "3"}]}]},{"label": "CIFS Attribute Replication","key": "CIFSAttributesReplication","components": [{"label": "Archive Attribute","key": "Archive","type": "checkbox"},{"key": "m_SO","type": "radio","options": [{"label": "Match","value": "0"},{"label": "Set","value": "1"},{"label": "Clear","value": "2"},{"label": "Unchanged","value": "3"}]},{"label": "Read-Only Attribute","key": "ReadOnly","type": "checkbox"},{"key": "m_SO","type": "radio","options": [{"label": "Match","value": "0"},{"label": "Set","value": "1"},{"label": "Clear","value": "2"},{"label": "Unchanged","value": "3"}]},{"label": "Compressed Attribute","key": "Compressed","type": "checkbox"},{"key": "m_SO","type": "radio","options": [{"label": "Match","value": "0"},{"label": "Set","value": "1"},{"label": "Clear","value": "2"},{"label": "Unchanged","value": "3"}]},{"label": "Hidden Attribute","key": "Hidden","type": "checkbox"},{"key": "m_SO","type": "radio","options": [{"label": "Match","value": "0"},{"label": "Set","value": "1"},{"label": "Clear","value": "2"},{"label": "Unchanged","value": "3"}]},{"label": "System Attribute","key": "System","type": "checkbox"},{"key": "m_SO","type": "radio","options": [{"label": "Match","value": "0"},{"label": "Set","value": "1"},{"label": "Clear","value": "2"},{"label": "Unchanged","value": "3"}]},{"label": "Do not copy Offline Files","key": "ExcludeOffline","type": "checkbox"},{"label": "Except for offline files","key": "DoCopySparseFiles","type": "checkbox"},{"label": "Do not preserve sparse file attribute","key": "DoNotPreserveSparseFiles","type": "checkbox"}]},{"label": "Universal Data Engine","key": "UniversalDataEngine","components": [{"label": "Specify the universal data engine to be used","key": "DataEngineChoice","type": "radio","options": [{"label": "Automatically select a data engine","value": "2"},{"label": "Use the following data engine","value": "0"},{"label": "Use this data engine group","value": "1"}]},{"label": "Data Engine Machine Name","key": "DataEngineMachineName","type": "textbox"},{"label": "Data Engine Group","key": "DataEngineGroup","type": "textbox"}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Replication Type', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Replication Type', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"ReplicationType","key":"ReplicationType","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Migration Schedule', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Migration Schedule', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"Migration Schedule","key":"MigrationSchedule","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Email', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Email', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"Email","key":"Email","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Batch Script', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Batch Script', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "Verify Replication","Key": "VerifyReplication","components": [{"key": "EnableVerifyReplication","Type": "checkbox","Default": ""},{"key":"Pause","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Verify Replication', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Verify Replication', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"label":"ReplicationType","key":"ReplicationType","type":"textbox"}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Copy', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Copy', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "Copy data once","Key": "CopyDataOnce","components": [{"key": "EnableCopyDataOnce","Type": "checkbox","Default": ""},{"key": "Pause","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]}]},{"label": "Copy data until","key": "CopyDataUntil","components": [{"key": "EnableCopyDataOnce","Label": "Copy the data","Type": "checkbox","Default": ""},{"key": "AutoRun","Label": "Automatically run the incremental copy as scheduled, even if the previous incremental copy was canceled","Type": "checkbox","Default": ""},{"label": "Advancing Conditions","key": "AdvancingConditions","components": [{"key": "AdvanceToNextAction","Label": "Conditions for advancing to the final phase","type": "dropdown","options": [{"label": "Never Auto Advance","value": "1"},{"label": "Advance To Final Phase","value": "2"},{"label": "End Incremental Phase","value": "3"}]},{"label":"After this Date and Time","key":"AfterDateTime","type":"textbox"},{"key": "DoNotAdvanceIfCopyDataHasErrors","Label": "Do not advance if copy data operation completed with errors","Type": "checkbox","Default": ""}]}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Stop Sharing the Source', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Stop Sharing the Source', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "Stop Sharing Source","Key": "StopSharingSource","components": [{"key": "EnableStopSharingSource","Type": "checkbox","Default": ""},{"key":"Pause","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'Update Automounts', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'Update Automounts', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "Update Automount Or DFS","Key": "UpdateAutomountOrDFS","components": [{"key": "EnableUpdateAutomountOrDFS","Type": "checkbox","Default": ""},{"key":"UpdateMethod","Type": "dropdown","Options": [{"label": "By retargeting links","value": "1"},{"label": "By adding online link targets","value": "2"},{"label": "By adding offline link targets","value": "3"},{"label": "By removing the link targets","value": "4"}]},{"key":"Pause","Label":"Pause after this step","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]},{"key":"DFSNamespaces","Label":"DFS Namespaces","Type": "textbox"},{"key":"AutomountPaths","Label":"Automount Paths","Type": "textbox"}]}]}');


INSERT INTO PUBLIC.MAF_COMPONENT(ID, NAME, CREATED_BY, CREATED_DATE, DESCRIPTION, LABEL, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, MODEL) VALUES (GEN_RANDOM_UUID(), 'If source is share, prevent user connections during final copy', 'SunilJangir', CURRENT_TIMESTAMP(6) , 'Demo description', 'If source is share, prevent user connections during final copy', 'SunilJangir', CURRENT_TIMESTAMP(6) , '{"Components": [{"Label": "If source is share, prevent user connections during the final copy (CIFS-Only)","Key": "PreventUserConnection","components": [{"key": "EnablePreventUserConnection","Type": "checkbox","Default": ""},{"key":"Pause","Label":"Pause after this step","Type": "dropdown","Options": [{"label": "Pause On Error Only","value": "1"},{"label": "Always","value": "2"},{"label": "Never","value": "3"}]},{"key": "RenameShare","Type": "checkbox","Default": ""},{"key":"AppendMacro","Label":"Specify string to append to original share name","Type": "textbox"}]}]}');
