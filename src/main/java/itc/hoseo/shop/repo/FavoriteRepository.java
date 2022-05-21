package itc.hoseo.shop.repo;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.domain.Member;

import java.util.List;

public interface FavoriteRepository {
    List<Favorite> findByMemberSeq(int memberSeq);
    void insert(Favorite m);
}
