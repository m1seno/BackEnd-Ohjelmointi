package k25.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @GetMapping("/path")
    public String getPath(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/index")
    public String getIndex(@RequestParam String param) {
        return new String();
    }

}
