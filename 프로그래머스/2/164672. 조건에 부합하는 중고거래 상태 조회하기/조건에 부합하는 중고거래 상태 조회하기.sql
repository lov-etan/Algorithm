SELECT board_id, writer_id, title, price, 
    (CASE 
     WHEN status = 'SALE' THEN '판매중'
     WHEN status = 'RESERVED' THEN '예약중'
     ELSE '거래완료' END) as status
FROM used_goods_board
WHERE DATE_FORMAT(created_date, "%Y-%m-%d") = '2022-10-05'
ORDER BY 1 DESC