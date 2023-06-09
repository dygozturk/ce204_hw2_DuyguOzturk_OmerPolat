package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;

import java.sql.Date;
import java.util.*;

// line 43 "model.ump"
// line 84 "model.ump"
public class DoctorWAT extends Doctor
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
  public DoctorWAT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation,
			String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
		specialty = aSpecialty;
	    locations = aLocations;
	    patientWATs = new ArrayList<PatientWAT>();
	}


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoctorWAT Attributes
  private String specialty;
  private String locations;

  //DoctorWAT Associations
  private Team team;
  private List<PatientWAT> patientWATs;

  //------------------------
  // CONSTRUCTOR
  //------------------------



  //------------------------
  // INTERFACE
  //------------------------

  /**
   * This is a collection of setter and getter methods for a DoctorWAT class. The methods set and get the doctor's specialty, 
   * locations, and team, as well as manage a many-to-many association with PatientWAT objects.
   * */
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
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }

  public boolean hasTeam()
  {
    boolean has = team != null;
    return has;
  }
  /* Code from template association_GetOne_clear */
  protected void clear_team()
  {
    team = null;
  }
  /* Code from template association_GetMany */
  public PatientWAT getPatientWAT(int index)
  {
    PatientWAT aPatientWAT = patientWATs.get(index);
    return aPatientWAT;
  }

  public List<PatientWAT> getPatientWATs()
  {
    List<PatientWAT> newPatientWATs = Collections.unmodifiableList(patientWATs);
    return newPatientWATs;
  }

  public int numberOfPatientWATs()
  {
    int number = patientWATs.size();
    return number;
  }

  public boolean hasPatientWATs()
  {
    boolean has = patientWATs.size() > 0;
    return has;
  }

  public int indexOfPatientWAT(PatientWAT aPatientWAT)
  {
    int index = patientWATs.indexOf(aPatientWAT);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_patientWATs()
  {
    patientWATs.clear();
  }
  /* Code from template association_SetOptionalOneToMany */
  /**
   * The first method sets a team for the doctor and updates the association between them. The second and third methods are related to the association between a doctor and multiple patientWAT objects. 
   * The fourth method returns the minimum number of patientWAT objects for the association, and the fifth and sixth methods add and remove patientWAT objects to/from the doctor's list of patients and update the association accordingly.
   * */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removeDoctorWAT(this);
    }
    if (aTeam != null)
    {
      aTeam.addDoctorWAT(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientWATs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * These methods are related to the DoctorWAT class and are used to add, remove, and manipulate PatientWAT objects and the associated Team object. 
   * The delete() method removes the DoctorWAT object and its associated PatientWAT and Team objects from the system. 
   * The toString() method returns a string representation of the DoctorWAT object, including its specialty, locations, and associated Team object.
   * */
  public boolean addPatientWAT(PatientWAT aPatientWAT)
  {
    boolean wasAdded = false;
    if (patientWATs.contains(aPatientWAT)) { return false; }
    patientWATs.add(aPatientWAT);
    if (aPatientWAT.indexOfDoctorWAT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatientWAT.addDoctorWAT(this);
      if (!wasAdded)
      {
        patientWATs.remove(aPatientWAT);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatientWAT(PatientWAT aPatientWAT)
  {
    boolean wasRemoved = false;
    if (!patientWATs.contains(aPatientWAT))
    {
      return wasRemoved;
    }

    int oldIndex = patientWATs.indexOf(aPatientWAT);
    patientWATs.remove(oldIndex);
    if (aPatientWAT.indexOfDoctorWAT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatientWAT.removeDoctorWAT(this);
      if (!wasRemoved)
      {
        patientWATs.add(oldIndex,aPatientWAT);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientWATAt(PatientWAT aPatientWAT, int index)
  {  
    boolean wasAdded = false;
    if(addPatientWAT(aPatientWAT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientWATs()) { index = numberOfPatientWATs() - 1; }
      patientWATs.remove(aPatientWAT);
      patientWATs.add(index, aPatientWAT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientWATAt(PatientWAT aPatientWAT, int index)
  {
    boolean wasAdded = false;
    if(patientWATs.contains(aPatientWAT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientWATs()) { index = numberOfPatientWATs() - 1; }
      patientWATs.remove(aPatientWAT);
      patientWATs.add(index, aPatientWAT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientWATAt(aPatientWAT, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (team != null)
    {
      Team placeholderTeam = team;
      this.team = null;
      placeholderTeam.removeDoctorWAT(this);
    }
    ArrayList<PatientWAT> copyOfPatientWATs = new ArrayList<PatientWAT>(patientWATs);
    patientWATs.clear();
    for(PatientWAT aPatientWAT : copyOfPatientWATs)
    {
      aPatientWAT.removeDoctorWAT(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "specialty" + ":" + getSpecialty()+ "," +
            "locations" + ":" + getLocations()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null");
  }
}