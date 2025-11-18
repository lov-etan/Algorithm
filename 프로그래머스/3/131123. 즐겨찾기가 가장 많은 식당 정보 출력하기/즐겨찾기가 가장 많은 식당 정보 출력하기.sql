WITH cte AS (
    SELECT food_type, MAX(favorites) as max_favs
    FROM REST_INFO
    GROUP BY 1
)

SELECT r.food_type, r.rest_id, r.rest_name, r.favorites
FROM REST_INFO as r
    JOIN cte as c ON r.food_type = c.food_type AND r.favorites = c.max_favs
GROUP BY 1
ORDER BY 1 DESC