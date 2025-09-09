# 리뷰 가장 많이 작성한 회원의 리뷰들
WITH cte AS (
    SELECT member_id, COUNT(member_id) as cnt
    FROM REST_REVIEW
    GROUP BY member_id
    ORDER BY 2 DESC
    LIMIT 1
)

SELECT p.member_name, r.review_text, DATE_FORMAT(review_date, "%Y-%m-%d") as review_date
FROM MEMBER_PROFILE as p
    JOIN cte as c ON p.member_id = c.member_id
    JOIN REST_REVIEW as r ON p.member_id = r.member_id
ORDER BY 3, 2
