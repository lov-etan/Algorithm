WITH filtered AS (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY car_id
    HAVING count(car_id) >= 5
)

SELECT MONTH(a.start_date) as month, a.car_id, count(a.car_id) as records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY as a JOIN filtered as b ON a.car_id = b.car_id
WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY 1,2
ORDER BY 1, 2 DESC;

# SELECT * 
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
#     WHERE DATE_FORMAT(start_date, "%Y-%m-%d") BETWEEN '2022-08' AND '2022-10'
#     GROUP BY car_id
#     HAVING count(car_id) >= 5;