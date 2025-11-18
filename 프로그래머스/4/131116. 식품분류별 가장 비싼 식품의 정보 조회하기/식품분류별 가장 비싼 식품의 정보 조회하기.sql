WITH cte AS (
    SELECT category, MAX(price) as max_price
    FROM FOOD_PRODUCT
    WHERE category IN ('과자', '국', '김치', '식용유')
    GROUP BY 1
)

SELECT f.category, c.max_price, f.product_name
FROM FOOD_PRODUCT as f
JOIN cte as c ON f.category = c.category && f.price = c.max_price
GROUP BY 1
ORDER BY 2 DESC


