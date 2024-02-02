package org.example.conrollers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecondController {


    @GetMapping(path = "/first",produces = MediaType.TEXT_PLAIN_VALUE+ ";charset=utf-8")
    public String second(@RequestParam(name = "name") String name
            , RedirectAttributes attributes){

        System.out.println(" Get request name - "+name+" и русский" );
        attributes.addAttribute("name",name);
        return "redirect:/second";
    }

}
//Напишите два контроллера, где первый принимает имя пользователя и
// передает его второму контроллеру через редирект. Для этого
//•	внедрите бин RedirectAttributes в метод первого контроллера
//•	добавьте в бин атрибут name и его значение
//•	верните из метода строку по шаблону
// "redirect:/путь_к_методу_второго_контроллера"р