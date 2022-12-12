package com.datdyn.platform.maf.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.datdyn.platform.maf.entities.Template;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TemplateRepository implements PanacheRepository<Template> {
  
}
