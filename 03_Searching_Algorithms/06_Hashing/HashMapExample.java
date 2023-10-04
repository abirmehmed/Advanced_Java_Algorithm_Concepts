import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("John", 25);
        map.put("Alice", 30);
        map.put("Bob", 35);
        map.put("Jane", 40);

        // Retrieve values from the HashMap using keys
        int johnAge = map.get("John");
        int aliceAge = map.get("Alice");

        // Print the retrieved values
        System.out.println("John's age: " + johnAge);
        System.out.println("Alice's age: " + aliceAge);
    }
}
