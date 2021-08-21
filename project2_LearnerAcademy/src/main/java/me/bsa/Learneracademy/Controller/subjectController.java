package me.bsa.Learneracademy.Controller;

import me.bsa.Learneracademy.Model.subject;
import me.bsa.Learneracademy.Model.teacher;
import me.bsa.Learneracademy.Service.impl.classesServiceImpl;
import me.bsa.Learneracademy.Service.impl.subjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class subjectController {

    @Autowired
    private subjectServiceImpl subjectService;
    @Autowired
    private classesServiceImpl classesService;

    @GetMapping("/subject")
    public String getSubject(Model model){
        model.addAttribute("subjects", subjectService.listAll());

        return "subject";
    }


    @GetMapping("/subject/delete")
    public String deleteSubject(@RequestParam("subjectId") int subjectId){
        subjectService.deleteById(subjectId);
        return "redirect:/subject";
    }

    @GetMapping("/addSubject")
    public String addSubject(Model model){
        model.addAttribute("subject",new subject());
        model.addAttribute("class",classesService.listAll());
        return "add-subject";
    }

    @GetMapping("/update-subject")
    public String updateSubject(@RequestParam("subjectId") int subjectId , Model model){
        model.addAttribute("class",classesService.listAll());
        subject subject = subjectService.findById(subjectId);
        model.addAttribute("subject",subject);

        return "add-subject";
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("teacher") subject subject , @RequestParam(value = "classId" , required = false) int class_id[]){
        if(class_id != null)
            for(int id : class_id)
                subject.addClass(classesService.findById(id));

        subjectService.create(subject);
        return "redirect:/subject";
    }


}
