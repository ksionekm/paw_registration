package paw;

import paw.registration.ejb.UserEntityBean;
import paw.registration.jpa.UserEntity;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ksionekm on 2016-06-15.
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class UserLookupDatabaseBean implements UsersLookupService, Serializable {

    public static final long serialVersionUID = 143534324234234234L;

    private Logger logger = Logger.getLogger("PawRegistration");

    @EJB(name = "UserEntityBean")
    private UserEntityBean userEntityBean;

    public UserLookupDatabaseBean() {
        logger.info("UserLookupDatabaseBean created");
    }

    public UserEntityBean getUserEntityBean() {
        return  userEntityBean;
    }

    public void setUserEntityBean(UserEntityBean userEntityBean) {
        this.userEntityBean = userEntityBean;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityBean.getLatestUsers(0);
    }

    @Override
    public UserEntity getUsers(int id) {
        UserEntity u = userEntityBean.getUserEntity(id);
        if (u == null)
            logger.info("Lookup service returning null for id=" + id);
        else
            logger.info("User " + id + "last name: " + u.getLastName());
        return u;
    }

    @Override
    public boolean merge(UserEntity userEntity) {
        return userEntityBean.merge(userEntity);
    }

    @Override
    public boolean persist(UserEntity userEntity) {
        return userEntityBean.persist(userEntity);
    }

    @Override
    public boolean remove(int id) {
        return userEntityBean.remove(id);
    }
}
