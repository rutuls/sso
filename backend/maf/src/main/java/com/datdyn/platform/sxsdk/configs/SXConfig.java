package com.datdyn.platform.sxsdk.configs;

import java.util.Optional;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "quarkus.rest-client.sx")
public interface SXConfig {
  String host();
  int port();
  Optional<String> url();
  String username();
  String password();
  Integer pagesize(); // Raviraj, please remove this from here.
}
