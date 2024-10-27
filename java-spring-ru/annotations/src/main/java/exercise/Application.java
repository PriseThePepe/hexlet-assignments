package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Inspect.class)) {
                String methodName = method.getName();
                String methodReturnValue = method.getReturnType().getSimpleName();

                try {
                    method.invoke(address);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Method " + methodName + " returns a value of type " + methodReturnValue);

                // END
            }
        }
    }
}
