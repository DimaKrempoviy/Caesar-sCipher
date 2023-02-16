import java.util.Scanner;

class CaesarCipher {

    private static final String PLAINT_TEXT_REQUEST = "Enter the plain text: ";
    private static final String SHIFT_REQUEST = "Enter the shift value: ";
    private static final String ENCRYPTED_TEXT_OUTPUT_PREFIX = "Encrypted Text: ";
    private static final String DECRYPTED_TEXT_OUTPUT_PREFIX = "Decrypted Text: ";
    private static final int ALPHABET_LENGTH = 26;
    private static final char LAST_LETTER = 'z';
    private static final char UPPERCASE_Z = 'Z';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(PLAINT_TEXT_REQUEST);
        String plainText = scanner.nextLine();

        System.out.println(SHIFT_REQUEST);
        int shift = scanner.nextInt();

        String encryptedText = encrypt(plainText, shift);
        System.out.println(ENCRYPTED_TEXT_OUTPUT_PREFIX + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println(DECRYPTED_TEXT_OUTPUT_PREFIX + decryptedText);

        scanner.close();
    }

    private static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);

            if (Character.isLetter(character)) {
                character = (char) (character + shift);

                if (Character.isUpperCase(plainText.charAt(i)) && character > UPPERCASE_Z
                        || Character.isLowerCase(plainText.charAt(i)) && character > ALPHABET_LENGTH) {
                    character = (char) (character - LAST_LETTER);
                }
            }
            encryptedText.append(character);
        }
        return encryptedText.toString();
    }

    private static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, 26 - shift);
    }

}
