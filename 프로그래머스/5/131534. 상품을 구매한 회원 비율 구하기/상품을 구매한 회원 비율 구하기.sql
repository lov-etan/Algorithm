# 2021년에 가입한 전체 회원들 중 
# 회원 비율( 2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수) -> 년, 월 별로 출력 

WITH 2021_users as (
    SELECT count(*) count_users
    FROM user_info
    WHERE joined BETWEEN '2021-01-01' AND '2021-12-31' 
)

SELECT year(os.sales_date) as year, month(os.sales_date) as month, count(distinct os.user_id) as purchased_users, 
        ROUND((count(distinct os.user_id) / tu.count_users ), 1) as purchased_ratio
FROM online_sale as os 
    JOIN user_info as ui ON os.user_id = ui.user_id CROSS JOIN 2021_users as tu
WHERE joined like '2021%'
GROUP BY year(os.sales_date), month(os.sales_date)
ORDER BY year, month