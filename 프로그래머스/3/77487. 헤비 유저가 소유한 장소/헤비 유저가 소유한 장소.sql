WITH cte AS (
    SELECT HOST_ID, COUNT(HOST_ID) as cnt
    FROM places
    GROUP BY 1
)

SELECT id, name, p.host_id
FROM places as p
    JOIN cte as c ON p.host_id = c.host_id
WHERE cnt >= 2
ORDER BY id