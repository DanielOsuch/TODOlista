package List.TODOlista.repository;

import List.TODOlista.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,Integer> {
}
