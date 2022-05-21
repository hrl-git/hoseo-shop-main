package itc.hoseo.shop.service.impl;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
@Slf4j
public class MemberServiceTxImpl implements MemberService {

    @Autowired
    @Qualifier("memberServiceImpl")
    MemberService memberService;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Override
    public boolean join(Member m, Favorite... favorites) {
        boolean result = false;
        TransactionStatus status =
                transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            result = memberService.join(m, favorites);
            transactionManager.commit(status);
        }catch (RuntimeException e){
            log.error("회원 가입중 에러 발생 : ",e);
            transactionManager.rollback(status);
            result = false;
        }
        return result;
    }
}
