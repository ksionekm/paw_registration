package paw;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import paw.registration.jpa.UserEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.logging.Logger;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

@ManagedBean(eager = true)
@SessionScoped
public class PawSignupBean implements Serializable {

	private static final long serialVersionUID = 5103450608081796600L;
	private Logger logger = Logger.getLogger("PAW-signup");

	private String login;
	private String password;
	private String rootLogin = "root";
	private String rootPassword = "root";


	private int id;

    protected UserEntity userEntity;
    private UserPersonalInfo userPersonal = new UserPersonalInfo();
    private UserContact userContact = new UserContact();
    private UserAddress address = new UserAddress();
    private UserAddress shAddress = new UserAddress();
    private Boolean checkBoxValue;
    private UserMilitaryData militaryData = new UserMilitaryData();
    private UserEducation userEducation = new UserEducation();
    private boolean skip;

    @ManagedProperty(value = "#{userLookupDatabaseBean}")
    private UsersLookupService usersLookupService;

    public PawSignupBean() {
        logger.info("Paw Signup Bean created...");
        userEntity = new UserEntity();
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UsersLookupService getUsersLookupService() {
        return usersLookupService;
    }

    public void setUsersLookupService(UsersLookupService usersLookupService) {
        this.usersLookupService = usersLookupService;
    }

	public UserPersonalInfo getUserPersonal() {
		return userPersonal;
	}

	public void setUserPersonal(UserPersonalInfo userPersonal) {
		this.userPersonal = userPersonal;
	}

	public UserContact getUserContact() {
		return userContact;
	}

	public Boolean getCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(Boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public UserAddress getShAddress() {

		return shAddress;
	}

	public void setShAddress(UserAddress shAddress) {
		this.shAddress = shAddress;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public UserEducation getUserEducation() {
		return userEducation;
	}

	public void setUserEducation(UserEducation userEducation) {
		this.userEducation = userEducation;
	}

	public UserMilitaryData getMilitaryData() {
		return militaryData;
	}

	public void setMilitaryData(UserMilitaryData militaryData) {
		this.militaryData = militaryData;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if(skip) {
			skip = false;
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}

	//Metoda do skopiowania danych adresowych przy użyciu ajaxa
	public void copyAddress() {

		if (getCheckBoxValue() == true) {
			shAddress.setCity(address.getCity());
			shAddress.setStreet(address.getStreet());
			shAddress.setState(address.getState());
			shAddress.setPostalCode(address.getPostalCode());
			shAddress.setHomeNumber(address.getHomeNumber());
			if (address.getFlatNumber() == null || address.getFlatNumber() == "0") {
				shAddress.setFlatNumber(null);
			} else {
				shAddress.setFlatNumber(address.getFlatNumber());
			}

		} else {
			shAddress.setCity(null);
			shAddress.setStreet(null);
			shAddress.setState(null);
			shAddress.setPostalCode(null);
			shAddress.setHomeNumber(null);
			shAddress.setFlatNumber(null);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		if (id == 0) {
			this.userEntity = null;
			this.userPersonal.setFirstName("");
			this.userPersonal.setLastName("");
			this.userPersonal.setBirthDate(null);
			this.userPersonal.setBirthPlace("");
			this.userPersonal.setFatherName("");
			this.userPersonal.setMotherName("");
			this.userPersonal.setMotherLastName("");
			this.userPersonal.setPesel(null);
			this.userPersonal.setCitizenship("");

			this.userContact.setEmail("");
			this.userContact.setPhone(null);

			this.address.setCity("");
			this.address.setFlatNumber("");
			this.address.setHomeNumber("");
			this.address.setPostalCode("");
			this.address.setState("");
			this.address.setStreet("");

			this.shAddress.setCity("");
			this.shAddress.setFlatNumber("");
			this.shAddress.setHomeNumber("");
			this.shAddress.setPostalCode("");
			this.shAddress.setState("");
			this.shAddress.setStreet("");

			this.userEducation.setAdditionalEd("");
			this.userEducation.setAdditionalSkills("");
			this.userEducation.setEducation("");
			this.userEducation.setJobs("");

			this.militaryData.setAllocation("");
			this.militaryData.setMilitaryCardNumber("");
			this.militaryData.setMilitaryRank("");
			this.militaryData.setMilitaryRatio("");
			this.militaryData.setSpecializationNumber("");
			this.militaryData.setWkuNumber("");
		}
		if (this.usersLookupService != null && id != 0) {

			this.userEntity = this.usersLookupService.getUsers(id);
			this.userPersonal.setFirstName(this.userEntity.getFirstName());
			this.userPersonal.setLastName(this.userEntity.getLastName());
			this.userPersonal.setBirthDate(this.userEntity.getBirthDate());
			this.userPersonal.setBirthPlace(this.userEntity.getBirthPlace());
			this.userPersonal.setFatherName(this.userEntity.getFatherName());
			this.userPersonal.setMotherName(this.userEntity.getMotherName());
			this.userPersonal.setMotherLastName(this.userEntity.getMotherLastName());
			this.userPersonal.setPesel((long)this.userEntity.getPesel());
			this.userPersonal.setCitizenship(this.userEntity.getCitizenship());

			this.userContact.setEmail(this.userEntity.getEmail());
			this.userContact.setPhone(this.userEntity.getPhone());

			this.address.setCity(this.userEntity.getAddressCity());
			this.address.setFlatNumber(this.userEntity.getAddressFlatNumber());
			this.address.setHomeNumber(this.userEntity.getAddressHomeNumber());
			this.address.setPostalCode(this.userEntity.getAddressPostalCode());
			this.address.setState(this.userEntity.getAddressState());
			this.address.setStreet(this.userEntity.getAddressStreet());

			this.shAddress.setCity(this.userEntity.getShippingAddressCity());
			this.shAddress.setFlatNumber(this.userEntity.getShippingAddressFlatNumber());
			this.shAddress.setHomeNumber(this.userEntity.getShippingAddressHomeNumber());
			this.shAddress.setPostalCode(this.userEntity.getShippingAddressPostalCode());
			this.shAddress.setState(this.userEntity.getShippingAddressState());
			this.shAddress.setStreet(this.userEntity.getShippingAddressStreet());

			this.userEducation.setAdditionalEd(this.userEntity.getAdditionalEducation());
			this.userEducation.setAdditionalSkills(this.userEntity.getAdditionalSkills());
			this.userEducation.setEducation(this.userEntity.getEducation());
			this.userEducation.setJobs(this.userEntity.getJobs());

			this.militaryData.setAllocation(this.userEntity.getAllocation());
			this.militaryData.setMilitaryCardNumber(this.userEntity.getMilitaryCard());
			this.militaryData.setMilitaryRank(this.userEntity.getMilitaryRank());
			this.militaryData.setMilitaryRatio(this.userEntity.getMilitaryRatio());
			this.militaryData.setSpecializationNumber(this.userEntity.getSpecializationNumber());
			this.militaryData.setWkuNumber(this.userEntity.getWkuNumber());
		}
	}

	public String signup() {
		logger.info("signup invoked, bean fields: " + this);
        FacesContext context = FacesContext.getCurrentInstance();
        this.userEntity = new UserEntity();
        this.userEntity.setFirstName(userPersonal.getFirstName());
        this.userEntity.setLastName(userPersonal.getLastName());
        this.userEntity.setPesel(userPersonal.getPesel());
        this.userEntity.setMotherName(userPersonal.getMotherName());
        this.userEntity.setFatherName(userPersonal.getFatherName());
        this.userEntity.setMotherLastName(userPersonal.getMotherLastName());
        this.userEntity.setBirthDate(new java.sql.Date(userPersonal.getBirthDate().getTime()));
        this.userEntity.setBirthPlace(userPersonal.getBirthPlace());
        this.userEntity.setCitizenship(userPersonal.getCitizenship());

        this.userEntity.setEmail(userContact.getEmail());
        this.userEntity.setPhone(userContact.getPhone());

        this.userEntity.setAddressStreet(address.getStreet());
        this.userEntity.setAddressHomeNumber(address.getHomeNumber());
        this.userEntity.setAddressFlatNumber(address.getFlatNumber());
        this.userEntity.setAddressCity(address.getCity());
        this.userEntity.setAddressPostalCode(address.getPostalCode());
        this.userEntity.setAddressState(address.getState());

        this.userEntity.setShippingAddressStreet(shAddress.getStreet());
        this.userEntity.setShippingAddressHomeNumber(shAddress.getHomeNumber());
        this.userEntity.setShippingAddressFlatNumber(shAddress.getFlatNumber());
        this.userEntity.setShippingAddressCity(shAddress.getCity());
        this.userEntity.setShippingAddressPostalCode(shAddress.getPostalCode());
        this.userEntity.setShippingAddressState(shAddress.getState());

        this.userEntity.setEducation(userEducation.getEducation());
        this.userEntity.setAdditionalEducation(userEducation.getAdditionalEd());
        this.userEntity.setJobs(userEducation.getJobs());
        this.userEntity.setAdditionalSkills(userEducation.getAdditionalSkills());

        this.userEntity.setMilitaryRatio(militaryData.getMilitaryRatio());
        this.userEntity.setMilitaryRank(militaryData.getMilitaryRank());
        this.userEntity.setSpecializationNumber(militaryData.getSpecializationNumber());
        this.userEntity.setWkuNumber(militaryData.getWkuNumber());
        this.userEntity.setMilitaryCard(militaryData.getMilitaryCardNumber());
        this.userEntity.setAllocation(militaryData.getAllocation());

        if (this.usersLookupService.persist(this.userEntity)) {
            context.addMessage(null, new FacesMessage("Dodano nowego użytkownika."));
        } else {
            context.addMessage(null, new FacesMessage("Błąd podczas dodania użytkownika."));
            return null;
        }

        return "signup-confirmation";
	}

	public String update() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.userEntity.setFirstName(userPersonal.getFirstName());
		this.userEntity.setLastName(userPersonal.getLastName());
		this.userEntity.setPesel(userPersonal.getPesel());
		this.userEntity.setMotherName(userPersonal.getMotherName());
		this.userEntity.setFatherName(userPersonal.getFatherName());
		this.userEntity.setMotherLastName(userPersonal.getMotherLastName());
		this.userEntity.setBirthDate(new java.sql.Date(userPersonal.getBirthDate().getTime()));
		this.userEntity.setBirthPlace(userPersonal.getBirthPlace());
		this.userEntity.setCitizenship(userPersonal.getCitizenship());

		this.userEntity.setEmail(userContact.getEmail());
		this.userEntity.setPhone(userContact.getPhone());

		this.userEntity.setAddressStreet(address.getStreet());
		this.userEntity.setAddressHomeNumber(address.getHomeNumber());
		this.userEntity.setAddressFlatNumber(address.getFlatNumber());
		this.userEntity.setAddressCity(address.getCity());
		this.userEntity.setAddressPostalCode(address.getPostalCode());
		this.userEntity.setAddressState(address.getState());

		this.userEntity.setShippingAddressStreet(shAddress.getStreet());
		this.userEntity.setShippingAddressHomeNumber(shAddress.getHomeNumber());
		this.userEntity.setShippingAddressFlatNumber(shAddress.getFlatNumber());
		this.userEntity.setShippingAddressCity(shAddress.getCity());
		this.userEntity.setShippingAddressPostalCode(shAddress.getPostalCode());
		this.userEntity.setShippingAddressState(shAddress.getState());

		this.userEntity.setEducation(userEducation.getEducation());
		this.userEntity.setAdditionalEducation(userEducation.getAdditionalEd());
		this.userEntity.setJobs(userEducation.getJobs());
		this.userEntity.setAdditionalSkills(userEducation.getAdditionalSkills());

		this.userEntity.setMilitaryRatio(militaryData.getMilitaryRatio());
		this.userEntity.setMilitaryRank(militaryData.getMilitaryRank());
		this.userEntity.setSpecializationNumber(militaryData.getSpecializationNumber());
		this.userEntity.setWkuNumber(militaryData.getWkuNumber());
		this.userEntity.setMilitaryCard(militaryData.getMilitaryCardNumber());
		this.userEntity.setAllocation(militaryData.getAllocation());
		if (this.usersLookupService.merge(this.userEntity)) {
			context.addMessage(null, new FacesMessage("Edycja danych użytkownika przebiegła poprawnie."));
		}
		else {
			context.addMessage(null, new FacesMessage("Błąd podczas edycji."));
		}
		return null;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg= new FacesMessage("Edycja zakończona", ((UserEntity) event.getObject()).getFirstName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.update();
	}

	public void onRowEditCancel(RowEditEvent event) {
		FacesMessage msg= new FacesMessage("Edycja anulowana", ((UserEntity) event.getObject()).getFirstName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void preProcessPDF(Object document) {
		Document pdf = (Document) document;
		pdf.setPageSize(PageSize.A2.rotate());
		pdf.open();
	}

	public String loginAction () {
		if(rootLogin.equals(login) && rootPassword.equals(password)) return "users-list";
		else return "home";
	}

	//Logger
	@Override
	public String toString() {
		return "PawSignupBean{" +
				"firstName='" + userPersonal.getFirstName() + '\'' +
				", lastName='" + userPersonal.getLastName() + '\'' +
				", email='" + userContact.getEmail() + '\'' +
				", ulica='" + address.getStreet() + '\'' +
				", nr domu='" + address.getHomeNumber() + '\'' +
				", nr mieszkania='" + address.getFlatNumber() + '\'' +
				", miasto='" + address.getCity() + '\'' +
				", kod pocztowy='" + address.getPostalCode() + '\'' +
				", województwo='" + address.getState() + '\'' +
				'}';
	}

}
