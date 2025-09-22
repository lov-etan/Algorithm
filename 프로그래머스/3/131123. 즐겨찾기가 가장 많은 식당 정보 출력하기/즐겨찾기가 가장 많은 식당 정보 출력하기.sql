# 음식종류별 즐겨찾기수가 가장 많은 식당은?
WITH cte AS (
    SELECT FOOD_TYPE, MAX(FAVORITES) as MAX_FAVORITES
    FROM REST_INFO
    GROUP BY 1
)

SELECT c.food_type, r.rest_id, r.rest_name, r.favorites
FROM rest_info as r
    JOIN cte as c ON r.food_type = c.food_type AND r.favorites = c.max_favorites
ORDER BY 1 DESC
