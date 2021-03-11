package edu.javacourse.studentorder.exeptions;

public class TransportExeprion extends Exception{
    public TransportExeprion() {
    }

    public TransportExeprion(String message) {
        super(message);
    }

    public TransportExeprion(String message, Throwable cause) {
        super(message, cause);
    }
}
