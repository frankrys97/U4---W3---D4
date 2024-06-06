package francescocristiano.entities;

import francescocristiano.enums.TipoEvento;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento {

    @OneToMany
    @JoinColumn(name = "gara_id")
    private Set<Persona> atleti;
    @OneToOne
    private Persona vincitore;

    public GaraDiAtletica() {
    }


    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
