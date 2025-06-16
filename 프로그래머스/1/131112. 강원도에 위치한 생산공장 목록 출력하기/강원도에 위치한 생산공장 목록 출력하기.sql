SELECT factory_id, factory_name, address
FROM food_factory
WHERE substr(address, 1, 3) = '강원도'
ORDER BY factory_id