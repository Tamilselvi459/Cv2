package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Models.VaccinationCenter;
import com.example.VaccinationBookingSystem.Repository.VaccinationRepository;
import com.example.VaccinationBookingSystem.dto.requestdto.CenterRequestdto;
import com.example.VaccinationBookingSystem.dto.responsedto.CenterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {

    @Autowired
    VaccinationRepository vaccinationRepository;
    public CenterResponseDto addcenter(CenterRequestdto centerRequestdto) {

        VaccinationCenter center = new VaccinationCenter();
        center.setCenterName(centerRequestdto.getCenterName());
        center.setCenterType(centerRequestdto.getCenterType());
        center.setAddress(centerRequestdto.getAddress());
       VaccinationCenter ans =    vaccinationRepository.save(center);

       CenterResponseDto centerresponse = new CenterResponseDto();
       centerresponse.setAddress(ans.getAddress());
       centerresponse.setCenterType(ans.getCenterType());
       centerresponse.setCenterName(ans.getCenterName());
       return centerresponse;
    }
}
