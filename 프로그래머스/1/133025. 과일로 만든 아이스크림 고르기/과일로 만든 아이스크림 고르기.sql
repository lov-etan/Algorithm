-- 상반기 총주문량 > 3000 && 아이스크림 주성분 = '과일' && Order by 총주문량 DESC
SELECT fh.flavor
FROM FIRST_HALF as fh
JOIN ICECREAM_INFO as ii ON fh.flavor = ii.flavor
WHERE fh.total_order > 3000 AND ii.ingredient_type = 'fruit_based'
ORDER BY fh.TOTAL_ORDER DESC;