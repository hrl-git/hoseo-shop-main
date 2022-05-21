package itc.hoseo.shop;

import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.LoginLogRepository;
import itc.hoseo.shop.repo.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SampleApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoginLogRepository logRepository;

    @Test
    void contextLoads() {
        assertEquals(5,logRepository.lastFiveLogs("user3").size());


    }

}
