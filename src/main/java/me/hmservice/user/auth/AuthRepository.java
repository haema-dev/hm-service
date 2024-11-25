package me.hmservice.user.auth;

import me.hmservice.domain.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project : hm-service Created by OKESTRO Developer : suajo Date Time : 4/5/AD2024 2:44 PM Summary
 * :
 **/
public interface AuthRepository extends JpaRepository<Token, Long> {

}
