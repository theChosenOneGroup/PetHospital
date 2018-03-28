package base.model;

import java.math.BigDecimal;

public class VaccineInfo {
    int vaccineId;
    String vaccineName;
    BigDecimal cost;

    public void setVaccineId(int vaccineId){
        this.vaccineId=vaccineId;
    }
    public void setVaccineName(String vaccineName){
        this.vaccineName=vaccineName;
    }
    public void setCost(BigDecimal cost){
        this.cost=cost;
    }
    public int getVaccineId(){
        return vaccineId;
    }
    public String getVaccineName(){
        return vaccineName;
    }
    public BigDecimal getCost() {
        return cost;
    }
}
