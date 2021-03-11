package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exeptions.CityRegisterExiption;
import edu.javacourse.studentorder.exeptions.TransportExeprion;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {

    public static final String INCODE = "NOGRN";
    private CityRegisterChecker personChecker;

     public CityRegisterValidator() {
         personChecker = new FakeCityRegisterChecker();
     }

     public AnswerCityRegister checkCityRegister(StudentOrder so){
         AnswerCityRegister ans = new AnswerCityRegister();
         ans.addItem(checkPerson(so.getHusband()));
         ans.addItem(checkPerson(so.getWife()));
         for (Child child : so.getChildren()){
             ans.addItem(checkPerson(child));
         }
         return ans;
     }

     private AnswerCityRegisterItem checkPerson(Person person){

         AnswerCityRegisterItem.CityStatus status = null;
         AnswerCityRegisterItem.CityError error = null;

         try {
             CityRegisterResponse tmp = personChecker.checkPerson(person);
             status = tmp.isExisting() ?
                     AnswerCityRegisterItem.CityStatus.YES : AnswerCityRegisterItem.CityStatus.NO;
         }catch (CityRegisterExiption | TransportExeprion ex){
             ex.printStackTrace(System.out);
             status = AnswerCityRegisterItem.CityStatus.ERROR;
             if (ex instanceof CityRegisterExiption){
                 CityRegisterExiption e = (CityRegisterExiption) ex;
                 error = new AnswerCityRegisterItem.CityError(e.getCode(), ex.getMessage());
             }
             if (ex instanceof TransportExeprion){
                 TransportExeprion e = (TransportExeprion) ex;
                 error = new AnswerCityRegisterItem.CityError(INCODE, ((TransportExeprion) ex).getMessage());
             }
         }catch (Exception ex) {


         }
        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status,person,error);

        return ans;
     }
}
