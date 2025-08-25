# 물고기 종류별 가장 큰 물고기의 ID
WITH cte AS (
    SELECT fish_type, max(length) as max_length
    FROM FISH_INFO
    GROUP BY 1
)

SELECT id, fish_name, length
FROM FISH_INFO as i
    JOIN FISH_NAME_INFO as n
    ON i.fish_type = n.fish_type
    JOIN cte as c 
    ON i.fish_type = c.fish_type
WHERE length = max_length
ORDER BY 1