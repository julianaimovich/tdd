import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        String number = null;
        if (contacts.containsKey(name)) {
            number = contacts.get(name);
        }
        return number;
    }

    public void printAllNames() {
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        if (!contacts.isEmpty()) {
            String contactsAsString = contacts.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(entry -> entry.getKey()  + ", " + entry.getValue())
                    .collect(Collectors.joining("; "));
            result = stringBuilder.append("Список контактов: ").append(contactsAsString).toString();
        } else {
            result = "Список контактов пуст";
        }
        System.out.print(result);
    }
}