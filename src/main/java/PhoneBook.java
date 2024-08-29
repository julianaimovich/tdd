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
        return null;
    }
}