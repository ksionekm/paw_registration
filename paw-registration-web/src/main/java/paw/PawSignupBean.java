package paw;

import org.primefaces.event.FlowEvent;
import paw.registration.jpa.UserEntity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.logging.Logger;

@ManagedBean(eager = true)
@SessionScoped
public class PawSignupBean implements Serializable {

	private static final long serialVersionUID = 5103450608081796600L;
	private Logger logger = Logger.getLogger("PAW-signup");

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
