import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Выберите действие введя его номер " +
                    "1. Зашифровать текст в файле с помощью ключа" +
                    "2. Расшифровать текст в файле с помощью ключа" +
                    "3. Подобрать ключ к зашифрованному тексту в файле " +
                    "4. Расшифровать текст в файле методом статического анализа " +
                    "5. Выход из программы");

            String answer = reader.readLine();

            switch (answer) {
                case "1" -> System.out.println("1. Зашифровать текст в файле с помощью ключа");
                case "2" -> System.out.println("2. Расшифровать текст в файле с помощью ключа");
                case "3" -> System.out.println("3. Подобрать ключ к зашифрованному тексту в файле ");
                case "4" -> System.out.println("4. Расшифровать текст в файле методом статического анализа ");
                default -> {
                    return;
                }

            }
        }
    }
}