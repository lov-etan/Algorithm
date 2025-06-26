SELECT p.product_id, p.product_name, sum(p.price*o.amount) as total_sales
FROM food_product as p 
    JOIN food_order as o ON p.product_id = o.product_id
WHERE YEAR(o.produce_date) = '2022' && MONTH(o.produce_date) = '5'
GROUP BY o.product_id
ORDER BY 3 DESC , 1
