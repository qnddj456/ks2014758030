package ac.kr.web.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

// Lombok
@Getter
@NoArgsConstructor
// JPA
@Entity
@Table
public class Work {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String company;

    @Column
    private String position;

    @Column
    private String webSite;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String summary;

    @Builder
    public Work(String company, String position, String webSite, LocalDateTime startDate, LocalDateTime endDate, String summary) {
        this.company = company;
        this.position = position;
        this.webSite = webSite;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }
}
