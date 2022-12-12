package com.datdyn.platform.maf.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.datdyn.platform.maf.entities.Component;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ComponentRepository implements PanacheRepository<Component> {
    
}
