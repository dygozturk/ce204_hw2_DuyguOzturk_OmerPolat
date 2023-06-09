package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 79 "model.ump"
public class Examination
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Examination Associations
  private PatientTreatment patientTreatment;
  private DoctorTreatment doctorTreatment;
  private List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  
  /**
   * 
   * @param aPatientTreatment
   * @param aDoctorTreatment
   */

  public Examination(PatientTreatment aPatientTreatment, DoctorTreatment aDoctorTreatment)
  {
    boolean didAddPatientTreatment = setPatientTreatment(aPatientTreatment);
    if (!didAddPatientTreatment)
    {
      throw new RuntimeException("Unable to create examination due to patientTreatment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddDoctorTreatment = setDoctorTreatment(aDoctorTreatment);
    if (!didAddDoctorTreatment)
    {
      throw new RuntimeException("Unable to create examination due to doctorTreatment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    diagnosis = new ArrayList<Diagnosis>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  /**
   * These methods are getters and helpers for accessing the instance variables of the Examination class related to the Diagnosis, PatientTreatment, and DoctorTreatment objects.
   * */
  public PatientTreatment getPatientTreatment()
  {
    return patientTreatment;
  }
  /* Code from template association_GetOne */
  public DoctorTreatment getDoctorTreatment()
  {
    return doctorTreatment;
  }
  /* Code from template association_GetMany */
  public Diagnosis getDiagnosi(int index)
  {
    Diagnosis aDiagnosi = diagnosis.get(index);
    return aDiagnosi;
  }

  public List<Diagnosis> getDiagnosis()
  {
    List<Diagnosis> newDiagnosis = Collections.unmodifiableList(diagnosis);
    return newDiagnosis;
  }

  public int numberOfDiagnosis()
  {
    int number = diagnosis.size();
    return number;
  }

  public boolean hasDiagnosis()
  {
    boolean has = diagnosis.size() > 0;
    return has;
  }

  public int indexOfDiagnosi(Diagnosis aDiagnosi)
  {
    int index = diagnosis.indexOf(aDiagnosi);
    return index;
  }
  /* Code from template association_SetOneToMany */
  /**
   * These methods set the patientTreatment and doctorTreatment fields of an Examination object and manage the associations between Examination and PatientTreatment/DoctorTreatment objects.
   * */
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
      existingPatientTreatment.removeExamination(this);
    }
    patientTreatment.addExamination(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasSet = false;
    if (aDoctorTreatment == null)
    {
      return wasSet;
    }

    DoctorTreatment existingDoctorTreatment = doctorTreatment;
    doctorTreatment = aDoctorTreatment;
    if (existingDoctorTreatment != null && !existingDoctorTreatment.equals(aDoctorTreatment))
    {
      existingDoctorTreatment.removeExamination(this);
    }
    doctorTreatment.addExamination(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDiagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * This code defines methods to add and remove diagnoses from a list of diagnoses associated with an examination.
   * */
  public boolean addDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasAdded = false;
    if (diagnosis.contains(aDiagnosi)) { return false; }
    diagnosis.add(aDiagnosi);
    if (aDiagnosi.indexOfExamination(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiagnosi.addExamination(this);
      if (!wasAdded)
      {
        diagnosis.remove(aDiagnosi);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasRemoved = false;
    if (!diagnosis.contains(aDiagnosi))
    {
      return wasRemoved;
    }

    int oldIndex = diagnosis.indexOf(aDiagnosi);
    diagnosis.remove(oldIndex);
    if (aDiagnosi.indexOfExamination(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiagnosi.removeExamination(this);
      if (!wasRemoved)
      {
        diagnosis.add(oldIndex,aDiagnosi);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * This codes contains methods for adding/moving diagnoses, deleting an examination, and manipulating the patient and doctor treatments associated with the examination.
   * */
  public boolean addDiagnosiAt(Diagnosis aDiagnosi, int index)
  {  
    boolean wasAdded = false;
    if(addDiagnosi(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDiagnosiAt(Diagnosis aDiagnosi, int index)
  {
    boolean wasAdded = false;
    if(diagnosis.contains(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDiagnosiAt(aDiagnosi, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    PatientTreatment placeholderPatientTreatment = patientTreatment;
    this.patientTreatment = null;
    if(placeholderPatientTreatment != null)
    {
      placeholderPatientTreatment.removeExamination(this);
    }
    DoctorTreatment placeholderDoctorTreatment = doctorTreatment;
    this.doctorTreatment = null;
    if(placeholderDoctorTreatment != null)
    {
      placeholderDoctorTreatment.removeExamination(this);
    }
    ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
    diagnosis.clear();
    for(Diagnosis aDiagnosi : copyOfDiagnosis)
    {
      aDiagnosi.removeExamination(this);
    }
  }

}