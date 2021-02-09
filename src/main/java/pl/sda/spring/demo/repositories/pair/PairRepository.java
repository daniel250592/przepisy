package pl.sda.spring.demo.repositories.pair;

import org.springframework.stereotype.Repository;
import pl.sda.spring.demo.entities.PairEntity;

@Repository
public class PairRepository {

    private final PairApi pairApi;

    public PairRepository(PairApi pairApi) {
        this.pairApi = pairApi;
    }

    public PairEntity addProductToRecipe(PairEntity pairEntity) {
        return pairApi.save(pairEntity);
    }
}
