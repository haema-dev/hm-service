package me.hmservice.vault.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

//@Configuration
//public class VaultConfig extends AbstractVaultConfiguration {
//
//    /**
//     * Specify an endpoint for connecting to Vault.
//     */
//    @Override
//    public VaultEndpoint vaultEndpoint() {
//        return new VaultEndpoint();
//    }
//
//    /**
//     * Configure a client authentication.
//     * Please consider a more secure authentication method
//     * for production use.
//     */
//    @Override
//    public ClientAuthentication clientAuthentication() {
//        return new TokenAuthentication("…");
//    }
//}