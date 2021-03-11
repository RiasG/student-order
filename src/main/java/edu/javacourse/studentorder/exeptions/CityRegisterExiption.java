package edu.javacourse.studentorder.exeptions;

public class CityRegisterExiption extends Exception{

    private String code;


    public CityRegisterExiption(String code,String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterExiption(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;

    }

    public String getCode() {
        return code;
    }
}
