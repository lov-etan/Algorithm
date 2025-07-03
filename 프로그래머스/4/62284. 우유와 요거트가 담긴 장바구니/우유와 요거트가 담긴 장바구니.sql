SELECT distinct a.cart_id
FROM cart_products as a
JOIN cart_products as b
ON a.cart_id = b.cart_id
WHERE a.name = 'Milk' AND b.name = 'Yogurt'
ORDER BY 1
