-- 코드를 입력하세요
SELECT member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
FROM member_profile
WHERE month(date_of_birth) = 3 AND TLNO is not null AND gender = 'W'
order by member_id ASC;