package com.emc.programming_quotes.quote.model;

import static com.datastax.oss.driver.api.core.uuid.Uuids.timeBased;
import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;
import java.util.Set;
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
@Table("quotes_by_id")
public class QuoteById {

	@PrimaryKey
	@Column("quote_id")
    private UUID quoteId = timeBased();

	@Column("author_id")
	private UUID authorId;

	@Column("author_name")
	private String authorName;

	@Column("quote_text")
	private String quoteText;

	@Column("tags")
	private Set<String> tags;

	@Column("created_at")
	private LocalDateTime createdAt;

	public QuoteById(final UUID quoteId, final UUID authorId, final String authorName, final String quoteText) {
		this.quoteId = quoteId;
		this.authorId = authorId;
		this.authorName = authorName;
		this.quoteText = quoteText;
		createdAt = now();
	}

}
