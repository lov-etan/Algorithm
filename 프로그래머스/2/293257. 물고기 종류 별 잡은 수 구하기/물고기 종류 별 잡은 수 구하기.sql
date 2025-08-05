# 물고기 종류별 - 물고기 이름, 잡은 수
SELECT count(i.id) as fish_count, n.fish_name
FROM fish_info as i
    JOIN fish_name_info as n
    ON i.fish_type = n.fish_type
GROUP BY 2
ORDER BY 1 DESC
