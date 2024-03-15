package me.hmservice.vault.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VaultConfig {

  @Value("${vault.uri}")
  private String uri;

  @Value("${vault.path}")
  private String path;

  @Value("${vault.token}")
  private String token;

  public String getUri() {
    return uri;
  }

  public String getPath() {
    return path;
  }

  public String getToken() {
    return token;
  }
}