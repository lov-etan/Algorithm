-- 3 중 하나 이상의 옵션이 포함된 자동차가 종류 별로 몇 대? 
SELECT car_type, count(*) as cars
FROM car_rental_company_car
WHERE options like '%통풍시트%' OR options like '%열선시트%' OR options like '%가죽시트%'
GROUP BY car_type
ORDER BY car_type
