package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 22 "model.ump"
// line 84 "model.ump"
public class Diagnosis
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Diagnosis Associations
  private PatientTreatment patientTreatment;
  private List<DoctorTreatment> doctorTreatments;
  private List<Examination> examinations;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  /**
   * 
   * @param aPatientTreatment
   */

  public Diagnosis(PatientTreatment aPatientTreatment)
  {
    boolean didAddPatientTreatment = setPatientTreatment(aPatientTreatment);
    if (!didAddPatientTreatment)
    {
      throw new RuntimeException("Unable to create diagnosi due to patientTreatment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctorTreatments = new ArrayList<DoctorTreatment>();
    examinations = new ArrayList<Examination>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public PatientTreatment getPatientTreatment()
  {
    return patientTreatment;
  }
  /* Code from template association_GetMany */
  /**
   * These methods provide basic access and information retrieval functionalities for the doctorTreatments attribute of the Diagnosi class, 
   * including getting a specific DoctorTreatment object by index, getting a list of all DoctorTreatment objects, checking if there are any 
   * DoctorTreatment objects, and getting the index of a specific DoctorTreatment object in the list.
   */
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
  /* Code from template association_GetMany */
  /**
   * These methods are related to managing the list of examinations associated with the diagnosis, including getting a specific examination,
   * getting all examinations, checking the number and presence of examinations, and finding the index of a specific examination in the list.
   */
  public Examination getExamination(int index)
  {
    Examination aExamination = examinations.get(index);
    return aExamination;
  }

  public List<Examination> getExaminations()
  {
    List<Examination> newExaminations = Collections.unmodifiableList(examinations);
    return newExaminations;
  }

  public int numberOfExaminations()
  {
    int number = examinations.size();
    return number;
  }

  public boolean hasExaminations()
  {
    boolean has = examinations.size() > 0;
    return has;
  }

  public int indexOfExamination(Examination aExamination)
  {
    int index = examinations.indexOf(aExamination);
    return index;
  }
  /* Code from template association_SetOneToMany */
  /** 
   * This method sets the patient treatment for a diagnosis and updates the associations between them.
   */
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
      existingPatientTreatment.removeDiagnosi(this);
    }
    patientTreatment.addDiagnosi(this);
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
   * This code adds a DoctorTreatment to the list of DoctorTreatments associated with a Diagnosi and returns a boolean indicating whether the addition was successful. 
   * If the DoctorTreatment is already in the list, it returns false. If the DoctorTreatment was added successfully, it also adds the Diagnosi to the DoctorTreatment's 
   * list of associated Diagnosies. If the DoctorTreatment was not added successfully, it removes the DoctorTreatment from the list.
   */
  public boolean addDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasAdded = false;
    if (doctorTreatments.contains(aDoctorTreatment)) { return false; }
    doctorTreatments.add(aDoctorTreatment);
    if (aDoctorTreatment.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTreatment.addDiagnosi(this);
      if (!wasAdded)
      {
        doctorTreatments.remove(aDoctorTreatment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * This code removes a given DoctorTreatment from the list of doctor treatments for this Diagnosi,
   * while also ensuring that the DoctorTreatment is no longer associated with this Diagnosi.
   */
  public boolean removeDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasRemoved = false;
    if (!doctorTreatments.contains(aDoctorTreatment))
    {
      return wasRemoved;
    }

    int oldIndex = doctorTreatments.indexOf(aDoctorTreatment);
    doctorTreatments.remove(oldIndex);
    if (aDoctorTreatment.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTreatment.removeDiagnosi(this);
      if (!wasRemoved)
      {
        doctorTreatments.add(oldIndex,aDoctorTreatment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExaminations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * This code adds a new Examination object to the list of examinations associated with a Diagnosi object,
   * while ensuring that the association is updated on both ends.
   */
  public boolean addExamination(Examination aExamination)
  {
    boolean wasAdded = false;
    if (examinations.contains(aExamination)) { return false; }
    examinations.add(aExamination);
    if (aExamination.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aExamination.addDiagnosi(this);
      if (!wasAdded)
      {
        examinations.remove(aExamination);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * his method removes an Examination object from the list of examinations of a Diagnosi object and checks if it was successfully removed.
   */
  public boolean removeExamination(Examination aExamination)
  {
    boolean wasRemoved = false;
    if (!examinations.contains(aExamination))
    {
      return wasRemoved;
    }

    int oldIndex = examinations.indexOf(aExamination);
    examinations.remove(oldIndex);
    if (aExamination.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aExamination.removeDiagnosi(this);
      if (!wasRemoved)
      {
        examinations.add(oldIndex,aExamination);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addExaminationAt(Examination aExamination, int index)
  {  
    boolean wasAdded = false;
    if(addExamination(aExamination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExaminations()) { index = numberOfExaminations() - 1; }
      examinations.remove(aExamination);
      examinations.add(index, aExamination);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExaminationAt(Examination aExamination, int index)
  {
    boolean wasAdded = false;
    if(examinations.contains(aExamination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExaminations()) { index = numberOfExaminations() - 1; }
      examinations.remove(aExamination);
      examinations.add(index, aExamination);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExaminationAt(aExamination, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    PatientTreatment placeholderPatientTreatment = patientTreatment;
    this.patientTreatment = null;
    if(placeholderPatientTreatment != null)
    {
      placeholderPatientTreatment.removeDiagnosi(this);
    }
    ArrayList<DoctorTreatment> copyOfDoctorTreatments = new ArrayList<DoctorTreatment>(doctorTreatments);
    doctorTreatments.clear();
    for(DoctorTreatment aDoctorTreatment : copyOfDoctorTreatments)
    {
      aDoctorTreatment.removeDiagnosi(this);
    }
    ArrayList<Examination> copyOfExaminations = new ArrayList<Examination>(examinations);
    examinations.clear();
    for(Examination aExamination : copyOfExaminations)
    {
      aExamination.removeDiagnosi(this);
    }
  }

}