CREATE TABLE IF NOT EXISTS public.available (
    id          BIGSERIAL PRIMARY KEY,
    book_id     BIGINT NOT NULL REFERENCES public.book
);

CREATE TABLE IF NOT EXISTS public.reserved (
    id          BIGSERIAL PRIMARY KEY,
    book_id     BIGINT NOT NULL REFERENCES public.book,
    user_id     BIGINT NOT NULL REFERENCES public.user
);

CREATE TABLE IF NOT EXISTS public.borrowed (
    id          BIGSERIAL PRIMARY KEY,
    book_id     BIGINT NOT NULL REFERENCES public.book,
    user_id     BIGINT NOT NULL REFERENCES public.user
);