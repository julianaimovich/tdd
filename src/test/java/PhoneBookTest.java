import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {

    String annaName = "Anna";
    String annaNumber = "88005553535";
    String elenaName = "Elena";
    String elenaNumber = "88166544514";

    public String getContactsList() {
        return "Список контактов: " + annaName + ", " + annaNumber + "; " +
                elenaName + ", " + elenaNumber;
    }

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
        assertNull(contactName);
    }

    @Test
    public void findContactNumberByExistentNameTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(annaName, annaNumber);
        String contactNumber = phoneBook.findByName(annaName);
        assertEquals(annaNumber, contactNumber);
    }

    @Test
    public void findContactNumberByNonexistentNameTest() {
        PhoneBook phoneBook = new PhoneBook();
        String contactNumber = phoneBook.findByName(annaName);
        assertNull(contactNumber);
    }

    @Test
    public void printAllExistentNamesTest() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(annaName, annaNumber);
        phoneBook.add(elenaName, elenaNumber);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        phoneBook.printAllNames();
        Assertions.assertEquals(getContactsList(), output.toString());
    }

    @Test
    public void printEmptyPhoneBookTest() {
        PhoneBook phoneBook = new PhoneBook();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        phoneBook.printAllNames();
        Assertions.assertEquals("Список контактов пуст", output.toString());
    }
}