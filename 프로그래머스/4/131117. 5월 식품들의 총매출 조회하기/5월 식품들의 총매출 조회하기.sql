-- 코드를 입력하세요
SELECT distinct p.product_id, p.product_name, sum(p.price*o.amount) as total_sales
FROM food_product as p
    JOIN food_order as o ON p.product_id = o.product_id
WHERE year(o.produce_date) = 2022 and month(o.produce_date) = 5
GROUP BY p.product_id
ORDER BY total_sales desc, product_id asc