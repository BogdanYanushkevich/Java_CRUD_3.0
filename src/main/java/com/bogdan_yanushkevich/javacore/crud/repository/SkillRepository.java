package com.bogdan_yanushkevich.javacore.crud.repository;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;

public interface SkillRepository extends GenericRepository<Skill, Long> {
    public Skill create(Skill skill);

    public Skill update(Skill skill);
}
