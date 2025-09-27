-- 코드를 입력하세요
SELECT YEAR(sales_date) as year, MONTH(sales_date) as month, 
        GENDER, COUNT(distinct i.user_id) as users
FROM USER_INFO as i
    JOIN ONLINE_SALE as s
    ON i.user_id = s.user_id
WHERE GENDER IS NOT NULL
GROUP BY 1,2,3
ORDER BY 1,2,3