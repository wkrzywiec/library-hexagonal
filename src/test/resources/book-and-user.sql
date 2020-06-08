INSERT INTO author (name) VALUES
('Yuval Noah Harari')
;

INSERT INTO book (book_external_id,isbn_10,isbn_13,title,publisher,published_date,description,page_count,image_link) VALUES
('dWYyCwAAQBAJ','1473545374','9781473545373','Homo Deus','Random House','2016-09-08','<p><b>**THE MILLION COPY BESTSELLER**</b><br> <b></b><br><b> <i>Sapiens </i>showed us where we came from. In uncertain times, <i>Homo Deus</i> shows us where we’re going.</b></p><p> Yuval Noah Harari envisions a near future in which we face a new set of challenges. <i>Homo Deus</i> explores the projects, dreams and nightmares that will shape the twenty-first century and beyond – from overcoming death to creating artificial life.</p><p> It asks the fundamental questions: how can we protect this fragile world from our own destructive power? And what does our future hold?<br> <b></b><br><b> ''<i>Homo Deus</i> will shock you. It will entertain you. It will make you think in ways you had not thought before’ Daniel Kahneman, bestselling author of <i>Thinking, Fast and Slow</i></b></p>',528,'http://books.google.com/books/content?id=dWYyCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE73PkLs4TNB-W2uhDvXJkIB4-9G9AJ_L1iYTYLEXa3zi2kahdsN9-_0tL7WRWgujNpjMA5ZuJO7_ykFUlCWAyLzcQVcGkqUS-NOkUkEcJ_ZRrgq48URpcfBrJWQCwSWtHo5pEGkp&source=gbs_api')
;

INSERT INTO book_author (book_id, author_id)
SELECT b.id, a.id
FROM public.book b, public.author a
WHERE b.title = 'Homo deus' AND a.name = 'Yuval Noah Harari'
;

INSERT INTO library_user (first_name, last_name, email) VALUES
('John','Doe','john.doe@test.com')
;