package com.emc.programming_quotes.author.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emc.programming_quotes.author.model.Author;
import com.emc.programming_quotes.author.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

	private final AuthorRepository authorRepository;

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author create(final Author author) {
		return authorRepository.save(author);
	}

	public Author update(final Author author) {
		return authorRepository.save(author);
	}

	public void delete(final UUID id) {
		authorRepository.deleteById(id);
	}

}
