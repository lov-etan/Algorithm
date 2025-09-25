# 2021년 1월 카테고리 별 도서 판매량 합산!
SELECT category, sum(sales) as total_sales
FROM BOOK as b
    JOIN BOOK_SALES as bs ON b.book_id = bs.book_id
WHERE sales_date LIKE '2022-01%'
GROUP BY 1
ORDER BY 1