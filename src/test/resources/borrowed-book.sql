INSERT INTO public.borrowed (book_id, user_id)
 VALUES (
    (SELECT id FROM public.book WHERE title = 'Homo Deus'),
    (SELECT id FROM public.user WHERE email = 'john.doe@test.com')
);