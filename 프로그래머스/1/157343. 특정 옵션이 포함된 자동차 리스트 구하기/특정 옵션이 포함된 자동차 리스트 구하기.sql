-- 네비게이션 옵션이 포함된 자동차 
SELECT car_id, car_type, daily_fee, options
FROM car_rental_company_car
WHERE options like "%네비게이션%"
ORDER BY car_id desc;