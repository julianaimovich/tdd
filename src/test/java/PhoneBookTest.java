import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    String annaName = "Anna";
    String annaNumber = "88005553535";
    String elenaName = "Elena";
    String elenaNumber = "88166544514";

    @Test
    public void addNewContactTest() {
        PhoneBook phoneBook = new PhoneBook();
        int contactsQuantity = phoneBook.add(annaName, annaNumber);
        assertEquals(1, contactsQuantity);
    }

    @Test
    public void addExistentContactTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(annaName, annaNumber);
        int contactsQuantity = phoneBook.add(annaName, annaNumber);
        assertEquals(1, contactsQuantity);
    }

    @Test
    public void addDifferentContactsTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(annaName, annaNumber);
        int contactsQuantity = phoneBook.add(elenaName, elenaNumber);
        assertEquals(2, contactsQuantity);
    }

    @Test
    public void findContactNameByExistentNumberTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(annaName, annaNumber);
        String contactName = phoneBook.findByNumber(annaNumber);
        assertEquals(annaName, contactName);
    }

    @Test
    public void findContactNameByNonexistentNumberTest() {
        PhoneBook phoneBook = new PhoneBook();
        String contactName = phoneBook.findByNumber(annaNumber);
        assertEquals(annaName, contactName);
    }
}