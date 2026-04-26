package com.emc.programming_quotes.quote.model;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyClass
@NoArgsConstructor
@AllArgsConstructor
public class QuoteByAuthorKey implements Serializable {

	private static final long serialVersionUID = -5373314244718570577L;

	@PrimaryKeyColumn(name = "author_id", type = PARTITIONED)
    private UUID authorId;

    @PrimaryKeyColumn(name = "quote_id", type = CLUSTERED)
    private UUID quoteId;

}
