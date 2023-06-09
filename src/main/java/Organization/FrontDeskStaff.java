package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 87 "model.ump"
// line 177 "model.ump"
public class FrontDeskStaff extends AdministrativeStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

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
	  */

  public FrontDeskStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined, aEducation, aCertification, aLanguages, aDepartment);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}