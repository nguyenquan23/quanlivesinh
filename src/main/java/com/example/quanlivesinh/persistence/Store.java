
package com.example.quanlivesinh.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cuahang")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "macuahang")
    private Long id;
    @Column(name ="tencuahang")
    private String name;
    @Column(name ="diachi")
    private String address;
    @Column(name ="hotline")
    private String phone;
    @Column(name = "tinhtrang")
    private boolean status;
    @Column(name = "thoigianhoatdong")
    private LocalDateTime operatingTime;
    @Column(name ="image")
    private String image;
    @ManyToMany(mappedBy = "stores", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Certification> certifications = new HashSet<>();
    public Store(){}
    public Store(Long id, String name, String address, String phone, boolean status, LocalDateTime operatingTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.operatingTime = operatingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(LocalDateTime operatingTime) {
        this.operatingTime = operatingTime;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }
/*@Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", operatingTime=" + operatingTime +
                ", certifications=" +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return status == store.status && Objects.equals(id, store.id) && Objects.equals(name, store.name) && Objects.equals(address, store.address) && Objects.equals(phone, store.phone) && Objects.equals(operatingTime, store.operatingTime) && Objects.equals(image, store.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, status, operatingTime, image);
    }
}

