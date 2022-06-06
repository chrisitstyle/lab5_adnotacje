package application;

public interface Validator {

    void validate(String value);

    boolean isValid();

    String getMessage();

}
