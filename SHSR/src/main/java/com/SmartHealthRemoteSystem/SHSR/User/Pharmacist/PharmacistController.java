package com.SmartHealthRemoteSystem.SHSR.User.Pharmacist;

import com.SmartHealthRemoteSystem.SHSR.Medicine.Medicine;
import com.SmartHealthRemoteSystem.SHSR.Service.DoctorService;
import com.SmartHealthRemoteSystem.SHSR.Service.MedicineService;
import com.SmartHealthRemoteSystem.SHSR.Service.PatientService;
import com.SmartHealthRemoteSystem.SHSR.Service.PharmacistService;
import com.SmartHealthRemoteSystem.SHSR.Service.SensorDataService;
import com.SmartHealthRemoteSystem.SHSR.User.Doctor.Doctor;
import com.SmartHealthRemoteSystem.SHSR.User.Patient.Patient;
import com.SmartHealthRemoteSystem.SHSR.WebConfiguration.MyUserDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Query.Direction;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RequestMapping("/pharmacist")
@Controller

public class PharmacistController {
    private final PharmacistService pharmacistService;

    public PharmacistController(PharmacistService pharmacistService) {
        this.pharmacistService = pharmacistService;
    }


    @GetMapping
    public String pharmacistDashboard(Model model) throws ExecutionException, InterruptedException {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
            Pharmacist pharmacist = pharmacistService.getPharmacist(myUserDetails.getUsername());
    
            model.addAttribute("pharmacist", pharmacist);
        return "PharmacistDashboard"; 
    }

    @GetMapping("/updateProfile")
    public String updateProfile(Model model) throws ExecutionException, InterruptedException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails= (MyUserDetails) auth.getPrincipal();
        Pharmacist pharmacist = pharmacistService.getPharmacist(myUserDetails.getUsername());
        model.addAttribute("pharmacist",pharmacist);
        return "updatePharmacistProfile";
    }

    @PostMapping("/updateProfile/profile")
    public String submitProfile(@ModelAttribute Pharmacist pharmacist, @RequestParam("profilePicture") MultipartFile profilePicture) throws ExecutionException, InterruptedException, IOException {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
    pharmacist.setUserId(myUserDetails.getUsername());

    if (!profilePicture.isEmpty()) {
      
        byte[] profilePictureBytes = profilePicture.getBytes();
        String base64EncodedProfilePicture = Base64.getEncoder().encodeToString(profilePictureBytes);
        pharmacist.setProfilePicture(base64EncodedProfilePicture);
    }

    pharmacistService.updatePharmacist(pharmacist);
    return "redirect:/phamacist/updateProfile";
    }  

    @GetMapping("/pharmacist/profilePicture/{userId}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getProfilePicture(@PathVariable String userId) {
        // You can customize the URL based on your application structure
        String imageUrl = "/images/profile/" + userId;

        Map<String, String> responseData = new HashMap<>();
        responseData.put("profilePictureUrl", imageUrl);

        return ResponseEntity.ok(responseData);
    }

    

    @GetMapping("/viewMedicineList")
    public String viewMedicineList(Model model) {
        try {
            List<Medicine> medicineList = pharmacistService.getListMedicine();
            model.addAttribute("medicineList", medicineList);
            return "viewMedicineList";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/editMedicine/{medId}")
    public String editMedicine(@PathVariable String medId, Model model) {
        try {
            Medicine medicine = pharmacistService.getMedicine(medId);
            model.addAttribute("medicine", medicine);
            return "editMedicine";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/updateMedicine/{medId}")
    public String updateMedicine(@PathVariable String medId, @ModelAttribute Medicine updatedMedicine) {
        try {
            Medicine existingMedicine = pharmacistService.getMedicine(medId);
            existingMedicine.setMedName(updatedMedicine.getMedName());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            pharmacistService.updateMedicine(existingMedicine);
            return "redirect:/pharmacist/viewMedicineList";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/deleteMedicine/{medId}")
    public String deleteMedicine(@PathVariable String medId) {
        try {
            pharmacistService.deleteMedicine(medId);
            return "redirect:/pharmacist/viewMedicineList";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
    

    /*@PostMapping("/updateProfile/profile")
    public String submitProfile(@ModelAttribute Pharmacist pharmacist, @RequestParam("profilePicture") MultipartFile profilePicture) throws ExecutionException, InterruptedException, IOException {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
    pharmacist.setUserId(myUserDetails.getUsername());

    if (!profilePicture.isEmpty()) {
      
        byte[] profilePictureBytes = profilePicture.getBytes();
        String base64EncodedProfilePicture = Base64.getEncoder().encodeToString(profilePictureBytes);
        pharmacist.setProfilePicture(base64EncodedProfilePicture);
    }

    pharmacistService.updatePharmacist(pharmacist);
    return "redirect:/pharmacist/updateProfile";
}

@GetMapping("/pharmacist/profilePicture")
@ResponseBody
public ResponseEntity<Map<String, String>> getProfilePicture() {
    // Retrieve the profile picture data (base64-encoded string)
    // You might want to replace this with your actual logic to get the profile picture data
    String profilePictureData = "base64-encoded-image-data"; 

    Map<String, String> responseData = new HashMap<>();
    responseData.put("profilePicture", profilePictureData);

    return ResponseEntity.ok(responseData);
}*/
    

