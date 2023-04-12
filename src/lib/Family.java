package lib;

import java.util.LinkedList;
import java.util.List;

public class Family {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;
    
    public Family() {
        childNames = new LinkedList<String> ();
        childIdNumbers = new LinkedList<String> ();
    }
    
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public String getSpouseName() {
        return spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }
}
