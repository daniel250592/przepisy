package pl.sda.spring.demo.repositories.pair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.spring.demo.entities.PairEntity;

import java.util.List;

public interface PairApi extends JpaRepository<PairEntity, Integer> {
    @Query(value = "SELECT PRODUCT_ENTITY_ID FROM PRODUCT_TO_RECIPE WHERE RECIPE_ENTITY_ID =:id", nativeQuery = true)
    List<Integer> findAByRecipeEntityIdLike(@Param("id") int id);


}
