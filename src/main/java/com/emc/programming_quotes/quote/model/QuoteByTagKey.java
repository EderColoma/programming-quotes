package com.emc.programming_quotes.quote.model;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class QuoteByTagKey {

	@PrimaryKeyColumn(name = "tag", type = PARTITIONED)
    private String tag;

    @PrimaryKeyColumn(name = "quote_id", type = CLUSTERED)
    private UUID quoteId;

}
