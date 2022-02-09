package Controllers;

import Entity.Student;
import Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {


    private StudentRepository studentRepository;

    @Autowired
    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("studentList", studentRepository.findAll());
        return "index";
    }

    @PostMapping("/add_student")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "form";
    }


}
