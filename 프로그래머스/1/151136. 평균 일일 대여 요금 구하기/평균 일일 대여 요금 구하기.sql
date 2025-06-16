SELECT round(avg(daily_fee), 0) as AVERAGE_FEE -- 첫번째 자리에서 반올림(결과, 0)
FROM car_rental_company_car
WHERE car_type = 'SUV'