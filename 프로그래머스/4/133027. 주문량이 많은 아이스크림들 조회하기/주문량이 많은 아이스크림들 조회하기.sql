SELECT F.FLAVOR
FROM FIRST_HALF F 
JOIN (SELECT flavor, SUM(total_order) as july_total FROM july GROUP BY flavor) as j
ON F.FLAVOR = J.FLAVOR
ORDER BY F.TOTAL_ORDER + july_total DESC
LIMIT 3;