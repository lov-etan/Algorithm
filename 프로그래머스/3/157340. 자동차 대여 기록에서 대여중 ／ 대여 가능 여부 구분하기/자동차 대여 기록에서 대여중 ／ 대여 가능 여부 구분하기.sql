WITH cte AS (
    SELECT distinct car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date <= '2022-10-16' && '2022-10-16' <= end_date
)

SELECT car_id, 
        (CASE 
         WHEN car_id IN (SELECT car_id FROM cte) THEN '대여중'
         ELSE '대여 가능'
         END) as availability
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY 1
ORDER BY 1 DESC
