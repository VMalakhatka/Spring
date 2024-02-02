package org.example.conrollers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class HeaderController {


    @GetMapping(path = "/headers")
    public ResponseEntity<?> headerReturn(HttpServletRequest request
            , HttpServletResponse response) throws IOException {
        Map<String,String> headers=new HashMap<>();
        Iterator<String> iner=request.getHeaderNames().asIterator();
        iner.forEachRemaining(hname->headers.put(hname, request.getHeader(hname)));
        if (headers.size()<3){
            response.sendError(400,"need mor Headers");
            return ResponseEntity.badRequest().body("need mor Headers");
        }
        if (headers.get("x-error-result").equals("true")){
            response.sendError(500,"get your Error");
            return ResponseEntity.badRequest().body("get your Error");
        }
        String redirectPath=headers.get("x-forward-path");
        if(redirectPath!=null && !redirectPath.isBlank()){
            response.sendRedirect(redirectPath);
            return null;
        }
        return ResponseEntity.ok().body(headers.toString());
    }

}
//Создайте контроллер, который анализирует заголовки GET-запроса.
// Если заголовков меньше 3, то возвращает код 400. Если присутствует
// заголовок X-Error-Result, равный true, то возвращает код 500. Если
// указан заголовок X-Forward-Path, то делает редирект на указанный путь.
// В остальных случаях возвращает все заголовки в виде строки.