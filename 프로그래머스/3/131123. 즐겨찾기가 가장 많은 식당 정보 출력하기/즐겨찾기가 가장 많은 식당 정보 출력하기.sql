# 음식종류별, 즐겨찾기수가 가장 많은! - 음식 종류, ID, 식당이름, 즐겨찾기수 조회
WITH filtered AS (
    SELECT food_type, MAX(favorites)
    FROM REST_INFO
    GROUP BY food_type
)

SELECT food_type, rest_id, rest_name, favorites
FROM REST_INFO
WHERE (food_type, favorites) IN (SELECT * FROM filtered)
ORDER BY food_type DESC;
