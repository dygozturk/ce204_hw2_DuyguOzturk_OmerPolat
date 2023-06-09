package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 24 "model.ump"
// line 74 "model.ump"
public class Ward
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ward Attributes
  private String name;
  private String patientGender;
  private int capacity;

  //Ward Associations
  private HospitalWAT hospitalWAT;
  private List<PatientWAT> patientWATs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ward(String aName, String aPatientGender, int aCapacity, HospitalWAT aHospitalWAT)
  {
    name = aName;
    patientGender = aPatientGender;
    capacity = aCapacity;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPatientGender(String aPatientGender)
  {
    boolean wasSet = false;
    patientGender = aPatientGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacity(int aCapacity)
  {
    boolean wasSet = false;
    capacity = aCapacity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getPatientGender()
  {
    return patientGender;
  }

  public int getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public HospitalWAT getHospitalWAT()
  {
    return hospitalWAT;
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
  /* Code from template association_SetOneToMany */
  public boolean setHospitalWAT(HospitalWAT aHospitalWAT)
  {
    boolean wasSet = false;
    if (aHospitalWAT == null)
    {
      return wasSet;
    }

    HospitalWAT existingHospitalWAT = hospitalWAT;
    hospitalWAT = aHospitalWAT;
    if (existingHospitalWAT != null && !existingHospitalWAT.equals(aHospitalWAT))
    {
      existingHospitalWAT.removeWard(this);
    }
    hospitalWAT.addWard(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientWATs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientWAT addPatientWAT(String aId, String aGender, int aAge, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Team aTeam)
  {
    return new PatientWAT(aId, aGender, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aAge, aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs, this, aTeam);
  }
  
  private List<PatientWAT> patientWAT = new ArrayList<>();
  
  public boolean addPatientWAT(PatientWAT aPatientWAT) {
	  
      boolean wasAdded = false;
      if (patientWAT.contains(aPatientWAT)) {
          return false;
      }
      Ward existingWard = aPatientWAT.getWard();
      boolean isNewWard = existingWard != null && !this.equals(existingWard);
      if (isNewWard) {
          aPatientWAT.setWard(this);
      } else {
          patientWAT.add(aPatientWAT);
      }
      wasAdded = true;
      return wasAdded;
  }

  public boolean removePatientWAT(PatientWAT aPatientWAT)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatientWAT, as it must always have a ward
    if (!this.equals(aPatientWAT.getWard()))
    {
      patientWATs.remove(aPatientWAT);
      wasRemoved = true;
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
    HospitalWAT placeholderHospitalWAT = hospitalWAT;
    this.hospitalWAT = null;
    if(placeholderHospitalWAT != null)
    {
      placeholderHospitalWAT.removeWard(this);
    }
    for(int i=patientWATs.size(); i > 0; i--)
    {
      PatientWAT aPatientWAT = patientWATs.get(i - 1);
      aPatientWAT.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "patientGender" + ":" + getPatientGender()+ "," +
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalWAT = "+(getHospitalWAT()!=null?Integer.toHexString(System.identityHashCode(getHospitalWAT())):"null");
  }
}