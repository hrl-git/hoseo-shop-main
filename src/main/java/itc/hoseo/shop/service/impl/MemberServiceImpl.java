package itc.hoseo.shop.service.impl;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.FavoriteRepository;
import itc.hoseo.shop.repo.MemberRepository;
import itc.hoseo.shop.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
@Slf4j
@ControllerAdvice
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    @Transactional
    public boolean join(Member m, Favorite... favorites) {
        memberRepository.insert(m);
        for(Favorite f : favorites){
            favoriteRepository.insert(f);
        }
        return true;
    }
}
