WITH 
cteA AS (
    SELECT distinct d.id
    FROM SKILLCODES as s
    JOIN DEVELOPERS as d 
    ON s.code & d.skill_code
    WHERE 
        d.skill_code & (SELECT code FROM skillcodes WHERE name = 'Python')
        AND s.category = 'Front End'
),
cteB AS (
    SELECT distinct d.id
    FROM skillcodes as s
        JOIN developers as d ON s.code & d.skill_code
    WHERE s.name = 'C#'
),
cteC AS (
    SELECT distinct id
    FROM skillcodes as s
        JOIN developers as d ON s.code & d.skill_code
    WHERE s.category = 'Front End'
),
tmp AS (
    SELECT 
        (
            CASE
            WHEN id IN (SELECT id FROM cteA) THEN 'A'
            WHEN id IN (SELECT id FROM cteB) THEN 'B'
            WHEN id IN (SELECT id FROM cteC) THEN 'C'
            END
        ) as GRADE
        , id, email
    FROM developers
)

SELECT grade, id, email
FROM tmp
WHERE grade IS NOT NULL
ORDER BY 1,2




