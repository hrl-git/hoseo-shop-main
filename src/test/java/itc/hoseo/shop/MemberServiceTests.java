package itc.hoseo.shop;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.FavoriteRepository;
import itc.hoseo.shop.repo.LoginLogRepository;
import itc.hoseo.shop.repo.MemberRepository;
import itc.hoseo.shop.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class MemberServiceTests {

    @Autowired
    @Qualifier("memberServiceTxImpl")
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void contextLoads() {
        Member m1 = Member.builder()
                .id("luna")
                .name("shock")
                .password("나만아니면되")
                .role("ROLE_USER")
                .useYn("Y")
                .build();

        Favorite f1 = Favorite.builder()
                .memberSeq(5)
                .name("주식")
                .build();

        Favorite f2 = Favorite.builder()
                .memberSeq(5)
                .name("부동산")
                .build();



        assertEquals(false, memberService.join(m1,f1,f1));


        assertEquals(4,memberRepository.findAll().size());



    }

}
