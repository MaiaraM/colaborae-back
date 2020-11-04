package com.galaxyware.colaborae.business;
<<<<<<< HEAD
=======

>>>>>>> main
import com.galaxyware.colaborae.model.ServiceModel;
import com.galaxyware.colaborae.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceBO {

    @Autowired
    ServiceRepository serviceRepository;

    public Page<ServiceModel> findAllServices(Pageable pageable) { return serviceRepository.findAll(pageable); }

    public ServiceModel findServiceByUuid(UUID uuid) { return serviceRepository.findById(uuid).orElse(null); }

    public List<ServiceModel> searchByTitle(String title) { return serviceRepository.findByTitleContaining(title); }

    public ServiceModel saveNewService(ServiceModel serviceModel) { return serviceRepository.save(serviceModel); }

    public ServiceModel updateService(UUID uuid, ServiceModel serviceModel) {
        ServiceModel serviceByUuid = findServiceByUuid(uuid);

        serviceByUuid.setDescription(serviceModel.getDescription());
        serviceByUuid.setRating(serviceModel.getRating());
        serviceByUuid.setTime(serviceModel.getTime());
        serviceByUuid.setTitle(serviceModel.getTitle());
        serviceByUuid.setValue(serviceModel.getValue());
        serviceByUuid.setActive(serviceModel.getActive());

        return serviceRepository.save(serviceByUuid);
    }

    public void deleteService(UUID uuid) {
        serviceRepository.deleteById(uuid);
    }
}
