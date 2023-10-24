package ro.fasttrackit.course15.homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ro.fasttrackit.course15.homework.Quote.Fields.*;

class QuoteServiceTest {
    private static QuoteReader quoteReader;
    private static List<Quote> quotes;

    @BeforeAll
    static void setup() {
        //GIVEN -- GENERAL for all test methods
        quoteReader = new QuoteReader("src/test/resources/quotes.txt");
        quotes = quoteReader.readQuotes();
    }

    @Test
    @DisplayName("WHEN requesting all quotes THEN the correct list is returned")
    void getAllQuotesTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(quotes);

        //WHEN
        List<Quote> allQuotes = quoteService.getAllQuotes();

        //THEN
        assertThat(allQuotes).isNotNull()
                .hasSize(20);
    }

    @Test
    @DisplayName("WHEN requesting non-existent quotes THEN an empty list is returned")
    void getEmptyQuotesListTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(List.of());

        //WHEN
        List<Quote> allQuotes = quoteService.getAllQuotes();

        //THEN
        assertThat(allQuotes).isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("WHEN requesting null quotes THEN an empty list is returned")
    void getNullQuotesListTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(null);

        //WHEN
        List<Quote> allQuotes = quoteService.getAllQuotes();

        //THEN
        assertThat(allQuotes).isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("WHEN requesting quotes for an author THEN the correct list is returned")
    void getQuotesForAuthorTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(quotes);

        //WHEN
        List<Quote> laoTzu = quoteService.getQuotesForAuthor("lao tzu");

        //THEN
        assertThat(laoTzu).hasSize(2)
                .extracting(id, author, favourite)
                .containsExactlyInAnyOrder(tuple(1, "Lao Tzu", false), tuple(16, "Lao Tzu", false));
    }

    @Test
    @DisplayName("WHEN requesting quotes for a null author THEN an empty list is returned")
    void getQuotesForNullAuthorTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(quotes);

        //WHEN
        List<Quote> laoTzu = quoteService.getQuotesForAuthor(null);

        //THEN
        assertThat(laoTzu).isEmpty();
    }

    @Test
    @DisplayName("WHEN setting a quote as favourite THEN the correctly modified quote is returned")
    void setFavouriteTest() {
        //GIVEN
        QuoteService quoteService = new QuoteService(quotes);

        //WHEN
        Quote favourite = quoteService.setFavourite(20);

        //THEN
        assertThat(favourite).isNotNull()
                .extracting(id, author, quote, Quote.Fields.favourite)
                .containsExactlyInAnyOrder(20, "Michael Korda", "To succeed, we must first believe that we can.", true);
    }

    @Test
    @DisplayName("WHEN setting a mock quote as favourite THEN the correctly modified quote is returned")
    void setFavouriteMockitoTest() {
        //GIVEN
        QuoteService quoteService = mock(QuoteService.class);

        //WHEN
        when(quoteService.setFavourite(anyInt())).thenCallRealMethod();
        when(quoteService.findById(anyInt()))
                .thenReturn(Quote.builder()
                        .id(25)
                        .quote("Sa fie bine ca sa nu fie rau")
                        .author("Soso")
                        .favourite(false)
                        .build());

        Quote favourite = quoteService.setFavourite(2);

        //THEN
        assertThat(favourite).isNotNull()
                .extracting(id, author, quote, Quote.Fields.favourite)
                .containsExactlyInAnyOrder(25, "Soso", "Sa fie bine ca sa nu fie rau", true);
    }
}