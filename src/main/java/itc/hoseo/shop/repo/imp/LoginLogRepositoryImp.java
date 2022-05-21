package itc.hoseo.shop.repo.imp;

import itc.hoseo.shop.domain.LoginLog;
import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginLogRepositoryImp implements LoginLogRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<LoginLog> lastFiveLogs(String id) {
        return template.query("select * from login_log where id = ? order by login_dttm desc limit 5",
                new BeanPropertyRowMapper<>(LoginLog.class), id);
    }

    @Override
    public void save(LoginLog log) {
        template.update("insert into login_log(id, ip, login_status) values ( ?,?,? )",
                log.getId(), log.getIp(), log.getLoginStatus());
    }
}
