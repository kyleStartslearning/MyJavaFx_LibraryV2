package codes.Databases;

import java.util.HashMap;

public class Admin {
    // Static HashMap to store admin accounts
    private static HashMap<String, Admin> admins = new HashMap<>();
    private static final String Admin_Passcode = "admin123";
    private static final int Max_attemp = 3;

    private String name;
    private String password;
    private String email;
    private int age;
    private String phoneNumber;

    // Constructor
    public Admin(String name, String password, String email, int age, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Initialize default admin accounts
    public static void initializeAdminDatabase() {
        addAdmin("Admin", "admin123", "admin@library.com", 30, "09000000000");
        addAdmin("System", "sys123", "system@library.com", 25, "09111111111");
    }

    // Add new admin to database
    public static void addAdmin(String name, String password, String email, int age, String phoneNumber) {
        Admin admin = new Admin(name, password, email, age, phoneNumber);
        admins.put(admin.getEmail(), admin);
    }

    // Verify admin credentials for login
    public static boolean verifyAdminCredentials(String email, String password) {
        Admin admin = admins.get(email);
        return admin != null && admin.getPassword().equals(password);
    }

    // Verify admin passcode for registration
    public static boolean VerifyPasscode(String input) {
        return Admin_Passcode.equals(input);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Get all admins
    public static HashMap<String, Admin> getAdmins() {
        return admins;
    }
}