CREATE TABLE quotes_by_id (
    quote_id UUID PRIMARY KEY,
    author_id UUID,
    quote_text TEXT,
    tags SET<TEXT>,
    created_at TIMESTAMP
);