package com.emc.programming_quotes.quote.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("quotes_by_author")
public class QuoteByAuthor {


	@PrimaryKey
    private QuoteByAuthorKey quoteByAuthorKey;

	@Column("author_name")
	private String authorName;

	@Column("quote_text")
	private String quoteText;

	public QuoteByAuthor(final UUID authorId, final UUID quoteId, final String authorName, final String quoteText) {
		quoteByAuthorKey = new QuoteByAuthorKey(authorId, quoteId);
		this.authorName = authorName;
		this.quoteText = quoteText;
	}

}
