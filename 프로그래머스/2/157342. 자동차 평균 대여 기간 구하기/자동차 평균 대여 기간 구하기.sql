-- 평균 대여 기간이 7일 이상인 자동차
-- ROUND(평균대여기간, 2)
SELECT car_id, round(avg(dateDiff(end_date, start_date)+1),1) as average_duration
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY car_id
HAVING average_duration >= 7
ORDER BY average_duration desc, car_id desc