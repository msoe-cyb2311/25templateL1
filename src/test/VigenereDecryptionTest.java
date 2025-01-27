package test;

import username.VigenereDecryption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Path;

class VigenereDecryptionTest {

    private VigenereDecryption decryptor = new VigenereDecryption();

    @Test
    void testBasicDecryption() {
        String ciphertext = "rifvs";  // Encrypted with key="key"
        String key = "key";
        String expected = "hello";
        assertEquals(expected, decryptor.decrypt(ciphertext, key));
    }

    @Test
    void testSimpleMessage() {
        String ciphertext = "khwor";  // Encrypted with key="test"
        String key = "test";
        String expected = "hello";
        assertEquals(expected, decryptor.decrypt(ciphertext, key));
    }

    @Test
    void testEmptyString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> decryptor.decrypt("", "key"));
        assertEquals("Ciphertext and key cannot be null or empty", exception.getMessage());
    }

    @Test
    void testNullKey() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> decryptor.decrypt("hello", null));
        assertEquals("Ciphertext and key cannot be null or empty", exception.getMessage());
    }

    @Test
    void testDecryptFile() throws IOException {
        String inputFile = "data/test_cipher.txt";
        String outputFile = "data/test_plain.txt";

        // Write test content to input file
        try (PrintWriter writer = new PrintWriter(new File(inputFile))) {
            writer.println("rifvscyvvn");  // "helloworld" encrypted with key="key"
        }

        try {
            // Perform decryption
            decryptor.decryptFile(inputFile, outputFile, "key");

            // Read and verify the output
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
                String decryptedText = reader.readLine();
                assertEquals("helloworld", decryptedText);
            }
        } finally {
            // Clean up test files
            new File(inputFile).delete();
            new File(outputFile).delete();
        }
    }

    @Test
    void testInvalidKeyCharacters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> decryptor.decryptFile("data/test.txt", "data/out.txt", "KEY123"));
        assertEquals("Key must contain only lowercase letters a-z", exception.getMessage());
    }
}