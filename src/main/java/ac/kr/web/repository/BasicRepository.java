package ac.kr.web.repository;

import ac.kr.web.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<Basic, Long> {
    Basic findByName(final String name);
}
