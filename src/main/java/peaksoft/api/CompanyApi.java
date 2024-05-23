package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.servcie.CompanyService;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("allCompanies", companyService.getAllCompany());
        return "mainPage";
    }

    @GetMapping("/lets")
    public String getInfo() {
        return "/info";
    }

    @GetMapping("/new")
    public String addCompany(Model model) {
        model.addAttribute("newCompany", new Company());
        return "/newCompany";
    }

    @PostMapping("/save")
    private String saveCompany(@ModelAttribute("newCompany") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

//    @GetMapping("/delete")
//    public String delete() {
//companyService.deleteCompanyById();
//        return "redirect:/companies";
//    }

    @GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable("id") Long companyId){
        companyService.deleteCompanyById(companyId);
        return "redirect:/companies";
    }

    @GetMapping("/{id}/update")
    public String getByIdToUpdate(Model model,@PathVariable("id") Long comId){
        model.addAttribute("upCompany",companyService.getById(comId));
        return "/update";
    }

    @PutMapping("/{id}/updateCompany")
    public String update(@ModelAttribute("upCompany")Company company,@PathVariable Long id){
        companyService.updateById(id,company);
        return "redirect:/companies";
    }
}
