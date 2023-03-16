

public class CaesarCipher {
    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";


    public static String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int index = alphabet.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt = 0;
                if (newIndex < 0) {
                    charAt = alphabet.charAt(newIndex + alphabet.length());
                } else {
                    charAt = alphabet.charAt(newIndex);
                }

                builder.append(charAt);
            }

        }
        return builder.toString();
    }

    public static String decrypt(String message, int key) {
        return encrypt(message, key * (-1));
    }

    public static void main(String[] args) {
        String str = "$";
        String encrypt = encrypt(str, 3);
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt, 3);
        System.out.println(decrypt);
    }
}

