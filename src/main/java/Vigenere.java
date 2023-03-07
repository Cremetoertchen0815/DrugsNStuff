public class Vigenere {

    private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static String encrypt(String key, String message) {
        char[] keyChars = key.toCharArray();
        char[] msgChars = message.toCharArray();
        char[] cipherChars = new char[message.length()];
        int i = 0;
        int j = 0;
        for (char c:
                msgChars) {
            int charIndex = getIndexOfChar(c);
            int keyCharIndex = getIndexOfChar(keyChars[i]);
            int indexCipher = charIndex + keyCharIndex;
            if(indexCipher > 25) indexCipher -= 26;
            cipherChars[j] = alphabet[indexCipher];
            j++;
            if(i == key.length() - 1) {i = 0;}
            else i++;
        }

        String cipher = new String(cipherChars);
        return cipher;
    }

    public static String decrypt(String key, String cipher) {
        char[] keyChars = key.toCharArray();
        char[] cipherChars = cipher.toCharArray();
        char[] msgChars = new char[cipher.length()];

        int i = 0;
        int j = 0;
        for (char c:
             cipherChars) {
            int charIndex = getIndexOfChar(c);
            int keyCharIndex = getIndexOfChar(keyChars[i]);
            int indexMessage = charIndex - keyCharIndex;
            if(indexMessage < 0) indexMessage += 26;
            msgChars[j] = alphabet[indexMessage];
            j++;
            if(i == key.length() - 1) {i = 0;}
            else i++;
        }

        String message = new String(msgChars);
        return message;
    }

    private static int getIndexOfChar(char c) {
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] == c) return i;
        }
        return -1;
    }
}
