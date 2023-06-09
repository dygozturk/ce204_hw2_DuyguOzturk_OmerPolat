package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 30 "model.ump"
// line 94 "model.ump"
public class Treatment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Treatment Associations
  private PatientTreatment patientTreatment;
  private List<DoctorTreatment> doctorTreatments;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  /**
   * 
   * @param aPatientTreatment
   */

  public Treatment(PatientTreatment aPatientTreatment)
  {
    boolean didAddPatientTreatment = setPatientTreatment(aPatientTreatment);
    if (!didAddPatientTreatment)
    {
      throw new RuntimeException("Unable to create treatment due to patientTreatment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctorTreatments = new ArrayList<DoctorTreatment>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  /**
   * This code provides various getter and setter methods for the PatientTreatment and DoctorTreatment associations, along with utility methods to determine the number of DoctorTreatments and their index. It also includes methods to add and remove DoctorTreatments from the list and set the PatientTreatment for the Treatment object.
   * */
  public PatientTreatment getPatientTreatment()
  {
    return patientTreatment;
  }
  /* Code from template association_GetMany */
  public DoctorTreatment getDoctorTreatment(int index)
  {
    DoctorTreatment aDoctorTreatment = doctorTreatments.get(index);
    return aDoctorTreatment;
  }

  public List<DoctorTreatment> getDoctorTreatments()
  {
    List<DoctorTreatment> newDoctorTreatments = Collections.unmodifiableList(doctorTreatments);
    return newDoctorTreatments;
  }

  public int numberOfDoctorTreatments()
  {
    int number = doctorTreatments.size();
    return number;
  }

  public boolean hasDoctorTreatments()
  {
    boolean has = doctorTreatments.size() > 0;
    return has;
  }

  public int indexOfDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    int index = doctorTreatments.indexOf(aDoctorTreatment);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatientTreatment(PatientTreatment aPatientTreatment)
  {
    boolean wasSet = false;
    if (aPatientTreatment == null)
    {
      return wasSet;
    }

    PatientTreatment existingPatientTreatment = patientTreatment;
    patientTreatment = aPatientTreatment;
    if (existingPatientTreatment != null && !existingPatientTreatment.equals(aPatientTreatment))
    {
      existingPatientTreatment.removeTreatment(this);
    }
    patientTreatment.addTreatment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorTreatments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * This code defines methods for adding and removing DoctorTreatment objects from a many-to-many association with Treatment objects.
   * */
  public boolean addDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasAdded = false;
    if (doctorTreatments.contains(aDoctorTreatment)) { return false; }
    doctorTreatments.add(aDoctorTreatment);
    if (aDoctorTreatment.indexOfTreatment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTreatment.addTreatment(this);
      if (!wasAdded)
      {
        doctorTreatments.remove(aDoctorTreatment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasRemoved = false;
    if (!doctorTreatments.contains(aDoctorTreatment))
    {
      return wasRemoved;
    }

    int oldIndex = doctorTreatments.indexOf(aDoctorTreatment);
    doctorTreatments.remove(oldIndex);
    if (aDoctorTreatment.indexOfTreatment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTreatment.removeTreatment(this);
      if (!wasRemoved)
      {
        doctorTreatments.add(oldIndex,aDoctorTreatment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * This code defines methods to add and move DoctorTreatments in a List, as well as a delete method that removes the Therapy object and its associations with DoctorTreatments and PatientTreatment.
   * */
  public boolean addDoctorTreatmentAt(DoctorTreatment aDoctorTreatment, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorTreatment(aDoctorTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTreatments()) { index = numberOfDoctorTreatments() - 1; }
      doctorTreatments.remove(aDoctorTreatment);
      doctorTreatments.add(index, aDoctorTreatment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorTreatmentAt(DoctorTreatment aDoctorTreatment, int index)
  {
    boolean wasAdded = false;
    if(doctorTreatments.contains(aDoctorTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTreatments()) { index = numberOfDoctorTreatments() - 1; }
      doctorTreatments.remove(aDoctorTreatment);
      doctorTreatments.add(index, aDoctorTreatment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorTreatmentAt(aDoctorTreatment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    PatientTreatment placeholderPatientTreatment = patientTreatment;
    this.patientTreatment = null;
    if(placeholderPatientTreatment != null)
    {
      placeholderPatientTreatment.removeTreatment(this);
    }
    ArrayList<DoctorTreatment> copyOfDoctorTreatments = new ArrayList<DoctorTreatment>(doctorTreatments);
    doctorTreatments.clear();
    for(DoctorTreatment aDoctorTreatment : copyOfDoctorTreatments)
    {
      aDoctorTreatment.removeTreatment(this);
    }
  }

}