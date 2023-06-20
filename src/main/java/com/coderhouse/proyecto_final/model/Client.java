package com.coderhouse.proyecto_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    @NotNull(message = "Text only field.")
    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Text only field.")
    private String name;

    @NotNull(message = "Text only field.")
    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Text only field.")
    private String surname;

    @NotNull(message = "Numbers only.")
    @Column(nullable = false, unique = true)
    private int dni;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Invoice> invoice;

    // Getter & Setter
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    // toString method
    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni=" + dni +
                ", invoice=" + invoice +
                '}';
    }
}
