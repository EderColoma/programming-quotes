package com.emc.programming_quotes.quote.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.emc.programming_quotes.quote.model.QuoteByTag;
import com.emc.programming_quotes.quote.model.QuoteByTagKey;

public interface QuoteByTagRepository extends CassandraRepository<QuoteByTag, QuoteByTagKey> {

}
