package com.datdyn.platform.maf.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "maf_component")
@EqualsAndHashCode(callSuper = false)
public class Component extends PanacheEntityBase {

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
    @NotNull
    @Column(name = "MODEL", nullable = false, columnDefinition = "text")
    private String model;
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Instant createdDate;
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private String createdBy;
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Instant lastModifiedDate;
    @Column(name = "LAST_MODIFIED_BY", nullable = false)
    private String lastModifiedBy;
    // @Column(name = "ORDER", nullable = false)
    // private Long order;

}
