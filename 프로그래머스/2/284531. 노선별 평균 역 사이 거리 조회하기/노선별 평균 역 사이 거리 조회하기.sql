# 노선별 노선-총 누계거리-평균 역 사이 거리
# 총 누계거리: 소수 둘째자리 / 평균 : 소수 셋째 자리 
SELECT  route, 
        CONCAT(ROUND(sum(d_between_dist), 1), 'km') as total_distance, 
        CONCAT(ROUND(avg(d_between_dist), 2), 'km') as average_distance
FROM subway_distance
GROUP BY 1
ORDER BY ROUND(sum(d_between_dist), 1) DESC # (함정) km 글자 포함 안되게 이렇게 써야 함!!