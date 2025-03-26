-- 코드를 입력하세요
SELECT book_id, date_format(published_date, "%Y-%m-%d") as PUBLISHED_DATE
FROM book
WHERE year(published_date) = 2021 AND category = '인문'
ORDER BY PUBLISHED_DATE;