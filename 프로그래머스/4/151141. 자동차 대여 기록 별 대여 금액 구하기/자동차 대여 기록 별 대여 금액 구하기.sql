# 차 종류 = '트럭'
# 대여 기록(history_id) 별 대여 금액(Fee)
WITH 
history AS (
    SELECT
        (
            CASE
            WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
            ELSE '7일 미만'
            END
        ) as duration_type, DATEDIFF(end_date, start_date)+1 as duration, history_id, h.car_id, c.daily_fee, c.car_type
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    JOIN CAR_RENTAL_COMPANY_CAR as c
    ON h.car_id = c.car_id
    WHERE car_type = '트럭'
)

# h.history_id, ROUND((c.daily_fee * (1 - p.discount_rate/100) * h.duration),0) as fee
SELECT 
        h.history_id, 
        FLOOR((h.daily_fee * (1 - IFNULL(p.discount_rate/100, 0)) * h.duration)) as fee
FROM history as h
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
ON h.car_type = p.car_type AND h.duration_type = p.duration_type
GROUP BY 1
ORDER BY 2 DESC, 1 DESC

# SELECT * FROM history
# SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN