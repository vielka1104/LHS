package com.api.lhs.patient.mapping;

import com.api.lhs.patient.domain.entity.Prediction;
import com.api.lhs.patient.resource.CreatePredictionResource;
import com.api.lhs.patient.resource.PredictionResource;
import com.api.lhs.patient.resource.UpdatePredictionResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PredictionMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public PredictionResource toResource(Prediction model) { return mapper.map(model, PredictionResource.class); }
    public List<PredictionResource> toResource(List<Prediction> model) { return  mapper.mapList(model, PredictionResource.class); }
    public Prediction toModel(CreatePredictionResource resource) { return mapper.map(resource, Prediction.class); }
    public Prediction toModel(UpdatePredictionResource resource) { return mapper.map(resource, Prediction.class); }
}
