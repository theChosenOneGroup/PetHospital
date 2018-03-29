package base.model;

public class OfficeInfo {
    int officeId;
    String personName;
    String officeName;

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getOfficeId() {
        return officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getPersonName() {

        return personName;
    }
}
