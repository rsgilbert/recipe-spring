package net.passioncloud.recipe.repositories;

import net.passioncloud.recipe.domain.UnitOfMeasure;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class UnitOfMeasureRepositoryIT {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up");
    }

    @Test
    void findAll() {
        System.out.println("FInding all");
        Iterable<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
//        unitOfMeasures.forEach(System.out::println);
    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        Assertions.assertThat(uomOptional.isPresent()).isTrue();
        org.assertj.core.api.Assertions.assertThat(uomOptional.get().getDescription()).isEqualTo("Teaspoon");
        System.out.println("finding description");
    }

    @AfterEach
    void tearDown() {     }

    @BeforeAll()
    static void befAll() {
        System.out.println("before all");
    }

    @AfterAll()
    static void aftAll() {
        System.out.println("after all");
    }

}