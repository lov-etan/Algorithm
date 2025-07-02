SELECT order_id, product_id, DATE_FORMAT(out_date, "%Y-%m-%d") as out_date,
    (CASE WHEN DATE_FORMAT(out_date, "%Y-%m-%d") <= '2022-05-01' THEN '출고완료'
          WHEN DATE_FORMAT(out_date, "%Y-%m-%d") > '2022-05-01' THEN '출고대기'
          ELSE '출고미정' END) as 출고여부
FROM food_order
ORDER BY 1