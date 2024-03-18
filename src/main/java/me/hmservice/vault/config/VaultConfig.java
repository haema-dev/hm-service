package me.hmservice.vault.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class VaultConfig {

  @Value("${vault.uri}")
  private String uri;

  @Value("${vault.path}")
  private String path;

  @Value("${vault.token}")
  private String token;
}