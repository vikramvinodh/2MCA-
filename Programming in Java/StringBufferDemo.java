import java.util.*;

public class StringBufferDemo {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello");

        // append() method
        str.append(" World!");
        System.out.println("Appended string: " + str);

        // insert() method
        str.insert(6, "Java");
        System.out.println("Inserted string: " + str);

        // replace() method
        str.replace(11, 14, "Programmer");
        System.out.println("Replaced string: " + str);

        // delete() method
        str.delete(0, 5);
        System.out.println("Deleted string: " + str);

        // charAt() method
        char ch = str.charAt(4);
        System.out.println("Character at index 4: " + ch);

        // setCharAt() method
        str.setCharAt(4, 'e');
        System.out.println("Modified character at index 4: " + str);

        // length() method
        int length = str.length();
        System.out.println("Length of the string: " + length);

        // capacity() method
        int capacity = str.capacity();
        System.out.println("Capacity of the string buffer: " + capacity);

        // ensureCapacity() method
        str.ensureCapacity(20);
        capacity = str.capacity();
        System.out.println("Increased capacity of the string buffer: " + capacity);

        // toString() method
        String str1 = str.toString();
        System.out.println("String representation: " + str1);

        // substring(int start) method
        String subStr1 = str.substring(3);
        System.out.println("Substring starting from index 3: " + subStr1);

        // substring(int start, int end) method
        String subStr2 = str.substring(2, 6);
        System.out.println("Substring from index 2 to 5: " + subStr2);
    }
}
