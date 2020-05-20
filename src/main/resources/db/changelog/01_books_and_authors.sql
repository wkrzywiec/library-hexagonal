CREATE TABLE IF NOT EXISTS public.book (
    id                  BIGSERIAL PRIMARY KEY,
    book_external_id    CHARACTER VARYING(255) NOT NULL UNIQUE,
    isbn_10             CHARACTER VARYING(10) DEFAULT NULL,
    isbn_13             CHARACTER VARYING(13) DEFAULT NULL,
    title               CHARACTER VARYING(255) NOT NULL,
    publisher           CHARACTER VARYING(255) DEFAULT NULL,
    published_date      CHARACTER VARYING(255) DEFAULT NULL,
    description         TEXT DEFAULT NULL,
    page_count          INTEGER DEFAULT NULL,
    image_link          CHARACTER VARYING(1000) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS public.author (
    id          BIGSERIAL PRIMARY KEY,
    name        CHARACTER VARYING(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.book_author (
    id          BIGSERIAL PRIMARY KEY,
    book_id     BIGINT NOT NULL REFERENCES public.book,
    author_id   BIGINT NOT NULL REFERENCES public.author
);