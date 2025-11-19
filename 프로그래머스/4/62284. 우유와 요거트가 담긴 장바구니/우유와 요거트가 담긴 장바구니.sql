-- 코드를 입력하세요
WITH
cte as (
    SELECT distinct cart_id
    FROM cart_products
    WHERE name = 'Milk'
),
cte2 as (
    SELECT distinct cart_id
    FROM cart_products
    WHERE name = 'Yogurt'
)

SELECT a.cart_id
FROM cte as a 
    JOIN cte2 as b ON a.cart_id = b.cart_id
ORDER BY 1
 