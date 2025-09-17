# 2022-08 ~ 2022-10 : 총 대여 횟수가 5회!
# 월별 자동자ID별 대여 횟수
WITH cte AS (
    SELECT *
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date >= '2022-08-01' && start_date <= '2022-10-31'
    GROUP BY car_id
    HAVING count(history_id) >= 5
)

SELECT MONTH(h.start_date) as month, h.car_id, count(c.history_id) as records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    JOIN cte as c ON h.car_id = c.car_id
WHERE h.start_date >= '2022-08-01' && h.start_date <= '2022-10-31'
GROUP BY 1,2
ORDER BY 1, 2 DESC
