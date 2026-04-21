CREATE TABLE quotes_by_tag (
    tag TEXT,
    quote_id UUID,
    author_id UUID,
    quote_text TEXT,
    PRIMARY KEY (tag, quote_id)
);