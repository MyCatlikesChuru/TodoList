package solo.project.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.project.todolist.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
}
