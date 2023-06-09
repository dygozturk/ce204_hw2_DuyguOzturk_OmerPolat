package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 65 "model.ump"
// line 157 "model.ump"
public class Doctor extends OperationsStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Attributes
  private String specialty;
  private String locations;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  
  /**

  @brief Constructor for creating a public Doctor object.
  @param aTitle
  @param aGivenname
  @param aMiddleName
  @param aFamilyName
  @param aName
  @param aBirthDate
  @param aHomeAddress
  @param aPhone
  @param aGender
  @Param aJoined
  @param aEducation
  @param aCertification
  @param aLanguages
  @param aDepartment
  @param aSpecialty
  @param aLocations
  */
  
  
  public Doctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined, aEducation, aCertification, aLanguages, aDepartment);
    specialty = aSpecialty;
    locations = aLocations;
  }

  //------------------------
  // INTERFACE
  //------------------------
  
  /** This code defines setters, getters, and methods for deleting and getting a string representation of an object. 
   * It also contains a private instance variable for specialty and locations.
   */
  public boolean setSpecialty(String aSpecialty)
  {
    boolean wasSet = false;
    specialty = aSpecialty;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocations(String aLocations)
  {
    boolean wasSet = false;
    locations = aLocations;
    wasSet = true;
    return wasSet;
  }

  public String getSpecialty()
  {
    return specialty;
  }

  public String getLocations()
  {
    return locations;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "specialty" + ":" + getSpecialty()+ "," +
            "locations" + ":" + getLocations()+ "]";
  }
}