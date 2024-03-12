package me.hmservice.vault;

import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VaultController {

  private final VaultService vaultService;

  public VaultController(VaultService vaultService) {
    this.vaultService = vaultService;
  }

  @GetMapping("/vault")
  public Mono<Object> getVault() {
    return vaultService.readSecret();
  }
}
