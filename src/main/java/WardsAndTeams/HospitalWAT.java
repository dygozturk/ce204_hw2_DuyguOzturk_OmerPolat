package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;
import java.util.*;

// line 2 "model.ump"
// line 64 "model.ump"
public class HospitalWAT extends Hospital
{

  public HospitalWAT(String aName, String aAddress, String aPhone) {
		super(aName, aAddress, aPhone);
		// TODO Auto-generated constructor stub
		name = aName;
	    address = aAddress;
	    phone = aPhone;
	    teams = new ArrayList<Team>();
	    wards = new ArrayList<Ward>();
	}


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //HospitalWAT Attributes
  private String name;
  private String address;
  private String phone;

  //HospitalWAT Associations
  private List<Team> teams;
  private List<Ward> wards;

  //------------------------
  // CONSTRUCTOR
  //------------------------



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
  public Team getTeam(int index)
  {
    Team aTeam = teams.get(index);
    return aTeam;
  }

  public List<Team> getTeams()
  {
    List<Team> newTeams = Collections.unmodifiableList(teams);
    return newTeams;
  }

  public int numberOfTeams()
  {
    int number = teams.size();
    return number;
  }

  public boolean hasTeams()
  {
    boolean has = teams.size() > 0;
    return has;
  }

  public int indexOfTeam(Team aTeam)
  {
    int index = teams.indexOf(aTeam);
    return index;
  }
  /* Code from template association_GetMany */
  public Ward getWard(int index)
  {
    Ward aWard = wards.get(index);
    return aWard;
  }

  public List<Ward> getWards()
  {
    List<Ward> newWards = Collections.unmodifiableList(wards);
    return newWards;
  }

  public int numberOfWards()
  {
    int number = wards.size();
    return number;
  }

  public boolean hasWards()
  {
    boolean has = wards.size() > 0;
    return has;
  }

  public int indexOfWard(Ward aWard)
  {
    int index = wards.indexOf(aWard);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTeamsValid()
  {
    boolean isValid = numberOfTeams() >= minimumNumberOfTeams();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTeams()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Team addTeam(String aName)
  {
    Team aNewTeam = new Team(aName, this);
    return aNewTeam;
  }

  public boolean addTeam(Team aTeam)
  {
    boolean wasAdded = false;
    if (teams.contains(aTeam)) { return false; }
    HospitalWAT existingHospitalWAT = aTeam.getHospitalWAT();
    boolean isNewHospitalWAT = existingHospitalWAT != null && !this.equals(existingHospitalWAT);

    if (isNewHospitalWAT && existingHospitalWAT.numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasAdded;
    }
    if (isNewHospitalWAT)
    {
      aTeam.setHospitalWAT(this);
    }
    else
    {
      teams.add(aTeam);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTeam(Team aTeam)
  {
    boolean wasRemoved = false;
    //Unable to remove aTeam, as it must always have a hospitalWAT
    if (this.equals(aTeam.getHospitalWAT()))
    {
      return wasRemoved;
    }

    //hospitalWAT already at minimum (1)
    if (numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasRemoved;
    }

    teams.remove(aTeam);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTeamAt(Team aTeam, int index)
  {  
    boolean wasAdded = false;
    if(addTeam(aTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTeams()) { index = numberOfTeams() - 1; }
      teams.remove(aTeam);
      teams.add(index, aTeam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTeamAt(Team aTeam, int index)
  {
    boolean wasAdded = false;
    if(teams.contains(aTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTeams()) { index = numberOfTeams() - 1; }
      teams.remove(aTeam);
      teams.add(index, aTeam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTeamAt(aTeam, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWards()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ward addWard(String aName, String aPatientGender, int aCapacity)
  {
    return new Ward(aName, aPatientGender, aCapacity, this);
  }

  public boolean addWard(Ward aWard)
  {
    boolean wasAdded = false;
    if (wards.contains(aWard)) { return false; }
    HospitalWAT existingHospitalWAT = aWard.getHospitalWAT();
    boolean isNewHospitalWAT = existingHospitalWAT != null && !this.equals(existingHospitalWAT);
    if (isNewHospitalWAT)
    {
      aWard.setHospitalWAT(this);
    }
    else
    {
      wards.add(aWard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWard(Ward aWard)
  {
    boolean wasRemoved = false;
    //Unable to remove aWard, as it must always have a hospitalWAT
    if (!this.equals(aWard.getHospitalWAT()))
    {
      wards.remove(aWard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWardAt(Ward aWard, int index)
  {  
    boolean wasAdded = false;
    if(addWard(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWardAt(Ward aWard, int index)
  {
    boolean wasAdded = false;
    if(wards.contains(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWardAt(aWard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (teams.size() > 0)
    {
      Team aTeam = teams.get(teams.size() - 1);
      aTeam.delete();
      teams.remove(aTeam);
    }
    
    while (wards.size() > 0)
    {
      Ward aWard = wards.get(wards.size() - 1);
      aWard.delete();
      wards.remove(aWard);
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