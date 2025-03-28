-- 문제: 가장 많이 작성한 회원의 '리뷰들'이 나와야 하는데..
SELECT p.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
FROM member_profile as p
    JOIN rest_review as r ON p.member_id = r.member_id
WHERE p.member_id = (SELECT member_id
        FROM rest_review
        GROUP BY member_id
        ORDER By count(member_id) desc
        LIMIT 1)
ORDER BY review_date, review_text;

-- 일단 가장 많이 작성한 회원(1명)을 구해보자 

-- group by는 '집계함수'와 쓰임!!