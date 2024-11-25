package me.hmservice.user.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final AuthRepository authRepository;

  public AuthService(AuthRepository authRepository) {
    this.authRepository = authRepository;
  }
}
