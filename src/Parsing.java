import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {
    private final Scanner console = new Scanner(System.in);
    private final Map<Character, Integer> encrypted = new HashMap<>();
    private final Map<Character, Integer> statistic = new HashMap<>();
    private final Map<Character, Character> decrypted = new HashMap<>();


    public void pars() throws IOException {
        System.out.println("Введите путь к файлу для его расшифровки");
        String pathEncrypted = console.nextLine();
        System.out.println("Введите путь к файлу для набора статистики");
        String pathStatistic = console.nextLine();
        Path path = PathHelper.buildFileName(pathEncrypted, "_parsing");

        List<Map.Entry<Character, Integer>> listEncrypted = mapToList(fillMapValues(encrypted, pathEncrypted));
        List<Map.Entry<Character, Integer>> listStatistic = mapToList(fillMapValues(statistic, pathStatistic));

        if (listEncrypted.size() <= listStatistic.size()) {
            for (int i = 0; i < listEncrypted.size(); i++) {
                decrypted.put(listEncrypted.get(i).getKey(), listStatistic.get(i).getKey());
            }
        } else {
            System.out.println("Размер файла статистики недостаточен, необходим файл большей длины, чем зашифрованный");
        }

        try (BufferedReader reader = Files.newBufferedReader(Path.of(pathEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(path)) {
            while (reader.ready()) {
                StringBuilder builder = new StringBuilder();
                String string = reader.readLine();
                for (char encryptedChar : string.toCharArray()) {
                    Character decryptedChar = decrypted.get(encryptedChar);
                    builder.append(decryptedChar);
                }
                writer.write(builder + System.lineSeparator());
            }
        }
        System.out.println("Содержимое файла расшифровано");
    }


    private Map<Character, Integer> fillMapValues(Map<Character, Integer> map, String path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            StringBuilder builder = new StringBuilder();

            while (reader.ready()) {
                String str = console.nextLine();
                builder.append(str);
            }
            for (char aChar : builder.toString().toCharArray()) {
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                } else {
                    map.put(aChar, map.get(aChar) + 1);
                }
            }
        }
        return map;
    }

    private List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return list;

    }

}
