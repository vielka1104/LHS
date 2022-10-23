package com.api.lhs.patient.api;

import com.api.lhs.patient.domain.service.PredictionService;
import com.api.lhs.patient.mapping.PredictionMapper;
import com.api.lhs.patient.resource.CreatePredictionResource;
import com.api.lhs.patient.resource.PredictionResource;
import com.api.lhs.patient.resource.UpdatePredictionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Prediction")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class PredictionController {
    @Autowired
    private PredictionService predictionService;

    @Autowired
    private PredictionMapper predictionMapper;

    @Operation(summary = "Get All Predictions", description = "Get All Predictions")
    @GetMapping("predictions")
    public List<PredictionResource> getAllPredictions(){
        return predictionMapper.toResource(predictionService.getAll());
    }

    @Operation(summary = "Get Prediction by Id", description = "Get Prediction by Id")
    @GetMapping("predictions/{predictionId}")
    public PredictionResource getPredictionById(@PathVariable Long predictionId){
        return predictionMapper.toResource(predictionService.getById(predictionId));
    }

    @Operation(summary = "Get Prediction by PatientId", description = "Get Prediction by PatientId")
    @GetMapping("predictions/patient/{patientId}")
    public PredictionResource getByPatientId(@PathVariable Long patientId){
        return predictionMapper.toResource(predictionService.getByPatientId(patientId));
    }

    @Operation(summary = "Create New Prediction", description = "Create New Prediction")
    @PostMapping("patients/{patientId}/predictions")
    public PredictionResource createPrediction(@RequestBody CreatePredictionResource model, @PathVariable Long patientId){
        return predictionMapper.toResource(predictionService.create(patientId, predictionMapper.toModel(model)));
    }

    @Operation(summary = "Update Prediction", description = "Update Prediction")
    @PutMapping("predictions/{predictionId}")
    public PredictionResource updatePrediction(@PathVariable Long predictionId, @RequestBody UpdatePredictionResource model){
        return predictionMapper.toResource(predictionService.update(predictionId, predictionMapper.toModel(model)));
    }

    @Operation(summary = "Delete Prediction", description = "Delete Prediction")
    @DeleteMapping("predictions/{predictionId}")
    public void deletePrediction(@PathVariable Long predictionId){
        predictionService.delete(predictionId);
    }
}
