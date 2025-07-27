# 아이스크림 성분 타입, 총주문량 
SELECT i.ingredient_type, sum(h.total_order) as TOTAL_ORDER
FROM FIRST_HALF as h 
    JOIN ICECREAM_INFO as i ON h.flavor = i.flavor
GROUP BY 1
ORDER BY 2