package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import io.wkrzywiec.hexagonal.library.domain.inventory.core.InventoryFacade;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"io.wkrzywiec.hexagonal.library.domain.inventory"},
        importOptions = { ImportOption.DoNotIncludeTests.class })
public class InventoryArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonalArchInInventoryDomain = onionArchitecture()
            .domainModels("io.wkrzywiec.hexagonal.library.domain.inventory.core.model..")
            .domainServices("io.wkrzywiec.hexagonal.library.domain.inventory..")
            .applicationServices("io.wkrzywiec.hexagonal.library.domain.inventory.application..")
            .adapter("infrastructure", "io.wkrzywiec.hexagonal.library.domain.inventory.infrastructure..");

    @ArchTest
    public static final ArchRule noSpringDependenciesInInventoryFacade =
            noClass(InventoryFacade.class)
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");

}
