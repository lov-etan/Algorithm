# 종류 = 세단
# 10월에 대여 시작 기록
# 중복x!!!! 

SELECT distinct h.car_id
FROM 
    CAR_RENTAL_COMPANY_CAR as c
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    ON c.car_id = h.car_id
WHERE 
    c.car_type = '세단'
    AND h.start_date LIKE '2022-10%'
ORDER BY 1 DESC