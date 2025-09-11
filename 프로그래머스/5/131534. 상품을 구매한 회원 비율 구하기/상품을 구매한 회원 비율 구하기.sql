# 2021년에 가입한 전체 회원들 중 
# 2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수
WITH cte AS (
    SELECT COUNT(user_id) as cnt
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
)

SELECT  YEAR(o.SALES_DATE) as year, 
        MONTH(o.SALES_DATE) as month, 
        COUNT(distinct u.user_id) as PURCHASED_USERS,
        ROUND(COUNT(distinct u.user_id) / (SELECT cnt FROM cte),1) as PUCHASED_RATIO
FROM ONLINE_SALE as o
    JOIN USER_INFO as u ON o.user_id = u.user_id
WHERE u.JOINED  LIKE '2021%'
GROUP BY 1,2
ORDER BY 1,2
