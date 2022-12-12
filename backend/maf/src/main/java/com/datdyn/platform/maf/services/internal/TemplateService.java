package com.datdyn.platform.maf.services.internal;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.datdyn.platform.maf.dtos.APIResponse.TemplateResponseDto;
import com.datdyn.platform.maf.repositories.TemplateRepository;


@ApplicationScoped
public class TemplateService {
  @Inject
  TemplateRepository templateRepository;

  public List<TemplateResponseDto> getAllTemplates() {
    return templateRepository.listAll().stream().map(TemplateResponseDto::new).collect(Collectors.toList());
  }

  public TemplateResponseDto getById(String id){
    return new TemplateResponseDto(templateRepository.list("ID",id).get(0));
  }
}
