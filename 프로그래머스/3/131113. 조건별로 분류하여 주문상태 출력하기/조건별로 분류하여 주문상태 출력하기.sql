-- 2022년 5월 1일 기준
-- 출고여부(2022년 5월 1일까지 <- 출료완료 | 이후 <- 출고미정)
SELECT order_id, product_id, date_format(out_date,"%Y-%m-%d") as out_date, 
    (case 
        when out_date <= date('2022-05-01') THEN '출고완료'
        WHEN out_date > date('2022-05-01') THEN '출고대기'
        WHEN out_date is null THEN '출고미정'
    end) as '출고여부'
FROM food_order