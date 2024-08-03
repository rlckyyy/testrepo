package relucky.code.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relucky.code.testapi.model.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
