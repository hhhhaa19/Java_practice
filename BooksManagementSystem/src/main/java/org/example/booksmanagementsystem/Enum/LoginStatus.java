package org.example.booksmanagementsystem.Enum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-22
 * Time: 16:55
 */
public enum LoginStatus {
    NOT_LOG(-2),ERROR(-1),SUCCESS(200);
    private Integer value;
    private LoginStatus(Integer value) {
        this.value = value;
    }
}
