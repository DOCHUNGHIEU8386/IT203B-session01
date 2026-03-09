import java.io.IOException;

public class bai4 {

    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");

        throw new IOException("Lỗi khi ghi dữ liệu vào file!");
    }

    public static void processUserData() throws IOException {
        System.out.println("Đang xử lý dữ liệu người dùng...");
        saveToFile(); // gọi Method C
    }

    public static void main(String[] args) {

        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy bình thường.");
    }
}