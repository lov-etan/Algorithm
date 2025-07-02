SELECT DISTINCT u.user_id, u.nickname, 
        CONCAT(city, ' ' ,street_address1, ' ', street_address2) as 전체주소, 
        CONCAT(LEFT(u.tlno,3), '-', SUBSTR(u.tlno, 4,4), '-', SUBSTR(u.tlno, 8,4)) as 전화번호
FROM used_goods_board as b
JOIN used_goods_user as u
ON b.writer_id = u.user_id
GROUP BY b.writer_id
HAVING COUNT(b.writer_id) >= 3
ORDER BY 1 DESC


