import java.util.List;

import entity.Characters;

import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Characters new2 = new Characters("Name", "Likes", "Loves", "Hates", "Dislikes", "new");
        Characters new3 = new Characters("Peaches", "apples,lemons", "food", "collars", "brushes", "new");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.persist(new2);
            session.persist(new3);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Characters> char1 = session.createQuery("from Characters", Characters.class).list();
            for (Characters s : char1) {
                System.out.println(s.toString());
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
