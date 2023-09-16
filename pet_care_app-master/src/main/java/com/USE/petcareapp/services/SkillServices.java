package com.USE.petcareapp.services;

import com.USE.petcareapp.data.Employee;
import com.USE.petcareapp.data.Skill;
import com.USE.petcareapp.repos.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SkillServices {
    private final SkillRepository skillRepository;
    public void createSkill(Skill skill){
        skillRepository.save(skill);
    }
}
