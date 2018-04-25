package base.model;

import org.springframework.security.access.method.P;

import java.util.Date;

public class ExamInfo {
    String labelType;
    String questionId;
    Date startDate;
    Date endDate;
    String duration;
    public void setLabelType(String labelType)
    {
        this.labelType = labelType;
    }
    public void setQuestion_id(String questionId)
    {
        this.questionId = questionId;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    public String getLabelType()
    {
        return labelType;
    }
    public String getQuestionId()
    {
        return questionId;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public Date getEndDate()
    {
        return endDate;
    }
    public String getDuration()
    {
        return duration;
    }
}
