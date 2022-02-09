package com.geekbrains.interwiev.Controllers;

import com.geekbrains.interwiev.Entity.Student;
import com.geekbrains.interwiev.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    private StudentService studentService;


    @Autowired
    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "index";
    }

    @GetMapping("/add_student")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "form";
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam String name, @RequestParam int age) {
        Student student = new Student(name, age);
        studentService.persist(student);
        return "redirect:/";
    }

    @GetMapping("/delete_student")
    public String deleteForm() {
        return "delete_form";
    }

    @PostMapping("/delete_student")
    public String deleteStudent(@RequestParam int id) {
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update_student")
    public String updateForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "update_form";
    }

    @PostMapping("/update_student")
    public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
        Student student = studentService.findById(id);
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        studentService.update(student);

        return "redirect:/";
    }



}
