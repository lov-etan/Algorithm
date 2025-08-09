# 2022년 5월 1일 기준 
# 5/1까지 출고완료, 이후는 출고대기, 미정이면 출고미정
SELECT  order_id, product_id, DATE_FORMAT(out_date, "%Y-%m-%d") as out_date,
        (
            CASE
            WHEN out_date <= '2022-05-01'THEN '출고완료'
            WHEN out_date > '2022-05-01' THEN '출고대기'
            WHEN out_date IS NULL THEN '출고미정'
            END
        ) as '출고여부'
FROM food_order
ORDER BY order_id
