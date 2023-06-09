package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 18 "model.ump"
// line 130 "model.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String title;
  private String givenName;
  private String middleName;
  private String familyName;
  private String name;
  private Date birthDate;
  private String homeAddress;
  private String phone;
  private String gender;

  //Person Associations
  private List<Hospital> hospitals;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  /**
   * 
   * @param aTitle
   * @param aGivenName
   * @param aMiddleName
   * @param aFamilyName
   * @param aName
   * @param aBirthDate
   * @param aHomeAddress
   * @param aPhone
   * @param aGender
   */

  public Person(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender)
  {
    title = aTitle;
    givenName = aGivenName;
    middleName = aMiddleName;
    familyName = aFamilyName;
    name = aName;
    birthDate = aBirthDate;
    homeAddress = aHomeAddress;
    phone = aPhone;
    gender = aGender;
    hospitals = new ArrayList<Hospital>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * This is a set of getters and setters for a person's information, such as name, birthdate, address, 
   * and phone number. The getters retrieve the value of each field, while the setters modify the value 
   * of each field and return a boolean indicating whether the modification was successful or not.
   */
  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setGivenName(String aGivenName)
  {
    boolean wasSet = false;
    givenName = aGivenName;
    wasSet = true;
    return wasSet;
  }

  public boolean setMiddleName(String aMiddleName)
  {
    boolean wasSet = false;
    middleName = aMiddleName;
    wasSet = true;
    return wasSet;
  }

  public boolean setFamilyName(String aFamilyName)
  {
    boolean wasSet = false;
    familyName = aFamilyName;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthDate(Date aBirthDate)
  {
    boolean wasSet = false;
    birthDate = aBirthDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setHomeAddress(String aHomeAddress)
  {
    boolean wasSet = false;
    homeAddress = aHomeAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setGender(String aGender)
  {
    boolean wasSet = false;
    gender = aGender;
    wasSet = true;
    return wasSet;
  }

  public String getTitle()
  {
    return title;
  }

  public String getGivenName()
  {
    return givenName;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public String getFamilyName()
  {
    return familyName;
  }

  public String getName()
  {
    return name;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public String getHomeAddress()
  {
    return homeAddress;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getGender()
  {
    return gender;
  }
  /* Code from template association_GetMany */
  /**
   * This code contains getter and utility methods for the hospitals attribute of the Person class.
   */
  public Hospital getHospital(int index)
  {
    Hospital aHospital = hospitals.get(index);
    return aHospital;
  }

  public List<Hospital> getHospitals()
  {
    List<Hospital> newHospitals = Collections.unmodifiableList(hospitals);
    return newHospitals;
  }

  public int numberOfHospitals()
  {
    int number = hospitals.size();
    return number;
  }

  public boolean hasHospitals()
  {
    boolean has = hospitals.size() > 0;
    return has;
  }

  public int indexOfHospital(Hospital aHospital)
  {
    int index = hospitals.indexOf(aHospital);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitals()
  {
    return 0;
  }
  
  /* Code from template association_AddManyToManyMethod */
  /**
   * This method adds a Hospital object to the list of hospitals that this Person belongs to. It returns true if the Hospital was successfully added, false otherwise. If the Hospital 
   * is already in the list, it returns false. If the Hospital is not in the list, it adds the Hospital to the list and then checks if this Person was successfully added to the Hospital's 
   * list of Persons. If this Person was not successfully added to the Hospital's list of Persons,the Hospital is removed from the Person's list of hospitals.
   * @param aHospital
   * @return
   */
  public boolean addHospital(Hospital aHospital)
  {
    boolean wasAdded = false;
    if (hospitals.contains(aHospital)) { return false; }
    hospitals.add(aHospital);
    if (aHospital.indexOfPerson(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aHospital.addPerson(this);
      if (!wasAdded)
      {
        hospitals.remove(aHospital);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * This method removes a given hospital from the list of hospitals associated with a person and removes 
   * the person from the hospital's list of associated persons. If successful, it returns true; otherwise, it returns false.
   * @param aHospital
   * @return
   */
  public boolean removeHospital(Hospital aHospital)
  {
    boolean wasRemoved = false;
    if (!hospitals.contains(aHospital))
    {
      return wasRemoved;
    }

    int oldIndex = hospitals.indexOf(aHospital);
    hospitals.remove(oldIndex);
    if (aHospital.indexOfPerson(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aHospital.removePerson(this);
      if (!wasRemoved)
      {
        hospitals.add(oldIndex,aHospital);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * This code adds a hospital to a specific index in the list of hospitals and returns true if the operation is successful.
   */
  public boolean addHospitalAt(Hospital aHospital, int index)
  {  
    boolean wasAdded = false;
    if(addHospital(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    }
    return wasAdded;
  }
  /**
   * This code adds or moves a hospital to a specific index in the list of hospitals associated with the person.
   */
  public boolean addOrMoveHospitalAt(Hospital aHospital, int index)
  {
    boolean wasAdded = false;
    if(hospitals.contains(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHospitalAt(aHospital, index);
    }
    return wasAdded;
  }
  /**
   * This code removes a person from a list of hospitals and removes the person from each hospital's list of associated people.
   */
  public void delete()
  {
    ArrayList<Hospital> copyOfHospitals = new ArrayList<Hospital>(hospitals);
    hospitals.clear();
    for(Hospital aHospital : copyOfHospitals)
    {
      aHospital.removePerson(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "title" + ":" + getTitle()+ "," +
            "givenName" + ":" + getGivenName()+ "," +
            "middleName" + ":" + getMiddleName()+ "," +
            "familyName" + ":" + getFamilyName()+ "," +
            "name" + ":" + getName()+ "," +
            "homeAddress" + ":" + getHomeAddress()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "gender" + ":" + getGender()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "birthDate" + "=" + (getBirthDate() != null ? !getBirthDate().equals(this)  ? getBirthDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}