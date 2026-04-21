package com.emc.programming_quotes.author.model;

import static com.datastax.oss.driver.api.core.uuid.Uuids.timeBased;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("authors")
public class Author {

	@PrimaryKey
	@Column("author_id")
    private UUID authorId = timeBased();

    @Column("name")
    private String name;

    @Column("bio")
    private String bio;

}
