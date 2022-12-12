package solo.project.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListResponseDto {
    private Long id;
    private String title;
    private Long todoOrder;
    private boolean completed;
}
