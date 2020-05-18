CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    book_external_id varchar(100) NOT NULL UNIQUE,
    isbn_10 varchar(10) DEFAULT NULL,
    isbn_13 varchar(13) DEFAULT NULL,
    title varchar(200) NOT NULL,
    publisher varchar(200) DEFAULT NULL,
    published_date varchar(100) DEFAULT NULL,
    description text DEFAULT NULL,
    page_count int(6) DEFAULT NULL,
    image_link varchar(1000) DEFAULT NULL
);

CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name varchar(200) NOT NULL UNIQUE
);

CREATE TABLE book_author (
    id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES book(id),
    author_id INTEGER REFERENCES author(id)
);