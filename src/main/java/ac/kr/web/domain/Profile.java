package ac.kr.web.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Lombok
@Getter
@NoArgsConstructor
// JPA
@Entity
@Table
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String userName;

    @Column
    private String netWork;

    @Column
    private String url;

    @Builder
    public Profile(String netWork, String userName, String url) {
        this.netWork = netWork;
        this.userName = userName;
        this.url = url;
    }
}
