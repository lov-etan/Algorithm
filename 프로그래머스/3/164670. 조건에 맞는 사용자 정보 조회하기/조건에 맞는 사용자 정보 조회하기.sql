# 중고거래 게시물 3건 이상 등록한 사람~?
WITH cte AS (
    SELECT writer_id
    FROM USED_GOODS_BOARD
    GROUP BY 1
    HAVING COUNT(writer_id) >= 3
)

SELECT  user_id, nickname, 
        CONCAT(city, ' ', street_address1, ' ', street_address2) as 전체주소, 
        CONCAT(SUBSTR(tlno, 1, 3), '-', SUBSTR(tlno, 4, 4), '-', SUBSTR(tlno, 8, 4)) as 전화번호
FROM cte as b
    JOIN USED_GOODS_USER as u
    ON b.writer_id = u.user_id
ORDER BY 1 DESC
    