package solo.project.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoListResponseDto {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;
}
