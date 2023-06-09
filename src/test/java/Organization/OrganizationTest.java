package Organization;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;

public class OrganizationTest {

	// ************************************ Hospital ******************************
			// Hospital Name test
			@Test
		    public void HospitalNameTest() {
		        Hospital hospital = new Hospital("medikal","kadikoy","02162162116");
		        assertEquals("medikal",hospital.getName());
		    }
			
			// Hospital Address Test
			@Test
		    public void HospitalAddressTest() {
		        Hospital hospital = new Hospital("medikal","kadikoy","02162162116");
		        assertEquals("kadikoy",hospital.getAddress());
		    }
			
			
			// Hospital Phone Test	
			@Test
			public void HospitalPhoneTest() {
			     Hospital hospital = new Hospital("medikal","kadikoy","02162162116");
			     assertEquals("02162162116", hospital.getPhone());
			 }
			
			
			@Test
			public void PersonTest_title() {
			     Person Person = new Person("Intern", "Ahmet", "Mehmet", "Yılmaz", "Ahmet", new Date(0), "Istanbul", "565 455 55 55", "Erkek");
			     assertEquals("Ahmet", Person.getGivenName());
			 }
			
	    
		        
		        
			// ************************************ Staff ****************************** 
				
			@Test
		    public void StaffTest1() {
				Hospital hospital = new Hospital(null, null, null);
		        Staff staff = new Staff("Dr.", "Kazım", "", "Kurtuluş", "Kazım Kurtuluş", null, "Mamak - Ankara", "1234567890", null, null, "doctor's degree", "Certification", "Spanish", new Department(hospital));
		        Date joined = null;
		        staff.setJoined(null);
		        assertEquals(staff.getJoined(), joined);
		    }
			
			@Test
		    public void StaffTest2() {
				Hospital hospital = new Hospital(null, null, null);
		        Staff staff = new Staff("Prof", "Hasan", "", "Ak", "Hasan Ak", null, "Pazar - Rize", "1234567890", null, null, "bachelor's Degree", "Certification", "Turkish", new Department(hospital));
		        assertEquals("Certification",staff.getCertification());
		        
		    }
			
			@Test
		    public void StaffTest3() {
				Hospital hospital = new Hospital(null, null, null);
				Person person = new Person("Doç.", "Doğukan", "", "Erzurum", "Doğukan Erzurum", null, "Merkez - Ordu", "1234567890", null);
		        Staff staff = new Staff("Doç.", "Doğukan", "", "Erzurum", "Doğukan Erzurum", null, "Merkez - Ordu", "1234567890", null, null, "Bachelor's Degree", "Certification", "French", new Department(hospital));
		        String Expected = person.toString() + "["+
		                "education" + ":" + staff.getEducation()+ "," +
		                "certification" + ":" + staff.getCertification()+ "," +
		                "languages" + ":" + staff.getLanguages()+ "]" + System.getProperties().getProperty("line.separator") +
		                "  " + "joined" + "=" + (staff.getJoined() != null ? !staff.getJoined().equals(this)  ? staff.getJoined().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
		                "  " + "department = "+(staff.getDepartment()!=null?Integer.toHexString(System.identityHashCode(staff.getDepartment())):"null");
		        assertNotEquals(Expected,staff.toString());
		        }

		        private Staff staff;

		        @Before
		        public void StaffBefore() throws Exception {
		        	Hospital hospital = new Hospital(null, null, null);
		        	Department department = new Department(hospital);
		            staff = new Staff("Mr.", "Can", "", "Yılmaz", "Can Yılmaz", Date.valueOf("1990-01-01"), "Kadikoy - Istanbul", "555-1234", "Male", Date.valueOf("2023-04-01"), "Bachelor of Science in Nursing", "Registered Nurse", "English, Spanish", department);
		        }
		        
		        
		        //Check the update 
		        
		        @Test
		        public void StafftestSetJoined() {
		            Date newDate = Date.valueOf("2022-03-01");
		            assertTrue(staff.setJoined(newDate));
		            assertEquals(newDate, staff.getJoined());
		        }

		        @Test
		        public void StafftestSetEducation() {
		            String newEducation = "Master of Science in Nursing";
		            assertTrue(staff.setEducation(newEducation));
		            assertEquals(newEducation, staff.getEducation());
		        }

		        @Test
		        public void StafftestSetCertification() {
		            String newCertification = "Certified Registered Nurse Anesthetist";
		            assertTrue(staff.setCertification(newCertification));
		            assertEquals(newCertification, staff.getCertification());
		        }

		        @Test
		        public void StafftestSetLanguages() {
		            String newLanguages = "English, Spanish, French";
		            assertTrue(staff.setLanguages(newLanguages));
		            assertEquals(newLanguages, staff.getLanguages());
		        }

		        @Test
		        public void StafftestGetDepartment() {
		            assertNotNull(staff.getDepartment());
		        }

		        @Test
		        public void StafftestDelete() {
		            staff.delete();
		            assertNull(staff.getDepartment());
		        }
		        
		        
		        
		        
		        
		        
		        
		     // ************************************ Receptionist ****************************** 
		        
		       
		        @Test
		        public void testReceptionistConstructor() {
		            // Create a new department for testing
		        	Hospital hospital = new Hospital(null, null, null);
		            Department department = new Department(hospital);

		            Receptionist receptionist = new Receptionist("", "Leo", "Silva", "Smith", "Leo Silva Smith", null, "13 WAC St. Argentina ", "123-456-7890", "Male", null, "high school graduate", "Certified Receptionist", "English, Spanish, french, Turkish", department);

		            assertEquals("", receptionist.getTitle());
		            assertEquals("Leo", receptionist.getGivenName());
		            assertEquals("Silva", receptionist.getMiddleName());
		            assertEquals("Smith", receptionist.getFamilyName());
		            assertEquals("Leo Silva Smith", receptionist.getName());
		            assertEquals("13 WAC St. Argentina ", receptionist.getHomeAddress());
		            assertEquals("123-456-7890", receptionist.getPhone());
		            assertEquals("Male", receptionist.getGender());
		            assertEquals("high school graduate", receptionist.getEducation());
		            assertEquals("Certified Receptionist", receptionist.getCertification());
		            assertEquals("English, Spanish, french, Turkish", receptionist.getLanguages());
		            assertEquals(department, receptionist.getDepartment());
		        }
		        
		        
		        
		        
		        
		        
		        
		     // ************************************ Surgeon ****************************** 
		        
		        
		        @Test
		        public void SurgeonGetMethodsTest() {
		          String title = "Prof.";
		          String givenName = "Hakkı";
		          String middleName = "";
		          String familyName = "Altun";
		          String name = "Hakkı Altun";
		          Date birthDate = new Date(System.currentTimeMillis());
		          String homeAddress = "Kayseri Sokak 231";
		          String phone = "555-1234";
		          String gender = "Male";
		          Date joined = new Date(System.currentTimeMillis());
		          String education = "MD";
		          String certification = " ";
		          String languages = "English";
		          
		          Hospital hospital = new Hospital(null, null, null);
		          Department department = new Department(hospital);
		          String specialty = "Cardiac Surgery";
		          String locations = "Hospital A, Hospital B";

		          Surgeon surgeon = new Surgeon(title, givenName, middleName, familyName, name, birthDate, homeAddress, phone, gender, joined, education, certification, languages, department, specialty, locations);

		          assertEquals(title, surgeon.getTitle());
		          assertEquals(givenName, surgeon.getGivenName());
		          assertEquals(middleName, surgeon.getMiddleName());
		          assertEquals(familyName, surgeon.getFamilyName());
		          assertEquals(name, surgeon.getName());
		          assertEquals(birthDate, surgeon.getBirthDate());
		          assertEquals(homeAddress, surgeon.getHomeAddress());
		          assertEquals(phone, surgeon.getPhone());
		          assertEquals(gender, surgeon.getGender());
		          assertEquals(joined, surgeon.getJoined());
		          assertEquals(education, surgeon.getEducation());
		          assertEquals(certification, surgeon.getCertification());
		          assertEquals(languages, surgeon.getLanguages());
		          assertEquals(department, surgeon.getDepartment());
		          assertEquals(specialty, surgeon.getSpecialty());
		          assertEquals(locations, surgeon.getLocations());
		        }

		        
		        
		        
		        
		        // ************************************ Doctor *******************************************
		        
		        
		        Doctor doctor;

		        @Before
		        public void DoctorTestBefore() throws Exception {
		          // Create a new Doctor object for testing
		        	Hospital hospital = new Hospital(null, null, null);
		          doctor = new Doctor("Prof.", "Ayşe ", "A.", "Kiraz", "Ayşe A. Kiraz", Date.valueOf("1993-11-23"), "Edirne Sokak 323", "555-1234", "Female", Date.valueOf("2020-04-15"), "Master Degree", "Board Certified", "English", new Department(hospital), "Cardiologist", "Acıbadem");
		        }
		        
		        // Test the getSpecialty() method
		        @Test
		        public void DoctortestGetSpecialty() {
		          assertEquals("Cardiologist", doctor.getSpecialty());
		        }
		        
		        // Test the setSpecialty() method
		        @Test
		        public void DoctortestSetSpecialty() {
		          assertTrue(doctor.setSpecialty("Pediatrician"));
		          assertEquals("Pediatrician", doctor.getSpecialty());
		        }

		        @Test
		        public void DoctortestGetLocations() {
		          assertEquals("Acıbadem", doctor.getLocations());
		        }

		        @Test
		        public void DoctortestSetLocations() {
		          assertTrue(doctor.setLocations("Hospital B"));
		          assertEquals("Hospital B", doctor.getLocations());
		        }
		        
		       
		        
		        
		        
		        
		        
		        
		        
		        // **************************************** TechnicalStaff ************************************
		        
		        @Test
		        public void testTechnicalStaffConstructor() {
		          String title = "";
		          String givenName = "Ali";
		          String middleName = "";
		          String familyName = "Kaya";
		          String name = "Ali Kaya";
		          Date birthDate = null;
		          String homeAddress = "Sultanbeyli";
		          String phone = "555-5555";
		          String gender = "Male";
		          Date joined = null;
		          String education = "Computer engineering";
		          String certification = "Java SE 16 Programmer";
		          String languages = "English, Turkish";
		          Hospital hospital = new Hospital(null,null,null);
		          Department department = new Department(hospital);

		          TechnicalStaff technicalStaff = new TechnicalStaff(title, givenName, middleName, familyName, name, birthDate, homeAddress, phone, gender, joined, education, certification, languages, department);

		          assertEquals(title, technicalStaff.getTitle());
		          assertEquals(givenName, technicalStaff.getGivenName());
		          assertEquals(middleName, technicalStaff.getMiddleName());
		          assertEquals(familyName, technicalStaff.getFamilyName());
		          assertEquals(name, technicalStaff.getName());
		          assertEquals(birthDate, technicalStaff.getBirthDate());
		          assertEquals(homeAddress, technicalStaff.getHomeAddress());
		          assertEquals(phone, technicalStaff.getPhone());
		          assertEquals(gender, technicalStaff.getGender());
		          assertEquals(joined, technicalStaff.getJoined());
		          assertEquals(education, technicalStaff.getEducation());
		          assertEquals(certification, technicalStaff.getCertification());
		          assertEquals(languages, technicalStaff.getLanguages());
		          assertEquals(department, technicalStaff.getDepartment());
		        }
		        
		        
		        
		        
		        
		        
		        // ***********************************  Technician ****************************
		        
		        
		        @Test
		        public void testTechnicianConstructor() {
		            String title = "";
		            String givenName = "Ali";
		            String middleName = "";
		            String familyName = "Kaya";
		            String name = "Ali Kaya";
		            Date birthDate = null;
		            String homeAddress = "Sultanbeyli";
		            String phone = "555-5555";
		            String gender = "Male";
		            Date joined = null;
		            String education = "Computer engineering";
		            String certification = "Java SE 16 Programmer";
		            String languages = "English, Turkish";
		            Hospital hospital = new Hospital(null,null,null);
			          Department department = new Department(hospital);

		            Technician technician = new Technician(title, givenName, middleName, familyName, name, birthDate, homeAddress, phone, gender, joined, education, certification, languages, department);

		            assertEquals(title, technician.getTitle());
		            assertEquals(givenName, technician.getGivenName());
		            assertEquals(middleName, technician.getMiddleName());
		            assertEquals(familyName, technician.getFamilyName());
		            assertEquals(name, technician.getName());
		            assertEquals(birthDate, technician.getBirthDate());
		            assertEquals(homeAddress, technician.getHomeAddress());
		            assertEquals(phone, technician.getPhone());
		            assertEquals(gender, technician.getGender());
		            assertEquals(joined, technician.getJoined());
		            assertEquals(education, technician.getEducation());
		            assertEquals(certification, technician.getCertification());
		            assertEquals(languages, technician.getLanguages());
		            assertEquals(department, technician.getDepartment());
		        }
		        
		        
		        
		        
		        
		        

		        // ***********************************  Technologist ****************************
		        
		        @Test
		        public void testTechnologistConstructor() {
		            String title = "Mr.";
		            String givenName = "Omer";
		            String middleName = "";
		            String familyName = "Polat";
		            String name = "Omer Polat";
		            Date birthDate = null;
		            String homeAddress = "Istanbul";
		            String phone = "555-5555";
		            String gender = "Male";
		            Date joined = null;
		            String education = "Bachelor of Science in Computer Engineering";
		            String certification = "Java SE 16 Programmer";
		            String languages = "English, Spanish, Turkish";
		            Hospital hospital = new Hospital(null,null,null);
			        Department department = new Department(hospital);

		            Technologist technologist = new Technologist(title, givenName, middleName, familyName, name, birthDate, homeAddress, phone, gender, joined, education, certification, languages, department);

		            assertEquals(title, technologist.getTitle());
		            assertEquals(givenName, technologist.getGivenName());
		            assertEquals(middleName, technologist.getMiddleName());
		            assertEquals(familyName, technologist.getFamilyName());
		            assertEquals(name, technologist.getName());
		            assertEquals(birthDate, technologist.getBirthDate());
		            assertEquals(homeAddress, technologist.getHomeAddress());
		            assertEquals(phone, technologist.getPhone());
		            assertEquals(gender, technologist.getGender());
		            assertEquals(joined, technologist.getJoined());
		            assertEquals(education, technologist.getEducation());
		            assertEquals(certification, technologist.getCertification());
		            assertEquals(languages, technologist.getLanguages());
		            assertEquals(department, technologist.getDepartment());
		        }
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        // *************************************  Person *****************************************
		        
		        
		        private Person person;

		        @Before
		        public void PersonBefore() throws Exception {
		            person = new Person("Doç.", "Yılmaz", "Kara", "", "Yılmaz Kara", new Date(0), "Uskudar - Istanbul", "555-5555", "Male");
		        }

		        @Test
		        public void PersontestSetTitle() {
		            boolean wasSet = person.setTitle("Dr.");
		            assertTrue(wasSet);
		            assertEquals("Dr.", person.getTitle());
		        }

		        @Test
		        public void PersontestSetGivenName() {
		            boolean wasSet = person.setGivenName("Fatma");
		            assertTrue(wasSet);
		            assertEquals("Fatma", person.getGivenName());
		        }

		        @Test
		        public void PersontestSetMiddleName() {
		            boolean wasSet = person.setMiddleName("W.");
		            assertTrue(wasSet);
		            assertEquals("W.", person.getMiddleName());
		        }

		        @Test
		        public void PersontestSetFamilyName() {
		            boolean wasSet = person.setFamilyName("Sahin");
		            assertTrue(wasSet);
		            assertEquals("Sahin", person.getFamilyName());
		        }

		        @Test
		        public void PersontestSetName() {
		            boolean wasSet = person.setName("Fatma Sahin");
		            assertTrue(wasSet);
		            assertEquals("Fatma Sahin", person.getName());
		        }

		        @Test
		        public void PersontestSetBirthDate() {
		            Date newDate = new Date(0);
		            boolean wasSet = person.setBirthDate(newDate);
		            assertTrue(wasSet);
		            assertEquals(newDate, person.getBirthDate());
		        }

		        @Test
		        public void PersontestSetHomeAddress() {
		            boolean wasSet = person.setHomeAddress("Bursa");
		            assertTrue(wasSet);
		            assertEquals("Bursa", person.getHomeAddress());
		        }

		        @Test
		        public void PersontestSetPhone() {
		            boolean wasSet = person.setPhone("555-555-5555");
		            assertTrue(wasSet);
		            assertEquals("555-555-5555", person.getPhone());
		        }

		        @Test
		        public void PersontestSetGender() {
		            boolean wasSet = person.setGender("Female");
		            assertTrue(wasSet);
		            assertEquals("Female", person.getGender());
		        }

		        @Test
		        public void PersontestAddHospital() {
		            Hospital hospital = new Hospital("Ersoy Hospital", "Kurtkoy", "555-555-5555");
		            boolean wasAdded = person.addHospital(hospital);
		            assertTrue(wasAdded);
		            assertTrue(person.getHospitals().contains(hospital));
		        }

		        @Test
		        public void PersontestRemoveHospital() {
		            Hospital hospital = new Hospital("Ersoy Hospital", "Kurtkoy", "555-555-5555");
		            person.addHospital(hospital);
		            boolean wasRemoved = person.removeHospital(hospital);
		            assertTrue(wasRemoved);
		            assertFalse(person.getHospitals().contains(hospital));
		        }
		        
		        
		        private Hospital hospital1;
		        private Hospital hospital2;

		        @Before
		        public void HospitalBefore() {
		            person = new Person(null, null, null, null, null, null, null, null, null);
		            hospital1 = new Hospital(null, null, null);
		            hospital2 = new Hospital(null, null, null);
		        }

		        @Test
		        public void testGetHospitals() {
		            List<Hospital> hospitals = person.getHospitals();
		            assertNotNull(hospitals);
		            assertEquals(0, hospitals.size());
		        }

		        @Test
		        public void testAddHospital1() {
		            assertTrue(person.addHospital(hospital1));
		            assertEquals(1, person.numberOfHospitals());
		            assertTrue(person.getHospitals().contains(hospital1));
		        }

		        @Test
		        public void testRemoveHospital1() {
		            person.addHospital(hospital1);
		            assertTrue(person.removeHospital(hospital1));
		            assertEquals(0, person.numberOfHospitals());
		            assertFalse(person.getHospitals().contains(hospital1));
		        }

		        @Test
		        public void testAddHospitalAt() {
		            assertTrue(person.addHospital(hospital1));
		            assertTrue(person.addHospitalAt(hospital2, 0));
		            assertEquals(2, person.numberOfHospitals());
		            assertEquals(hospital2, person.getHospitals().get(0));
		            assertEquals(hospital1, person.getHospitals().get(1));
		        }

		        @Test
		        public void testAddOrMoveHospitalAt() {
		            assertTrue(person.addHospital(hospital1));
		            assertTrue(person.addOrMoveHospitalAt(hospital1, 0));
		            assertEquals(1, person.numberOfHospitals());
		            assertEquals(hospital1, person.getHospitals().get(0));
		            assertTrue(person.addOrMoveHospitalAt(hospital2, 0));
		            assertEquals(2, person.numberOfHospitals());
		            assertEquals(hospital2, person.getHospitals().get(0));
		            assertEquals(hospital1, person.getHospitals().get(1));
		        }

		        @Test
		        public void HospitaltestDelete() {
		            person.addHospital(hospital1);
		            person.addHospital(hospital2);
		            person.delete();
		            assertEquals(0, hospital1.numberOfPersons());
		            assertEquals(0, hospital2.numberOfPersons());
		        }
		        
		        
		        
		        

		        
		        // ********************************  Patient *******************************
		        
		        
		        
		        @Test
		        public void testPatientConstructorAndGetters() {
		          // Create a new patient
		          Patient patient = new Patient("", "Haluk", "", "Uygun", "Haluk Uygun",
		              new Date(0), "Trabzon", "555-1234", "Male", "1234567",
		              new Date(0), 22, new Date(0), "Flu", "Ibuprofen",
		              "None", "None");

		          // Check that the getters return the expected values
		          assertEquals("", patient.getTitle());
		          assertEquals("Haluk", patient.getGivenName());
		          assertEquals("", patient.getMiddleName());
		          assertEquals("Uygun", patient.getFamilyName());
		          assertEquals("Haluk Uygun", patient.getName());
		          assertEquals(new Date(0), patient.getBirthdate());
		          assertEquals("Trabzon", patient.getHomeAddress());
		          assertEquals("555-1234", patient.getPhone());
		          assertEquals("Male", patient.getGender());
		          assertEquals("1234567", patient.getId());
		          assertEquals(new Date(0), patient.getBirthdate());
		          assertEquals(22, patient.getAge());
		          assertEquals(new Date(0), patient.getAccepted());
		          assertEquals("Flu", patient.getSickness());
		          assertEquals("Ibuprofen", patient.getPrescriptions());
		          assertEquals("None", patient.getAllergies());
		          assertEquals("None", patient.getSpecialReqs());

		          // Check that the operationsStaffs list is initially empty
		          assertTrue(patient.getOperationsStaffs().isEmpty());
		        }

		        @Test
		        public void testPatientSetters() {
		          // Create a new patient
		          Patient patient = new Patient("", "Haluk", "", "Uygun", "Haluk Uygun",
			              new Date(0), "Trabzon", "555-1234", "Male", "1234567",
			              new Date(0), 22, new Date(0), "Flu", "Ibuprofen",
			              "None", "None");

		          // Use the setters to change the patient's attributes
		          assertTrue(patient.setId("12345678"));
		          assertTrue(patient.setBirthdate(new Date(0)));
		          assertTrue(patient.setAge(22));
		          assertTrue(patient.setAccepted(new Date(0)));
		          assertTrue(patient.setSickness("Cold"));
		          assertTrue(patient.setPrescriptions("Aspirin"));
		          assertTrue(patient.setAllergies("Pollen"));
		          assertTrue(patient.setSpecialReqs("Wheelchair"));

		          // Check that the getters return the new values
		          assertEquals("12345678", patient.getId());
		          assertEquals(new Date(0), patient.getBirthdate());
		          assertEquals(22, patient.getAge());
		          assertEquals(new Date(0), patient.getAccepted());
		          assertEquals("Cold", patient.getSickness());
		          assertEquals("Aspirin", patient.getPrescriptions());
		          assertEquals("Pollen", patient.getAllergies());
		          assertEquals("Wheelchair", patient.getSpecialReqs());
		        }

		        
		        
		        
		        
		        
		        
		        @Test
		        public void testAddPatient() {
		          // create an OperationsStaff object
		          OperationsStaff os = new OperationsStaff("Mr.", "John", "Doe", "Smith", "John Smith", new Date(0),
		              "123 Main Street", "123-456-7890", "Male", new Date(0), "BS", "Certified", "English", null);

		          // create a Patient object
		          Patient p = new Patient("Ms.", "Jane", "Mary", "Doe", "Jane Doe", new Date(0), "456 Main Street",
		              "987-654-3210", "Female", null, new Date(0), 0, null, "Cancer", null, null, null);

		          // add the Patient object to the OperationsStaff object
		          boolean added = os.addPatient(p);

		          // check if the Patient object was added successfully
		          assertTrue(added);
		          assertTrue(os.getPatients().contains(p));
		          assertEquals(os.numberOfPatients(), 1);
		        }

		        @Test
		        public void testRemovePatient() {
		          // create an OperationsStaff object
		          OperationsStaff os = new OperationsStaff("Mr.", "John", "Doe", "Smith", "John Smith", new Date(0),
		              "123 Main Street", "123-456-7890", "Male", new Date(0), "BS", "Certified", "English", null);

		          // create a Patient object
		          Patient p = new Patient("Ms.", "Jane", "Mary", "Doe", "Jane Doe", new Date(2001, 1, 1), "456 Main Street",
		              "987-654-3210", "Female", null, new Date(0), 0, null, "Cancer", null, null, null);

		          // add the Patient object to the OperationsStaff object
		          boolean added = os.addPatient(p);

		          // check if the Patient object was added successfully
		          assertTrue(added);
		          assertTrue(os.getPatients().contains(p));
		          assertEquals(os.numberOfPatients(), 1);

		          // remove the Patient object from the OperationsStaff object
		          boolean removed = os.removePatient(p);

		          // check if the Patient object was removed successfully
		          assertTrue(removed);
		          assertFalse(os.getPatients().contains(p));
		          assertEquals(os.numberOfPatients(), 0);
		        }
}
