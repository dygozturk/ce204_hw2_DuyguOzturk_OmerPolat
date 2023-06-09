package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

/**
 * Hospital system - sample UML class diagram in Umple
 */
// line 4 "model.ump"
// line 123 "model.ump"
public class Hospital
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hospital Attributes
  private String name;
  private String address;
  private String phone;

  //Hospital Associations
  private List<Department> departments;
  private List<Person> persons;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  
  /**
   * 
   * @param aName
   * @param aAddress
   * @param aPhone
   */

  public Hospital(String aName, String aAddress, String aPhone)
  {
    name = aName;
    address = aAddress;
    phone = aPhone;
    departments = new ArrayList<Department>();
    persons = new ArrayList<Person>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  
  /**
   * This code provides setters and getters for the hospital's name, address, and phone number.
   */
  
  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
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

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhone()
  {
    return phone;
  }
  /* Code from template association_GetMany */
  
  /**
   * These methods provide access and information about the departments in the hospital.
   * @param index
   * @return
   */
  public Department getDepartment(int index)
  {
    Department aDepartment = departments.get(index);
    return aDepartment;
  }

  public List<Department> getDepartments()
  {
    List<Department> newDepartments = Collections.unmodifiableList(departments);
    return newDepartments;
  }

  public int numberOfDepartments()
  {
    int number = departments.size();
    return number;
  }

  public boolean hasDepartments()
  {
    boolean has = departments.size() > 0;
    return has;
  }

  public int indexOfDepartment(Department aDepartment)
  {
    int index = departments.indexOf(aDepartment);
    return index;
  }
  /* Code from template association_GetMany */
  /**
   * These methods provide access to and information about the list of people associated with a hospital.
   * @param index
   * @return
   */
  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDepartments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  /**
   * This code defines methods to add and remove departments to a hospital.
   * 
   */
  public Department addDepartment()
  {
    return new Department(this);
  }

  public boolean addDepartment(Department aDepartment)
  {
    boolean wasAdded = false;
    if (departments.contains(aDepartment)) { return false; }
    Hospital existingHospital = aDepartment.getHospital();
    boolean isNewHospital = existingHospital != null && !this.equals(existingHospital);
    if (isNewHospital)
    {
      aDepartment.setHospital(this);
    }
    else
    {
      departments.add(aDepartment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDepartment(Department aDepartment)
  {
    boolean wasRemoved = false;
    //Unable to remove aDepartment, as it must always have a hospital
    if (!this.equals(aDepartment.getHospital()))
    {
      departments.remove(aDepartment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  
  /* Code from template association_AddIndexControlFunctions */
  
  /**
   * This code defines methods to add or move departments in the hospital's list of departments.
   */
  public boolean addDepartmentAt(Department aDepartment, int index)
  {  
    boolean wasAdded = false;
    if(addDepartment(aDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepartments()) { index = numberOfDepartments() - 1; }
      departments.remove(aDepartment);
      departments.add(index, aDepartment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDepartmentAt(Department aDepartment, int index)
  {
    boolean wasAdded = false;
    if(departments.contains(aDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepartments()) { index = numberOfDepartments() - 1; }
      departments.remove(aDepartment);
      departments.add(index, aDepartment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDepartmentAt(aDepartment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPersons()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * This code adds a person to a hospital and establishes a 
   * bi-directional relationship between them, returning a boolean indicating if the operation was successful.
   */
  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (persons.contains(aPerson)) { return false; }
    persons.add(aPerson);
    if (aPerson.indexOfHospital(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPerson.addHospital(this);
      if (!wasAdded)
      {
        persons.remove(aPerson);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * This code implements the removal of a Person object from a list and updates the relevant associations.
   * @param aPerson
   * @return
   */
  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    if (!persons.contains(aPerson))
    {
      return wasRemoved;
    }

    int oldIndex = persons.indexOf(aPerson);
    persons.remove(oldIndex);
    if (aPerson.indexOfHospital(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPerson.removeHospital(this);
      if (!wasRemoved)
      {
        persons.add(oldIndex,aPerson);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /** 
   * These are methods from a Hospital class: addPersonAt: Adds a Person object at the specified index in the persons list, 
   * if possible, and returns a boolean value indicating if the addition was successful.
   */
  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }
  /**
   * addOrMovePersonAt: If the specified Person object is already in the persons list, moves it to the specified index. 
   * Otherwise, adds the Person at the specified index. Returns a boolean value indicating if the operation was successful.
   */
  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(persons.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
  }
  /**
   * delete: Deletes the Hospital object by first deleting all associated Department objects, 
   * then removing the Hospital object from all associated Person objects' hospitals list.
   */
  public void delete()
  {
    while (departments.size() > 0)
    {
      Department aDepartment = departments.get(departments.size() - 1);
      aDepartment.delete();
      departments.remove(aDepartment);
    }
    
    ArrayList<Person> copyOfPersons = new ArrayList<Person>(persons);
    persons.clear();
    for(Person aPerson : copyOfPersons)
    {
      aPerson.removeHospital(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "phone" + ":" + getPhone()+ "]";
  }
}