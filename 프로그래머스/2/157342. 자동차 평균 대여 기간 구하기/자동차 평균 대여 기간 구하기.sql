-- 평균 대여 기간(round1 )이 7일 이상
SELECT car_id, ROUND(AVG(DATEDIFF(dd, end_date, start_date)+1),1) as average_duration
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING AVG(DATEDIFF(dd, end_date, start_date)+1) >= 7
ORDER BY 2 DESC, 1 DESC

-- DATEDIFF(end_date, start_date)