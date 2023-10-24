package ro.fasttrackit.course15.homework;

import java.util.*;

import static java.util.Collections.unmodifiableList;

public class QuoteService {
    private final List<Quote> quotes;

    public QuoteService(List<Quote> quotes) {
        this.quotes = quotes == null ? List.of() : new ArrayList<>(quotes);
    }

    public List<Quote> getAllQuotes() {
        return unmodifiableList(quotes);
    }

    public List<Quote> getQuotesForAuthor(String author) {
        if (author == null) {
            return List.of();
        }

        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (author.equalsIgnoreCase(quote.getAuthor())) {
                result.add(quote);
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        Set<String> result = new HashSet<>();
        for (Quote quote : quotes) {
            result.add(quote.getAuthor());
        }
        return new ArrayList<>(result);
    }

    public Quote setFavourite(int id) {
        Quote favouriteQuote = findById(id);
        if (favouriteQuote != null) {
            favouriteQuote.setFavourite(true);
        }
        return favouriteQuote;
    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavourite()) {
                result.add(quote);
            }
        }
        return result;
    }

    public Quote getRandomQuote() {
        Random random = new Random();
        int id = random.nextInt(1, quotes.size() + 1);
        return findById(id);
    }

    public Quote findById(int id) {
//        throw new RuntimeException("Do not test me");
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                return quote;
            }
        }
        return null;
    }
}
