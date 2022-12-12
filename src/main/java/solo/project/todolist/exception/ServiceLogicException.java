package solo.project.todolist.exception;

import lombok.Getter;

public class ServiceLogicException extends RuntimeException{
    @Getter
    private ExceptionCode exceptionCode;

    ServiceLogicException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
