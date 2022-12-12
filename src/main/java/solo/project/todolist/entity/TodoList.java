package solo.project.todolist.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoList {

    private Long id;
    private String title;
    private Long todoOrder;
    private boolean completed;

}
