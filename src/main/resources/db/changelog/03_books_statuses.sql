CREATE TABLE IF NOT EXISTS public.available (
    id          BIGSERIAL PRIMARY KEY,
    book_id     BIGINT NOT NULL REFERENCES public.book
);

CREATE TABLE IF NOT EXISTS public.reserved (
    id              BIGSERIAL PRIMARY KEY,
    reserved_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    book_id         BIGINT NOT NULL REFERENCES public.book,
    user_id         BIGINT NOT NULL REFERENCES public.library_user
);

CREATE TABLE IF NOT EXISTS public.borrowed (
    id              BIGSERIAL PRIMARY KEY,
    borrowed_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    book_id         BIGINT NOT NULL REFERENCES public.book,
    user_id         BIGINT NOT NULL REFERENCES public.library_user
);