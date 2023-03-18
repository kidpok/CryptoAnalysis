import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Bruteforce {
    private final Scanner console = new Scanner(System.in);
    private final CaesarCipher caesarCipher = new CaesarCipher();
    private static final int MAX_LENGTH_WORD = 28;

    public void bruteforce() throws IOException {

        System.out.println("Введите путь к файлу для его расшифровки");
        String path = console.nextLine();

        Path result = PathHelper.buildFileName(path, "_bruteforce");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(result)) {

            StringBuilder builder = new StringBuilder();

            while (reader.ready()) {
                String str = reader.readLine();
                builder.append(str).append(System.lineSeparator());
            }
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(builder.toString(), i);

          if (isValidateText(decrypt)){
              //дз что делать если он вернул тру
          }
            }
        }
    }

    private boolean isValidateText(String text) {

        boolean isValidate = false;

        for (String string : text.split(" ")) {
            if (string.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        if (text.contains(". ") || text.contains("? ") || text.contains("! ") || text.contains(", ")) {
            isValidate = true;
        }
        while (isValidate) {
            //дз сократить текст чтобы выводилась не вся книга
            System.out.println(text);
            System.out.println("Понятен ли этот текст? Y / N");
            String answer = console.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                isValidate = false;
            } else {
                System.out.println("Выберите между Y / N");
            }
        }

        return false;
    }
}
