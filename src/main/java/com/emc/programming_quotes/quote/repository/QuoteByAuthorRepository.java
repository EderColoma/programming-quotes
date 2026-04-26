package com.emc.programming_quotes.quote.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.emc.programming_quotes.quote.model.QuoteByAuthor;
import com.emc.programming_quotes.quote.model.QuoteByAuthorKey;

public interface QuoteByAuthorRepository extends CassandraRepository<QuoteByAuthor, QuoteByAuthorKey> {

}
