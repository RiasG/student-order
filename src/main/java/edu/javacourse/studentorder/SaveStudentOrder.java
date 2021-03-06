package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.DictionaryDao;
import edu.javacourse.studentorder.dao.DictionaryDaoImpl;
import edu.javacourse.studentorder.dao.StudentDaoImpl;
import edu.javacourse.studentorder.dao.StudentOrderDao;
import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exeptions.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {

    public static void main(String[] args) throws DaoException {
//        List<Street> d = new DictionaryDaoImpl().findStreet("улиц");
//        for (Street s : d){
//            System.out.print(s.getStreetCode() + " : ");
//            System.out.println(s.getStreetName());
//
//        }
//
//        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//        for (PassportOffice p : po){
//            System.out.println(p.getOfficeName());
//        }
//
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        for (RegisterOffice r : ro){
//            System.out.println(r.getOfficeName() );
//        }

//        List<CountryArea> co1 = new DictionaryDaoImpl().findAreas("");
//        for (CountryArea c : co1){
//            System.out.println(c.getAreaId() + " : " + c.getAreaName() );
//        }

//        System.out.println("-----------------------");
//        List<CountryArea> co2 = new DictionaryDaoImpl().findAreas("020000000000");
//        for (CountryArea c : co2){
//            System.out.println(c.getAreaId() + " : " + c.getAreaName() );
//        }
//        System.out.println("-----------------------");
//        List<CountryArea> co3 = new DictionaryDaoImpl().findAreas("020010000000");
//        for (CountryArea c : co3){
//            System.out.println(c.getAreaId() + " : " + c.getAreaName() );
//        }

//        System.out.println("-----------------------");
//        List<CountryArea> co4 = new DictionaryDaoImpl().findAreas("020010010000");
//        for (CountryArea c : co4){
//            System.out.println(c.getAreaId() + " : " + c.getAreaName() );
//        }


//        StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentDaoImpl();
//        Long id = dao.saveStudentOrder(s);
//        System.out.println(id);

        List<StudentOrder> listSo = dao.getStudentOrders();

        for (StudentOrder so : listSo){
            System.out.println(so.getStudentOrderId());
        }
//        StudentOrder so = new StudentOrder();
//        buildStudentOrder(1);
//
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);

    }
    static int saveStudentOrder(StudentOrder so){
        int answer = 199;
        System.out.println("Save student order");

        return answer;
    }
    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));

        RegisterOffice ro = new RegisterOffice(1,"","");
        so.setMarriageOffice(ro);
        Street steet = new Street(1,"First street");
        Address address = new Address("195000", steet, "12", "", "142");

        // Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        System.out.println(husband.getPassportSeria().getClass());
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1,"","");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L,""));
        husband.setStudentId("HH12345");

        // Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2,"","");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L,""));
        wife.setStudentId("WW12345");
        // Ребенок
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 6, 11));
        RegisterOffice ro2 = new RegisterOffice(2,"","");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);

        Child child2 = new Child("Петрова", "Мария", "Викторовна", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3,"","");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);


        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
    }
}

