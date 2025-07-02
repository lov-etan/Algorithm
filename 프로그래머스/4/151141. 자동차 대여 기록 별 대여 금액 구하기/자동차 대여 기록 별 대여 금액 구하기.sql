-- HISTORY_ID -> car_id = 1 (트럭)
-- end_date,start_date+1 case when >= 7 THEN '7일이상' && car_type = 위

WITH RENT AS (
    SELECT car.car_id, car.car_type, car.daily_fee, his.history_id, his.start_date, his.end_date,
        CASE
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 7 THEN '7일 이상'
        ELSE '7일 미만'
        END as duration_type
    FROM car_rental_company_car as car
    JOIN car_rental_company_rental_history as his
    ON car.car_id = his.car_id
    WHERE car.car_type = '트럭'
)

SELECT distinct rent.history_id, 
    FLOOR(rent.daily_fee * (1-IFNULL(plan.discount_rate,0)/100))*(DATEDIFF(rent.end_date, rent.start_date)+1) as fee
FROM car_rental_company_discount_plan as plan
RIGHT JOIN rent 
ON plan.car_type = rent.car_type AND plan.duration_type = rent.duration_type
ORDER BY 2 DESC, 1 DESC