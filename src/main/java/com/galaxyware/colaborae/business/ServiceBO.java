package com.galaxyware.colaborae.business;

import com.galaxyware.colaborae.model.CategoryModel;
import com.galaxyware.colaborae.model.ServiceModel;
import com.galaxyware.colaborae.repository.CategoryRepository;
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

    @Autowired
    CategoryRepository categoryRepository;

    public Page<ServiceModel> findAllServices(Pageable pageable) { return serviceRepository.findAll(pageable); }

    public ServiceModel findServiceByUuid(UUID uuid) { return serviceRepository.findById(uuid).orElse(null); }

    public List<ServiceModel> searchByTitle(String title) { return serviceRepository.findByTitleContaining(title); }

    public ServiceModel saveNewService(ServiceModel serviceModel) {
        CategoryModel byName = categoryRepository.findByName(serviceModel.getCategory().getName());
        serviceModel.setCategory(byName);

        return serviceRepository.save(serviceModel);
    }

    public ServiceModel updateService(UUID uuid, ServiceModel serviceModel) {
        ServiceModel serviceByUuid = findServiceByUuid(uuid);

        serviceByUuid.setDescription(serviceModel.getDescription());
        serviceByUuid.setRating(serviceModel.getRating());
        serviceByUuid.setTime(serviceModel.getTime());
        serviceByUuid.setTitle(serviceModel.getTitle());
        serviceByUuid.setValue(serviceModel.getValue());
        serviceByUuid.setActive(serviceModel.getActive());

        CategoryModel byName = categoryRepository.findByName(serviceModel.getCategory().getName());
        serviceByUuid.setCategory(byName);

        return serviceRepository.save(serviceByUuid);
    }

    public void deleteService(UUID uuid) {
        serviceRepository.deleteById(uuid);
    }

    public List<ServiceModel> getServiceByUser(UUID uuid) {
        return serviceRepository.findByUserUuid(uuid);
    }
}
