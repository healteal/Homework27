import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class General {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static TreeMap<String, String> base = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        while (true) {
            showMenu();
            inputReader();
        }
    }

    static void showMenu() {
        System.out.println("""
                1. Введите нового пользователя
                2. Удалить существующего пользователя
                3. Проверить существует ли пользователь
                4. Изменить логин существуещего пользователя
                5. Изменить пароль существующего пользователя
                6. Выход
                """);
    }

    static void inputReader() throws IOException {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Неверный ввод\n");
            }
        }
        switch (choice) {
            case 1 -> {
                System.out.println("Введите логин:");
                String username = reader.readLine();
                if (base.containsKey(username)) {
                    System.out.println("Такой пользователь уже есть.\n");
                    break;
                }
                System.out.println("Введите пароль:");
                String password = reader.readLine();
                base.put(username, password);
            }
            case 2 -> {
                System.out.println("Введете логин:");
                String username = reader.readLine();
                if (base.containsKey(username)) {
                    base.remove(username);
                    System.out.println("Пользователь удалён\n");
                } else {
                    System.out.println("Такого пользователя нет\n");
                }
            }
            case 3 -> {
                System.out.println("Введите логин:");
                String username = reader.readLine();
                if (base.containsKey(username)) {
                    System.out.println("Такой пользователь есть\n");
                } else {
                    System.out.println("Такого пользователя не существует\n");
                }
            }
            case 4 -> {
                System.out.println("Введите логин:");
                String username = reader.readLine();
                if (base.containsKey(username)) {
                    System.out.println("Введите новый логин:");
                    String newUsername = reader.readLine();
                    String password = base.get(username);
                    base.remove(username);
                    base.put(newUsername, password);
                } else {
                    System.out.println("Такого пользователя не существует\n");
                }
            }
            case 5 -> {
                System.out.println("Введите логин:");
                String username = reader.readLine();
                if (base.containsKey(username)) {
                    System.out.println("Введите новый пароль:");
                    String password = reader.readLine();
                    base.replace(username, password);
                } else {
                    System.out.println("Такого пользователя не существует\n");
                }
            }
            case 6 -> System.exit(1);
            default -> System.out.println("Неверный ввод\n");
        }
    }
}
