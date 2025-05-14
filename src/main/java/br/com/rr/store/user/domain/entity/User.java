package br.com.rr.store.user.domain.entity;


import br.com.rr.store.order.domain.entity.Order;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String email;

    private LocalDate birthday;

    private String phone;

    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, LocalDate birthday, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
