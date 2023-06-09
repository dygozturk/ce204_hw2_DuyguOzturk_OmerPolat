package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;

import java.sql.Date;
import java.util.*;

/**
 * Hospital system - sample UML class diagram in Umple
 */
// line 4 "model.ump"
// line 62 "model.ump"
// line 69 "model.ump"
public class PatientTreatment extends Patient
{

  public PatientTreatment(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthDate, String aHomeAddress, String aPhone, String aGender, String aId, Date aBirthdate2, int aAge,
			Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthDate, aHomeAddress, aPhone, aGender, aId, aBirthdate2,
				aAge, aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs);
		// TODO Auto-generated constructor stub
		doctorTreatments = new ArrayList<DoctorTreatment>();
	    examinations = new ArrayList<Examination>();
	    diagnosis = new ArrayList<Diagnosis>();
	    prescriptions = new ArrayList<Prescription>();
	    treatments = new ArrayList<Treatment>();
	}

//------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientTreatment Associations
  private List<DoctorTreatment> doctorTreatments;
  private List<Examination> examinations;
  private List<Diagnosis> diagnosis;
  private List<Prescription> prescriptions;
  private List<Treatment> treatments;

  //------------------------
  // CONSTRUCTOR
  //------------------------



  //------------------------
  // INTERFACE
  //------------------------
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
  /* Code from template association_GetMany */
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
  /* Code from template association_GetMany */
  public Prescription getPrescription(int index)
  {
    Prescription aPrescription = prescriptions.get(index);
    return aPrescription;
  }

  public int numberOfPrescriptions()
  {
    int number = prescriptions.size();
    return number;
  }

  public boolean hasPrescriptions()
  {
    boolean has = prescriptions.size() > 0;
    return has;
  }

  public int indexOfPrescription(Prescription aPrescription)
  {
    int index = prescriptions.indexOf(aPrescription);
    return index;
  }
  /* Code from template association_GetMany */
  public Treatment getTreatment(int index)
  {
    Treatment aTreatment = treatments.get(index);
    return aTreatment;
  }

  public List<Treatment> getTreatments()
  {
    List<Treatment> newTreatments = Collections.unmodifiableList(treatments);
    return newTreatments;
  }

  public int numberOfTreatments()
  {
    int number = treatments.size();
    return number;
  }

  public boolean hasTreatments()
  {
    boolean has = treatments.size() > 0;
    return has;
  }

  public int indexOfTreatment(Treatment aTreatment)
  {
    int index = treatments.indexOf(aTreatment);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorTreatments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasAdded = false;
    if (doctorTreatments.contains(aDoctorTreatment)) { return false; }
    doctorTreatments.add(aDoctorTreatment);
    if (aDoctorTreatment.indexOfPatientTreatment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTreatment.addPatientTreatment(this);
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
    if (aDoctorTreatment.indexOfPatientTreatment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTreatment.removePatientTreatment(this);
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
  /* Code from template association_AddManyToOne */
  public Examination addExamination(DoctorTreatment aDoctorTreatment)
  {
    return new Examination(this, aDoctorTreatment);
  }

  public boolean addExamination(Examination aExamination)
  {
    boolean wasAdded = false;
    if (examinations.contains(aExamination)) { return false; }
    PatientTreatment existingPatientTreatment = aExamination.getPatientTreatment();
    boolean isNewPatientTreatment = existingPatientTreatment != null && !this.equals(existingPatientTreatment);
    if (isNewPatientTreatment)
    {
      aExamination.setPatientTreatment(this);
    }
    else
    {
      examinations.add(aExamination);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExamination(Examination aExamination)
  {
    boolean wasRemoved = false;
    //Unable to remove aExamination, as it must always have a patientTreatment
    if (!this.equals(aExamination.getPatientTreatment()))
    {
      examinations.remove(aExamination);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDiagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Diagnosis addDiagnosi()
  {
    return new Diagnosis(this);
  }

  public boolean addDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasAdded = false;
    if (diagnosis.contains(aDiagnosi)) { return false; }
    PatientTreatment existingPatientTreatment = aDiagnosi.getPatientTreatment();
    boolean isNewPatientTreatment = existingPatientTreatment != null && !this.equals(existingPatientTreatment);
    if (isNewPatientTreatment)
    {
      aDiagnosi.setPatientTreatment(this);
    }
    else
    {
      diagnosis.add(aDiagnosi);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasRemoved = false;
    //Unable to remove aDiagnosi, as it must always have a patientTreatment
    if (!this.equals(aDiagnosi.getPatientTreatment()))
    {
      diagnosis.remove(aDiagnosi);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPrescriptions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prescription addPrescription()
  {
    return new Prescription(this);
  }

  public boolean addPrescription(Prescription aPrescription)
  {
    boolean wasAdded = false;
    if (prescriptions.contains(aPrescription)) { return false; }
    PatientTreatment existingPatientTreatment = aPrescription.getPatientTreatment();
    boolean isNewPatientTreatment = existingPatientTreatment != null && !this.equals(existingPatientTreatment);
    if (isNewPatientTreatment)
    {
      aPrescription.setPatientTreatment(this);
    }
    else
    {
      prescriptions.add(aPrescription);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePrescription(Prescription aPrescription)
  {
    boolean wasRemoved = false;
    //Unable to remove aPrescription, as it must always have a patientTreatment
    if (!this.equals(aPrescription.getPatientTreatment()))
    {
      prescriptions.remove(aPrescription);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPrescriptionAt(Prescription aPrescription, int index)
  {  
    boolean wasAdded = false;
    if(addPrescription(aPrescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrescriptions()) { index = numberOfPrescriptions() - 1; }
      prescriptions.remove(aPrescription);
      prescriptions.add(index, aPrescription);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePrescriptionAt(Prescription aPrescription, int index)
  {
    boolean wasAdded = false;
    if(prescriptions.contains(aPrescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrescriptions()) { index = numberOfPrescriptions() - 1; }
      prescriptions.remove(aPrescription);
      prescriptions.add(index, aPrescription);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPrescriptionAt(aPrescription, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTreatments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Treatment addTreatment()
  {
    return new Treatment(this);
  }

  public boolean addTreatment(Treatment aTreatment)
  {
    boolean wasAdded = false;
    if (treatments.contains(aTreatment)) { return false; }
    PatientTreatment existingPatientTreatment = aTreatment.getPatientTreatment();
    boolean isNewPatientTreatment = existingPatientTreatment != null && !this.equals(existingPatientTreatment);
    if (isNewPatientTreatment)
    {
      aTreatment.setPatientTreatment(this);
    }
    else
    {
      treatments.add(aTreatment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTreatment(Treatment aTreatment)
  {
    boolean wasRemoved = false;
    //Unable to remove aTreatment, as it must always have a patientTreatment
    if (!this.equals(aTreatment.getPatientTreatment()))
    {
      treatments.remove(aTreatment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTreatmentAt(Treatment aTreatment, int index)
  {  
    boolean wasAdded = false;
    if(addTreatment(aTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreatments()) { index = numberOfTreatments() - 1; }
      treatments.remove(aTreatment);
      treatments.add(index, aTreatment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreatmentAt(Treatment aTreatment, int index)
  {
    boolean wasAdded = false;
    if(treatments.contains(aTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreatments()) { index = numberOfTreatments() - 1; }
      treatments.remove(aTreatment);
      treatments.add(index, aTreatment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreatmentAt(aTreatment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<DoctorTreatment> copyOfDoctorTreatments = new ArrayList<DoctorTreatment>(doctorTreatments);
    doctorTreatments.clear();
    for(DoctorTreatment aDoctorTreatment : copyOfDoctorTreatments)
    {
      aDoctorTreatment.removePatientTreatment(this);
    }
    for(int i=examinations.size(); i > 0; i--)
    {
      Examination aExamination = examinations.get(i - 1);
      aExamination.delete();
    }
    for(int i=diagnosis.size(); i > 0; i--)
    {
      Diagnosis aDiagnosi = diagnosis.get(i - 1);
      aDiagnosi.delete();
    }
    for(int i=prescriptions.size(); i > 0; i--)
    {
      Prescription aPrescription = prescriptions.get(i - 1);
      aPrescription.delete();
    }
    for(int i=treatments.size(); i > 0; i--)
    {
      Treatment aTreatment = treatments.get(i - 1);
      aTreatment.delete();
    }
  }

}