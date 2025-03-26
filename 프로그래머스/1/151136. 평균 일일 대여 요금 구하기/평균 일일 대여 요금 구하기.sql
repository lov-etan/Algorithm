-- 코드를 입력하세요
SELECT round(avg(daily_fee)) as AVERAGE_FEE
FROM car_rental_company_car
WHERE car_type = 'SUV';