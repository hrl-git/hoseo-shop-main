package itc.hoseo.shop.repo.imp;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.repo.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Favorite> findByMemberSeq(int memberSeq) {
        return jdbcTemplate.query("select * from favorite where member_seq = ?",
                new BeanPropertyRowMapper<>(Favorite.class),
                memberSeq);
    }

    @Override
    public void insert(Favorite f) {
        jdbcTemplate.update("insert into favorite(member_seq, name) values ( ?,? )",
                f.getMemberSeq(), f.getName());
    }
}
