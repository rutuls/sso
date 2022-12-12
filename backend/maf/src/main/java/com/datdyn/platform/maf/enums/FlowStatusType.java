package com.datdyn.platform.maf.enums;

import java.util.HashMap;
import java.util.Map;

public enum FlowStatusType {
  NOT_RUNNING, RUNNING, COMPLETED;

  private static final Map<String, FlowStatusType> allFlowStatusTypes = new HashMap<>();

  static {
    for (FlowStatusType type : FlowStatusType.values()) {
      allFlowStatusTypes.put(type.name(), type);
    }
  }

  public static FlowStatusType get(String name) {
    if (name != null) {
      return allFlowStatusTypes.get(name.trim().toUpperCase());
    }
    return null;
  }

  public static boolean isValid(String flowStatusTypeString) {
    if (flowStatusTypeString != null) {
      return allFlowStatusTypes.containsKey(flowStatusTypeString.trim().toUpperCase());
    }
    return false;
  }
}
