package username;

import java.io.IOException;

/**
 * Course: CYB - 2311
 * Lab 1 - Vigenere cipher
 *
 * This class implements the decryption algorithm for the Vigenère cipher.
 * It provides functionality to decrypt text that has been encrypted using
 * the Vigenère cipher with a given key. The implementation supports
 * lowercase letters (a-z) only.
 *
 * @author TODO
 */
public class VigenereDecryption {

    /**
     * Decrypts the given ciphertext using the Vigenère cipher with the specified key.
     * Only processes lowercase letters a-z, all other characters will be ignored.
     * The formula for decryption is: p = (c - k) mod 26,
     * where p is the plaintext letter, c is the ciphertext letter, and k is the key letter.
     *
     * @param ciphertext The text to decrypt (must contain only lowercase letters a-z)
     * @param key The decryption key (must contain only lowercase letters a-z)
     * @return The decrypted text (plaintext)
     * @throws IllegalArgumentException if the ciphertext or key is null or empty,
     *         or if they contain invalid characters
     */
    public String decrypt(String ciphertext, String key) {
        return null;
    }

    /**
     * Decrypts content from an input file and writes the result to an output file
     * using the provided key. All files are assumed to be in the data directory.
     * The input file should contain only lowercase letters. The decrypted result
     * will be written to the output file, with each line processed separately.
     *
     * @param inputFile Name of the input file containing the ciphertext (in data directory)
     * @param outputFile Name of the file where the decrypted text will be written (in data directory)
     * @param key The decryption key (must contain only lowercase letters a-z)
     * @throws IOException If file operations fail
     * @throws IllegalArgumentException if the key is null, empty, or contains invalid characters,
     *         or if file paths are invalid
     */
    public void decryptFile(String inputFile, String outputFile, String key) throws IOException {
        // TODO: Implement decryption from file
    }
}