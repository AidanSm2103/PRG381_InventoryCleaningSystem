package inventorycleaning.model;

public class User {
    private int id;
    private String username;
    private String password; // store hashed, never plain text
    private String role; // "Storekeeper" or "Supervisor" — matches role-based access requirement

    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
