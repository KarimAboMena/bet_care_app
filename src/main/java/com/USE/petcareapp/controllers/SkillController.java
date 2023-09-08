package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.Skill;
import com.USE.petcareapp.services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final SkillServices skillServices;
    @Autowired
    public SkillController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }
    @PostMapping("/post")
    public void createSkill(@RequestBody Skill skill){
        skillServices.createSkill(skill);
    }
}
