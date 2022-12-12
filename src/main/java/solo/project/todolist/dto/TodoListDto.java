package solo.project.todolist.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoListDto {

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private String title;

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private Long order;

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private boolean completed;


    public boolean getCompleted(){
        return completed;
    }
}
