package francescocristiano;

import francescocristiano.dao.EventoDAO;
import francescocristiano.dao.LocationDAO;
import francescocristiano.dao.PartecipazioneDAO;
import francescocristiano.dao.PersonaDAO;
import francescocristiano.entities.*;
import francescocristiano.enums.Sesso;
import francescocristiano.enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        LocationDAO ld = new LocationDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO pard = new PartecipazioneDAO(em);
        EventoDAO ed = new EventoDAO(em);

        Location location1 = new Location("Mole", "Torino");
        Location location2 = new Location("San Siro", "Milano");
        Location location3 = new Location("Stadio Olimpico", "Roma");


/*        ld.save(location1);
        ld.save(location2);
        ld.save(location3);*/

        Persona persona1 = new Persona("Francesco", "Cristiano", "francescocristiano@example.com", LocalDate.of(1997, 5, 27), Sesso.M);
        Persona persona2 = new Persona("Antonio", "Rossi", "antoniorossi@example.com", LocalDate.of(2000, 7, 20), Sesso.M);
        Persona persona3 = new Persona("Maria", "Verdi", "mariaverdi@example.com", LocalDate.of(2001, 9, 15), Sesso.F);


 /*       pd.save(persona1);
        pd.save(persona2);
        pd.save(persona3);*/

        Persona persona1FromDb = pd.getById("d19e4892-39de-4d26-9fe1-23ba9ceea4d9"); // Antonio Rossi
        Persona persona2FromDb = pd.getById("6a0c4f14-49ee-4675-bd2a-62a79f54a22f"); // Francesco Cristiano
        Persona persona3FromDb = pd.getById("e46e0971-9202-41c6-811c-72b3c817827a"); // Maria Verdi


/*        System.out.println(persona1FromDb);
        System.out.println(persona2FromDb);
        System.out.println(persona3FromDb);*/

/*
        persona1FromDb.getListaPartecipazioni().forEach(System.out::println);
*/

        Location location1FromDb = ld.getById("b93558ef-7691-4207-8ab3-c66601f027d1"); // Torino
        Location location2FromDb = ld.getById("a58b0293-d922-4e3c-973c-fc1d6761bf97"); // Milano
        Location location3FromDb = ld.getById("f57778eb-7c54-452c-8c18-07437aca8397"); // Roma

  /*      System.out.println();
        System.out.println("LOCATIONS from DB: ");
        System.out.println(location1FromDb);
        System.out.println(location2FromDb);
        System.out.println(location3FromDb);*/

        Evento evento1 = new Evento("Evento1", new Date(), "Descrizione1", francescocristiano.enums.TipoEvento.PUBBLICO, 10, location1FromDb);
        Evento evento2 = new Evento("Evento2", new Date(), "Descrizione2", francescocristiano.enums.TipoEvento.PUBBLICO, 20, location2FromDb);
        Evento evento3 = new Evento("Evento3", new Date(), "Descrizione3", francescocristiano.enums.TipoEvento.PRIVATO, 30, location3FromDb);


  /*      ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3);*/

        Evento evento1FromDb = ed.getById(402);
        Evento evento2FromDb = ed.getById(403);
        Evento evento3FromDb = ed.getById(404);

    /*    System.out.println();
        System.out.println("EVENTI from DB: ");
        System.out.println(evento1FromDb);
        System.out.println(evento2FromDb);
        System.out.println(evento3FromDb);*/

        Partecipazione partecipazione1 = new Partecipazione(persona1FromDb, evento1FromDb, Stato.CONFERMATO);
        Partecipazione partecipazione2 = new Partecipazione(persona2FromDb, evento2FromDb, Stato.DA_CONFERMARE);
        Partecipazione partecipazione3 = new Partecipazione(persona3FromDb, evento3FromDb, Stato.CONFERMATO);


    /*    pard.save(partecipazione1);
        pard.save(partecipazione2);
        pard.save(partecipazione3);*/

        Concerto concerto1 = new Concerto("Concerto1", new Date(), "Descrizione1", francescocristiano.enums.TipoEvento.PUBBLICO, 10, location1FromDb, francescocristiano.enums.Genere.ROCK, true);
        Concerto concerto2 = new Concerto("Concerto2", new Date(), "Descrizione2", francescocristiano.enums.TipoEvento.PUBBLICO, 20, location2FromDb, francescocristiano.enums.Genere.POP, false);
        Concerto concerto3 = new Concerto("Concerto3", new Date(), "Descrizione3", francescocristiano.enums.TipoEvento.PRIVATO, 30, location3FromDb, francescocristiano.enums.Genere.CLASSICO, true);

  /*      ed.save(concerto1);
        ed.save(concerto2);
        ed.save(concerto3);*/

  /*      System.out.println("Concerti in streaming: ");
        ed.findConcertiInStreaming(true).forEach(System.out::println);
        System.out.println();

        System.out.println("Concerti di genere ROCK: ");
        ed.findConcertiByGenere(francescocristiano.enums.Genere.ROCK).forEach(System.out::println);
        System.out.println();

        System.out.println("Concerti di genere CLASSICO: ");
        ed.findConcertiByGenere(francescocristiano.enums.Genere.CLASSICO).forEach(System.out::println);
        System.out.println();

        System.out.println("Concerti di genere POP: ");
        ed.findConcertiByGenere(francescocristiano.enums.Genere.POP).forEach(System.out::println);
        System.out.println();
*/
        PartitaDiCalcio partitaDiCalcio1 = new PartitaDiCalcio("PartitaDiCalcio1", new Date(), "Team A vs Team B", francescocristiano.enums.TipoEvento.PUBBLICO, 10, location1FromDb, "Squadra A", "Squadra B", 2, 1);
        PartitaDiCalcio partitaDiCalcio2 = new PartitaDiCalcio("PartitaDiCalcio2", new Date(), "Team C vs Team D", francescocristiano.enums.TipoEvento.PUBBLICO, 20, location2FromDb, "Squadra C", "Squadra D", 1, 2);
        PartitaDiCalcio partitaDiCalcio3 = new PartitaDiCalcio("PartitaDiCalcio3", new Date(), "Team E vs Team F", francescocristiano.enums.TipoEvento.PRIVATO, 30, location3FromDb, "Squadra E", "Squadra F", 0, 0);


    /*    ed.save(partitaDiCalcio1);
        ed.save(partitaDiCalcio2);
        ed.save(partitaDiCalcio3);

        System.out.println("Partite vinte in casa: ");
        ed.getPartiteVinteInCasa().forEach(System.out::println);
        System.out.println();

        System.out.println("Partite vinte in trasferta: ");
        ed.getPartiteVinteInTrasferta().forEach(System.out::println
        );
        System.out.println();

        System.out.println("Partite pareggiate: ");
        ed.getPartitePareggiate().forEach(System.out::println);
        System.out.println();*/


        GaraDiAtletica gara1 = new GaraDiAtletica("Gara1", new Date(), "Olimpiadi", francescocristiano.enums.TipoEvento.PUBBLICO, 1000, location3FromDb, pd.findAll(), persona1FromDb);
        GaraDiAtletica gara2 = new GaraDiAtletica("Gara2", new Date(), "Nazionali", francescocristiano.enums.TipoEvento.PUBBLICO, 200, location3FromDb, pd.findAll(), persona2FromDb);
        GaraDiAtletica gara3 = new GaraDiAtletica("Gara3", new Date(), "Regionali", francescocristiano.enums.TipoEvento.PRIVATO, 300, location3FromDb, pd.findAll(), persona3FromDb);


   /*     ed.save(gara1);
        ed.save(gara2);
        ed.save(gara3);*/

        System.out.println("Gara vinta da " + persona1FromDb.getNome() + " " + persona1FromDb.getCognome() + ": ");
        System.out.println(ed.getGareVinteByVincitore(persona1FromDb));
        System.out.println();

        System.out.println("Gara vinta da " + persona2FromDb.getNome() + " " + persona2FromDb.getCognome() + ": ");
        System.out.println(ed.getGareVinteByVincitore(persona2FromDb));
        System.out.println();

        System.out.println("Gara vinta da " + persona3FromDb.getNome() + " " + persona3FromDb.getCognome() + ": ");
        System.out.println(ed.getGareVinteByVincitore(persona3FromDb));
        System.out.println();


        System.out.println(persona1FromDb.getNome() + " " + persona1FromDb.getCognome() + " ha partecipato alla gara: ");
        ed.getGareDiAtleticaByPartecipante(persona1FromDb).forEach(System.out::println);
        System.out.println();


    }
}
