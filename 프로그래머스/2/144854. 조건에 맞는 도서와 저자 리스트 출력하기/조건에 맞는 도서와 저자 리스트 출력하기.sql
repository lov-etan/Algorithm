SELECT b.book_id, a.author_name, DATE_FORMAT(b.published_date, "%Y-%m-%d") as published_date
FROM BOOK as b
    JOIN AUTHOR as a
    ON b.author_id = a.author_id
WHERE b.category = '경제'
ORDER BY 3