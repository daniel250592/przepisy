package pl.sda.spring.demo.repositories.pair;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.demo.entities.PairEntity;

public interface PairApi extends JpaRepository<PairEntity, Integer> {
}
