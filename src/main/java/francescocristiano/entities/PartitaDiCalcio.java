package francescocristiano.entities;

import francescocristiano.enums.TipoEvento;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolCasa;
    private int numeroGolOspite;

    public PartitaDiCalcio() {
    }


    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspite, int numeroGolCasa, int numeroGolOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolCasa = numeroGolCasa;
        this.numeroGolOspite = numeroGolOspite;
        this.squadraVincente = determinaSquadraVincente();
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolCasa() {
        return numeroGolCasa;
    }

    public void setNumeroGolCasa(int numeroGolCasa) {
        this.numeroGolCasa = numeroGolCasa;
    }

    public int getNumeroGolOspite() {
        return numeroGolOspite;
    }

    public void setNumeroGolOspite(int numeroGolOspite) {
        this.numeroGolOspite = numeroGolOspite;
    }

    private String determinaSquadraVincente() {
        if (this.getNumeroGolCasa() > this.getNumeroGolOspite()) {
            return this.getSquadraCasa();
        } else if (this.getNumeroGolCasa() < this.getNumeroGolOspite()) {
            return this.getSquadraOspite();
        } else {
            return null;
        }
    }
}
