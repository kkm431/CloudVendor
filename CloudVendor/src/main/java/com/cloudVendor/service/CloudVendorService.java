package com.cloudVendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudVendor.model.CloudVendor;
import com.cloudVendor.repository.CloudVendorRepository;

@Service
public class CloudVendorService {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    public CloudVendor findById(String id) {
        return cloudVendorRepository.findById(id);
    }

    public List<CloudVendor> findAll() {
        return cloudVendorRepository.findAll();
    }

    public void save(CloudVendor vendor) {
        cloudVendorRepository.save(vendor);
    }

    public void update(CloudVendor vendor) {
        cloudVendorRepository.update(vendor);
    }

    public void delete(String id) {
        cloudVendorRepository.delete(id);
    }
}
