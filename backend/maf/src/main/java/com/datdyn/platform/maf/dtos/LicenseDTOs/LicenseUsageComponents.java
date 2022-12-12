package com.datdyn.platform.maf.dtos.LicenseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenseUsageComponents {
    Double licenseUsage;
    Double licenseOverdraft;
}