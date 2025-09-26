# 자동차 종류: '트럭'
# 대여 기록(대여기록ID) 별 대여 금액
WITH cte AS (
    SELECT distinct history_id, h.car_id, DATEDIFF(end_date, start_date)+1 as dates, c.car_type,
         (CASE
            WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
            ELSE '7일 미만'
          END) as duration_type
    FROM CAR_RENTAL_COMPANY_CAR as c
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as h ON c.car_id = h.car_id
    WHERE car_type = '트럭'
)


SELECT history_id, 
        TRUNCATE(dates * daily_fee * (1 - IFNULL(p.DISCOUNT_RATE/100, 0)),0) as fee
FROM CAR_RENTAL_COMPANY_CAR as c
    JOIN cte as h ON c.car_id = h.car_id AND c.car_id = h.car_id
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p ON h.duration_type = p.duration_type AND h.car_type = p.car_type
WHERE c.car_type = '트럭'
ORDER BY 2 DESC, 1 DESC