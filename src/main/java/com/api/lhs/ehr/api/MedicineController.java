package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.MedicineService;
import com.api.lhs.ehr.mapping.MedicineMapper;
import com.api.lhs.ehr.resource.CreateMedicineResource;
import com.api.lhs.ehr.resource.MedicineResource;
import com.api.lhs.ehr.resource.UpdateMedicineResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Medicine")
@RestController
@RequestMapping("api/v1/medicines")
@CrossOrigin
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MedicineMapper medicineMapper;

    @Operation(summary = "Get All Medicines", description = "Get All Medicines")
    @GetMapping
    public List<MedicineResource> getAllMedicines(){
        return medicineMapper.toResource(medicineService.getAll());
    }

    @Operation(summary = "Get Medicine by Id", description = "Get Medicine by Id")
    @GetMapping("{medicineId}")
    public MedicineResource getMedicineById(@PathVariable Long medicineId){
        return medicineMapper.toResource(medicineService.getById(medicineId));
    }

    @Operation(summary = "Get Medicine by Name", description = "Get Medicine by Name")
    @GetMapping("name/{name}")
    public List<MedicineResource> getMedicineByName(@PathVariable String name){
        return medicineMapper.toResource(medicineService.getMedicinesByName(name));
    }

    @Operation(summary = "Create New Medicine", description = "Create New Medicine")
    @PostMapping
    public MedicineResource createMedicine(@RequestBody CreateMedicineResource model){
        return medicineMapper.toResource(medicineService.create(medicineMapper.toModel(model)));
    }

    @Operation(summary = "Update Medicine", description = "Update Medicine")
    @PutMapping("{medicineId}")
    public MedicineResource updateMedicine(@PathVariable Long medicineId, @RequestBody UpdateMedicineResource model){
        return medicineMapper.toResource(medicineService.update(medicineId, medicineMapper.toModel(model)));
    }

    @Operation(summary = "Delete Medicine", description = "Delete Medicine")
    @DeleteMapping("{medicineId}")
    public void deleteMedicine(@PathVariable Long medicineId){
        medicineService.delete(medicineId);
    }
}
