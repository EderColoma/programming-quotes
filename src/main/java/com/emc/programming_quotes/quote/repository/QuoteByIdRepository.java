package com.emc.programming_quotes.quote.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.emc.programming_quotes.quote.model.QuoteById;

@Repository
public interface QuoteByIdRepository extends CassandraRepository<QuoteById, UUID>{

}
