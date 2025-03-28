-- 보호소 들어오기 전 중성화 x | 보호소 들어온 후 중성화 o 
SELECT ins.animal_id, ins.animal_type, ins.name
FROM animal_outs as outs
    JOIN animal_ins as ins ON outs.animal_id = ins.animal_id
WHERE LEFT(outs.sex_upon_outcome, 6) IN ('Spayed', 'Neuter') 
    AND LEFT(ins.sex_upon_intake, 6) = 'Intact'