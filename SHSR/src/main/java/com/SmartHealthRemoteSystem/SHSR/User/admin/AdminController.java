package com.SmartHealthRemoteSystem.SHSR.User.admin;

import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;
import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
import com.SmartHealthRemoteSystem.SHSR.User.Pharmacist.Pharmacist;
import com.SmartHealthRemoteSystem.SHSR.Service.DoctorService;
import com.SmartHealthRemoteSystem.SHSR.Service.PatientService;
import com.SmartHealthRemoteSystem.SHSR.Service.PharmacistService;
import com.SmartHealthRemoteSystem.SHSR.Service.UserService;
import com.SmartHealthRemoteSystem.SHSR.User.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final PharmacistService pharmacistService;

    public AdminController(UserService userService, PatientService patientService, DoctorService doctorService, PharmacistService pharmacistsService) {
        this.userService = userService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.pharmacistService = pharmacistsService;
    }

    @GetMapping
    public String getAdminDashboard(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo
    ) throws ExecutionException, InterruptedException {
        List<User> adminList = userService.getAdminList();
        List<Patient> patientList = patientService.getPatientList();
        List<Doctor> doctorList = doctorService.getListDoctor();
        List<Pharmacist> pharmacistList = pharmacistService.getListPharmacist();

        // Set Pagination details for each list
        PaginationInfo patientPagination = getPaginationInfo(patientList, pageNo);
        PaginationInfo adminPagination = getPaginationInfo(adminList, pageNo);
        PaginationInfo doctorPagination = getPaginationInfo(doctorList, pageNo);

        // Add data and pagination details to the model
   
        model.addAttribute("patientList", patientPagination.getDataToDisplay());
        model.addAttribute("patientPagination", patientPagination);
        model.addAttribute("adminList", adminPagination.getDataToDisplay());
        model.addAttribute("adminPagination", adminPagination);
        model.addAttribute("doctorList", doctorPagination.getDataToDisplay());
        model.addAttribute("doctorPagination", doctorPagination);    
        model.addAttribute("pharmacistList", pharmacistList);
        
        return "adminDashboard";
    }
    
    @GetMapping("/search/patients")
    public String searchPatients(@RequestParam String query, Model model) throws ExecutionException, InterruptedException {
    List<Patient> patientList = patientService.searchPatients(query);
    PaginationInfo patientPagination = getPaginationInfo(patientList, 1);

    model.addAttribute("patientList", patientPagination.getDataToDisplay());
    model.addAttribute("patientPagination", patientPagination);

    return "adminDashboard :: patientTable"; // Return only the patientTable fragment
}

// @GetMapping("/search/admins")
// public String searchAdmins(@RequestParam String query, Model model) throws ExecutionException, InterruptedException {
//     List<User> adminList = userService.searchUsers(query);
//     PaginationInfo adminPagination = getPaginationInfo(adminList, 1);

//     model.addAttribute("adminList", adminPagination.getDataToDisplay());
//     model.addAttribute("adminPagination", adminPagination);

//     return "adminDashboard :: adminTable"; // Return only the adminTable
// }

// @GetMapping("/search/doctors")
// public String searchDoctors(@RequestParam String query, Model model) throws ExecutionException, InterruptedException {
//     List<Doctor> doctorList = doctorService.searchDoctors(query);
//     PaginationInfo doctorPagination = getPaginationInfo(doctorList, 1);

//     model.addAttribute("doctorList", doctorPagination.getDataToDisplay());
//     model.addAttribute("doctorPagination", doctorPagination);

//     return "adminDashboard :: doctorTable"; // Return only the doctorTable
// }

    @PostMapping("/adduser")
    public String saveUserInformation(@RequestParam(value = "userId") String id,
                                      @RequestParam(value = "userFullName") String name,
                                      @RequestParam(value = "userPassword") String password,
                                      @RequestParam(value = "userEmail") String email,
                                      @RequestParam(value = "contact") String contact,
                                      @RequestParam(value = "role") String role,
                                      @RequestParam(value = "address") String patientAddress,
                                      @RequestParam(value = "emergencyContact") String emergencyContact,
                                      @RequestParam(value = "doctorHospital") String doctorHospital,
                                      @RequestParam(value = "doctorPosition") String doctorPosition,
                                      @RequestParam(value = "pharmacistHospital") String pharmacistHospital,
                                      @RequestParam(value = "pharmacistPosition") String pharmacistPosition,
                                      @RequestParam(value="sensorId")String sensorId,
                                      @RequestParam(value = "action") String action,
                                      Model model) throws ExecutionException, InterruptedException {
       
        String Message;
        if(action.equals("add")){
            if(role.equals("PATIENT")){
                Message =  patientService.createPatient(new Patient(id,name,password,contact,role,email,"",patientAddress,emergencyContact,"","Under Surveillance"));
            } else if(role.equals("DOCTOR")){
                Message = doctorService.createDoctor(new Doctor(id,name,password,contact,role,email, doctorHospital, doctorPosition));
            } else if(role.equals("PHARMACIST")){
                Message = pharmacistService.createPharmacist(new Pharmacist(id,name,password,contact,role,email, pharmacistHospital, pharmacistPosition));
            } else {
                Message =userService.createUser(new User(id,name,password,contact,role,email));
            }
        }else{
            User user = new User(id,name,password,contact,role);
            if(role.equals("PATIENT")){
                Patient patient = new Patient(id,name,password,contact,role, email,patientAddress,emergencyContact,sensorId);
                Message = patientService.updatePatient(patient);
            } else if(role.equals("DOCTOR")){
                Message = doctorService.updateDoctor(new Doctor(id,name,password,contact,role, email, doctorHospital, doctorPosition));
            } else if(role.equals("PHARMACIST")){
                Message = pharmacistService.updatePharmacist(new Pharmacist(id,name,password,contact,role, email, pharmacistHospital, pharmacistPosition));
            } else {
                Message = userService.updateUser(new User(id,name,password,contact,role));
            }
        }
        
        //get current timestamp for lastupdate
        Date timestamp = new Date();

        // Format the timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM dd yyyy HH:mm");
        String formattedTimestamp = dateFormat.format(timestamp);

        // Set timestamp as message too
        Message += " at " + formattedTimestamp;

        List<User> adminList = userService.getAdminList();
        List<Patient> patientList = patientService.getPatientList();
        List<Doctor> doctorList = doctorService.getListDoctor();
        List<Pharmacist> pharmacistList = pharmacistService.getListPharmacist();
        model.addAttribute("message", Message);
        model.addAttribute("adminList", adminList);
        model.addAttribute("patientList", patientList);
        model.addAttribute("doctorList", doctorList);
        model.addAttribute("pharmacistList", pharmacistList);
        return "adminDashboard";
    }

    @DeleteMapping("/deleteuser")
    public String deleteSelectedUser(@RequestParam("userIdToBeDelete") String userId,
                                     @RequestParam("userRoleToBeDelete") String role,
                                     Model model) throws ExecutionException, InterruptedException {
        String message;
        if(role.equals("PATIENT")){
            System.out.println(userId);
            message = patientService.deletePatient(userId);
        } else if(role.equals("DOCTOR")){
            message = doctorService.deleteDoctor(userId);
        } else if(role.equals("PHARMACIST")){
            message = pharmacistService.deletePharmacist(userId);
        }else {
            message = userService.deleteUser(userId);
        }

         //get current timestamp for lastupdate
        Date timestamp = new Date();

        // Format the timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM dd yyyy HH:mm");
        String formattedTimestamp = dateFormat.format(timestamp);

        // Set timestamp as message too
        message += " at " + formattedTimestamp;

        List<User> adminList = userService.getAdminList();
        List<Patient> patientList = patientService.getPatientList();
        List<Doctor> doctorList = doctorService.getListDoctor();
        List<Pharmacist> pharmacistList = pharmacistService.getListPharmacist();
        model.addAttribute("message", message);
        model.addAttribute("adminList", adminList);
        model.addAttribute("patientList", patientList);
        model.addAttribute("doctorList", doctorList);
        model.addAttribute("pharmacistList", pharmacistList);
        return "adminDashboard";
    }

    private PaginationInfo getPaginationInfo(List<?> dataList, int pageNo){
        int pageSize = 5;
        int totalItems = dataList.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
    
        // Adjust pageNo to be within valid bounds
        pageNo = Math.max(1, Math.min(pageNo, totalPages));
    
        int start = (pageNo - 1) * pageSize;
        int end = Math.min(start + pageSize, totalItems);
    
        List<?> dataToDisplay = dataList.subList(start, end);
    
        int prevPage = Math.max(1, pageNo - 1);
        int nextPage = Math.min(totalPages, pageNo + 1);
    
        return new PaginationInfo(dataToDisplay, pageSize, pageNo, totalPages, prevPage, nextPage);
    }
}
