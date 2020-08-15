package ru.amelin.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
//RequestMapping добавляет к началу всех url префикс
//@RequestMapping("/aaa")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//       передаем данные в модель
        model.addAttribute("message", "Hello, " + name + " " + surname);

        //возвращает страницу first/hello.html (thymeleaf-spring)
        return "first/hello";
    }

    @GetMapping("/goodbuy")
    public String goodbuyPage() {
        return "first/goodbuy";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("x") int x,
                             @RequestParam("y") int y,
                             @RequestParam("action") String action,
                             Model model) {
        double result;
        switch (action) {
            case "multiplication": {
                result = x * y;
                break;
            }
            case "division": {
                result = x / (double) y;
                break;
            }
            case "subtraction": {
                result = x - y;
                break;
            }
            case "addition": {
                result = x + y;
                break;
            }
            default: {
                result = 0;
            }
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
