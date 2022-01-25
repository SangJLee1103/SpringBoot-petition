package myproject.petition.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @AfterEach
    void clearMemory(){
        memberRepository.clearStore();
    }

    @Test
    void memberSave(){
        Member member1 = new Member("이상준", "lsj16632", "lsj2486512!");
        Member member2 = new Member("David", "david", "david1234");

        Member save1 = memberRepository.save(member1);
        Member save2 = memberRepository.save(member2);

        assertThat(member1).isEqualTo(save1);
        assertThat(member2).isEqualTo(save2);
    }

    @Test
    void findAll(){
        Member member1 = new Member("이상준", "lsj16632", "lsj2486512!");
        Member member2 = new Member("David", "david", "david1234");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member>memberList = memberRepository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);
    }
}