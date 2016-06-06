package ua.levelup.AddressManager.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by java on 11.05.2016.
 */
@Entity
@Table(name = "phone")
@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
public class Phone implements Serializable {

    private long id_phone;
    private String namber;
    private Address address;

    public Phone() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_phone")
    public long getId_phone() {
        return id_phone;
    }

    public void setId_phone(long id_phone) {
        this.id_phone = id_phone;
    }

    @Column(name = "namber")
    public String getNumber() {
        return namber;
    }

    public void setNumber(String namber) {
        this.namber = namber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return namber;
    }
}