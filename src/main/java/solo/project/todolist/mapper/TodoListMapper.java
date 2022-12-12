package solo.project.todolist.mapper;

import org.mapstruct.Mapper;
import solo.project.todolist.dto.TodoListDto;
import solo.project.todolist.dto.TodoListResponseDto;
import solo.project.todolist.entity.TodoList;

@Mapper(componentModel = "spring")
public interface TodoListMapper {
    TodoList todoListDtoToTodoList(TodoListDto todoListDto);
    TodoListResponseDto todoListToTodoListResponseDto(TodoList todoList);
}
