package com.emc.programming_quotes.quote.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.emc.programming_quotes.author.model.Author;
import com.emc.programming_quotes.author.service.AuthorService;
import com.emc.programming_quotes.quote.model.QuoteByAuthor;
import com.emc.programming_quotes.quote.model.QuoteById;
import com.emc.programming_quotes.quote.model.QuoteByTag;
import com.emc.programming_quotes.quote.model.dto.request.QuoteRequest;
import com.emc.programming_quotes.quote.repository.QuoteByAuthorRepository;
import com.emc.programming_quotes.quote.repository.QuoteByIdRepository;
import com.emc.programming_quotes.quote.repository.QuoteByTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuoteService {

	private final QuoteByIdRepository quotesByIdRepository;
	private final QuoteByTagRepository quoteByTagRepository;
	private final QuoteByAuthorRepository quoteByAuthorRepository;

	private final AuthorService authorService;

	public String createQuote(final QuoteRequest request) {
		final UUID quoteId = Uuids.timeBased();

	    final Author author = authorService.findById(request.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

	    quotesByIdRepository.save(new QuoteById(quoteId, request.getAuthorId(), author.getName(), request.getText()));
	    quoteByAuthorRepository.save(new QuoteByAuthor(request.getAuthorId(), quoteId, author.getName(), request.getText()));

	    saveTagQuote(request, quoteId, author);

	    return quoteId.toString();
	}

	private void saveTagQuote(final QuoteRequest request, final UUID quoteId, final Author author) {
		for (final String tag : request.getTags()) {
	        quoteByTagRepository.save(
	            new QuoteByTag(tag, quoteId, request.getAuthorId(), author.getName(), request.getText())
	        );
	    }
	}

	public void updateQuote(final UUID quoteId, final QuoteRequest request) {
		final Author author = authorService.findById(request.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));

	    quotesByIdRepository.save(new QuoteById(quoteId, request.getAuthorId(), author.getName(), request.getText()));
	    quoteByAuthorRepository.save(new QuoteByAuthor(request.getAuthorId(), quoteId, author.getName(), request.getText()));

	    saveTagQuote(request, quoteId, author);
	}

	public Optional<QuoteById> findById(final UUID quoteId) {
		return quotesByIdRepository.findById(quoteId);
	}

	public Optional<QuoteById> findRandomQuote() {
		final List<QuoteById> quotes = quotesByIdRepository.findAll();
	    if (quotes.isEmpty()) {
	        return Optional.empty();
	    }

		return Optional.of(quotes.get((int) (Math.random() * quotes.size())));
	}

}
