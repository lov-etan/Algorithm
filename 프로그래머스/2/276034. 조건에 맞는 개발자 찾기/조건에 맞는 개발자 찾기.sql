SELECT id, email, first_name, last_name
FROM developers
WHERE
    skill_code & (SELECT code FROM skillcodes WHERE name = 'C#')
    OR
    skill_code & (SELECT code FROM skillcodes WHERE name = 'Python')
ORDER BY 1

