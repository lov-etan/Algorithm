# 2022-05-01 기준 출고완료 / 이후 : 출고대기 / NULL: 출고미정
SELECT order_id, product_id, DATE_FORMAT(out_date,"%Y-%m-%d") as out_date, 
        (CASE
            WHEN out_date <= '2022-05-01' THEN '출고완료'
            WHEN out_date > '2022-05-01' THEN '출고대기'
            ELSE '출고미정'
        END) as '출고여부'
FROM FOOD_ORDER
ORDER BY 1