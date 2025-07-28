# 완료된 중고거래 총금액 70만원 이상
# 회원 ID(writer_id 별) - sum(price)
SELECT u.user_id, u.nickname, sum(b.price) as total_sales
FROM USED_GOODS_BOARD as b
    JOIN USED_GOODS_USER as u ON b.writer_id = u.user_id
WHERE b.status = 'DONE'
GROUP BY 1
HAVING total_sales >= 700000
ORDER BY 3