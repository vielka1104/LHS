package com.api.lhs.surveillance.service;

import com.api.lhs.doctor.domain.persistence.DoctorRepository;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.surveillance.domain.entity.Surveillance;
import com.api.lhs.surveillance.domain.persistence.SurveillanceRepository;
import com.api.lhs.surveillance.domain.service.SurveillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveillanceServiceImpl implements SurveillanceService {
    private final static String ENTITY = "Surveillance";
    private final static String ENTITY2 = "Patient";
    private final static String ENTITY3 = "Doctor";

    @Autowired
    private SurveillanceRepository surveillanceRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Surveillance> getAll() {
        return surveillanceRepository.findAll();
    }

    @Override
    public Surveillance getById(Long surveillanceId) {
        return surveillanceRepository.findById(surveillanceId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, surveillanceId));
    }

    @Override
    public List<Surveillance> getByPatientId(Long patientId) {
        return surveillanceRepository.findByPatientId(patientId);
    }

    @Override
    public List<Surveillance> getByDoctorId(Long doctorId) {
        return surveillanceRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Surveillance> getByPatientIdAndDoctorId(Long patientId, Long doctorId) {
        return surveillanceRepository.findByPatientIdAndDoctorId(patientId, doctorId);
    }

    @Override
    public Surveillance create(Surveillance request, Long patientId, Long doctorId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, doctorId);

        request.setPatient(patient.get());
        request.setDoctor(doctor.get());

        return surveillanceRepository.save(request);
    }

    @Override
    public Surveillance update(Long surveillanceId, Surveillance request) {
        return surveillanceRepository.findById(surveillanceId)
                .map(surveillance -> surveillanceRepository.save(
                        surveillance.withWeight(request.getWeight())
                                .withHemoglobin(request.getHemoglobin())
                                .withLymphocytes(request.getLymphocytes())
                                .withSegmented(request.getSegmented())
                                .withMonocytes(request.getMonocytes())
                                .withMvc(request.getMvc())
                                .withMch(request.getMch())
                                .withLeukocytes(request.getLeukocytes())
                                .withErythrocytes(request.getErythrocytes())
                                .withGlucose(request.getGlucose())
                                .withCholesterol(request.getCholesterol())
                                .withTriglycerides(request.getTriglycerides())
                                .withUrea(request.getUrea())
                                .withCreatinine(request.getCreatinine())
                                .withDensity(request.getDensity())
                                .withPh(request.getPh())
                                .withProtein(request.getProtein())
                                .withKetone(request.getKetone())
                                .withUrobilinogen(request.getUrobilinogen())
                                .withBilirubin(request.getBilirubin())
                                .withNitrite(request.getNitrite())
                                .withCrystals(request.getCrystals())
                                .withSugar(request.getSugar())
                                .withUrineAppearance(request.getUrineAppearance())
                                .withUrineColor(request.getUrineColor())
                                .withPlanCalories(request.getPlanCalories())
                                .withConsumedCalories(request.getConsumedCalories())
                                .withAppetite(request.getAppetite())
                                .withPain(request.getPain())
                                .withOtherSymptoms(request.getOtherSymptoms())
                                .withImc(request.getImc())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, surveillanceId));
    }

    @Override
    public Surveillance delete(Long surveillanceId) {
        return surveillanceRepository.findById(surveillanceId)
                .map(surveillance -> {
                    surveillanceRepository.delete(surveillance);
                    return surveillance;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, surveillanceId));
    }
}
