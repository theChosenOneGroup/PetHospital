package base.model;

import java.math.BigDecimal;

public class LabworkInfo {
    int labworkId;
    String labworkName;
    BigDecimal cost;

    public void setLabworkId(int labworkId){
        this.labworkId=labworkId;
    }
    public void setLabworkName(String labworkName){
        this.labworkName=labworkName;
    }
    public void setCost(BigDecimal cost){
        this.cost=cost;
    }
    public int getLabworkId(){
        return labworkId;
    }
    public String getLabworkName(){
        return labworkName;
    }
    public BigDecimal getCost() {
        return cost;
    }
}
