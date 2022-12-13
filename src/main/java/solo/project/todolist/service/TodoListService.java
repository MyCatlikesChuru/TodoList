package solo.project.todolist.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.project.todolist.dto.TodoListDto;
import solo.project.todolist.entity.TodoList;
import solo.project.todolist.exception.ExceptionCode;
import solo.project.todolist.exception.ServiceLogicException;
import solo.project.todolist.repository.TodoListRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoList createTodoList(TodoList todoList){
        return saveTodoList(todoList);

    }

    public TodoList getList(Long listId){
        return findTodoList(listId);
    }

    public List<TodoList> getLists(){
        return todoListRepository.findAll();
    }

    public TodoList changeTodoList(Long listId, TodoListDto todoListDto){
        TodoList findTodoList = findTodoList(listId);

        Optional.ofNullable(todoListDto.getTitle()).ifPresent(title -> findTodoList.setTitle(title));
        Optional.ofNullable(todoListDto.getOrder()).ifPresent(todoOrder -> findTodoList.setOrder(todoOrder));
        Optional.ofNullable(todoListDto.getCompleted()).ifPresent(completed -> findTodoList.setCompleted(completed));

        return saveTodoList(findTodoList);
    }

    public void deleteTodoLists(){
        todoListRepository.deleteAll();
    }

    public void deleteTodoList(Long listId){
        findTodoList(listId);
        todoListRepository.deleteById(listId);
    }


    private TodoList findTodoList(Long listId) {
        Optional<TodoList> findTodoList = todoListRepository.findById(listId);

        return findTodoList.orElseThrow(() -> new ServiceLogicException(ExceptionCode.LIST_NOT_FOUND));
    }

    private TodoList saveTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

}
