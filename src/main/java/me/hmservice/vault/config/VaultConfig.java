package me.hmservice.vault.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VaultConfig {

  @Value("${vault.uri}")
  private String uri;

  @Value("${vault.path}")
  private String path;

  @Value("${vault.token}")
  private String token;

  public Mono<Object> getVault() {
    return WebClient.create().get().uri(uri + path)
        .header("X-Vault-Token", token)
        .retrieve()
        .bodyToMono(Object.class);
  }
}