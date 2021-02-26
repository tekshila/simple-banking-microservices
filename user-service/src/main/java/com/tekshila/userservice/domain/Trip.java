package com.tekshila.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    private Integer tripId;
    private Integer customerId;
    private String city;
    private String from;
    private String to;
}
