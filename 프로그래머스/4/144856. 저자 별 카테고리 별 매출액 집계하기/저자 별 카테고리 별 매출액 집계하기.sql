SELECT a.author_id, a.author_name, b.category, SUM(bs.sales*b.price) as total_sales
FROM book as b
    JOIN author as a
    ON b.author_id = a.author_id
    JOIN book_sales as bs
    ON b.book_id = bs.book_id
WHERE bs.SALES_DATE LIKE '2022-01%'
GROUP BY 1, 3
ORDER BY 1 , 3 DESC