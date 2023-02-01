package practice;

import java.util.*;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();

    String rgPhone = "['7'][0-9]{10}";
    String rgName = "[A-Za-zа-яА-Я]+";


    public boolean isName(String name) {
        if (name.matches(rgName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPhone(String phone) {
        if (phone.matches(rgPhone)) {
            return true;
        } else {
            return false;
        }
    }

    public void addContact(String phone, String name) {
        if (isPhone(phone) && isName(name)) {
            if (phoneBook.containsValue(phone)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (phone.equals(value)) {
                        phoneBook.remove(key);
                        phoneBook.put(name, phone);
                    }
                }
            } else if (phoneBook.containsKey(name)) {
                phoneBook.put(name, phoneBook.get(name) + ", " + phone);
            } else {
                phoneBook.put(name, phone);
            }
        }
    }


    public String getContactByPhone(String phone) {
        if (phoneBook.containsValue(phone)) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (phone.equals(entry.getValue())) {
                    return entry.getKey() + " - " + phone;
                }

            }
        }
        return "";
    }


    public Set<String> getContactByName(String name) {

        if (phoneBook.containsKey(name)) {
            return Collections.singleton(name + " - " + phoneBook.get(name));
        } else {
            return new TreeSet<>();
        }
    }

    public Set<String> getAllContacts() {
        Map<String, String> contacts = new HashMap<>();
        Set<String> allContacts = new TreeSet<>();

        if (!phoneBook.isEmpty()) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (contacts.containsKey(entry.getValue())) {
                    String nameA = contacts.get(entry.getValue());
                    if (contacts.containsValue(nameA) && contacts.containsKey(entry.getValue())) {
                        return Collections.singleton(nameA + " - " + entry.getValue());
                    } else {
                        contacts.put(entry.getValue(), nameA.concat(", ").concat(entry.getKey()));
                        String nameNew = contacts.get(entry.getValue());
                        allContacts.add(nameNew + " - " + entry.getValue());
                    }

                } else {
                    contacts.put(entry.getKey(), entry.getValue());
                    allContacts.add(entry.getKey() + " - " + entry.getValue());
                }
            }
        }
        return new TreeSet<>(allContacts);
    }
}
