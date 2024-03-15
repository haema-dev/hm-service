package me.hmservice.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "vaultClient", url = "http://localhost:8200", path = "/v1/vault-person/data/1")
public interface VaultClient {

    @GetMapping
    Object getVault(@RequestHeader("X-Vault-Token") String vaultToken);
}