package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.IllnessRecord;
import com.api.lhs.ehr.resource.CreateIllnessRecordResource;
import com.api.lhs.ehr.resource.IllnessRecordResource;
import com.api.lhs.ehr.resource.UpdateIllnessRecordResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IllnessRecordMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public IllnessRecordResource toResource(IllnessRecord model) { return mapper.map(model, IllnessRecordResource.class); }
    public List<IllnessRecordResource> toResource(List<IllnessRecord> model) { return mapper.mapList(model, IllnessRecordResource.class); }
    public IllnessRecord toModel(CreateIllnessRecordResource resource) { return mapper.map(resource, IllnessRecord.class); }
    public IllnessRecord toModel(UpdateIllnessRecordResource resource) { return mapper.map(resource, IllnessRecord.class); }
}
