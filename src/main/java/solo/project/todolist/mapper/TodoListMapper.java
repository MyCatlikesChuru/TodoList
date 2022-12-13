package solo.project.todolist.mapper;

import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import solo.project.todolist.dto.TodoListDto;
import solo.project.todolist.dto.TodoListResponseDto;
import solo.project.todolist.entity.TodoList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TodoListMapper {
    default TodoList todoListDtoToTodoList(TodoListDto todoListDto){
        if ( todoListDto == null ) {
            return null;
        }

        if(ObjectUtils.isEmpty(todoListDto.getTitle())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(todoListDto.getOrder())){
            todoListDto.setOrder(0L);
        }

        if(ObjectUtils.isEmpty(todoListDto.getCompleted())){
            todoListDto.setCompleted(false);
        }

        TodoList todoList = new TodoList();

        todoList.setTitle( todoListDto.getTitle());
        todoList.setOrder(todoListDto.getOrder());
        todoList.setCompleted( todoListDto.getCompleted());

        return todoList;
    }
    default TodoListResponseDto todoListToTodoListResponseDto(TodoList todoList){
        if (todoList == null) {
            return null;
        } else {

            TodoListResponseDto todoListResponseDto = new TodoListResponseDto();
            todoListResponseDto.setId(todoList.getId());
            todoListResponseDto.setTitle(todoList.getTitle());
            todoListResponseDto.setOrder(todoList.getOrder());
            todoListResponseDto.setCompleted(todoList.getCompleted());
            todoListResponseDto.setUrl("http://localhost:8080/"+todoList.getId());
            return todoListResponseDto;
        }
    }

    default List<TodoListResponseDto> todoListToTodoListResponseDto(List<TodoList> todoList){
        if (todoList == null){
            return null;
        } else {

            return todoList.stream()
                    .map(todo -> {
                        TodoListResponseDto todoListResponseDto = new TodoListResponseDto();
                        todoListResponseDto.setId(todo.getId());
                        todoListResponseDto.setTitle(todo.getTitle());
                        todoListResponseDto.setOrder(todo.getOrder());
                        todoListResponseDto.setCompleted(todo.getCompleted());
                        todoListResponseDto.setUrl("http://localhost:8080/" + todo.getId());
                        return todoListResponseDto;
                    })
                    .collect(Collectors.toList());

        }
    }


}
