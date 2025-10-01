package tpe1.dao;


import javax.persistence.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Timestamp fecha;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> jugadores;


    private Turno(Timestamp fecha){
        super();
        this.fecha = fecha;
        this.jugadores = new ArrayList<Persona>();
    }

    public Turno() {
        super();
    }

    public int getId() {
        return id;
    }


    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getJugadores() {
        return new ArrayList<>(jugadores);
    }


    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", jugadores=" + jugadores +
                '}';
    }

    public void setFecha(java.sql.Timestamp timestamp) {
        this.fecha = fecha;
    }
}
