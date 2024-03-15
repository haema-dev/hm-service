package me.hmservice.vault;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultController {

  private final VaultService vaultService;

  public VaultController(VaultService vaultService) {
    this.vaultService = vaultService;
  }

  @GetMapping("/vault")
  public Object getVault() {
    return vaultService.readSecret();
  }
}
