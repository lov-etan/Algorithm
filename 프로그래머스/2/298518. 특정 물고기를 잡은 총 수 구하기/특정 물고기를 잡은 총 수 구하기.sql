SELECT (count(info.id)) AS FISH_COUNT
FROM fish_info as info
    JOIN fish_name_info as name ON info.fish_type = name.fish_type
WHERE name.fish_name = 'BASS' OR name.fish_name = 'SNAPPER'