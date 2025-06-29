# 상품코드 별 매출액(판매가*판매량) 합계
SELECT p.product_code, (s.sum_amount * p.price) as sales
FROM product as p
    JOIN (SELECT *, SUM(sales_amount) as sum_amount 
          FROM offline_sale GROUP BY product_id) as s
    ON p.product_id = s.product_id
GROUP BY product_code
ORDER BY 2 DESC, 1