package com.salesforce.bazel.sdk.model;

import java.util.List;

import com.salesforce.bazel.sdk.aspect.AspectPackageInfos;
import com.salesforce.bazel.sdk.model.BazelPackageLocation;

/**
 * Orders modules for import.
 */
public interface ImportOrderResolver {
    
    Iterable<BazelPackageLocation> resolveModulesImportOrder(BazelPackageLocation rootModule,
            List<BazelPackageLocation> childModules, AspectPackageInfos aspects);
}