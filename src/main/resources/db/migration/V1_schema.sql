CREATE SCHEMA IF NOT EXISTS data;

CREATE TABLE IF NOT EXISTS instruments
(
    instrument_id SERIAL NOT NULL
    CONSTRAINT instrument_pk
    PRIMARY KEY,
    isin           TEXT NOT NULL UNIQUE,
    description    TEXT,
    created_at     TIMESTAMPTZ NOT NULL
);

CREATE TABLE IF NOT EXISTS quotes
(
    isin TEXT NOT NULL
    CONSTRAINT instrument_fk
    REFERENCES instruments(isin) ON DELETE CASCADE,
    price         NUMERIC(15,4) NOT NULL,
    created_at    TIMESTAMPTZ NOT NULL
    );

CREATE INDEX IF NOT EXISTS quotes_isin_created_at_idx
    ON quotes (isin, created_at);
