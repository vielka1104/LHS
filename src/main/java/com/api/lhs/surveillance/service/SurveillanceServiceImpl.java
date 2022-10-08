package com.api.lhs.surveillance.service;

import com.api.lhs.patient.domain.entity.Patient;
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

    @Autowired
    private SurveillanceRepository surveillanceRepository;
    @Autowired
    private PatientRepository patientRepository;

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
    public Surveillance create(Surveillance request, Long patientId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        Patient p = patient.get();
        request.setPatient(patient.get());
        request.setImc(request.getInitWeight() / Float.parseFloat(p.getHeight()) * Float.parseFloat(p.getHeight()));

        return surveillanceRepository.save(request);
    }

    @Override
    public Surveillance update(Long surveillanceId, Surveillance request) {
        return surveillanceRepository.findById(surveillanceId)
                .map(surveillance -> surveillanceRepository.save(
                        surveillance.withInitWeight(request.getInitWeight())
                                .withFinalWeight(request.getFinalWeight())
                                .withHdTime(request.getHdTime())
                                .withUf(request.getUf())
                                .withUreaPre(request.getUreaPre())
                                .withSerumElectrolytes(request.getSerumElectrolytes())
                                .withChlorine(request.getChlorine())
                                .withPhosphorus(request.getPhosphorus())
                                .withSerumCalcium(request.getSerumCalcium())
                                .withProteinElectrophoresis(request.getProteinElectrophoresis())
                                .withAlkalinePhosphatase(request.getAlkalinePhosphatase())
                                .withTgo(request.getTgo())
                                .withTgp(request.getTgp())
                                .withDayCreatinine(request.getDayCreatinine())
                                .withParathormone(request.getParathormone())
                                .withSerumIron(request.getSerumIron())
                                .withSerumFerritin(request.getSerumFerritin())
                                .withTransferrinSaturation(request.getTransferrinSaturation())
                                .withTransferrin(request.getTransferrin())
                                .withElisa(request.getElisa())
                                .withVdrlAndRpr(request.getVdrlAndRpr())
                                .withHepatitisBAntigen(request.getHepatitisBAntigen())
                                .withHepatitisBAntibody(request.getHepatitisBAntibody())
                                .withHepatitisCAntibody(request.getHepatitisCAntibody())
                                .withKtv(request.getKtv())
                                .withBloodUrea(request.getBloodUrea())
                                .withSerumCreatinine(request.getSerumCreatinine())
                                .withHemoglobin(request.getHemoglobin())
                                .withSodium(request.getSodium())
                                .withPotassium(request.getPotassium())
                                .withAlbumin(request.getAlbumin())
                                .withBloodPressure(request.getBloodPressure())
                                .withSpecificGravity(request.getSpecificGravity())
                                .withSugar(request.getSugar())
                                .withRedBloodCells(request.getRedBloodCells())
                                .withPusCells(request.getPusCells())
                                .withPusCellClumps(request.getPusCellClumps())
                                .withBacteria(request.getBacteria())
                                .withBloodGlucoseRandom(request.getBloodGlucoseRandom())
                                .withPackedCellVolume(request.getPackedCellVolume())
                                .withWhiteBloodCellCount(request.getWhiteBloodCellCount())
                                .withRedBloodCellCount(request.getRedBloodCellCount())
                                .withAppetite(request.getAppetite())
                                .withPlanCalories(request.getPlanCalories())
                                .withConsumedCalories(request.getConsumedCalories())
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
