
package com.example.quanlivesinh.persistence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chungnhan")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "machungnhan")
    private Long id;
    @Column (name = "tenchungnhan")
    private String name;
    @Column (name ="mota")
    private String describe;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name ="chitiet_chungnhan",
               joinColumns = @JoinColumn(name ="machungnhan", referencedColumnName = "machungnhan"),
               inverseJoinColumns = @JoinColumn(name ="macuahang", referencedColumnName = "macuahang"))
    private Set<Store> stores = new HashSet<>();
     public  Certification(){}

    public Certification(Long id, String name, String describe, Set<Store> stores) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.stores = stores;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

  /*  @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", stores=" + stores +
                '}';
    }*/
}

