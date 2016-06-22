package paw;

import paw.registration.jpa.UserEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ksionekm on 2016-06-17.
 */

@ManagedBean
@RequestScoped
public class UsersManager implements Serializable {
    private static final long serialVersionUID = 3754037223174977077L;
    private static final int resultPerPage = 10;

    private List<UserEntity> allUsersList;
    private List<UserEntity> usersList;

    private int removeId;

    private Logger logger = Logger.getLogger("UsersManager Logger");

    @ManagedProperty(value = "#{userLookupDatabaseBean}")
    private UserLookupDatabaseBean userLookupService;

    //atrybuty potrzebne do wyświetlania listy newsów
    private int page = 1, nextPage = 1, lastPage = 1, firstPage = 1, previousPage = 1;
    private int allPages = 0;
    private long recordsCount = 0;
    private String tableListCaption = "Brak rekordów do wyświetlenia";

    public UsersManager() {
        logger.info("UsersManager created.");
    }

    public List<UserEntity> getAllUsersList() {
        return allUsersList;
    }

    public void setAllUsersList(List<UserEntity> allUsersList) {
        this.allUsersList = allUsersList;
    }

    public List<UserEntity> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserEntity> usersList) {
        this.usersList = usersList;
    }

    public int getRemoveId() {
        return removeId;
    }

    public void setRemoveId(int removeId) {
        this.removeId = removeId;
        if (removeId != 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            if (this.userLookupService != null) {
                if (userLookupService.remove(removeId))
                    context.addMessage(null, new FacesMessage("Ususnięto użytkownika o id = " + removeId));
                else
                    context.addMessage(null, new FacesMessage("Błąd usuwania użytkownika o id = " + removeId));
                allUsersList = this.userLookupService.getAllUsers();
                calculatePages();
            } else {
                context.addMessage(null, new FacesMessage("Błąd usuwania użytkownika o id = " + removeId));
            }
        }
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public UserLookupDatabaseBean getUserLookupService() {
        return userLookupService;
    }

    public void setUserLookupService(UserLookupDatabaseBean userLookupService) {
        logger.info("SetUserBean() invoked. Trybing to receive message list.");
        this.userLookupService = userLookupService;
        if (this.userLookupService != null) {
            allUsersList = this.userLookupService.getAllUsers();//pobieramy wszystkich użytkownikó
            calculatePages();
        }
        else
            logger.info("Lookup service is NULL. Injection failed.");
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public long getRecordsCount() {
        return recordsCount;
    }

    public void setRecordsCount(long recordsCount) {
        this.recordsCount = recordsCount;
    }

    public String getTableListCaption() {
        return tableListCaption;
    }

    public void setTableListCaption(String tableListCaption) {
        this.tableListCaption = tableListCaption;
    }

    private void calculatePages() {
        if (allUsersList != null) {
            recordsCount = allUsersList.size();
            allPages = (int) Math.ceil((double) ( (double)recordsCount / UsersManager.resultPerPage));
        }
        firstPage = 1;
        if (recordsCount == 0 || recordsCount <= UsersManager.resultPerPage) {
            page = 1;
            nextPage = 1;
            lastPage = 1;
            previousPage = 1;
        }
        else {
            lastPage = allPages;
            if (page < lastPage)
                nextPage = page + 1;
            else
                nextPage = page;
            if (page > 1)
                previousPage = page - 1;
            else
                previousPage = page;
        }
        generateTableCaption();
        //wsadzamy do userList te co trzeba
        int start = UsersManager.resultPerPage * (page-1);
        int end = start + UsersManager.resultPerPage;
        if (end > recordsCount)
            end = (int) recordsCount;
        usersList = allUsersList.subList(start, end);
    }

    private void generateTableCaption() {
        String caption = "";
        String str = recordsCount + "";
        String lastDigitStr = str.substring(str.length()-1);
        int lastDigit = new Integer(lastDigitStr).intValue();

        if (recordsCount == 0) {
            caption = "Brak rekordów do wyświetlenia";
        }
        if (recordsCount == 1) {
            caption = "1 wynik (strona 1 z 1)";
        }
        else if (recordsCount > 1 && (lastDigit == 2 || lastDigit == 3 || lastDigit == 3 || lastDigit == 4) ) {
            caption = recordsCount + " wyniki (strona " + page + " z " + allPages + ")";
        }
        else {
            caption = recordsCount + " wyników (strona " + page + " z " + allPages + ")";
        }
        this.tableListCaption = caption;
    }
}
