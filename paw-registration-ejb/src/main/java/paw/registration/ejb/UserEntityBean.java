package paw.registration.ejb;

import paw.registration.jpa.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by ksionekm on 2016-06-15.
 */

@Stateless(mappedName = "UserEntityBean")
public class UserEntityBean {

    public static final int DEFAULT_COUNT = 20;

    private Logger logger = Logger.getLogger("PawRegistration");

    @PersistenceUnit(unitName = "paw-registration")
    EntityManagerFactory emf;

    public UserEntityBean() {
        logger.info("UserEntity bean created...");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean persist(Object o) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            logger.info("Saving object..." + o);
            entityManager.persist(o);
            logger.info("Object saved:" + o);
            return true;
        } catch (Exception e) {
            logger.severe("UserEntityBean::persist: Error writing to db:" + e);
            logger.severe("" + e.fillInStackTrace());
            return false;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean remove(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            Query q = entityManager.createQuery("DELETE FROM UserEntity u WHERE u.userId = " + id);
            q.executeUpdate();
            logger.info("Object removed");
            return true;
        } catch (Exception e) {
            logger.severe("UserEntityBean::remove: " + e);
            logger.severe("" + e.fillInStackTrace());
            return false;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean merge(Object o) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            logger.info("Updating object " + o);
            entityManager.merge(o);
            logger.info("Object updated: " + o);
            return true;
        } catch (Exception e) {
            logger.severe("UserEntityBean::merge: error writing to db: " + e);
            logger.severe("" + e.fillInStackTrace());
            return false;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<UserEntity> getLatestUsers (int count) {
        if (count<0)
            count = DEFAULT_COUNT;
        EntityManager entityManager = emf.createEntityManager();
        try {
            Query query = entityManager.createQuery("FROM UserEntity u ORDER BY u.userId DESC ", UserEntity.class);
            if (count>0)
                query.setMaxResults(count);
            return query.getResultList();
        } catch (Exception e) {
            logger.warning("UserEntityBean::getLatestUsers, error while executing query: " + e);
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserEntity getUserEntity(int id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(UserEntity.class, id);
    }
}
