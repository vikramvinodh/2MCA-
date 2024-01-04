import java.util.*;

interface Myinterface<T> {
    T performOperation(T value);
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Integer");
        int intValue = scanner.nextInt();
        System.out.println("Enter a double");
        double doubleValue = scanner.nextDouble();
        System.out.println("Enter a string");
        String stringValue = scanner.next();

        Myinterface<Object> myInterface = new Myinterface<Object>() {
            @Override
            public Object performOperation(Object value) {
                if (value instanceof Integer) {
                    return (int) value * 2;
                } else if (value instanceof Double) {
                    return (double) value / 2;
                } else if (value instanceof String) {
                    return ((String) value).toUpperCase();
                } else {
                    return null;
                }
            }
        };

        Object result1 = myInterface.performOperation(stringValue);
        Object result2 = myInterface.performOperation(intValue);
        Object result3 = myInterface.performOperation(doubleValue);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
