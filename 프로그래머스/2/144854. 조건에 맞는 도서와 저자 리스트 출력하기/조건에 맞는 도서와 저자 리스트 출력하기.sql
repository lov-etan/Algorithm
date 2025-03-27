-- 코드를 입력하세요
SELECT book_id, author_name, date_format(published_date, "%Y-%m-%d") as published_date
FROM book as b
    JOIN author as a ON b.author_id = a.author_id
WHERE b.category = '경제' 
ORDER BY published_date ASC;