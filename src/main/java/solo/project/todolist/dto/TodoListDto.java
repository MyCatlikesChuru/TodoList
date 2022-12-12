package solo.project.todolist.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListDto {

    private String title;
    private Long todoOrder;
    private boolean completed;


    public boolean getCompleted(){
        return completed;
    }
}
