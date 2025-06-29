# 2021년에 가입 + 상품을 구매한 회원수
# 비율: 2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수
# year, month, perchased_users, purchased_ratio
WITH cnt_2021 AS (
    SELECT distinct *, count(*) as cnt
    FROM user_info
    WHERE YEAR(joined) = '2021'
)

SELECT YEAR(s.sales_date) as year, MONTH(s.sales_date) as month,
    count(distinct u.user_id) as purchased_users,
    ROUND((count(distinct u.user_id)/(SELECT cnt FROM cnt_2021)),1) as purchased_ratio
FROM user_info as u
    JOIN online_sale as s
    ON u.user_id = s.user_id
WHERE YEAR(u.joined) = '2021'
GROUP BY YEAR(s.sales_date), MONTH(s.sales_date)
ORDER BY 1, 2