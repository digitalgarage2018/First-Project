package org.project.bean;


public class ResultStateBean {
    //message send to caller
    private String message;
    private String result;
    private int State; //Refer to a Response State on utility controller
    private Object resultSet;

    public ResultStateBean(String message, String result, int State, Object resultSet){
        this.message = message;
        this.State = State;
        this.result = result;
        this.resultSet = resultSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getState() {
        return State;
    }

    public void setState(int errorState) {
        this.State = errorState;
    }

    public Object getResultSet() {
        return resultSet;
    }

    public void setResultSet(Object resultSet) {
        this.resultSet = resultSet;
    }

}
