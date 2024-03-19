package com.cloudVendor.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudVendor.model.CloudVendor;
import com.cloudVendor.service.CloudVendorService;

@RestController
@RequestMapping("/vendors")
public class CloudVendorController {

    @Autowired
    private CloudVendorService cloudVendorService;

    @GetMapping("/{id}")
    public ResponseEntity<CloudVendor> getVendorById(@PathVariable String id) {
        CloudVendor vendor = cloudVendorService.findById(id);
        if (vendor != null) {
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CloudVendor>> getAllVendors() {
        List<CloudVendor> vendors = cloudVendorService.findAll();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addVendor(@RequestBody CloudVendor vendor) {
        cloudVendorService.save(vendor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVendor(@PathVariable String id, @RequestBody CloudVendor vendor) {
        vendor.setVendorId(id);
        cloudVendorService.update(vendor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable String id) {
        cloudVendorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
