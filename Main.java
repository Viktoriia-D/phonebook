package practice;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name, phone;
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("Введите номер, имя или команду:");
            String newEnter = scanner.nextLine();
            if (newEnter.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            } else if (phoneBook.isName(newEnter)) {
                name = newEnter;
                if (phoneBook.getContactByName(name).isEmpty()) {
                    System.out.println("Такого имени нет в телефонной книге. \n" +
                            "Введите номер телефона для " + name + ":");
                    String newPhone = scanner.nextLine();
                    if (phoneBook.isPhone(newPhone)) {
                        phone = newPhone;
                        phoneBook.addContact(name, phone);
                        System.out.println("Новый контакт записан в телефонную книгу: \n" +
                                name + " - " + phone);
                    } else {
                        System.out.println("Введенные данные не соответствуют формату номера телефона.");
                    }
                }
            } else if (phoneBook.isPhone(newEnter)) {
                phone = newEnter;
                if (phoneBook.getContactByPhone(phone).isEmpty()) {
                    System.out.println("Такого номера нет в телефонной книге. \n" +
                            "Введите имя абонента для " + phone + ":");
                    String newName = scanner.nextLine();
                    if (phoneBook.isName(newName)) {
                        name = newName;
                        phoneBook.addContact(name, phone);
                        System.out.println("Новый контакт записан в телефонную книгу: \n" +
                                name + " - " + phone);
                    } else {
                        System.out.println("Введенные данные не соответствуют формату имени абонента.");
                    }

                }
            }


        }


    }}




