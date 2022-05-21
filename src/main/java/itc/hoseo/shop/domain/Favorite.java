package itc.hoseo.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorite {
    //관심사 고유 식별자(자동증가)
    private int seq;
    //해당 관심사의 맴버 식별자
    private int memberSeq;
    //관심사 명
    private String name;
}
