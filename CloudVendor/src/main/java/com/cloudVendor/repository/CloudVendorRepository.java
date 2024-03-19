package com.cloudVendor.repository;

import java.util.List;

import com.cloudVendor.model.CloudVendor;

public interface CloudVendorRepository {
    CloudVendor findById(String id);
    List<CloudVendor> findAll();
    void save(CloudVendor vendor);
    void update(CloudVendor vendor);
    void delete(String id);
}
