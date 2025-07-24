# 식품분류별로 가격이 제일 비싼 식품!의 분류, 가격, 이름
# 과자 국 김치 식용유만 궁금
WITH filtered AS (
    SELECT category, max(price)
    FROM FOOD_PRODUCT
    WHERE category IN ('과자', '국', '김치', '식용유')
    GROUP BY category
)

SELECT category, price as max_price, product_name
FROM FOOD_PRODUCT
WHERE (category, price) IN (SELECT * FROM filtered)
ORDER BY 2 DESC


