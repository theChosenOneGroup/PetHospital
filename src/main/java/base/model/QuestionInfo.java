package base.model;


public class QuestionInfo {
    int questionId;
    String typeName;
    String text;
    String answer;
    public void setQuestionId(int questionId){
        this.questionId=questionId;
    }
    public void setTypeName(String typeName){
        this.typeName=typeName;
    }
    public void setText(String text){
        this.text=text;
    }
    public void setAnswer(String answer) {this.answer=answer;}
    public int getQuestionId(){
        return questionId;
    }
    public String getTypeName(){
        return typeName;
    }
    public String getText() {
        return text;
    }
    public String getAnswer() {
        return answer;
    }
}
