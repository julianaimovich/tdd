import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    protected Map<String, String> contacts = new HashMap<>();

    public int add(String name, String number) {
        if (!(contacts.containsKey(name) && contacts.containsValue(number))) {
            contacts.put(name, number);
        }
        return contacts.size();
    }

    public String findByNumber(String number) {
        String name = null;
        if (contacts.containsValue(number)) {
            name = contacts.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(number))
                    .map(Map.Entry::getKey)
                    .toList()
                    .get(0);
        }
        return name;
    }

    public String findByName(String name) {
        return null;
    }
}