package com.datdyn.platform.maf.services.internal;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.datdyn.platform.maf.entities.Component;
import com.datdyn.platform.maf.repositories.ComponentRepository;

@ApplicationScoped
public class ComponentService {
    @Inject
    ComponentRepository componentRepository;

    public List<Component> getAllComponents() {
        return Component.listAll();
    }

}
