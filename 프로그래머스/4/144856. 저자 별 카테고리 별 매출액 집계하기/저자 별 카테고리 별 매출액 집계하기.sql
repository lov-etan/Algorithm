WITH filteredBS AS (
    SELECT book_id, SUM(SALES) as sum_sales
    FROM BOOK_SALES
    WHERE YEAR(sales_date) = '2022' AND MONTH(sales_date) = '01'
    GROUP BY book_id
)

# 저자ID별, 카테고리별 '매출액(판매량 * 판매가)'
SELECT a.author_id, a.author_name, b.category, 
        SUM(b.price * bs.sum_sales) as total_sales
FROM BOOK as b
    JOIN AUTHOR as a ON b.author_id = a.author_id
    JOIN filteredBS as bs ON b.book_id = bs.book_id
GROUP BY 1,2,3 
ORDER BY 1,3 DESC;

# SELECT *, SUM(SALES) as sum_sales
# FROM BOOK_SALES
# WHERE YEAR(sales_date) = '2022' AND MONTH(sales_date) = '01'
# GROUP BY book_id
    
# SELECT * FROM BOOK_SALES WHERE YEAR(sales_date) = '2022' AND MONTH(sales_date) = '01' ORDER BY book_id;
