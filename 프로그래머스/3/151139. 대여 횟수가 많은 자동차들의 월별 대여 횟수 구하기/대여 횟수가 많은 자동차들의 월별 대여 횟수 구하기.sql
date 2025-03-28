-- 2022-08부터 2022-10까지 총 대여 횟수가 5회 이상 월별 / 자동차 id
-- 특정 월의 총 대여 횟수가 0인 경우 결과에서 제외하기 
SELECT month(start_date) as month, car_id, count(car_id) as records 
FROM car_rental_company_rental_history
WHERE start_date between '2022-08-01' and '2022-10-31'
    AND car_id in (SELECT car_id
        FROM car_rental_company_rental_history
        WHERE start_date between '2022-08-01' and '2022-10-31'
        GROUP BY car_id
        HAVING count(car_id) >= 5)
GROUP BY month, car_id
ORDER BY month asc, car_id desc;



# 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차
# SELECT car_id
# FROM car_rental_company_rental_history
# WHERE start_date between '2022-08-01' and '2022-10-31'
# GROUP BY car_id
# HAVING count(car_id) >= 5