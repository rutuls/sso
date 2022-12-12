package com.datdyn.platform.maf.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.datdyn.platform.maf.entities.Flow;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FlowRepository  implements PanacheRepository<Flow> {
    
}
