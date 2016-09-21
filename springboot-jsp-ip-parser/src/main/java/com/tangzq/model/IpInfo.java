package com.tangzq.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author tangzq.
 */
@Getter
@Setter
public class IpInfo {
        private String ip;
        private String country;
        private String province;
        private String city;
        private String district;
        private String carrier;
}
