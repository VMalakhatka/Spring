import org.example.dto.CreateResponce;
import org.example.dto.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class TaskController {
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public Map<Long, Task> getTaskMap(){
        return taskService.getTasks();
    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@RequestParam(name="id") long id){
        return taskService.getTask(id);
    }

    @PostMapping(path = "/tasks")
    public CreateResponce create(@RequestBody Task task){
        return taskService.creatTask(task);
    }

//    @PutMapping(path = "/tasks/{id}")
//    public void update(){
//        taskService.up
//    }
}
//Создайте контроллер, который анализирует заголовки GET-запроса.
// Если заголовков меньше 3, то возвращает код 400. Если присутствует
// заголовок X-Error-Result, равный true, то возвращает код 500. Если
// указан заголовок X-Forward-Path, то делает редирект на указанный путь.
// В остальных случаях возвращает все заголовки в виде строки.