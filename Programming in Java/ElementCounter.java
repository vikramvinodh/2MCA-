import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;


public class ElementCounter {

    public static <T> int countElementsWithProperty(Collection<T> collection, Predicate<T> propertyCondition) {
        int count = 0;

        for (T element : collection) {
            if (propertyCondition.test(element)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage:

        // Count odd integers in a list
        Collection<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        int oddCount = countElementsWithProperty(integerList, isOdd);
        System.out.println("Count of odd integers: " + oddCount);

        // Count prime numbers in a set
        Collection<Integer> primeSet = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23);
        Predicate<Integer> isPrime = ElementCounter::isPrime;
        int primeCount = countElementsWithProperty(primeSet, isPrime);
        System.out.println("Count of prime numbers: " + primeCount);
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
