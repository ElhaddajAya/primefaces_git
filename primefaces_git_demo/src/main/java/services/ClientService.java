package services;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Client;

@ManagedBean
public class ClientService {
	
	private SessionFactory sessionFactory;

	// constructor qui initialise la sessionFactory et ouvre la session
	public ClientService() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Client.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public List<Client> getAllClients() {
		// fetching clients code here...
		
		
		return null;
	}
	
	public void addClient(Client client) {
		try(Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
		}
	}

}
