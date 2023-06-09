package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;
import java.sql.Date;
import java.util.*;

// line 31 "model.ump"
// line 79 "model.ump"
public class PatientWAT extends Patient
{

	public PatientWAT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
            Date aBirthDate, String aHomeAddress, String aPhone, String aGender, String aId, Date aBirthdate2, int aAge,
            Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs,Ward aWard, Team aTeam) {
        super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aId, aBirthdate2,
                aAge, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs);
        sickness = aSickness;
        prescriptions = aPrescriptions;
        allergies = aAllergies;
        specialReqs = aSpecialReqs;
        ward = aWard;
        doctorWATs = new ArrayList<DoctorWAT>();
        team = aTeam;
    }


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientWAT Attributes
  private String id;
  private String gender;
  private int age;
  private Date accepted;
  private String sickness;
  private String prescriptions;
  private String allergies;
  private String specialReqs;

  //PatientWAT Associations
  private Ward ward;
  private List<DoctorWAT> doctorWATs;
  private Team team;



  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
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

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccepted(Date aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }

  public boolean setSickness(String aSickness)
  {
    boolean wasSet = false;
    sickness = aSickness;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrescriptions(String aPrescriptions)
  {
    boolean wasSet = false;
    prescriptions = aPrescriptions;
    wasSet = true;
    return wasSet;
  }

  public boolean setAllergies(String aAllergies)
  {
    boolean wasSet = false;
    allergies = aAllergies;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpecialReqs(String aSpecialReqs)
  {
    boolean wasSet = false;
    specialReqs = aSpecialReqs;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getGender()
  {
    return gender;
  }

  public int getAge()
  {
    return age;
  }

  public Date getAccepted()
  {
    return accepted;
  }

  public String getSickness()
  {
    return sickness;
  }

  public String getPrescriptions()
  {
    return prescriptions;
  }

  public String getAllergies()
  {
    return allergies;
  }

  public String getSpecialReqs()
  {
    return specialReqs;
  }
  /* Code from template association_GetOne */
  public Ward getWard()
  {
    return ward;
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
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }
  /* Code from template association_GetOne_relatedSpecialization */
  public ConsultantDoctor getConsultantDoctor_OneConsultantDoctor()
  {
    return (ConsultantDoctor)ConsultantDoctor.get(0);
  } 
  /* Code from template association_SetOneToMany */
  public boolean setWard(Ward aWard)
  {
    boolean wasSet = false;
    if (aWard == null)
    {
      return wasSet;
    }

    Ward existingWard = ward;
    ward = aWard;
    if (existingWard != null && !existingWard.equals(aWard))
    {
      existingWard.removePatientWAT(this);
    }
    ward.addPatientWAT(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorWATs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorWAT(DoctorWAT aDoctorWAT)
  {
    boolean wasAdded = false;
    if (doctorWATs.contains(aDoctorWAT)) { return false; }
    doctorWATs.add(aDoctorWAT);
    if (aDoctorWAT.indexOfPatientWAT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorWAT.addPatientWAT(this);
      if (!wasAdded)
      {
        doctorWATs.remove(aDoctorWAT);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorWAT(DoctorWAT aDoctorWAT)
  {
    boolean wasRemoved = false;
    if (!doctorWATs.contains(aDoctorWAT))
    {
      return wasRemoved;
    }

    int oldIndex = doctorWATs.indexOf(aDoctorWAT);
    doctorWATs.remove(oldIndex);
    if (aDoctorWAT.indexOfPatientWAT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorWAT.removePatientWAT(this);
      if (!wasRemoved)
      {
        doctorWATs.add(oldIndex,aDoctorWAT);
      }
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
  /* Code from template association_SetOneToMany */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    if (aTeam == null)
    {
      return wasSet;
    }

    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removePatientWAT(this);
    }
    team.addPatientWAT(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_SetOneToMany_relatedSpecialization */
  

  public void delete()
  {
    Ward placeholderWard = ward;
    this.ward = null;
    if(placeholderWard != null)
    {
      placeholderWard.removePatientWAT(this);
    }
    ArrayList<DoctorWAT> copyOfDoctorWATs = new ArrayList<DoctorWAT>(doctorWATs);
    doctorWATs.clear();
    for(DoctorWAT aDoctorWAT : copyOfDoctorWATs)
    {
      aDoctorWAT.removePatientWAT(this);
    }
    Team placeholderTeam = team;
    this.team = null;
    if(placeholderTeam != null)
    {
      placeholderTeam.removePatientWAT(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "gender" + ":" + getGender()+ "," +
            "age" + ":" + getAge()+ "," +
            "sickness" + ":" + getSickness()+ "," +
            "prescriptions" + ":" + getPrescriptions()+ "," +
            "allergies" + ":" + getAllergies()+ "," +
            "specialReqs" + ":" + getSpecialReqs()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accepted" + "=" + (getAccepted() != null ? !getAccepted().equals(this)  ? getAccepted().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ward = "+(getWard()!=null?Integer.toHexString(System.identityHashCode(getWard())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null") + System.getProperties().getProperty("line.separator") ;
  }
}