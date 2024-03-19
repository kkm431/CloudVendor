package com.cloudVendor.model;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cloud_vendor")
public class CloudVendor {
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
    // Getters and setters
}
