package application;

public class JavaBeanClass {

    @MyPattern(regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "E-mail musi wyglądać następująco.\n"
            + "twojanazwa@domena.pl \n" + "twoja.nazwa@domena.pl \n" + "twoja-nazwa@domena.com \n"
            + "twojanazwa@domena.ed.pl \n" + "twoja_nazwa@domena.com \n")

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}