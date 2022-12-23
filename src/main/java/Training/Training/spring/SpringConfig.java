package Training.Training.spring;

import Training.Training.spring.repository.MemberRepository;
import Training.Training.spring.repository.MemoryMemberRepository;
import Training.Training.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
