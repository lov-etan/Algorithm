# 3세대를 찾아라
SELECT ID
FROM ECOLI_DATA
WHERE PARENT_ID IN (SELECT ID
                    FROM ECOLI_DATA
                    WHERE PARENT_ID IN (SELECT ID
                                        FROM ECOLI_DATA
                                        WHERE PARENT_ID IS NULL))
ORDER BY 1
