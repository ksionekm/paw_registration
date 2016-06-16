package paw.registration.jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by ksionekm on 2016-06-15.
 */
@Entity
@javax.persistence.Table(name = "user", schema = "paw_signup", catalog = "")
public class UserEntity {
    private int userId;

    @Id
    @javax.persistence.Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String firstName;

    @Basic
    @javax.persistence.Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @Basic
    @javax.persistence.Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private double pesel;

    @Basic
    @javax.persistence.Column(name = "pesel", nullable = false, precision = 0)
    public double getPesel() {
        return pesel;
    }

    public void setPesel(double pesel) {
        this.pesel = pesel;
    }

    private String motherName;

    @Basic
    @javax.persistence.Column(name = "mother_name", nullable = false, length = 45)
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    private String fatherName;

    @Basic
    @javax.persistence.Column(name = "father_name", nullable = false, length = 45)
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    private String motherLastName;

    @Basic
    @javax.persistence.Column(name = "mother_last_name", nullable = false, length = 45)
    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    private Date birthDate;

    @Basic
    @javax.persistence.Column(name = "birth_date", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private String birthPlace;

    @Basic
    @javax.persistence.Column(name = "birth_place", nullable = false, length = 45)
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    private String citizenship;

    @Basic
    @javax.persistence.Column(name = "citizenship", nullable = false, length = 45)
    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    private String email;

    @Basic
    @javax.persistence.Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;

    @Basic
    @javax.persistence.Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String addressStreet;

    @Basic
    @javax.persistence.Column(name = "address_street", nullable = false, length = 45)
    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    private String addressHomeNumber;

    @Basic
    @javax.persistence.Column(name = "address_home_number", nullable = false, length = 45)
    public String getAddressHomeNumber() {
        return addressHomeNumber;
    }

    public void setAddressHomeNumber(String addressHomeNumber) {
        this.addressHomeNumber = addressHomeNumber;
    }

    private String addressFlatNumber;

    @Basic
    @javax.persistence.Column(name = "address_flat_number", nullable = true, length = 45)
    public String getAddressFlatNumber() {
        return addressFlatNumber;
    }

    public void setAddressFlatNumber(String addressFlatNumber) {
        this.addressFlatNumber = addressFlatNumber;
    }

    private String addressCity;

    @Basic
    @javax.persistence.Column(name = "address_city", nullable = true, length = 45)
    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    private String addressPostalCode;

    @Basic
    @javax.persistence.Column(name = "address_postal_code", nullable = true, length = 45)
    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    private String addressState;

    @Basic
    @javax.persistence.Column(name = "address_state", nullable = true, length = 45)
    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    private String shippingAddressStreet;

    @Basic
    @javax.persistence.Column(name = "shipping_address_street", nullable = true, length = 45)
    public String getShippingAddressStreet() {
        return shippingAddressStreet;
    }

    public void setShippingAddressStreet(String shippingAddressStreet) {
        this.shippingAddressStreet = shippingAddressStreet;
    }

    private String shippingAddressHomeNumber;

    @Basic
    @javax.persistence.Column(name = "shipping_address_home_number", nullable = true, length = 45)
    public String getShippingAddressHomeNumber() {
        return shippingAddressHomeNumber;
    }

    public void setShippingAddressHomeNumber(String shippingAddressHomeNumber) {
        this.shippingAddressHomeNumber = shippingAddressHomeNumber;
    }

    private String shippingAddressFlatNumber;

    @Basic
    @javax.persistence.Column(name = "shipping_address_flat_number", nullable = true, length = 45)
    public String getShippingAddressFlatNumber() {
        return shippingAddressFlatNumber;
    }

    public void setShippingAddressFlatNumber(String shippingAddressFlatNumber) {
        this.shippingAddressFlatNumber = shippingAddressFlatNumber;
    }

    private String shippingAddressCity;

    @Basic
    @javax.persistence.Column(name = "shipping_address_city", nullable = true, length = 45)
    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    private String shippingAddressPostalCode;

    @Basic
    @javax.persistence.Column(name = "shipping_address_postal_code", nullable = true, length = 45)
    public String getShippingAddressPostalCode() {
        return shippingAddressPostalCode;
    }

    public void setShippingAddressPostalCode(String shippingAddressPostalCode) {
        this.shippingAddressPostalCode = shippingAddressPostalCode;
    }

    private String shippingAddressState;

    @Basic
    @javax.persistence.Column(name = "shipping_address_state", nullable = true, length = 45)
    public String getShippingAddressState() {
        return shippingAddressState;
    }

    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    private String education;

    @Basic
    @javax.persistence.Column(name = "education", nullable = true, length = 800)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    private String additionalEducation;

    @Basic
    @javax.persistence.Column(name = "additional_education", nullable = true, length = 800)
    public String getAdditionalEducation() {
        return additionalEducation;
    }

    public void setAdditionalEducation(String additionalEducation) {
        this.additionalEducation = additionalEducation;
    }

    private String jobs;

    @Basic
    @javax.persistence.Column(name = "jobs", nullable = true, length = 800)
    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    private String additionalSkills;

    @Basic
    @javax.persistence.Column(name = "additional_skills", nullable = true, length = 800)
    public String getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String additionalSkills) {
        this.additionalSkills = additionalSkills;
    }

    private String militaryRatio;

    @Basic
    @javax.persistence.Column(name = "military_ratio", nullable = true, length = 45)
    public String getMilitaryRatio() {
        return militaryRatio;
    }

    public void setMilitaryRatio(String militaryRatio) {
        this.militaryRatio = militaryRatio;
    }

    private String militaryRank;

    @Basic
    @javax.persistence.Column(name = "military_rank", nullable = true, length = 45)
    public String getMilitaryRank() {
        return militaryRank;
    }

    public void setMilitaryRank(String militaryRank) {
        this.militaryRank = militaryRank;
    }

    private String specializationNumber;

    @Basic
    @javax.persistence.Column(name = "specialization_number", nullable = true, length = 45)
    public String getSpecializationNumber() {
        return specializationNumber;
    }

    public void setSpecializationNumber(String specializationNumber) {
        this.specializationNumber = specializationNumber;
    }

    private String wkuNumber;

    @Basic
    @javax.persistence.Column(name = "wku_number", nullable = true, length = 45)
    public String getWkuNumber() {
        return wkuNumber;
    }

    public void setWkuNumber(String wkuNumber) {
        this.wkuNumber = wkuNumber;
    }

    private String militaryCard;

    @Basic
    @javax.persistence.Column(name = "military_card", nullable = true, length = 45)
    public String getMilitaryCard() {
        return militaryCard;
    }

    public void setMilitaryCard(String militaryCard) {
        this.militaryCard = militaryCard;
    }

    private String allocation;

    @Basic
    @javax.persistence.Column(name = "allocation", nullable = true, length = 45)
    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (Double.compare(that.pesel, pesel) != 0) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (motherName != null ? !motherName.equals(that.motherName) : that.motherName != null) return false;
        if (fatherName != null ? !fatherName.equals(that.fatherName) : that.fatherName != null) return false;
        if (motherLastName != null ? !motherLastName.equals(that.motherLastName) : that.motherLastName != null)
            return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (birthPlace != null ? !birthPlace.equals(that.birthPlace) : that.birthPlace != null) return false;
        if (citizenship != null ? !citizenship.equals(that.citizenship) : that.citizenship != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (addressStreet != null ? !addressStreet.equals(that.addressStreet) : that.addressStreet != null)
            return false;
        if (addressHomeNumber != null ? !addressHomeNumber.equals(that.addressHomeNumber) : that.addressHomeNumber != null)
            return false;
        if (addressFlatNumber != null ? !addressFlatNumber.equals(that.addressFlatNumber) : that.addressFlatNumber != null)
            return false;
        if (addressCity != null ? !addressCity.equals(that.addressCity) : that.addressCity != null) return false;
        if (addressPostalCode != null ? !addressPostalCode.equals(that.addressPostalCode) : that.addressPostalCode != null)
            return false;
        if (addressState != null ? !addressState.equals(that.addressState) : that.addressState != null) return false;
        if (shippingAddressStreet != null ? !shippingAddressStreet.equals(that.shippingAddressStreet) : that.shippingAddressStreet != null)
            return false;
        if (shippingAddressHomeNumber != null ? !shippingAddressHomeNumber.equals(that.shippingAddressHomeNumber) : that.shippingAddressHomeNumber != null)
            return false;
        if (shippingAddressFlatNumber != null ? !shippingAddressFlatNumber.equals(that.shippingAddressFlatNumber) : that.shippingAddressFlatNumber != null)
            return false;
        if (shippingAddressCity != null ? !shippingAddressCity.equals(that.shippingAddressCity) : that.shippingAddressCity != null)
            return false;
        if (shippingAddressPostalCode != null ? !shippingAddressPostalCode.equals(that.shippingAddressPostalCode) : that.shippingAddressPostalCode != null)
            return false;
        if (shippingAddressState != null ? !shippingAddressState.equals(that.shippingAddressState) : that.shippingAddressState != null)
            return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (additionalEducation != null ? !additionalEducation.equals(that.additionalEducation) : that.additionalEducation != null)
            return false;
        if (jobs != null ? !jobs.equals(that.jobs) : that.jobs != null) return false;
        if (additionalSkills != null ? !additionalSkills.equals(that.additionalSkills) : that.additionalSkills != null)
            return false;
        if (militaryRatio != null ? !militaryRatio.equals(that.militaryRatio) : that.militaryRatio != null)
            return false;
        if (militaryRank != null ? !militaryRank.equals(that.militaryRank) : that.militaryRank != null) return false;
        if (specializationNumber != null ? !specializationNumber.equals(that.specializationNumber) : that.specializationNumber != null)
            return false;
        if (wkuNumber != null ? !wkuNumber.equals(that.wkuNumber) : that.wkuNumber != null) return false;
        if (militaryCard != null ? !militaryCard.equals(that.militaryCard) : that.militaryCard != null) return false;
        if (allocation != null ? !allocation.equals(that.allocation) : that.allocation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        temp = Double.doubleToLongBits(pesel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (motherName != null ? motherName.hashCode() : 0);
        result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        result = 31 * result + (motherLastName != null ? motherLastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (citizenship != null ? citizenship.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addressStreet != null ? addressStreet.hashCode() : 0);
        result = 31 * result + (addressHomeNumber != null ? addressHomeNumber.hashCode() : 0);
        result = 31 * result + (addressFlatNumber != null ? addressFlatNumber.hashCode() : 0);
        result = 31 * result + (addressCity != null ? addressCity.hashCode() : 0);
        result = 31 * result + (addressPostalCode != null ? addressPostalCode.hashCode() : 0);
        result = 31 * result + (addressState != null ? addressState.hashCode() : 0);
        result = 31 * result + (shippingAddressStreet != null ? shippingAddressStreet.hashCode() : 0);
        result = 31 * result + (shippingAddressHomeNumber != null ? shippingAddressHomeNumber.hashCode() : 0);
        result = 31 * result + (shippingAddressFlatNumber != null ? shippingAddressFlatNumber.hashCode() : 0);
        result = 31 * result + (shippingAddressCity != null ? shippingAddressCity.hashCode() : 0);
        result = 31 * result + (shippingAddressPostalCode != null ? shippingAddressPostalCode.hashCode() : 0);
        result = 31 * result + (shippingAddressState != null ? shippingAddressState.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (additionalEducation != null ? additionalEducation.hashCode() : 0);
        result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
        result = 31 * result + (additionalSkills != null ? additionalSkills.hashCode() : 0);
        result = 31 * result + (militaryRatio != null ? militaryRatio.hashCode() : 0);
        result = 31 * result + (militaryRank != null ? militaryRank.hashCode() : 0);
        result = 31 * result + (specializationNumber != null ? specializationNumber.hashCode() : 0);
        result = 31 * result + (wkuNumber != null ? wkuNumber.hashCode() : 0);
        result = 31 * result + (militaryCard != null ? militaryCard.hashCode() : 0);
        result = 31 * result + (allocation != null ? allocation.hashCode() : 0);
        return result;
    }
}
