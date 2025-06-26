SELECT c.id, c.genotype, p.genotype as parent_genotype
FROM ecoli_data as c
    JOIN ecoli_data as p ON c.parent_id = p.id
WHERE c.genotype & p.genotype = p.genotype
ORDER BY 1