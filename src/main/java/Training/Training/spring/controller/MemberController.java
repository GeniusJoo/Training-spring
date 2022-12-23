package Training.Training.spring.controller;

import Training.Training.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    @Autowired private MemberService memberService; -> 필드 주입
    private final MemberService memberService;

    @Autowired // -> memberService를 spring이 spring container에 있는 memberService를 가져다 연결시켜줌(생성자 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
