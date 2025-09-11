-- 상품코드 별 매출액(판매가 * 판매량) 합계
SELECT p.product_code, SUM(sales_amount)*p.price as sales
FROM PRODUCT as p 
    JOIN OFFLINE_SALE as o ON p.product_id = o.product_id
GROUP BY 1
ORDER BY 2 DESC, 1 ASC
