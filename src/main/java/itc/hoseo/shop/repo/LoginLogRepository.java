package itc.hoseo.shop.repo;

import itc.hoseo.shop.domain.LoginLog;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface LoginLogRepository {
    List<LoginLog> lastFiveLogs(String id);
    void save(LoginLog log);
}
