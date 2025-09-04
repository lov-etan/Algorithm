WITH cte AS (
    SELECT f.flavor, (f.total_order + sum(j.total_order)) as sum_order
    FROM FIRST_HALF as f
        JOIN JULY as j ON f.flavor = j.flavor
    GROUP BY 1
) 

SELECT flavor
FROM cte
ORDER BY sum_order DESC
LIMIT 3