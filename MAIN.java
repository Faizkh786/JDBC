import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MAIN {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/faiz";
    private static final String USER = "root";
    private static final String PASS = "Sahil@2003";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sql = "INSERT INTO student (name, age,gender) VALUES (?, ?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            while (true) {

                // 🔹 Terminal se input
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter age: ");
                int age = Integer.parseInt(sc.nextLine());



                // 🔹 Query me values set
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3,gender);

                // 🔹 Insert
                ps.executeUpdate();
                System.out.println("✅ Data inserted successfully!");

                // 🔹 Continue or stop
                System.out.print("Add more data? (yes/no): ");
                String choice = sc.nextLine();

                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
