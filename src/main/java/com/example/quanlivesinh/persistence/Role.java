package com.example.quanlivesinh.persistence;

import com.example.quanlivesinh.enums.ERole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME")
    private ERole name;
  @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
  Set<User> users = new HashSet<>();


    public Role() {

    }

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }



    /*@Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +

                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role developer = (Role) o;

        if (!id.equals(developer.id)) return false;
        return name.equals(developer.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}