package solo.project.todolist.mapper;

import org.mapstruct.Mapper;
import solo.project.todolist.dto.TodoListDto;
import solo.project.todolist.dto.TodoListResponseDto;
import solo.project.todolist.entity.TodoList;

@Mapper(componentModel = "spring")
public interface TodoListMapper {
    default TodoList todoListDtoToTodoList(TodoListDto todoListDto){
        if ( todoListDto == null ) {
            return null;
        }

        TodoList todoList = new TodoList();

        todoList.setTitle( todoListDto.getTitle() );
        todoList.setTodoOrder(todoListDto.getOrder());
        todoList.setCompleted( todoListDto.getCompleted());

        return todoList;
    }
    TodoListResponseDto todoListToTodoListResponseDto(TodoList todoList);
}
