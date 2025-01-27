/**
 * Course: CYB - 2311
 * Lab 1 - Vigenere cipher
 * @author Zhonghao Liao
 *
 */

package username;

import java.io.*;
import java.util.Scanner;

public class VigenereCipher {
    /**
     * Encrypts the given plaintext using the Vigenère cipher with the specified key.
     * Only processes lowercase letters a-z, ignoring all other characters.
     *
     * @param plaintext The text to encrypt
     * @param key The encryption key
     * @return The encrypted text
     */
    public String encrypt(String plaintext, String key) {
        if (plaintext == null || key == null || plaintext.isEmpty() || key.isEmpty()) {
            throw new IllegalArgumentException("Plaintext and key cannot be null or empty");
        }

        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();
        int keyIndex = 0;

        for (char c : plaintext.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Convert letters to 0-25 range
                int p = c - 'a';
                int k = key.charAt(keyIndex) - 'a';

                // Apply Vigenère encryption formula: (p + k) mod 26
                int encrypted = (p + k) % 26;

                // Convert back to letter and append
                ciphertext.append((char) (encrypted + 'a'));

                // Move to next key character
                keyIndex = (keyIndex + 1) % keyLength;
            }
        }

        return ciphertext.toString();
    }

    /**
     * Encrypts content from input file and writes to output file using the provided key.
     *
     * @param inputFile Path to the input file
     * @param outputFile Path to the output file
     * @param key The encryption key
     * @throws IOException If file operations fail
     */
    public void encryptFile(String inputFile, String outputFile, String key) throws IOException {
        // Validate the key
        if (key == null || key.isEmpty() || !key.matches("[a-z]+")) {
            throw new IllegalArgumentException("Key must contain only lowercase letters a-z");
        }

        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                String encryptedLine = encrypt(line, key);
                writer.println(encryptedLine);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Input file not found: " + inputFile, e);
        }
    }

    /**
     * Main method demonstrating the usage of the Vigenère cipher.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java VigenereCipher <input_file> <output_file> <key>");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        String inputFile = "data/" + inputFileName;
        String outputFile = "data/" + outputFileName;
        String key = args[2].toLowerCase();

        VigenereCipher cipher = new VigenereCipher();

        try {
            cipher.encryptFile(inputFile, outputFile, key);
            System.out.println("Encryption completed successfully.");
            System.out.println("Encrypted content written to: " + outputFile);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            System.exit(1);
        }
    }

}