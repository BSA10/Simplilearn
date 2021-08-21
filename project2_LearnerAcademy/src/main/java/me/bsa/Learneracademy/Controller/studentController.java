package me.bsa.Learneracademy.Controller;

import me.bsa.Learneracademy.Model.classes;
import me.bsa.Learneracademy.Model.student;
import me.bsa.Learneracademy.Service.impl.classesServiceImpl;
import me.bsa.Learneracademy.Service.impl.studentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class studentController {

    @Autowired
    private studentServiceImpl studentService;
    @Autowired
    private classesServiceImpl classesService;

    @GetMapping("/student")
    public String getStudent(Model model){
        model.addAttribute("student",studentService.listAll());
        return "student";
    }

    @GetMapping("/add-student")
    public String addStudent(Model model){
        model.addAttribute("student",new student());
        model.addAttribute("class",classesService.listAll());
        return "add-student";
    }

    @GetMapping("/delete/student")
    public String deleteStudent(@RequestParam("studentId") int studentId){
        studentService.deleteById(studentId);
        return "redirect:/student";
    }

    @GetMapping("/update-student")
    public String updateStudent(@RequestParam("studentId") int studentId , Model model){
        student student = studentService.findById(studentId);
        model.addAttribute("student",student);
        model.addAttribute("class",classesService.listAll());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute("student") student TheStudent ,
                             @RequestParam(value = "class_id",required = false) int class_id){
        classes c;
        if (class_id > 0){
             c =  classesService.findById(class_id);
            TheStudent.setClasses(c);
        }
        studentService.create(TheStudent);
        return "redirect:/student";
    }




}
