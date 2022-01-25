package myproject.petition.domain.login;

import lombok.RequiredArgsConstructor;
import myproject.petition.domain.member.Member;
import myproject.petition.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member checkLogin(String loginId, String password){
        return memberRepository.findByLoginId(loginId)
                .filter(m->m.getPassword().equals(password))
                .orElse(null);
    }

}
