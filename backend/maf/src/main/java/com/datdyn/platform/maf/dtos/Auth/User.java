package com.datdyn.platform.maf.dtos.Auth;

import io.quarkus.security.identity.SecurityIdentity;

public class User {

    private final String userName;

    public User(SecurityIdentity securityContext) {
        this.userName = securityContext.getPrincipal().getName();
    }
    public String getUserName() {
        return userName;
    }
}
