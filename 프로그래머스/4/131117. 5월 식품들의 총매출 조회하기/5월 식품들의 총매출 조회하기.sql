# product_date가 2022년 5월
WITH cte AS (
    SELECT PRODUCT_ID, sum(AMOUNT) as sum_amount
    FROM FOOD_ORDER
    WHERE PRODUCE_DATE LIKE '2022-05%'
    GROUP BY 1
)

SELECT p.product_id, p.product_name, p.price * c.sum_amount as total_sales
FROM FOOD_PRODUCT as p
    JOIN cte as c
    ON p.product_id = c.product_id
ORDER BY 3 DESC, 1