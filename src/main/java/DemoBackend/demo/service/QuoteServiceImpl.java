package DemoBackend.demo.service;

import DemoBackend.demo.model.Quote;
import DemoBackend.demo.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Override
    public List<Quote> getAllQuote() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Integer id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Quote not found!"));
    }

    @Override
    public void addQuote(Quote quote) {
        Optional<Quote> quoteOp = quoteRepository.findById(quote.getId());
        if (quoteOp.isPresent())
            throw new IllegalArgumentException("Quote already exists!");

        quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Quote quote) {
        this.getQuoteById(quote.getId());
        return quoteRepository.save(quote);
    }

    @Override
    public void deleteQuote(Integer id) {
        this.getQuoteById(id);
        quoteRepository.deleteById(id);
    }
}
