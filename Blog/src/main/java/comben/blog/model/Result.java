package comben.blog.model;

import comben.blog.constance.Status;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 22:58
 */
@Data
public class Result<T> {
    private T data;
    private String errorMessage;
    private Status status;


    public static Result fail(String errorMessage) {
        Result result = new Result();
        result.setErrorMessage(errorMessage);
        result.setStatus(Status.FAIL);
        return result;
    }

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setData(data);
        result.setStatus(Status.SUCCESS);
        return result;
    }

}
