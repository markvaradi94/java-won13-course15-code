package ro.fasttrackit.course15.homework;

public class HomeworkMain {
    public static void main(String[] args) {
        QuoteReader quoteReader = new QuoteReader("src/main/resources/quotes.txt");
        QuoteService service = new QuoteService(quoteReader.readQuotes());

        service.getAllQuotes().forEach(System.out::println);
        System.out.println("====================================================");
        service.getQuotesForAuthor("aristotle").forEach(System.out::println);
        System.out.println("====================================================");
        service.getAuthors().forEach(System.out::println);
        System.out.println("====================================================");
        System.out.println(service.setFavourite(1994));
        System.out.println("====================================================");
        service.getFavourites().forEach(System.out::println);
        System.out.println("====================================================");
        System.out.println(service.getRandomQuote());
    }
}
