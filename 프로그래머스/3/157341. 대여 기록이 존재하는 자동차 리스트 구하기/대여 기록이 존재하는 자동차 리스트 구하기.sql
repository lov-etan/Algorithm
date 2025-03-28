-- 자동차 종류: '세단'
-- 10월에 대여를 시작한 기록이 있는 자동차 ID
SELECT distinct car.car_id
FROM car_rental_company_car as car
    JOIN car_rental_company_rental_history as his ON car.car_id = his.car_id
WHERE car.car_type = '세단' 
    AND month(his.start_date) = 10
ORDER BY car_id desc;