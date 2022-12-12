package com.datdyn.platform.maf.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    SYS_ADMIN, ADMIN, USER;

    private static final Map<String, RoleType> allRoles = new HashMap<>();

    static {
        for (RoleType role : RoleType.values()) {
            allRoles.put(role.name(), role);
        }
    }

    public static RoleType get(String name) {
        if (name != null) {
            return allRoles.get(name.trim().toUpperCase());
        }
        return null;
    }

    public static boolean isValid(String roleTypeString) {
        if (roleTypeString != null) {
            return allRoles.containsKey(roleTypeString.trim().toUpperCase());
        }
        return false;
    }
}
