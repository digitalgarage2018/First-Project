package org.project.bean;

public class ResultStateBean {
    //message send to caller
    private String message;
    private String result;

    //0 for OK and 1 for ERROR
    private int errorState;

    public ResultStateBean(String message, String result, int errorState){
        this.message = message;
        this.errorState = errorState;
        this.result = result;
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

    public int getErrorState() {
        return errorState;
    }

    public void setErrorState(int errorState) {
        this.errorState = errorState;
    }

}
