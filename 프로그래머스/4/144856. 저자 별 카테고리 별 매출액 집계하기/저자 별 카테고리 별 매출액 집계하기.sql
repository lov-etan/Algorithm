WITH cte AS (
    SELECT book_id, sum(sales) as 'sum_sales'
    FROM BOOK_SALES
    WHERE YEAR(sales_date) = '2022' AND MONTH(sales_date) = '01'
    GROUP BY 1
)


# SELECT a.author_id, a.author_name, b.category, b.price*c.sum_sales as total_sales
# FROM book as b 
#     JOIN author as a ON b.author_id = a.author_id
#     JOIN cte as c on b.book_id = c.book_id
# GROUP BY 1, 3
# ORDER BY 1, 3 DESC


SELECT a.author_id, a.author_name, b.category, SUM(b.price*c.sum_sales) as total_sales
FROM book as b 
    JOIN author as a ON b.author_id = a.author_id
    JOIN cte as c on b.book_id = c.book_id
GROUP BY 1, 3
ORDER BY 1, 3 DESC