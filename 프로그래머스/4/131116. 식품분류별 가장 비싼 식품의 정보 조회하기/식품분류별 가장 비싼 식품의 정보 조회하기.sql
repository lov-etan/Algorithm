# 식품분류별로 - 제일 비싼 식품의 가격, 이름은?
WITH cte AS (
    SELECT category, max(price) as max_price
    FROM FOOD_PRODUCT
    WHERE category IN ('과자', '국', '김치', '식용유')
    GROUP BY 1
)

SELECT c.category, c.max_price, f.product_name
FROM food_product as f
    JOIN cte as c ON f.CATEGORY = c.CATEGORY AND f.price = c.max_price
ORDER BY 2 DESC