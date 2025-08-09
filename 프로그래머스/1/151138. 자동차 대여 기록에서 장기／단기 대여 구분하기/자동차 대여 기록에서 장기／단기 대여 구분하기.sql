# 2022년 9월에 속하는 대여 기록
# 대여 기간 : 30이상 - 장기 / ELSE 단기
SELECT  history_id, car_id, 
        DATE_FORMAT(start_date, "%Y-%m-%d") as start_date,
        DATE_FORMAT(end_date, "%Y-%m-%d") as end_date, 
        (
            CASE
            WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '장기 대여'
            ELSE '단기 대여'
            END
        ) as rent_type
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date LIKE '2022-09%'
ORDER BY 1 DESC
