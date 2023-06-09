package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 77 "model.ump"
// line 167 "model.ump"
public class Surgeon extends Doctor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

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
	 * @param aJoined
	 * @param aEducation
	 * @param aCertification
	 * @param aLanguages
	 * @param aDepartment
	 * @param aSpecialty
	 * @param aLocations
	 */

  public Surgeon(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined, aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}