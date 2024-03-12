package me.hmservice.vault.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.client.WebClientBuilder;
import org.springframework.vault.core.ReactiveVaultTemplate;
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