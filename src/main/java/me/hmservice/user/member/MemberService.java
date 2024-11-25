package me.hmservice.user.member;

import me.hmservice.domain.member.repo.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
}
