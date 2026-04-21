package com.emc.programming_quotes.author.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.emc.programming_quotes.author.model.Author;

@Repository
public interface AuthorRepository extends CassandraRepository<Author, UUID> {

}
