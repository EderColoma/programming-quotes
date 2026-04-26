package com.emc.programming_quotes.quote.model.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emc.programming_quotes.quote.model.QuoteById;
import com.emc.programming_quotes.quote.model.dto.request.QuoteRequest;
import com.emc.programming_quotes.quote.service.QuoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quote")
public class QuoteController {

	private final QuoteService quoteService;

	@GetMapping("/{quoteId}")
	public QuoteById getQuoteById(@PathVariable final UUID quoteId) {
		return quoteService.findById(quoteId).orElseThrow(() -> new RuntimeException("Quote not found"));
	}

	@GetMapping("/random")
	public QuoteById getRandomQuote() {
		return quoteService.findRandomQuote().orElseThrow(() -> new RuntimeException("Quote not found"));
	}

	@PostMapping
	public String createQuote(@RequestBody final QuoteRequest request) {
		return quoteService.createQuote(request);
	}

	@PutMapping("/{quoteId}")
	public void updateQuote(@PathVariable final UUID quoteId, @RequestBody final QuoteRequest request) {
		quoteService.updateQuote(quoteId, request);
	}

}
