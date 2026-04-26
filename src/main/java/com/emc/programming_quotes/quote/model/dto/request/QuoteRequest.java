package com.emc.programming_quotes.quote.model.dto.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class QuoteRequest {

	private UUID authorId;
    private String text;
    private List<String> tags;

}
