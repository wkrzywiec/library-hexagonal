INSERT INTO public.borrowed (book_id, user_id)
 VALUES (
    (SELECT id FROM book WHERE title = 'Homo Deus'),
    (SELECT id FROM library_user WHERE email = 'john.doe@test.com')
);