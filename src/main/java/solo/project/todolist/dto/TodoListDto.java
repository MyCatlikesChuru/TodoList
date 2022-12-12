package solo.project.todolist.dto;


import lombok.Getter;
import lombok.Setter;
import solo.project.customvalidator.NotSpace;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoListDto {

    @NotSpace
    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    private String title;

    @NotSpace
    @NotBlank(message = "목록 번호는 공백이 아니어야 합니다.")
    private Long order;

    @NotSpace
    @NotBlank(message = "완료여부는 공백이 아니어야 합니다.")
    private boolean completed;


    public boolean getCompleted(){
        return completed;
    }
}
