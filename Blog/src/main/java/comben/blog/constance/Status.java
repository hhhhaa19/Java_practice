package comben.blog.constance;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 23:00
 */
public enum Status {
    FAIL(-1), SUCCESS(200);
    private Integer value;

    private Status(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
