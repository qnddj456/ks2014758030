package ac.kr.web.repository;

import ac.kr.web.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByPostCode(final String postCode);
}
