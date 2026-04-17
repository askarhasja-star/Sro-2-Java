import java.util.Scanner;

// Узел
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Связный список
class LinkedList {
    Node head;

    // добавить в конец
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // добавить в начало
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // удалить элемент
    public void remove(int data) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Элемент не найден");
    }

    // поиск
    public boolean contains(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // размер
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // вывод
    public void printList() {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}

// Главный класс с меню
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice;

        do {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Добавить элемент в конец");
            System.out.println("2. Добавить элемент в начало");
            System.out.println("3. Удалить элемент");
            System.out.println("4. Найти элемент");
            System.out.println("5. Показать список");
            System.out.println("6. Размер списка");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите число: ");
                    int value1 = scanner.nextInt();
                    list.add(value1);
                    break;

                case 2:
                    System.out.print("Введите число: ");
                    int value2 = scanner.nextInt();
                    list.addFirst(value2);
                    break;

                case 3:
                    System.out.print("Введите число для удаления: ");
                    int value3 = scanner.nextInt();
                    list.remove(value3);
                    break;

                case 4:
                    System.out.print("Введите число для поиска: ");
                    int value4 = scanner.nextInt();
                    if (list.contains(value4)) {
                        System.out.println("Элемент найден");
                    } else {
                        System.out.println("Элемент не найден");
                    }
                    break;

                case 5:
                    list.printList();
                    break;

                case 6:
                    System.out.println("Размер: " + list.size());
                    break;

                case 0:
                    System.out.println("Выход...");
                    break;

                default:
                    System.out.println("Неверный выбор");
            }

        } while (choice != 0);

        scanner.close();
    }
}