package services;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Client;

@Singleton
@Startup
public class ClientService {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Client.class);
        sessionFactory = cfg.buildSessionFactory();
    }

    public List<Client> getAllClients() {
        try (Session session = sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("from Client", Client.class);
            return query.list();
        }
    }

    public void addClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }
    
    public void deleteClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }
}
