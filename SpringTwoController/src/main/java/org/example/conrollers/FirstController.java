package org.example.conrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FirstController {


    @GetMapping(path = "/second",produces = MediaType.TEXT_PLAIN_VALUE+ ";charset=utf-8")
    @ResponseBody
    public String first(@RequestParam(name = "name") String name){
        return " User "+name+" redirect олтлортло";
    }

}
//Напишите два контроллера, где первый принимает имя пользователя и
// передает его второму контроллеру через редирект. Для этого
//•	внедрите бин RedirectAttributes в метод первого контроллера
//•	добавьте в бин атрибут name и его значение
//•	верните из метода строку по шаблону
// "redirect:/путь_к_методу_второго_контроллера"р