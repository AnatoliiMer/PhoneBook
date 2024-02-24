import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts; //private

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public void displayAllContacts() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        sortedContacts.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Иван", "111111111");
        phoneBook.addContact("Степан", "222222222");
        phoneBook.addContact("Иван", "333333333");
        phoneBook.addContact("Федор", "444444444");
        phoneBook.addContact("Степан", "555555555");
        phoneBook.addContact("Степан", "666666666");

        phoneBook.displayAllContacts();
    }
}