package com.galaxyware.colaborae.controller;
import com.galaxyware.colaborae.business.ServiceBO;
import com.galaxyware.colaborae.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    ServiceBO serviceBO;

    @GetMapping()
    public ResponseEntity<Page<ServiceModel>> getAll(@PageableDefault(page = 0, size = 12) Pageable pageable) {
        Page<ServiceModel> services = serviceBO.findAllServices(pageable);
        return ResponseEntity.ok().body(services);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ServiceModel> findById(@PathVariable UUID uuid) {
        ServiceModel service = serviceBO.findServiceByUuid(uuid);
        return service != null
                ? ResponseEntity.ok().body(service)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ServiceModel>> searchByName(@RequestParam() String title) {
        List<ServiceModel> services = serviceBO.searchByTitle(title);
        return ResponseEntity.ok().body(services);
    }

    @PostMapping()
    public ResponseEntity<ServiceModel> insert(@RequestBody ServiceModel serviceModel) {
        ServiceModel save = serviceBO.saveNewService(serviceModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ServiceModel> update(@PathVariable UUID uuid, @RequestBody ServiceModel serviceModel) {
        ServiceModel updateService = serviceBO.updateService(uuid, serviceModel);
        return ResponseEntity.ok().body(updateService);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ServiceModel> delete(@PathVariable UUID uuid) {
        serviceBO.deleteService(uuid);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
