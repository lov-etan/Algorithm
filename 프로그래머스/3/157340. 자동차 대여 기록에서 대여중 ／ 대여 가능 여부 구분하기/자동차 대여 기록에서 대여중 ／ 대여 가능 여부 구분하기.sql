# 2022-10-16에 대여 중인 차 (대여중) / 아닌 차 (대여 가능)
WITH cte AS (
    SELECT distinct car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    WHERE start_date <= '2022-10-16' AND end_date >= '2022-10-16'
)

SELECT  distinct car_id, 
        (CASE
        WHEN car_id IN (SELECT car_id FROM cte) THEN '대여중'
        ELSE '대여 가능'
        END) as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY 1 DESC