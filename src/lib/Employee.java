package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private Person person;
    private LocalDate dateJoined;
    private int monthWorkingInYear;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    // Data Keluarga
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(Person person, LocalDate dateJoined, int monthWorkingInYear, int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
        this.person = person;
        this.dateJoined = dateJoined;
        this.monthWorkingInYear = monthWorkingInYear;
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;

        childNames = new LinkedList<String> ();
        childIdNumbers = new LinkedList<String> ();
    }

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            monthlySalary = 3000000;
            if (person.isIsForeigner()) {
                monthlySalary = (int)(3000000 * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (person.isIsForeigner()) {
                monthlySalary = (int)(3000000 * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (person.isIsForeigner()) {
                monthlySalary = (int)(3000000 * 1.5);
            }
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {

        //Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate date = LocalDate.now();

        if (date.getYear() == dateJoined.getYear()) {
            monthWorkingInYear = date.getMonthValue() - dateJoined.getMonthValue();
        } else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
    }
}