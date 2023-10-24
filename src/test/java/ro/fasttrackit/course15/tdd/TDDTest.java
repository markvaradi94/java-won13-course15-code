package ro.fasttrackit.course15.tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Create a function TDD.find() that receives a list and a number and returns the index or -1 if
// the number is not found
public class TDDTest {

    // 1. Try to instantiate our class
    @Test
    void instantiateClass() {
        TDD tdd = new TDD();
    }

    // 2. Call find() method
    @Test
    void callMethod() {
        TDD tdd = new TDD();
        tdd.find(List.of(), 0);
    }

    // 3. Get return value from method
    @Test
    void methodReturnsAnInt() {
        TDD tdd = new TDD();
        int result = tdd.find(List.of(), 0);
    }

    // 4. Return -1 when value not found
    @Test
    void methodReturnsMinusOne() {
        //GIVEN
        TDD tdd = new TDD();

        //WHEN
        int result = tdd.find(List.of(), 0);

        //THEN
        assertThat(result).isEqualTo(-1);
    }

    // 5. Return -1 when not in received list
    @Test
    void methodReturnsMinusOneIfNotFound() {
        //GIVEN
        TDD tdd = new TDD();
        List<Integer> list = List.of();
        int number = 2;

        //WHEN
        int result = tdd.find(list, number);

        //THEN
        assertThat(result).isEqualTo(-1);
    }

    // 6. Return index when number is in list
    @Test
    void methodReturnsIndex() {
        //GIVEN
        TDD tdd = new TDD();
        List<Integer> list = List.of(1, 2, 5, 7);
        int number = 2;

        //WHEN
        int result = tdd.find(list, number);

        //THEN
        assertThat(result).isEqualTo(1);
    }

    // 7. Return -1 if null list is received
    @Test
    void methodReturnsMinusOneOnNullList() {
        //GIVEN
        TDD tdd = new TDD();
        int number = 2;

        //WHEN
        int result = tdd.find(null, number);

        //THEN
        assertThat(result).isEqualTo(-1);
    }

    // 7. Return -1 if null number is received
    @Test
    void methodReturnsMinusOneOnNullNumber() {
        //GIVEN
        TDD tdd = new TDD();
        List<Integer> list = List.of(1, 2, 5, 7);

        //WHEN
        int result = tdd.find(list, null);

        //THEN
        assertThat(result).isEqualTo(-1);
    }
}
