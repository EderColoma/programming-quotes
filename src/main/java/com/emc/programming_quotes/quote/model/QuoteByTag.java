package com.emc.programming_quotes.quote.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table("quotes_by_tag")
public class QuoteByTag {

	@PrimaryKey
    private QuoteByTagKey quoteByTagKey;

	@Column("author_id")
    private UUID authorId;

	@Column("author_name")
    private String authorName;

	@Column("quote_text")
    private String quoteText;

    public QuoteByTag(final String tag, final UUID quoteId, final UUID authorId, final String authorName, final String quoteText) {
		quoteByTagKey = new QuoteByTagKey(tag, quoteId);
		this.authorId = authorId;
		this.authorName = authorName;
		this.quoteText = quoteText;
	}

}
