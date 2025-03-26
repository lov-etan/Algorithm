-- 코드를 입력하세요
SELECT DISTINCT os2.user_id, os2.product_id
FROM online_sale as os1 
    JOIN online_sale as os2 ON os1.user_id = os2.user_id
WHERE os1.product_id = os2.product_id AND os1.sales_date < os2.sales_date
order by user_id ASC, product_id DESC;