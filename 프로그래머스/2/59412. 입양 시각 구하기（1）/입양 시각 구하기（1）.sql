-- 각 시간대별 - 입양 몇 건?
SELECT HOUR(datetime) as hour, count(animal_id) as count
FROM animal_outs
WHERE HOUR(datetime) BETWEEN 9 AND 19
GROUP BY 1
ORDER BY 1