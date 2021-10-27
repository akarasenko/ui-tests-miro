package helpers;

public class DataGenerator {

    public static String generateLogin() {
        return String.format("login%s", System.currentTimeMillis());
    }

    public static String generateEmail() {
        return String.format("email%s@email.com", System.currentTimeMillis());
    }

    public static String generatePasswordWithEigthCharacters() {
        return (Long.toString(System.currentTimeMillis())).substring(0,8);
    }

    public static String generateRandomNumberPart() {
        return Long.toString(System.currentTimeMillis());
    }
}
