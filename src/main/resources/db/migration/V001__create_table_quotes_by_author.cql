CREATE TABLE IF NOT EXISTS quotes.quotes_by_author (
    author_id UUID,
    quote_id UUID,
    quote_text TEXT,
    PRIMARY KEY (author_id, quote_id)
);