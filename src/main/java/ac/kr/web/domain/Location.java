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
public class Location {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String address;

    @Column
    private String postCode;

    @Builder
    public Location(String address, String postCode) {
        this.address = address;
        this.postCode = postCode;
    }
}
