package base.model;

public class CaseInfo {
    int caseId;
    String caseName;
    String caseType;
    String jcName;
    String jcPic;
    String checkName;
    String checkPic;
    String result;
    String treatText;
    String treatVideo;
    int medicineId;
    int labworkId;
    int vaccineId;
    int stayDays;

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getJcName() {
        return jcName;
    }

    public void setJcName(String jcName) {
        this.jcName = jcName;
    }

    public String getJcPic() {
        return jcPic;
    }

    public void setJcPic(String jcPic) {
        this.jcPic = jcPic;
    }

    public int getStayDays() {
        return stayDays;
    }

    public void setStayDays(int stayDays) {
        this.stayDays = stayDays;
    }

    public int getVaccineId() {

        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public int getLabworkId() {

        return labworkId;
    }

    public void setLabworkId(int labworkId) {
        this.labworkId = labworkId;
    }

    public int getMedicineId() {

        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getTreatVideo() {

        return treatVideo;
    }

    public void setTreatVideo(String treatVideo) {
        this.treatVideo = treatVideo;
    }

    public String getTreatText() {

        return treatText;
    }

    public void setTreatText(String treatText) {
        this.treatText = treatText;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCheckPic() {

        return checkPic;
    }

    public void setCheckPic(String checkPic) {
        this.checkPic = checkPic;
    }

    public String getCheckName() {

        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

}
