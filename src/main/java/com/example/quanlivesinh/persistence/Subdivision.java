package com.example.quanlivesinh.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chicuc")
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machicuc")
    private Long id;
    @Column(name = "tenchicuc")
    private String name;
    @Column(name ="addres")
    private String address;
    @Column(name = "phone")
    private Integer phone;
    @OneToMany(mappedBy = "subdivision")
    private List<Inspect> employees = new ArrayList<>();

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

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public List<Inspect> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Inspect> employees) {
        this.employees = employees;
    }
}
