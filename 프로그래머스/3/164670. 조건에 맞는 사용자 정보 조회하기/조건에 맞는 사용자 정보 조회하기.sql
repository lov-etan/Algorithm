-- 중고 거래 게시물 3건 이상 등록한 사용자 
SELECT distinct user_id, nickname, concat(city," ", street_address1, " " ,street_address2) as '전체주소', 
concat(substr(tlno,1,3), '-', substr(tlno, 4,4), '-', substr(tlno, 8,4)) as '전화번호'
FROM used_goods_user
WHERE user_id in
    (Select writer_id FROM used_goods_board GROUP BY writer_id Having count(writer_id) >= 3)
ORDER BY user_id desc;
    
# 거래 게시물을 3건 이상 등록한 사용자
# SELECT writer_id
# FROM used_goods_board
# Having count(writer_id) >= 3