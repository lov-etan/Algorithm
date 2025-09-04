# 종류 = 세단, SUV | 2022 11월
# 할인 적용 * 30 * 금액 -> 총 50-200만원
WITH
nov AS (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date <='2022-11-30' AND end_date >= '2022-11-01'
)
, cte AS (
    SELECT c.car_id, c.car_type, c.daily_fee
    FROM   CAR_RENTAL_COMPANY_CAR as c
            JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
            ON c.car_id = h.car_id
    WHERE  c.car_id NOT IN (SELECT car_id FROM nov)
            AND c.car_type IN ('SUV', '세단')
)


SELECT distinct c.car_id, c.car_type, FLOOR((c.daily_fee*30*(1-p.discount_rate/100))) as fee
FROM cte as c
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
        ON c.car_type = p.car_type
WHERE p.duration_type = '30일 이상'
        AND c.daily_fee*30*(1-p.discount_rate/100) >= 500000
        AND c.daily_fee*30*(1-p.discount_rate/100) < 2000000
ORDER BY 3 DESC, 2, 1 DESC