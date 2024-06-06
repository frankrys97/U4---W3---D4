package francescocristiano.dao;

import francescocristiano.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona salvata correttamente");
    }


    public Persona getById(String id) {
        return em.find(Persona.class, UUID.fromString(id));
    }

    public void findAndDeleteById(String id) {
        Persona personaTrovata = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(personaTrovata);
        transaction.commit();
        System.out.println("Persona con id " + id + " eliminata correttamente");
    }

    public Set<Persona> findAll() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultStream().collect(toSet());
    }
}
