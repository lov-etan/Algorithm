-- 대여 시작일이 2022년 9월에 속하는 대여 기록
-- 대여 기간이 30일 -> 장기 / 단기 
SELECT history_id, car_id, date_format(start_date, "%Y-%m-%d") as start_date, date_format(end_date,"%Y-%m-%d") as end_date, 
    (case
        when dateDiff(end_date, start_date)+1 >= 30 then '장기 대여'
        when dateDiff(end_date, start_date)+1 < 30 then '단기 대여'
    end )as rent_type
FROM car_rental_company_rental_history
WHERE date_format(start_date, "%Y-%m-%d") like '2022-09%'
ORDER BY history_id desc