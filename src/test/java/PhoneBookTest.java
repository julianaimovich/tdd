import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    @Test
    public void addNewContactTest() {
        PhoneBook phoneBook = new PhoneBook();
        int contactsQuantity = phoneBook.add("Anna", "88005553535");
        assertEquals(1, contactsQuantity);
    }

    @Test
    public void addExistentContactTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Anna", "88005553535");
        int contactsQuantity = phoneBook.add("Anna", "88005553535");
        assertEquals(1, contactsQuantity);
    }

    @Test
    public void addDifferentContactsTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Anna", "88005553535");
        int contactsQuantity = phoneBook.add("Elena", "88166544514");
        assertEquals(1, contactsQuantity);
    }
}