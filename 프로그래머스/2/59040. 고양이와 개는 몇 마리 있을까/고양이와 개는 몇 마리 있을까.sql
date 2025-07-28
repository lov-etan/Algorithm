# 고양이 개 각각 몇 마리?
SELECT animal_type, COUNT(*) as count
FROM animal_ins as i
GROUP BY 1
ORDER BY 1