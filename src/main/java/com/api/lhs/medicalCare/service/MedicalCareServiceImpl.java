package com.api.lhs.medicalCare.service;

import com.api.lhs.medicalCare.domain.entity.MedicalCare;
import com.api.lhs.medicalCare.domain.persistence.MedicalCareRepository;
import com.api.lhs.medicalCare.domain.service.MedicalCareService;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.surveillance.domain.persistence.SurveillanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCareServiceImpl implements MedicalCareService {
    private final static String ENTITY = "MedicalCare";
    private final static String ENTITY2 = "Patient";

    @Autowired
    private MedicalCareRepository medicalCareRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<MedicalCare> getAll() {
        return medicalCareRepository.findAll();
    }

    @Override
    public MedicalCare getById(Long medicalCareId) {
        return medicalCareRepository.findById(medicalCareId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, medicalCareId));
    }

    @Override
    public List<MedicalCare> getByPatientId(Long patientId) {
        return medicalCareRepository.findByPatientId(patientId);
    }

    @Override
    public MedicalCare create(MedicalCare request, Long patientId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        request.setPatient(patient.get());
        Float postDivpre = request.getUreaPost()/request.getUreaPre();
        Double ktv = +(-1) * (Math.log((postDivpre)-(0.008*request.getHdTime()))) + (4-(3.5*postDivpre)) * (request.getUf()/request.getUreaPre());
        Float ktvFloat = ktv.floatValue();
        request.setKtv(ktvFloat);

        return medicalCareRepository.save(request);
    }

    @Override
    public MedicalCare update(Long medicalCareId, MedicalCare request) {
        return medicalCareRepository.findById(medicalCareId)
                .map(medicalCare -> medicalCareRepository.save(
                        medicalCare.withUreaPre(request.getUreaPre())
                                .withUreaPost(request.getUreaPost())
                                .withDryWeight(request.getDryWeight())
                                .withInitialWeight(request.getInitialWeight())
                                .withFinalWeight(request.getFinalWeight())
                                .withHdTime(request.getHdTime())
                                .withUf(request.getUf())
                                .withKtv(request.getKtv())
                                .withHb(request.getHb())
                                .withHto(request.getHto())
                                .withDialysisMaterial(request.getDialysisMaterial())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, medicalCareId));
    }

    @Override
    public MedicalCare delete(Long medicalCareId) {
        return medicalCareRepository.findById(medicalCareId)
                .map(medicalCare -> {
                    medicalCareRepository.delete(medicalCare);
                    return medicalCare;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, medicalCareId));
    }
}
