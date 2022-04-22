package DemoBackend.demo.controller;

import DemoBackend.demo.model.Quote;
import DemoBackend.demo.service.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteServiceImpl quoteService;

    @GetMapping("/all")
    public ResponseEntity<List<Quote>> findAll() {
        return ResponseEntity.ok(quoteService.getAllQuote());
    }

    @GetMapping(value = "/quote/{id}")
    public Quote getQuoteById(@PathVariable("id") Integer id) {
        return quoteService.getQuoteById(id);
    }

    @PutMapping("/editQuote")
    public void addQuote(@RequestBody Quote quote) {
        quoteService.updateQuote(quote);
    }

    @DeleteMapping("/deleteQuote/{id}")
    public void deleteQuote(@PathVariable Integer id) {
        quoteService.deleteQuote(id);
    }

    @PatchMapping("/updateQuote")
    public void updateQuote(@RequestBody Quote quote) {
        quoteService.updateQuote(quote);
    }

    @PostMapping("/newQuote")
    public void saveQuote(@RequestBody Quote quote) {
        quoteService.addQuote(quote);
    }
}
