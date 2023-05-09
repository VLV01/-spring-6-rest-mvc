package vlv.springframework.spring6restmvc.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vlv.springframework.spring6restmvc.entities.Beer;
import vlv.springframework.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerToLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer 1415454144554544141415544154544414144141544154414141657495274592792419279175206270247757507554175517515676510576507060657218750747140745075740704057745057450074650750750575")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("88851115665")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });





    }

}