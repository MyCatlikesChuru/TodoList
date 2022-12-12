package solo.project.todolist.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solo.project.todolist.dto.TodoListDto;

@Slf4j
@RestController
public class TodoListController {

    @PostMapping
    public ResponseEntity createList(@RequestBody TodoListDto todoListDto){

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getLists(){

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{listId}")
    public ResponseEntity getList(@PathVariable Long listId){


        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{listId}")
    public ResponseEntity updateList(@PathVariable Long listId,
                                     @RequestBody TodoListDto todoListDto){

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteLists(){

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity deleteList(@PathVariable Long listId){

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
