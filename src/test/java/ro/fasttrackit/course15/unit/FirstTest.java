package ro.fasttrackit.course15.unit;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {
    private static First first;

    @BeforeAll
    static void setupAll() {
        System.out.println("BeforeAll()");
        first = new First();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach()");
    }

    @Test
    void sumWorks() {
        // GIVEN
        First first = new First();

        // WHEN
        int sum = first.sum(0, 3);

        // THEN
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN summing 2 negative numbers THEN the correct result is returned")
    void negativeNumbersSum() {
        System.out.println("Negative numbers sum");

        //GIVEN
        First first = new First();

        //WHEN
        int sum = first.sum(-5, -10);

        //THEN
        assertThat(sum).isNegative()
                .isEqualTo(-15);
    }

    @Test
    @DisplayName("WHEN summing 2 positive numbers THEN the correct result is returned")
    void positiveNumbersSum() {
        System.out.println("Positive numbers sum");
        //GIVEN
        First first = new First();

        //WHEN
        int sum = first.sum(5, 10);

        //THEN
        assertThat(sum).isPositive()
                .isEqualTo(15);
    }

    @Test
    @DisplayName("WHEN multiplying 2 positive numbers THEN the correct result is returned")
    void positiveNumbersMultiplication() {
        //GIVEN
//        First first = new First();

        //WHEN
        int sum = first.sum(5, 10);

        //THEN
        assertThat(sum).isPositive()
                .isEqualTo(15);
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll()");
    }
}
