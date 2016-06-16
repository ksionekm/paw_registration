package paw;

import paw.registration.jpa.UserEntity;

import java.util.List;

/**
 * Created by ksionekm on 2016-06-15.
 */
public interface UsersLookupService {
    public UserEntity getUsers(int id);
    public List<UserEntity> getAllUsers();
    public boolean merge (UserEntity user);
    public boolean persist (UserEntity user);
    public boolean remove(int id);
}
