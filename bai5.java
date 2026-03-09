import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

class User {
    private int age;

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class bai5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        try {
            System.out.print("Nhập tuổi người dùng: ");
            int age = scanner.nextInt();

            user.setAge(age); // có thể ném InvalidAgeException
            System.out.println("Tuổi hợp lệ: " + user.getAge());

        } catch (InvalidAgeException e) {
            System.out.println("Lỗi nghiệp vụ: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("Đã dọn dẹp tài nguyên.");
        }

        System.out.println("Chương trình tiếp tục chạy.");
    }
}