package lk.ijse.absd.pos.dto;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:30 AM
 */
public class CustomerDTO {

    private int id;
    private String name;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
