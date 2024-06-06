package francescocristiano.dao;

import francescocristiano.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location salvata correttamente");
    }

    public Location getById(String id) {
        return em.find(Location.class, UUID.fromString(id));
    }

    public void findAndDeleteById(String id) {
        Location locationTrovata = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(locationTrovata);
        transaction.commit();
        System.out.println("Location con id " + id + " eliminata correttamente");
    }


}
