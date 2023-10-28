package jpabook.jpashop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public String createPost(@RequestBody MemberForm form) {
        Member member = new Member();
        member.setUsername(form.getUsername());
        memberService.createPost(member);
        return "POST OK";
    }

    @GetMapping(value = "/new")
    public String findPost(Model model) {
        model.addAttribute("memberForm", "hello");
        return "GET OK";
    }

    @PutMapping("/new/{postId}")
    public Member updatePost(@PathVariable Long postId, @RequestBody MemberForm memberForm) {
        return memberService.updatePost(postId, memberForm);
    }

    @DeleteMapping("/new/{postId}")
    public Member deletePost(@PathVariable Long postId, @RequestBody MemberForm memberForm) {
        return memberService.deletePost(postId, memberForm);
    }
}