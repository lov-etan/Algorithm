# MAX(조건식)은 TRUE가 하나라도 있으면 1 반환
# 즉, 해당 차의 기록 중 하나라도 '대여중'이면 그렇게 분류됨
SELECT car_id, 
    (case 
        WHEN max(date(start_date) <= '2022-10-16' AND date(end_date) >= '2022-10-16') 
            THEN '대여중'
        ELSE '대여 가능' 
     end) as availability
FROM car_rental_company_rental_history 
GROUP BY car_id
ORDER BY car_id desc;