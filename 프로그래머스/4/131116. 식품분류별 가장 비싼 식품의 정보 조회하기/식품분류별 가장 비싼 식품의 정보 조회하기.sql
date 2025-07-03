-- '식품분류별' 가격이 제일 비싼MAX 식품
-- '이때 식품분류 = IN (과자, 국, 김치, 식용유)'

WITH max_food AS (
    SELECT category, MAX(price) as max_p
    FROM food_product
    GROUP BY category
    HAVING category IN ('과자', '국', '김치', '식용유')
    ORDER BY category
)


SELECT a.category, b.max_p as max_price, a.product_name
FROM food_product as a
JOIN max_food as b
ON a.category = b.category AND a.price = b.max_p
ORDER BY 2 DESC