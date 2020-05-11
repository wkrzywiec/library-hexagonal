package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "io.wkrzywiec.hexagonal.library.domain")
public class NoSpringInDomainPackageTest {

    @ArchTest
    public static final ArchRule noSpringDependenciesInDomainPackage =
            noClasses().that()
                    .resideInAPackage("..io.wkrzywiec.hexagonal.library.domain..")
            .should()
            .dependOnClassesThat().resideInAPackage("org.springframework..");
}
