package com.emc.programming_quotes.author;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emc.programming_quotes.author.model.Author;
import com.emc.programming_quotes.author.service.AuthorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorService authorService;

	@GetMapping
	public List<Author> findAll() {
		return authorService.findAll();
	}

	@PostMapping
	public Author create(@RequestBody final Author author) {
		return authorService.create(author);
	}

	@PutMapping("/{id}")
	public Author update(@PathVariable final UUID id, @RequestBody final Author author) {
	    author.setAuthorId(id);
	    return authorService.update(author);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final UUID id) {
		authorService.delete(id);
	}

}
