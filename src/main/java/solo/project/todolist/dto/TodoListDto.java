package solo.project.todolist.dto;


import lombok.Getter;

@Getter
public class TodoListDto {

    private String title;
    private Long todoOrder;
    private boolean completed;

}
