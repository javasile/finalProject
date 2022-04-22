package DemoBackend.demo.service;

import DemoBackend.demo.model.Quote;

import java.util.List;

public interface QuoteService {

    List<Quote> getAllQuote();

    Quote getQuoteById(Integer id);

    void addQuote(Quote quote);

    Quote updateQuote(Quote quote);

    void deleteQuote(Integer id);
}
