package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Instructor;
import peaksoft.servcie.InstructorService;

@Controller
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorApi {
    private final InstructorService instructorService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("allInstructor", instructorService.getAllInstructors());
        return "instructor/instructor-main";
    }

    @GetMapping("/new")
    public String creatIns(Model model) {
        model.addAttribute("newInstructor", new Instructor());
        return "/instructor/save";
    }

    @PostMapping("/save")
    public String saveInstructor(@ModelAttribute("newInstructor") Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }

    @GetMapping("{instructorId}/get")
    public String getIns(@PathVariable Long instructorId, Model model) {
        model.addAttribute("ins", instructorService.getInstructorById(instructorId));
        model.addAttribute("insId", instructorId);
        return "instructor/update";
    }

    @PostMapping("/update/{instructorId}")
    public String update(@ModelAttribute("ins") Instructor instructor, @PathVariable Long instructorId) {
        instructorService.updateInstructor(instructorId, instructor);
        return "redirect:/instructors";
    }

    @GetMapping("/delete/{instructorId}")
    public String delete(@PathVariable Long instructorId) {
        instructorService.deleteById(instructorId);
        return "redirect:/instructors";
    }
    @GetMapping("/assignIn/{companyId}")
    public String assignInstructor(@PathVariable Long companyId,Model model){
        model.addAttribute("allInstructors",instructorService.getAllInstructorsByComId(companyId));
        model.addAttribute("comId",companyId);
        return "/assign/ins-com";
    }
    @GetMapping("/addInstructor/{companyId}/{instructorId}")
    public String addIns(@PathVariable Long companyId,@PathVariable Long instructorId ){
        instructorService.assignInstructorToCompany(companyId,instructorId);
        return "redirect:/assignIn/{companyId}";
    }
}
