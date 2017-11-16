package List.TODOlista.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import List.TODOlista.model.ToDo;
import List.TODOlista.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/")
    public String addToDoList(@RequestParam String nameToDo, @RequestParam String todo, @RequestParam String status) {
        ToDo toDo = new ToDo();
        toDo.setNameToDo(nameToDo);
        toDo.setTodo(todo);
        toDo.setStatus(status);
        toDoRepository.save(toDo);
        return "home";
    }
}
