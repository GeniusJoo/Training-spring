package Training.Training.spring.service;

import Training.Training.spring.domain.Member;
import Training.Training.spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository()
;        memberService = new MemberService(memberRepository); // dependency injection DI 방식
    }

    @AfterEach
    public void afterEach(){ // Test case가 진행되고 나서 메모리를 지워줘야함. 안그럼 Error
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 뭔가 주어져서
        Member member = new Member();
        member.setName("spring");

        //when 이것을 실행했을 때
        Long saveId = memberService.join(member);

        //then 결과가 ~것이 나와야 한다.
        Member findMember =  memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            memberService.join(member2);
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        } //try ~ catch 방법

        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}