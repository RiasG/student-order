package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.exeptions.CityRegisterExiption;
import edu.javacourse.studentorder.exeptions.TransportExeprion;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    private static final String GOOD1 = "1000";
    private static final String GOOD2 = "2000";
    private static final String BAD1 = "1001";
    private static final String BAD2 = "2001";
    private static final String ERROR1 = "1002";
    private static final String ERROR2 = "2002";
    private static final String ERRORT1 = "1003";
    private static final String ERRORT2 = "2003";


    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterExiption, TransportExeprion {

        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult){
            Adult t = (Adult)person;
            String ps = t.getPassportSeria();
            if(ps.equals(GOOD1) || ps.equals(GOOD2)){
                res.setExisting(true);
                res.setTemporal(false);
            }
            if(ps.equals(BAD1) || ps.equals(BAD2)){
                res.setExisting(false);
            }
            if(ps.equals(ERROR1) || ps.equals(ERROR2)){
                CityRegisterExiption ex = new CityRegisterExiption("1","GRN ERROR " + ps);
                throw ex;
            }
            if(ps.equals(ERRORT1) || ps.equals(ERRORT2)){
                    TransportExeprion ex = new TransportExeprion("Transport ERROR " + ps);
                    throw ex;
            }
        }

        if (person instanceof Child){
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);
        return res;
    }
}
