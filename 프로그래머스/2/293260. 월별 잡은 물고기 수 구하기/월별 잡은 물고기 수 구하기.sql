# 월별 잡은 물고기의 수, 월
SELECT COUNT(id) as fish_count, month(time) as month
FROM fish_info
GROUP BY 2
ORDER BY 2