package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.BorrowingFacade;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"io.wkrzywiec.hexagonal.library.domain.borrowing"},
                importOptions = { ImportOption.DoNotIncludeTests.class })
public class BorrowingArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonalArchInBorrowingDomain = onionArchitecture()
            .domainModels("io.wkrzywiec.hexagonal.library.domain.borrowing.core.model..")
            .domainServices("io.wkrzywiec.hexagonal.library.domain.borrowing..")
            .applicationServices("io.wkrzywiec.hexagonal.library.domain.borrowing.application..")
            .adapter("infrastructure", "io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure..");

    @ArchTest
    public static final ArchRule noSpringDependenciesInBorrowingFacade =
            noClass(BorrowingFacade.class)
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");
}
