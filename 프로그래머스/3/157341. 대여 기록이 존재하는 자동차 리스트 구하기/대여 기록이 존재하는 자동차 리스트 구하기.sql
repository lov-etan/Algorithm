-- 10월에 대여 시작
-- '세단' 종류

SELECT DISTINCT car.car_id
FROM car_rental_company_car as car
JOIN car_rental_company_rental_history as his
ON car.car_id = his.car_id
WHERE MONTH(his.start_date) = 10 AND car.car_type = '세단'
ORDER BY 1 DESC