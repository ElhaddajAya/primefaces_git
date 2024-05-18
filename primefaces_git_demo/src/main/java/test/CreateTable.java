package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Client;

public class CreateTable {

	public static void main(String[] args) {
		// Créer la session Hibernate en utilisant la configuration définie dans hibernate.cfg.xml
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Client.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Ouvrir une session Hibernate
        Session session = sessionFactory.openSession();

        // Commencer une transaction
        Transaction transaction = session.beginTransaction();

        // Créer la table en exécutant le mapping des entités
        // Cette opération n'est nécessaire que si vous utilisez `hibernate.hbm2ddl.auto` avec `create` ou `update`
        session.createQuery("from Client").list(); // Cette opération déclenche la création de la table si elle n'existe pas

        // Valider la transaction
        transaction.commit();

        // Fermer la session Hibernate
        session.close();

        // Fermer la session factory Hibernate
        sessionFactory.close();
	}

}
