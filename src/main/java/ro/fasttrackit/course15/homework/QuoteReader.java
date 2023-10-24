package ro.fasttrackit.course15.homework;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuoteReader {
    private static int QUOTE_ID = 0;
    private final String inputFile;

    public List<Quote> readQuotes() {
        try (Scanner scanner = new Scanner(Path.of(inputFile))) {
            List<Quote> quotes = new ArrayList<>();
            while (scanner.hasNextLine()) {
                quotes.add(buildQuote(scanner.nextLine()));
            }
            return quotes;
        } catch (IOException e) {
            throw new RuntimeException("Error reading quotes from file %s: %s".formatted(inputFile, e.getMessage()));
        }
    }

//    public List<Quote> bufferedReadQuotes() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
//            return reader.lines()
//                    .map(this::buildQuote)
//                    .toList();
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading quotes from file %s: %s".formatted(inputFile, e.getMessage()));
//        }
//    }

    private Quote buildQuote(String line) {
        String[] tokens = line.split("~");
        return Quote.builder()
                .id(++QUOTE_ID)
                .author(tokens[0])
                .quote(tokens[1])
                .build();
    }
}
