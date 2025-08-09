package springbootassi7.controller;

import jakarta.validation.Valid;
import jakarta.validation.Validation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import springbootassi7.model.Student;

@SuppressWarnings("unused")
@Controller
public class StudentController {

    @GetMapping("/enroll")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "enrollForm";
    }

    @PostMapping("/enroll")
    public String submitForm(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "enrollForm";
        }
        return "success";
    }
}
