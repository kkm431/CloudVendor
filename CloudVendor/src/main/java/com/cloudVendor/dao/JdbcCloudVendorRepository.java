package com.cloudVendor.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cloudVendor.model.CloudVendor;
import com.cloudVendor.repository.CloudVendorRepository;

import java.util.List;

@Repository
public class JdbcCloudVendorRepository implements CloudVendorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CloudVendor findById(String id) {
        String sql = "SELECT * FROM cloud_vendor_info WHERE vendor_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(CloudVendor.class));
    }

    @Override
    public List<CloudVendor> findAll() {
        String sql = "SELECT * FROM cloud_vendor_info";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CloudVendor.class));
    }

    @Override
    public void save(CloudVendor vendor) {
        String sql = "INSERT INTO cloud_vendor_info (vendor_id, vendor_name, vendor_address, vendor_phone_number) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, vendor.getVendorId(), vendor.getVendorName(), vendor.getVendorAddress(), vendor.getVendorPhoneNumber());
    }


    @Override
    public void update(CloudVendor vendor) {
        String sql = "UPDATE cloud_vendor_info SET vendor_name=?, vendor_address=?, vendor_phone_number=? WHERE vendor_id=?";
        jdbcTemplate.update(sql, vendor.getVendorName(), vendor.getVendorAddress(), vendor.getVendorPhoneNumber(), vendor.getVendorId());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM cloud_vendor_info WHERE vendor_id=?";
        jdbcTemplate.update(sql, id);
    }
}
