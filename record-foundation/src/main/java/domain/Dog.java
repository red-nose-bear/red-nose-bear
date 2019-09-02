package domain;

public class Dog {

    public static void main(String[] args) {
        String s = null;
        if ("a".equals(null))
            System.out.println("a");
    }

    private String name;
    private int age;
    private BigDog bigDog;
    private boolean success;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BigDog getBigDog() {
        return bigDog;
    }

    public void setBigDog(BigDog bigDog) {
        this.bigDog = bigDog;
    }
}

enum ResponseStatus {
    SUCCESS("成功"),
    FAILURE("失败"),
    ERROR("系统异常"),
    PROCESSING("处理中");

    public final String message;

    private ResponseStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}