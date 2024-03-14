package me.hmservice.vault;

import lombok.extern.slf4j.Slf4j;
//import me.hmservice.vault.config.VaultConfig;
import me.hmservice.domain.client.VaultClient;
import me.hmservice.vault.config.VaultConfig;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VaultService {

  private final VaultConfig vaultConfig;
  private final VaultClient vaultClient;

  public VaultService(VaultConfig vaultConfig, VaultClient vaultClient) {
    this.vaultConfig = vaultConfig;
    this.vaultClient = vaultClient;
  }

  public Object readSecret() {
    return vaultClient.getVault(vaultConfig.getToken());
  }
}
