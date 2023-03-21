import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bruteforce {
    private final Scanner console = new Scanner(System.in);
    private final CaesarCipher caesarCipher = new CaesarCipher();
    private static final int MAX_LENGTH_WORD = 28;

    public void bruteforce() throws IOException {

        System.out.println("Введите путь к файлу для его расшифровки");
        String path = console.nextLine();

        Path result = PathHelper.buildFileName(path, "_bruteforce");

//        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
//             BufferedWriter writer = Files.newBufferedWriter(result)) {
            String content = Files.readString(Path.of(path));

//           StringBuilder builder = new StringBuilder();
//            List<String> list = new ArrayList<>();
//            while (reader.ready()) {
//                String str = reader.readLine();
//                list.add(str);
//                builder.append(str).append(System.lineSeparator());
//            }
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
//              String decrypt = caesarCipher.decrypt(builder.toString(), i);
                String decrypt = caesarCipher.decrypt(content, i);
                if (isValidateText(decrypt)) {
                    Files.writeString(result, decrypt);
                    System.out.println("Содержимое было расшифровано. Ключ расшифровки К = " + i);
                    break;
                }


//                if (isValidateText(decrypt)) {
//                    for (String string : list) {
//                        String encrypt = caesarCipher.decrypt(string, i);
//                        writer.write(encrypt + System.lineSeparator());
//                    }
//                    System.out.println("Содержимое было расшифровано. Ключ расшифровки К = " + i);
//                    break;
//                }

            }
//        }
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
            System.out.println(text.substring(0, Math.min(text.length(), 1000)));
            // int indexStart = new Random().nextInt(text.length() / 2); // так тоже можно
            // System.out.println(text.substring(indexStart, indexStart + (int) Math.sqrt(text.length())));
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
