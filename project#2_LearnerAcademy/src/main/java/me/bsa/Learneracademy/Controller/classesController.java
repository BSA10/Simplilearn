package me.bsa.Learneracademy.Controller;

import me.bsa.Learneracademy.Model.classes;
import me.bsa.Learneracademy.Service.impl.classesServiceImpl;
import me.bsa.Learneracademy.Service.impl.studentServiceImpl;
import me.bsa.Learneracademy.Service.impl.subjectServiceImpl;
import me.bsa.Learneracademy.Service.impl.teacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class classesController {

    @Autowired
    private classesServiceImpl classesService;
    @Autowired
    private teacherServiceImpl teacherService;
    @Autowired
    private studentServiceImpl studentService;
    @Autowired
    private subjectServiceImpl subjectService;

    @GetMapping("class")
    public String getClass(Model model){
        model.addAttribute("class" , classesService.listAll());

        return "class";
    }

    @GetMapping("add-class")
    public String addClass(Model model){

        model.addAttribute("class",new classes());
        return "add-class";
    }

    @GetMapping("/class/delete")
    public String deleteClass(@RequestParam("classId") int classId){
        classesService.deleteById(classId);
        return "redirect:/class";
    }

    @GetMapping("/update-class")
    public String updateClass(@RequestParam("classId") int classId, Model model){
        classes tempClass = classesService.findById(classId);
        model.addAttribute("class",tempClass);
        return "add-class";
    }

    @GetMapping("class-report")
    public String classReport(Model model){
        model.addAttribute("class",classesService.listAll());
        model.addAttribute("teacher",teacherService.listAll());
        model.addAttribute("student",studentService.listAll());
        model.addAttribute("subject",subjectService.listAll());
        return "class-report";
    }

    @PostMapping("add-class")
    public String addClass(@ModelAttribute("class") classes classes){
        classesService.create(classes);
        return "redirect:/class";
    }

}
