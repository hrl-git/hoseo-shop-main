package itc.hoseo.shop.service;

import itc.hoseo.shop.domain.LoginLog;
import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.LoginLogRepository;
import itc.hoseo.shop.repo.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service

public class LoginService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LoginLogRepository logRepository;


    public boolean login (String id, String pwd) {
        // 1. DB에서 id로 사용자 정보를 가져옴
        // 2. pwd 와 일치하는지 확인
        boolean result = checkPassword(id,pwd);
        LoginLog loginLog = LoginLog.builder()
                .id(id)
                .loginStatus(result ? "Y" : "N")
                .build();

        // 4. 로그인을 시도할떄마다 로그를 남겨야함
        logRepository.save(loginLog);

        List<LoginLog> loginLogs = logRepository.lastFiveLogs(id);
        if(loginLogs.size() < 5) return result;


        if (loginLogs.stream()
                .filter(l -> l.getLoginStatus().equals("N"))
                .count() == 5) {
            // 5. 비밀번호가 5회 틀리면 계정을 잠궈버려야함
            Member member = memberRepository.findById(id);
            member.setUseYn("N");
            memberRepository.update(member);
        }
        return result;
    }

    /**
     * 해당 id,pwd 가 일치하는지를 확인해주는 서비스
     * @param id
     * @param pwd
     * @return
     */
    public boolean checkPassword (String id, String pwd){
        Member member = memberRepository.findById(id);
        //DB에 사용자가 없거나, 비밀번호가 지정이 안되있거나
        if(ObjectUtils.isEmpty(member) || StringUtils.hasText(member.getPassword()) == false)
            return false;
        return member.getPassword().equals(pwd);
    }
}
