# 2022년 1월 기준
# 저자 별, 카테고리 별 매출액
WITH cte AS (
    SELECT book_id, sum(sales) as sum_sales
    FROM BOOK_SALES
    WHERE SALES_DATE LIKE '2022-01%'
    GROUP BY 1
)

SELECT a.author_id, a.author_name, b.category, SUM(b.PRICE*c.sum_sales) as total_sales
FROM BOOK as b
    JOIN AUTHOR as a ON b.author_id = a.author_id
    JOIN cte as c ON b.book_id = c.book_id
GROUP BY 1,3
ORDER BY 1, 3 DESC


