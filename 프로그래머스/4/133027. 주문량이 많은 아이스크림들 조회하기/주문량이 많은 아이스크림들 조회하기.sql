SELECT h.FLAVOR
FROM FIRST_HALF as h
    JOIN JULY as j ON h.flavor = j.flavor
GROUP BY 1
ORDER BY SUM(h.total_order) + SUM(j.total_order) DESC
LIMIT 3