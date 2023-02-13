import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String plainText, int shift) {
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (Character.isUpperCase(plainText.charAt(i)) && c > 'Z'
                        || Character.isLowerCase(plainText.charAt(i)) && c > 'z') {
                    c = (char) (c - 26);
                }
            }
            encryptedText += c;
        }
        return encryptedText;
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        String plainText = sc.nextLine();
        System.out.println("Enter the shift value: ");
        int shift = sc.nextInt();
        String encryptedText = encrypt(plainText, shift);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }

}
