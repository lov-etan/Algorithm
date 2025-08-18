# 4분할 등급제
SELECT  ID,
        (
            CASE NTILE(4) OVER (ORDER BY size_of_colony DESC)
            WHEN 1 THEN 'CRITICAL'
            WHEN 2 THEN 'HIGH'
            WHEN 3 THEN 'MEDIUM'
            WHEN 4 THEN 'LOW'
            END
        ) as COLONY_NAME
FROM ECOLI_DATA
ORDER BY 1
