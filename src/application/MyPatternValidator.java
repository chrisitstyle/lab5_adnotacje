package application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternValidator implements Validator {

    public String message;
    public String regex;
    public String value;

    @Override
    public void validate(String value) {
        this.value = value;
        Field field = null;
        try {
            field = JavaBeanClass.class.getDeclaredField("value");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Annotation a = (Annotation) field.getAnnotation(MyPattern.class);
        MyPattern p = (MyPattern) a;

        message = p.message().toString();
        regex = p.regex().toString();
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.value);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

}
