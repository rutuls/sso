package com.datdyn.platform.maf.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

import com.datdyn.platform.maf.entities.converters.TemplateModelAttributeConverter;
import com.datdyn.platform.maf.enums.TemplateType;
import com.datdyn.platform.maf.models.TemplateModel;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maf_templates")
@EqualsAndHashCode(callSuper = false)
public class Template extends PanacheEntityBase{

  @Id
  @Column(name = "ID", updatable = false)
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  @NotBlank
  @Column(name = "NAME", unique = true, nullable = false)
  private String name;
  @Column(name = "LABEL")
  private String label;
  @Column(name = "DESCRIPTION")
  private String description;
  @Enumerated(EnumType.STRING)
  @Column(name = "TYPE", nullable = false)
  private TemplateType type;
  @Convert(converter = TemplateModelAttributeConverter.class)
  @Column(name = "MODEL", unique = true, nullable = false, columnDefinition = "jsonb")
  private TemplateModel model;
  @Column(name = "CREATED_DATE", nullable = false, updatable = false)
  private Instant createdDate;
  @Column(name = "CREATED_BY", nullable = false, updatable = false)
  private String createdBy;
  @Column(name = "LAST_MODIFIED_DATE", nullable = false)
  private Instant lastModifiedDate;
  @Column(name = "LAST_MODIFIED_BY", nullable = false)
  private String lastModifiedBy;

}
