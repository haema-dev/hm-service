package me.hmservice.vault;

import lombok.extern.slf4j.Slf4j;
//import me.hmservice.vault.config.VaultConfig;
import me.hmservice.vault.config.VaultConfig;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class VaultService {

  private final VaultConfig vaultConfig;

  public VaultService(VaultConfig vaultConfig) {
    this.vaultConfig = vaultConfig;
  }

  public Mono<Object> readSecret() {
    return vaultConfig.getVault();
  }
}
