WITH
cte AS (
    SELECT flavor, sum(total_order) as sum_order
    FROM first_half 
    GROUP BY 1
), 
cte2 AS (
    SELECT flavor, sum(total_order) as sum_order
    FROM july
    GROUP BY 1
)

SELECT a.flavor
FROM cte as a 
    JOIN cte2 as b ON a.flavor = b.flavor
GROUP BY 1
ORDER BY SUM(a.sum_order + b.sum_order) DESC
LIMIT 3