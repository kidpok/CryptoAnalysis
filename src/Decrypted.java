import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Decrypted {

    private final Scanner console = new Scanner(System.in);
    private final CaesarCipher caesar = new CaesarCipher();

    public void decrypted() throws IOException {
        System.out.println("Введите полный путь к файлу для его расшифровки");
        String path = console.nextLine();

        System.out.println("Введите ключ");
        int key = Integer.parseInt(console.nextLine());

        System.out.println("Куда записать результат?");
        String result = console.nextLine();

        try(BufferedReader reader = Files.newBufferedReader(Path.of(path));
            BufferedWriter writer = Files.newBufferedWriter(Path.of(result))){

            while (reader.ready()){
                String str = reader.readLine();
                String decrypt = caesar.decrypt(str, key);
                writer.write(decrypt + System.lineSeparator());
            }
        }

        System.out.println("Содержимое файла расшифровано");

    }

}
