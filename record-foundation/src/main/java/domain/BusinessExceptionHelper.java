package domain;

public class BusinessExceptionHelper {
    private BusinessExceptionHelper() {}

    public static void checkArgument(boolean expression, String message) {
        if(!expression) {
            throw new IllegalArgumentException(message);
        }
    }


    public static void main(String[] args) {
        BigDog bigDog = null;
        if (bigDog == null || bigDog.getAge() == -1) // -1 - 系统异常
            System.out.println("afadsfasdf");

        BusinessExceptionHelper.checkArgument(!(bigDog == null || bigDog.getAge() == -1), "aasdfasdf");
    }
}
