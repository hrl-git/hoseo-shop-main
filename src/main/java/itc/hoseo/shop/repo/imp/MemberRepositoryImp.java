package itc.hoseo.shop.repo.imp;

import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class MemberRepositoryImp implements MemberRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Member> findAll() {
        return template.query("select * from member",
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public Member findById(String id) {
        return template.queryForObject("select * from member where id = ?",
                new BeanPropertyRowMapper<>(Member.class), id);
    }

    @Override
    public void insert(Member m) {
        template.update("insert into member (id, name , password, role, address, telno, email, use_yn) " +
                "values ( ? ,? , ? ,? ,? ,? ,? ,?  )", m.getId(), m.getName(), m.getPassword(), m.getRole(), m.getAddress(), m.getTelno(), m.getEmail(), m.getUseYn());
    }

    @Override
    public void update(Member m) {
        template.update("update member set password = ? , address = ? , telno = ? , email = ? , use_yn = ? where id = ?",
                m.getPassword(), m.getAddress(), m.getTelno(), m.getEmail(), m.getUseYn(), m.getId());
    }
}
