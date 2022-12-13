package solo.project.todolist.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class TodoListDto {

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private String title;

    @Positive(message = "양수만 허용합니다.")
    private Long order;

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private boolean completed;


    public boolean getCompleted(){
        return completed;
    }
}
