package itc.hoseo.shop.service;

import itc.hoseo.shop.domain.Favorite;
import itc.hoseo.shop.domain.Member;

public interface MemberService {
    public boolean join(Member m, Favorite... Favorites);
}
