import java.util.Scanner;
import java.io.FileNotFoundException;

class InvalidAgeExcep extends Exception {
    public InvalidAgeExcep(String msg) {
        super(msg);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}

public class btth {

    public static String registerUser(String name, String ageInput, String email)
            throws InvalidAgeException, InvalidEmailException {

        int age;

        try {
            age = Integer.parseInt(ageInput); // có thể gây NumberFormatException
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Tuổi phải là một con số!");
        }

        if (age < 18) {
            throw new InvalidAgeException("Lỗi nghiệp vụ: Tuổi không đủ để đăng ký hệ thống.");
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException("Lỗi nghiệp vụ: Email không hợp lệ (phải chứa @).");
        }

        return "Tên: " + name + ", Tuổi: " + age + ", Email: " + email;
    }

    public static void saveUserToFile(String userData) throws FileNotFoundException {
        System.out.println("Đang lưu dữ liệu người dùng...");

        throw new FileNotFoundException("Không tìm thấy file lưu trữ.");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi: ");
            String age = scanner.nextLine();

            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            String userData = registerUser(name, age, email);
            System.out.println("Đăng ký thành công: " + userData);

            saveUserToFile(userData);

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());

        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());

        } finally {
            System.out.println("Hoàn tất luồng xử lý đăng ký.");
            scanner.close();
        }
    }
}   