# 2022년 10월 5일에 등록된 중고거래 조회 / 거래상태 매핑 
SELECT  board_id, writer_id, title, price, 
        (
            CASE
            WHEN status = 'SALE' THEN '판매중'
            WHEN status = 'RESERVED' THEN '예약중'
            WHEN status = 'DONE' THEN '거래완료'
            END
        ) as status
FROM USED_GOODS_BOARD
WHERE created_date = '2022-10-05'
ORDER BY 1 DESC