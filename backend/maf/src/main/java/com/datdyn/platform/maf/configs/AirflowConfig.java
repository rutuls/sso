package com.datdyn.platform.maf.configs;

import java.util.Optional;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "quarkus.rest-client.airflow")
public interface AirflowConfig {
    Optional<String> url();
    
    String user();

    String password();
}
