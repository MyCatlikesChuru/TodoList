package solo.project.todolist.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class TodoListDto {

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private String title;

    @Positive(message = "양수만 허용합니다.")
    private Long order;

    private Boolean completed;

}
