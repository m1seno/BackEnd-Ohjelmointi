package kevat25.studentlist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kevat25.studentlist.domain.Student;

@Controller
public class StudentController {

    public static final List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student("Aku", "Ankka"));
        students.add(new Student("Iines", "Ankka"));
        students.add(new Student("Hannu", "Hanhi"));
    }

    @GetMapping("/hello")
    public String showStudents (Model model){
        model.addAttribute("students", students);
        return "studentlist";

    }

}
