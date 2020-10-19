package chao.util.validate;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/31 21:05:00
 */
public class ValidateInfo {


    private Validation validation;

    private String message;

    public ValidateInfo(Validation validation, String message) {
        this.validation = validation;
        this.message = message;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    void handler(String name, String value) throws Exception {
        if (!validation.validate(name, value)) {
            throw new Exception(message);
        }
    }
}
