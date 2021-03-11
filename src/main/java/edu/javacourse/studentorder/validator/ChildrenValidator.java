package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.children.AnswerChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public String hostName;
    public String login;
    String password;

    public AnswerChildren checkChildren(StudentOrder so){
        System.out.println("Chldren Check is running: " +
                hostName + ", " + login + ", " + password);

        return new AnswerChildren();
    }
}
