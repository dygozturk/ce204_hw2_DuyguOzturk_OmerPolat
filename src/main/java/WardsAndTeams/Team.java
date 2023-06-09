package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 9 "model.ump"
// line 69 "model.ump"
public class Team
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Team Attributes
  private String name;

  //Team Associations
  private HospitalWAT hospitalWAT;
  private List<DoctorWAT> doctorWATs;
  private List<PatientWAT> patientWATs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Team(String aName, HospitalWAT aHospitalWAT)
  {
    name = aName;
    boolean didAddHospitalWAT = setHospitalWAT(aHospitalWAT);
    if (!didAddHospitalWAT)
    {
      throw new RuntimeException("Unable to create team due to hospitalWAT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctorWATs = new ArrayList<DoctorWAT>();
    patientWATs = new ArrayList<PatientWAT>();
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

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public HospitalWAT getHospitalWAT()
  {
    return hospitalWAT;
  }
  /* Code from template association_GetMany */
  public DoctorWAT getDoctorWAT(int index)
  {
    DoctorWAT aDoctorWAT = doctorWATs.get(index);
    return aDoctorWAT;
  }

  public List<DoctorWAT> getDoctorWATs()
  {
    List<DoctorWAT> newDoctorWATs = Collections.unmodifiableList(doctorWATs);
    return newDoctorWATs;
  }

  public int numberOfDoctorWATs()
  {
    int number = doctorWATs.size();
    return number;
  }

  public boolean hasDoctorWATs()
  {
    boolean has = doctorWATs.size() > 0;
    return has;
  }

  public int indexOfDoctorWAT(DoctorWAT aDoctorWAT)
  {
    int index = doctorWATs.indexOf(aDoctorWAT);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_doctorWATs()
  {
    doctorWATs.clear();
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
  /* Code from template association_GetOne_relatedSpecialization */
  public ConsultantDoctor getConsultantDoctor_OneConsultantDoctor()
  {
    return (ConsultantDoctor)ConsultantDoctor.get(0);
  } 
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setHospitalWAT(HospitalWAT aHospitalWAT)
  {
    boolean wasSet = false;
    //Must provide hospitalWAT to team
    if (aHospitalWAT == null)
    {
      return wasSet;
    }

    if (hospitalWAT != null && hospitalWAT.numberOfTeams() <= HospitalWAT.minimumNumberOfTeams())
    {
      return wasSet;
    }

    HospitalWAT existingHospitalWAT = hospitalWAT;
    hospitalWAT = aHospitalWAT;
    if (existingHospitalWAT != null && !existingHospitalWAT.equals(aHospitalWAT))
    {
      boolean didRemove = existingHospitalWAT.removeTeam(this);
      if (!didRemove)
      {
        hospitalWAT = existingHospitalWAT;
        return wasSet;
      }
    }
    hospitalWAT.addTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorWATs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addDoctorWAT(DoctorWAT aDoctorWAT)
  {
    boolean wasAdded = false;
    if (doctorWATs.contains(aDoctorWAT)) { return false; }
    Team existingTeam = aDoctorWAT.getTeam();
    if (existingTeam == null)
    {
      aDoctorWAT.setTeam(this);
    }
    else if (!this.equals(existingTeam))
    {
      existingTeam.removeDoctorWAT(aDoctorWAT);
      addDoctorWAT(aDoctorWAT);
    }
    else
    {
      doctorWATs.add(aDoctorWAT);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDoctorWAT(DoctorWAT aDoctorWAT)
  {
    boolean wasRemoved = false;
    if (doctorWATs.contains(aDoctorWAT))
    {
      doctorWATs.remove(aDoctorWAT);
      aDoctorWAT.setTeam(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorWATAt(DoctorWAT aDoctorWAT, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorWAT(aDoctorWAT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWATs()) { index = numberOfDoctorWATs() - 1; }
      doctorWATs.remove(aDoctorWAT);
      doctorWATs.add(index, aDoctorWAT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorWATAt(DoctorWAT aDoctorWAT, int index)
  {
    boolean wasAdded = false;
    if(doctorWATs.contains(aDoctorWAT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWATs()) { index = numberOfDoctorWATs() - 1; }
      doctorWATs.remove(aDoctorWAT);
      doctorWATs.add(index, aDoctorWAT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorWATAt(aDoctorWAT, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientWATs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientWAT addPatientWAT(String aId, String aGender, int aAge, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Ward aWard)
  {
    return new PatientWAT(aId, aGender, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aAge, aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs, aWard, this);
  }

  public boolean addPatientWAT(PatientWAT aPatientWAT)
  {
    boolean wasAdded = false;
    if (patientWATs.contains(aPatientWAT)) { return false; }
    Team existingTeam = aPatientWAT.getTeam();
    boolean isNewTeam = existingTeam != null && !this.equals(existingTeam);
    if (isNewTeam)
    {
      aPatientWAT.setTeam(this);
    }
    else
    {
      patientWATs.add(aPatientWAT);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatientWAT(PatientWAT aPatientWAT)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatientWAT, as it must always have a team
    if (!this.equals(aPatientWAT.getTeam()))
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
  
  /* Code from template association_GetPrivate */
  private void setTeam(ConsultantDoctor aConsultantDoctor, Team aTeam)
  {
    try
    {
      java.lang.reflect.Field mentorField = aConsultantDoctor.getClass().getDeclaredField("team");
      mentorField.setAccessible(true);
      mentorField.set(aConsultantDoctor, aTeam);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aTeam to aConsultantDoctor", e);
    }
  }

  public void delete()
  {
    HospitalWAT placeholderHospitalWAT = hospitalWAT;
    this.hospitalWAT = null;
    if(placeholderHospitalWAT != null)
    {
      placeholderHospitalWAT.removeTeam(this);
    }
    while (doctorWATs.size() > 0)
    {
      DoctorWAT aDoctorWAT = doctorWATs.get(doctorWATs.size() - 1);
      aDoctorWAT.delete();
      doctorWATs.remove(aDoctorWAT);
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
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalWAT = "+(getHospitalWAT()!=null?Integer.toHexString(System.identityHashCode(getHospitalWAT())):"null") + System.getProperties().getProperty("line.separator") ;
  }
}