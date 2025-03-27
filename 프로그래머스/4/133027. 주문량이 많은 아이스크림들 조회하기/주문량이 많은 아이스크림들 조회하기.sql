-- 코드를 입력하세요
SELECT h.flavor
FROM first_half as h 
    JOIN july as j ON h.flavor = j.flavor
GROUP BY h.flavor
ORDER BY sum(h.total_order + j.total_order) DESC
LIMIT 3;