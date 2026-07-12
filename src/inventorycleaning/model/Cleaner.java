package inventorycleaning.model;

public class Cleaner {
    private int id;
    private String name;
    private String department; // optional, per the spec

    public Cleaner(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
}
