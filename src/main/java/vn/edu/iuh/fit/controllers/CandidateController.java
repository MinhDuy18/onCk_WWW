package vn.edu.iuh.fit.controllers;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entites.Candidate;
import vn.edu.iuh.fit.entites.Experience;
import vn.edu.iuh.fit.reponsitory.CandidateReponsitoty;
import vn.edu.iuh.fit.reponsitory.ExperienceReponsitory;

import java.util.List;

//@RestController
//@RequestMapping(value = { "/index"})
@Controller
public class CandidateController {
    @Autowired
    private CandidateReponsitoty candidateRepository;
    @Autowired
    private ExperienceReponsitory experienceReponsitory;
    //trang chinh
    @GetMapping("/index")
    public   String  showIndex(Model model){
        return "Candidate/index";
    }
    //list cadidate
    @GetMapping("/candidates")
    public String  showCandidate(Model model){
        model.addAttribute("candidatePage",candidateRepository.findAll());
        return "Candidate/ListCandidate";
    }
    // ứng với từng id hiển thì cadidate tương ứng
    @GetMapping("/candidates/{id}")
    public String showCandidateDetails(@PathVariable("id") Long id, Model model) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate != null)
            model.addAttribute("candidateDetail", candidate);
            return "Candidate/ListCandidateDetail"; // Trả về view để hiển thị chi tiết candidate

    }
@GetMapping("/cadidates/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id){
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        List<Experience> experiences =  candidate.getExperiences();
        for (Experience exp : experiences
             ) {
            experienceReponsitory.delete(exp);
        }
            candidateRepository.delete(candidate);
    return "redirect:/candidates";

}

//    //show form add
//    @GetMapping ("/customers/show-add-form")
//    public String addCustomer(Model model) {
//        Customer customer = new Customer();
//        model.addAttribute("customerAdd",customer);
//        return "customer/add";
//    }
    @GetMapping("/candidates/showformadd")
    public String add(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candidateAdd",candidate);
        return "Candidate/addCandidateForm";
    }
@PostMapping("/cadidates/add")
    public String addCandidate(@ModelAttribute Candidate candidate){
        candidateRepository.save(candidate);
    return "redirect:/candidates";
}

    @GetMapping("/candidates/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate != null)
            model.addAttribute("candidateUpdate", candidate);
        return "Candidate/updateForm"; // Trả về view để hiển thị chi tiết candidate

    }

    @PostMapping("/cadidates/update/{id}")
    public String uppdateCandidate(@PathVariable("id") long id,@ModelAttribute("candidateUpdate") Candidate candidateUpdate){
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if(candidate != null){
            candidate.setFullName(candidateUpdate.getFullName());
            candidate.setEmail(candidateUpdate.getEmail());
            candidate.setPhone(candidateUpdate.getPhone());
            candidate.setId(candidateUpdate.getId());
            candidateRepository.save(candidate);
        }
        return "redirect:/candidates";
    }


}
