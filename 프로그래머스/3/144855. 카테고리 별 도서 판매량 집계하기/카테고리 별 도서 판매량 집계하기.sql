#2022년 1월 '카테고리 별' '도서 판매량 합산'
SELECT b.category, sum(bs.sales) as TOTAL_SALES
FROM book as b 
    JOIN book_sales as bs ON b.book_id = bs.book_id
WHERE bs.sales_date LIKE '2022-01%'
GROUP BY 1
ORDER BY 1