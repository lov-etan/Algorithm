-- 코드를 입력하세요
SELECT distinct car.car_id, car.car_type, ROUND(30 * car.daily_fee * (100 - plan.discount_rate) / 100) as fee
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as his 
    JOIN(CAR_RENTAL_COMPANY_CAR as car 
            JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as plan ON car.car_type = plan.car_type)
    ON his.car_id = car.car_id
WHERE car.car_type IN ('세단', 'SUV') AND plan.duration_type = '30일 이상'
    AND car.car_id NOT IN(SELECT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE 
                            start_date <= '2022-11-30' AND end_date >= '2022-11-01')
HAVING fee >= 500000 AND fee < 2000000
ORDER BY fee desc, car.car_type, car.car_id DESC;