package solo.project.todolist.exception;

import lombok.Getter;

public enum ExceptionCode {
    LIST_NOT_FOUND(404,"TodoList Not Found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
