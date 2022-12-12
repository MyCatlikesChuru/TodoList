package solo.project.todolist.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solo.project.todolist.dto.TodoListDto;
import solo.project.todolist.dto.TodoListResponseDto;
import solo.project.todolist.entity.TodoList;
import solo.project.todolist.mapper.TodoListMapper;
import solo.project.todolist.service.TodoListService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TodoListController {

    private final TodoListService todoListService;
    private final TodoListMapper todoListMapper;

    @PostMapping
    public ResponseEntity createList(@RequestBody TodoListDto todoListDto){

        log.info(todoListDto.getTitle());
        log.info(String.valueOf(todoListDto.getTodoOrder()));
        log.info(String.valueOf(todoListDto.getCompleted()));

        TodoList todoList = todoListService.createTodoList(todoListMapper.todoListDtoToTodoList(todoListDto));
        TodoListResponseDto todoListResponseDto = todoListMapper.todoListToTodoListResponseDto(todoList);

        return new ResponseEntity(todoListResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getLists(){

        List<TodoList> todoLists = todoListService.getLists();
        return new ResponseEntity(todoLists,HttpStatus.OK);
    }

    @GetMapping("/{listId}")
    public ResponseEntity getList(@PathVariable Long listId){

        TodoList todoList = todoListService.getList(listId);
        TodoListResponseDto todoListResponseDto = todoListMapper.todoListToTodoListResponseDto(todoList);
        return new ResponseEntity(todoListResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{listId}")
    public ResponseEntity updateList(@PathVariable Long listId,
                                     @RequestBody TodoListDto todoListDto){

        TodoList todoList = todoListService.changeTodoList(listId, todoListMapper.todoListDtoToTodoList(todoListDto));
        TodoListResponseDto todoListResponseDto = todoListMapper.todoListToTodoListResponseDto(todoList);
        return new ResponseEntity(todoListResponseDto,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteLists(){

        todoListService.deleteTodoLists();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity deleteList(@PathVariable Long listId){

        todoListService.deleteTodoList(listId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
