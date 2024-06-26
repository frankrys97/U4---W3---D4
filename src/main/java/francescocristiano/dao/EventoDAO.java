package francescocristiano.dao;

import francescocristiano.entities.Evento;
import francescocristiano.entities.Persona;
import francescocristiano.enums.Genere;
import francescocristiano.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento salvato correttamente");
    }

    public Evento getById(long id) {
        Evento eventoTrovato = em.find(Evento.class, id);
        if (eventoTrovato == null) throw new NotFoundException(id);

        return eventoTrovato;
    }

    public void findAndDeleteById(long id) {
        Evento eventoTrovato = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(eventoTrovato);
        transaction.commit();
        System.out.println("Evento con id " + id + " eliminato correttamente");
    }

    public List<Evento> findConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.inStreaming = :inStreaming", Evento.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Evento> findConcertiByGenere(Genere genere) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.genere = :genere", Evento.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<Evento> getPartiteVinteInCasa() {
        TypedQuery<Evento> query = em.createNamedQuery("getPartiteVinteInCasa", Evento.class);
        return query.getResultList();
    }

    public List<Evento> getPartiteVinteInTrasferta() {
        TypedQuery<Evento> query = em.createNamedQuery("getPartiteVinteInTrasferta", Evento.class);
        return query.getResultList();
    }

    public List<Evento> getPartitePareggiate() {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.numeroGolCasa = e.numeroGolOspite", Evento.class);
        return query.getResultList();
    }

   /* public List<GaraDiAtletica> getGareDiAtleticaByVincitore(Persona vincitore) {
        TypedQuery<GaraDiAtletica> query = em.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaByPartecipante(Persona partecipante) {
        TypedQuery<GaraDiAtletica> query = em.createQuery("SELECT g FROM GaraDiAtletica g WHERE :partecipante MEMBER OF g.atleti ", GaraDiAtletica.class);
        query.setParameter("partecipante", partecipante);
        return query.getResultList();
    }*/

    public List<Evento> getGareVinteByVincitore(Persona vincitore) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.vincitore = :vincitore", Evento.class);
        query.setParameter("vincitore", vincitore);
        return query.getResultList();
    }

    public List<Evento> getGareDiAtleticaByPartecipante(Persona partecipante) {
        TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE :partecipante MEMBER OF e.atleti", Evento.class);
        query.setParameter("partecipante", partecipante);
        return query.getResultList();
    }

    // Creare una funzione che paragona la lista partecipanti di un evento con il numero massimo di partecipanti dell'evento,
    // e restituisce una lista di eventi che hanno raggiunto il numero massimo di partecipanti, bisogna farlo con un COUNT

    public List<Evento> getEventiConMassimoPartecipantiRaggiunto() {
        TypedQuery<Evento> query = em.createQuery(
                "SELECT e FROM Evento e WHERE SIZE(e.partecipanti) = e.numeroMassimoPartecipanti",
                Evento.class);
        return query.getResultList();
    }


}
