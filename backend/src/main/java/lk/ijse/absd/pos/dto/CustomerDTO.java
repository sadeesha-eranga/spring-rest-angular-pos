package lk.ijse.absd.pos.dto;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:30 AM
 */
public class CustomerDTO {

    private int customerId;
    private String name;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public CustomerDTO(int customerId, String name, String address) {
        this.setCustomerId(customerId);
        this.setName(name);
        this.setAddress(address);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
