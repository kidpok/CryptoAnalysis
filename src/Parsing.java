import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {
    private final Scanner console = new Scanner(System.in);
    private final Map<Character, Integer> encrypted = new HashMap<>();
    private final Map<Character, Integer> statistic = new HashMap<>();

    public void pars() throws IOException {
        System.out.println("Введите путь к файлу для его расшифровки");
        String pathEncrypted = console.nextLine();
        System.out.println("Введите путь к файлу для набора статистики");
        String pathStatistic = console.nextLine();

        fillMapValues(encrypted, pathEncrypted);
        fillMapValues(statistic, pathStatistic);

        Set<Character> characters = encrypted.keySet();
        Collection<Integer> values = encrypted.values();
        Set<Map.Entry<Character, Integer>> entries = encrypted.entrySet();


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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new Random().nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
