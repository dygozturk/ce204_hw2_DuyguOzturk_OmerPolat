package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 40 "model.ump"
// line 104 "model.ump"
public class Therapy extends Treatment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Therapy Associations
  private Prescription prescription;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**
   * 
   * @param aPatientTreatment
   * @param aPrescription
   */
  public Therapy(PatientTreatment aPatientTreatment, Prescription aPrescription)
  {
    super(aPatientTreatment);
    boolean didAddPrescription = setPrescription(aPrescription);
    if (!didAddPrescription)
    {
      throw new RuntimeException("Unable to create therapy due to prescription. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  
  /**
   * This code defines methods for managing the association between Prescription and Therapy objects, including setting and getting the Prescription, 
   * deleting the Therapy object, and adding/removing associations between Prescription and Therapy objects.
   * */
  
  public Prescription getPrescription()
  {
    return prescription;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPrescription(Prescription aPrescription)
  {
    boolean wasSet = false;
    if (aPrescription == null)
    {
      return wasSet;
    }

    Prescription existingPrescription = prescription;
    prescription = aPrescription;
    if (existingPrescription != null && !existingPrescription.equals(aPrescription))
    {
      existingPrescription.removeTherapy(this);
    }
    prescription.addTherapy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Prescription placeholderPrescription = prescription;
    this.prescription = null;
    if(placeholderPrescription != null)
    {
      placeholderPrescription.removeTherapy(this);
    }
    super.delete();
  }

}