package exercise;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        List<String> notNullFields = new ArrayList<>();
        for(Field field: fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (value == null) {
                        notNullFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notNullFields;
    }
    public static Map<String,List<String>> advancedValidate(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Map<String,List<String>> validationErrors = new HashMap<>();
        for(Field field: fields) {
           List<String> errors = new ArrayList<>();
           field.setAccessible(true);
           try {
               Object value = field.get(object);
               if (field.isAnnotationPresent(NotNull.class)) {
                   if(value == null) {
                       errors.add("can not be null");
                   }
               }
               if(field.isAnnotationPresent(MinLength.class)) {
                   MinLength minLength = field.getAnnotation(MinLength.class);
                   int minLengthValue = minLength.minLength();
                   if(value instanceof String) {
                       String stringValue = (String) value;
                       if(stringValue.length()< minLengthValue) {
                           errors.add("length less than " + minLengthValue);
                       }
                   }
               }

           } catch (IllegalAccessException e) {
               e.printStackTrace();
             }
           if(!errors.isEmpty()) {
               validationErrors.put(field.getName(), errors);
           }

        }
        return validationErrors;
    }
}
// END
