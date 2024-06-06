package francescocristiano.entities;

import francescocristiano.enums.TipoEvento;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")


@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT e FROM Evento e WHERE e.squadraVincente = e.squadraCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT e FROM Evento e WHERE e.squadraVincente = e.squadraOspite")
public class Evento {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data_evento")
    private Date dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listPartecipazioni;


    public Evento() {
    }


    public Evento(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public long getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getListPartecipazioni() {
        return listPartecipazioni;
    }

    public void setListPartecipazioni(List<Partecipazione> listPartecipazioni) {
        this.listPartecipazioni = listPartecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }
}
