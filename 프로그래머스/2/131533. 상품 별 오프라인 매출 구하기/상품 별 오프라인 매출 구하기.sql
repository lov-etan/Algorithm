-- 상품코드 별 매출액(판매가 * 판매량) -상품코드 앞2자리: 카테고리 코드
SELECT product_code, (p.price * sum(off.sales_amount)) as sales
FROM product as p JOIN offline_sale as off ON p.product_id = off.product_id
GROUP BY product_code
ORDER BY sales desc, product_code asc