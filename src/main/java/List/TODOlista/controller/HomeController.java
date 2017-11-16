package List.TODOlista.controller;

import List.TODOlista.model.ToDo;
import List.TODOlista.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/")
    public @ResponseBody String addToDoList(@RequestParam String name,@RequestParam String todo,@RequestParam String status){
        ToDo toDo = new ToDo();

        return "home";
    }
}
