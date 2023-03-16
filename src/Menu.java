import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("""
                    Выберите действие введя его номер\s
                    1. Зашифровать текст в файле с помощью ключа\s
                    2. Расшифровать текст в файле с помощью ключа\s
                    3. Подобрать ключ к зашифрованному тексту в файле\s
                    4. Расшифровать текст в файле методом статического анализа\s
                    5. Выход из программы""");

            String answer = reader.readLine();

            switch (answer) {
                case "1" -> new Encrypted().encrypted();
                case "2" -> new Decrypted().decrypted();
                case "3" -> System.out.println("3. Подобрать ключ к зашифрованному тексту в файле ");
                case "4" -> System.out.println("4. Расшифровать текст в файле методом статического анализа ");
                case "5" -> {
                    return;
                }

            }
        }
    }
}