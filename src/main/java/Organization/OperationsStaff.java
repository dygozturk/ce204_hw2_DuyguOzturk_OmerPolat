package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 60 "model.ump"
// line 152 "model.ump"
public class OperationsStaff extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OperationsStaff Associations
  private List<Patient> patients;

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
   */

  public OperationsStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthDate, String aHomeAddress, String aPhone, String aGender, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aJoined, aEducation, aCertification, aLanguages, aDepartment);
    patients = new ArrayList<Patient>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  /**
   * These methods provide access to the list of patients associated 
   * with an operations staff, including retrieving a patient at a specific index, 
   * getting a list of all patients, getting the number of patients, 
   * checking if there are any patients, and finding the index of a specific patient in the list.
   */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * This code adds a patient to the list of patients and associates the operations staff with the patient.
   */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfOperationsStaff(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addOperationsStaff(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * This code removes a given Patient object from the list of patients associated with this OperationsStaff object.
   */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfOperationsStaff(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeOperationsStaff(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * These methods allow adding or moving a Patient object to a specific index in the patients ArrayList.
   */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  /**
   * This code deletes the current instance of OperationsStaff and removes the association between it and all its associated Patients.
   */
  public void delete()
  {
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeOperationsStaff(this);
    }
    super.delete();
  }

}