SELECT YEAR(sale.sales_date) as year, MONTH(sale.sales_date) as month, info.gender, COUNT(distinct info.user_id) as users
FROM user_info as info
JOIN online_sale as sale
ON info.user_id = sale.user_id
GROUP BY 1,2,3
HAVING info.gender IS NOT NULL
ORDER BY 1,2,3