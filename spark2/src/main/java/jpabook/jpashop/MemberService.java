package jpabook.jpashop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional //변경
    public Long createPost(Member member) {
        memberRepository.save(member);
        return member.getId();
    }
    public List<Member> findPost(Long id) {
        List<Member> members = new ArrayList<>();
        Member member = memberRepository.findById(id);
        if (member != null) {
            members.add(member);
        }
        return members;
    }
    @Transactional
    public Member updatePost(Long memberId, MemberForm memberForm) {
        Member member = memberRepository.updateById(memberId, memberForm);
        return member;
    }
    @Transactional
    public Member deletePost(Long memberId, MemberForm memberForm) {
        Member member = memberRepository.deleteById(memberId, memberForm);
        return member;
    }
}
