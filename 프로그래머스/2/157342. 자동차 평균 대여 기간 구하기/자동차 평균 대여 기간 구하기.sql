# 평균 대여 기간(round 1)이 7일 이상 
# 자동차 ID, 평균 대여 기간
SELECT car_id, ROUND(AVG(DATEDIFF(end_date, start_date)+1), 1) as average_duration
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY 1
HAVING AVG(DATEDIFF(end_date, start_date)+1) >= 7
ORDER BY 2 DESC, 1 DESC
