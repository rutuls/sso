package com.datdyn.platform.maf.enums;

import java.util.HashMap;
import java.util.Map;

public enum TemplateType {
  CUSTOM,F2F,O2O;

  private static final Map<String, TemplateType> allTemplateTypes = new HashMap<>();

  static {
    for (TemplateType type : TemplateType.values()) {
      allTemplateTypes.put(type.name(), type);
    }
  }

  public static TemplateType get(String name) {
    if (name != null) {
      return allTemplateTypes.get(name.trim().toUpperCase());
    }
    return null;
  }

  public static boolean isValid(String templateTypeString) {
    if (templateTypeString != null) {
      return allTemplateTypes.containsKey(templateTypeString.trim().toUpperCase());
    }
    return false;
  }
}
