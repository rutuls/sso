package com.datdyn.platform.maf.entities.converters;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.AttributeConverter;

import com.datdyn.platform.maf.models.TemplateModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.logging.Log;

@Singleton
public class TemplateModelAttributeConverter implements AttributeConverter<TemplateModel, String> {

  @Inject
  ObjectMapper objectMapper;

  @Override
  public String convertToDatabaseColumn(TemplateModel object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      Log.error("Error while converting TemplateModel to JSON string ", e);
      return null;
    }
  }

  @Override
  public TemplateModel convertToEntityAttribute(String jsonString) {
    try {
      return objectMapper.readValue(jsonString, TemplateModel.class);
    } catch (IOException e) {
      Log.error("Error while converting JSON string to TemplateModel ", e);
      return null;
    }
  }

}
