# 평균 길이가 33 이상인 물고기
# 종류별 - 잡은 수, 최대 길이
WITH 
cte AS (
    SELECT 
        (
            CASE
            WHEN length IS NULL THEN 10
            ELSE length
            END
        ) as len, id, fish_type
    FROM fish_info
)

SELECT COUNT(id) as fish_count, MAX(len) as max_length, fish_type
FROM cte
GROUP BY 3
HAVING AVG(len) >= 33
ORDER BY 3


