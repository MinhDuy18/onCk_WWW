package vn.edu.iuh.fit.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entites.Experience;
import vn.edu.iuh.fit.entites.Role;
import vn.edu.iuh.fit.reponsitory.CandidateReponsitoty;
import vn.edu.iuh.fit.reponsitory.ExperienceReponsitory;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class ExperienceController {
    @Autowired
    private ExperienceReponsitory experienceReponsitory;
    @Autowired
    private CandidateReponsitoty canRepon;
    //list Exp
    @GetMapping("/experiences")
    public String  showExperience(Model model){
        model.addAttribute("experiencePage",experienceReponsitory.findAll());
        return "Experience/Experiences";
    }

    @GetMapping("/experiences/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model){
        Experience exp = experienceReponsitory.findById(id).orElse(null);
        if(exp != null)
            model.addAttribute("ExperienceDatil", exp);
        return "Experience/ListExperience";
    }
    @GetMapping("/experiences/formAdd")
    public String FormADD(Model model){
        Experience exp = new Experience();
        model.addAttribute("FormADDExperience", exp);
        model.addAttribute("CandidateList", canRepon.findAll());
        model.addAttribute("RoleList", Role.values());
        return "Experience/FormAdd";
    }

    @PostMapping("/experiences/add")
    public String add(@ModelAttribute Experience experience){
        experienceReponsitory.save(experience);
        return "redirect:/experiences";
    }

}
