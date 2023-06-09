package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 13 "model.ump"
// line 135 "model.ump"
public class Department
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Department Associations
  private List<Staff> staffs;
  private Hospital hospital;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Department(Hospital aHospital)
  {
    staffs = new ArrayList<Staff>();
    boolean didAddHospital = setHospital(aHospital);
    if (!didAddHospital)
    {
      throw new RuntimeException("Unable to create department due to hospital. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  
  
  /**
   * @brief These methods are related to accessing and managing the list of staffs in a department. The comments could be something like:
   * getStaff(int index): Returns the staff at the specified index in the list.
   * /getStaffs(): Returns an unmodifiable list of all staffs in the department.
   * numberOfStaffs(): Returns the number of staffs in the department.
   * hasStaffs(): Returns true if the department has at least one staff, false otherwise.
   * indexOfStaff(Staff aStaff): Returns the index of the specified staff in the list, or -1 if it is not found.
   * */
  public Staff getStaff(int index)
  {
    Staff aStaff = staffs.get(index);
    return aStaff;
  }

  public List<Staff> getStaffs()
  {
    List<Staff> newStaffs = Collections.unmodifiableList(staffs);
    return newStaffs;
  }

  public int numberOfStaffs()
  {
    int number = staffs.size();
    return number;
  }

  public boolean hasStaffs()
  {
    boolean has = staffs.size() > 0;
    return has;
  }

  public int indexOfStaff(Staff aStaff)
  {
    int index = staffs.indexOf(aStaff);
    return index;
  }
  /* Code from template association_GetOne */
  public Hospital getHospital()
  {
    return hospital;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStaffs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  
  /**
  This code defines methods to add and remove staff from a department.
  */
  public Staff addStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation, String aCertification, String aLanguages)
  {
    return new Staff(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined, aEducation, aCertification, aLanguages, this);
  }

  public boolean addStaff(Staff aStaff)
  {
    boolean wasAdded = false;
    if (staffs.contains(aStaff)) { return false; }
    Department existingDepartment = aStaff.getDepartment();
    boolean isNewDepartment = existingDepartment != null && !this.equals(existingDepartment);
    if (isNewDepartment)
    {
      aStaff.setDepartment(this);
    }
    else
    {
      staffs.add(aStaff);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStaff(Staff aStaff)
  {
    boolean wasRemoved = false;
    //Unable to remove aStaff, as it must always have a department
    if (!this.equals(aStaff.getDepartment()))
    {
      staffs.remove(aStaff);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * These methods are used to add or move staff to a department at a specified index in the staffs list.
   * */
  public boolean addStaffAt(Staff aStaff, int index)
  {  
    boolean wasAdded = false;
    if(addStaff(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStaffAt(Staff aStaff, int index)
  {
    boolean wasAdded = false;
    if(staffs.contains(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStaffAt(aStaff, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  /**
   * This code defines methods for setting the hospital of a department and deleting a department along with its staff.
   * */
  public boolean setHospital(Hospital aHospital)
  {
    boolean wasSet = false;
    if (aHospital == null)
    {
      return wasSet;
    }

    Hospital existingHospital = hospital;
    hospital = aHospital;
    if (existingHospital != null && !existingHospital.equals(aHospital))
    {
      existingHospital.removeDepartment(this);
    }
    hospital.addDepartment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (staffs.size() > 0)
    {
      Staff aStaff = staffs.get(staffs.size() - 1);
      aStaff.delete();
      staffs.remove(aStaff);
    }
    
    Hospital placeholderHospital = hospital;
    this.hospital = null;
    if(placeholderHospital != null)
    {
      placeholderHospital.removeDepartment(this);
    }
  }

}