package com.example.androidfundamentals;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.Assert.*;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.example.androidfundamentals")
public class ViperArchitectureTest {

    @ArchTest
    public static final ArchRule responseObjectsResideInResponsesPackage =
        classes().that()
                .haveNameMatching(".*Response")
                .should()
                .resideInAPackage("..clients.responses..")
                .as("DAOs should reside in a package '..clients.responses..'");

    @ArchTest
    public static final ArchRule clientObjectsResideInClientsPackage =
            classes().that()
                    .haveNameMatching(".*Client")
                    .should()
                    .resideInAPackage("..adapters.clients..")
                    .as("DAOs should reside in a package '..adapters.clients..'");
}