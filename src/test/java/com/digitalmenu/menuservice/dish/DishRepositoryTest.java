package com.digitalmenu.menuservice.dish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class DishRepositoryTest {

    @Autowired
    private DishRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll(); // Clears database for every test
    }

    @Test
    void itShouldDeleteDishById () {
        // given
        Dish dish = new Dish(
                1,
                "Pumpkin soup",
                "Good Soup",
                "Soup"
        );
        underTest.save(dish);
        // when
        var expected = underTest.deleteDishById(1);
        // then
        assertThat(expected).isEqualTo(0);
    }

    @Test
    void itShouldFindDishByName() {
        // given
        Dish dish = new Dish(
                1,
                "Pumpkin soup",
                "Good Soup",
                "Soup"
        );
        underTest.save(dish);
        String name = "Pumpkin soup";
        // when
        var expected = underTest.findDishByName(name);
        // then
        assertThat(expected).isNotEmpty();
    }
}
