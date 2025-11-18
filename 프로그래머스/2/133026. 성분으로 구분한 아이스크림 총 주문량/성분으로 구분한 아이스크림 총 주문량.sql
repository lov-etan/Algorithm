# 상반기 동안 성분 타입 별 아이스크림 총 주문량
SELECT i.INGREDIENT_TYPE, SUM(total_order) as TOTAL_ORDER
FROM FIRST_HALF as f
JOIN ICECREAM_INFO as i ON f.flavor = i.flavor
GROUP BY 1
ORDER BY 2