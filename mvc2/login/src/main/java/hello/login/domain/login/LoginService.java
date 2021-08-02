package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    public final MemberRepository memberRepository;

    /**
     *
     * @param loginId
     * @param password
     * @return
     */
    public Member login(String loginId, String password){


        return memberRepository.findByLoginId(loginId).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);

    }
}