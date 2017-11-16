package List.TODOlista.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import List.TODOlista.model.ToDo;
import List.TODOlista.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/")
    public String addToDoList() {
        return "htmls/home";
    }

    @PostMapping("/")
    public String addToDoList(@RequestParam String nameToDo, @RequestParam String todo, @RequestParam String status) {
        ToDo toDo = new ToDo(nameToDo,todo,status);
        toDoRepository.save(toDo);
        return "htmls/home";
    }

    @GetMapping("/show")
    public String show(@ModelAttribute ToDo toDo, ModelMap modelMap){
        modelMap.addAttribute("todo",toDoRepository.findAll());
        return"htmls/show";
    }

   /* @GetMapping("/all")
    public @ResponseBody Iterable<ToDo> getAllToDoList() {
        // This returns a JSON or XML with the users
        return toDoRepository.findAll();
    }*/

    @GetMapping("/change")
    public String change(@ModelAttribute ToDo toDo, ModelMap modelMap ){
        if(toDoRepository.equals(toDo.getNameToDo()))
        {
            toDoRepository.deleteById(toDo.getId());
            toDoRepository.save(toDo);
        }
        return "htmls/change";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id,ModelMap modelMap ){
        toDoRepository.deleteById(id);
        modelMap.addAttribute("Message","Delete Succesful");
        return "htmls/show";
    }
}
