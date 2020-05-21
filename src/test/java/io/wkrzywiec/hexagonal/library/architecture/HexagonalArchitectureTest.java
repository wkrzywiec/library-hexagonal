package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import io.wkrzywiec.hexagonal.library.borrowing.BorrowingFacade;
import io.wkrzywiec.hexagonal.library.inventory.InventoryFacade;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"io.wkrzywiec.hexagonal.library.inventory",
                            "io.wkrzywiec.hexagonal.library.borrowing"},
                importOptions = { ImportOption.DoNotIncludeTests.class })
public class HexagonalArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonalArchInInventoryDomain = onionArchitecture()
            .domainModels("io.wkrzywiec.hexagonal.library.inventory.model..")
            .domainServices("io.wkrzywiec.hexagonal.library.inventory..")
            .applicationServices("io.wkrzywiec.hexagonal.library.inventory.application..")
            .adapter("infrastructure", "io.wkrzywiec.hexagonal.library.inventory.infrastructure..");

    @ArchTest
    public static final ArchRule hexagonalArchInBorrowingDomain = onionArchitecture()
            .domainModels("io.wkrzywiec.hexagonal.library.borrowing.model..")
            .domainServices("io.wkrzywiec.hexagonal.library.borrowing..")
            .applicationServices("io.wkrzywiec.hexagonal.library.borrowing.application..")
            .adapter("infrastructure", "io.wkrzywiec.hexagonal.library.borrowing.infrastructure..");

    @ArchTest
    public static final ArchRule noSpringDependenciesInInventoryFacade =
            noClass(InventoryFacade.class)
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");

    @ArchTest
    public static final ArchRule noSpringDependenciesInBorrowingFacade =
            noClass(BorrowingFacade.class)
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");
}
