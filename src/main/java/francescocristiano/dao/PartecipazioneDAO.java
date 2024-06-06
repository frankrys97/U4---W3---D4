package francescocristiano.dao;

import francescocristiano.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione salvata correttamente");
    }

    public Partecipazione getById(String id) {
        return em.find(Partecipazione.class, UUID.fromString(id));
    }

    public void findAndDeleteById(String id) {
        Partecipazione partecipazioneTrovata = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(partecipazioneTrovata);
        transaction.commit();
        System.out.println("Partecipazione con id " + id + " eliminata correttamente");
    }
}
