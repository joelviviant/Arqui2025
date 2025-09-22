package tpe1.dao;

import javax.persistence.*;

@Entity
public class Socio {

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Persona persona;

    @Column
    private String tipo;

    public Socio() {
        super();
    }
    public Socio(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", persona=" + persona +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
