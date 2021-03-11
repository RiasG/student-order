package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeptions.CityRegisterExiption;
import edu.javacourse.studentorder.exeptions.TransportExeprion;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterExiption, TransportExeprion {
            return null;

    }
}
