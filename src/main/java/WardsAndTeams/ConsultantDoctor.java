package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

import Organization.Department;

import java.sql.Date;

// line 49 "model.ump"
// line 89 "model.ump"
public class ConsultantDoctor extends DoctorWAT
{

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
  public ConsultantDoctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation,
			String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub

	}
//------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------



  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne_specialization */
  public Team getTeam_OneTeam()
  {
    return super.getTeam();
  }
  /* Code from template association_GetMany_specialization */
  public PatientWAT getPatientWAT_PatientWAT(int index)
  {
    PatientWAT aPatientWAT = (PatientWAT)super.getPatientWAT(index);
    return aPatientWAT;
  }

  /* required for Java 7. */
  @SuppressWarnings("unchecked")
  public List<PatientWAT> getPatientWATs_PatientWAT()
  {
    List<? extends PatientWAT> newPatientWATs = super.getPatientWATs();
    return (List<PatientWAT>)newPatientWATs;
  }
  /* Code from template association_set_specialization_reqSuperCode */  /* Code from template association_set_specialization_reqSuperCode */  /* Code from template association_MinimumNumberOfMethod_specialization */
  public static int minimumNumberOfPatientWATs_PatientWAT()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne_specialization */
  public PatientWAT addPatientWAT(String aId, String aGender, int aAge, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Ward aWard, Team aTeam)
  {
    // need to keep this because of the type differences between sub & super classes
    return new PatientWAT(aId, aGender, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aAge, aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs, aWard, aTeam);
  }
  public void delete()
  {
    Team existingTeam = getTeam();
    super.clear_team();
    if (existingTeam != null)
    {
      existingTeam.delete();
    }
    super.delete();
  }

public static ConsultantDoctor get(int i) {
	// TODO Auto-generated method stub
	return null;
}

}