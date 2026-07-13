package inventorycleaning.model;

public class Supplier {
    private int id;
    private String name;
    private String contactNumber;
    private String email;

    public Supplier(int id, String name, String contactNumber, String email) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString(){
        return String.format("%d,%s,%s,%s", id, name, contactNumber, email);
    }
}
