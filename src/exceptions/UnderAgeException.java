package exceptions;

public class UnderAgeException extends Exception {
    public UnderAgeException() {
        super("Movie goer is under age");
    }
}
