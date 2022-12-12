package com.datdyn.platform.maf.entities;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "maf_flows")
@EqualsAndHashCode(callSuper = false)
public class Flow{
  @Id
  @Column(name = "ID", updatable = false)
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  @NotBlank
  @Column(name = "NAME", unique = true, nullable = false)
  private String name;
  @NotBlank
  @Column(name = "PROJECT_NAME", unique = false, nullable = false)
  private String projectName;
  @Column(name = "SX_REF_ID", unique = false, nullable = false)
  private Long sxRefId;
  @Column(name = "STATUS", unique = false, nullable = true)
  private String status;
  @Column(name = "CREATED_DATE", nullable = false, updatable = false)
  private Instant createdDate;
  @Column(name = "CREATED_BY", nullable = false, updatable = false)
  private String createdBy;
  @Column(name = "LAST_MODIFIED_DATE", nullable = false)
  private Instant lastModifiedDate;
  @Column(name = "LAST_MODIFIED_BY", nullable = false)
  private String lastModifiedBy;
}
