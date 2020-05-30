package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import io.wkrzywiec.hexagonal.library.domain.user.core.UserFacade;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"io.wkrzywiec.hexagonal.library.domain.user"},
        importOptions = { ImportOption.DoNotIncludeTests.class })
public class UserArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonalArchInUserDomain = onionArchitecture()
            .domainModels("io.wkrzywiec.hexagonal.library.domain.user.core.model..")
            .domainServices("io.wkrzywiec.hexagonal.library.domain.user..")
            .applicationServices("io.wkrzywiec.hexagonal.library.domain.user.application..")
            .adapter("infrastructure", "io.wkrzywiec.hexagonal.library.domain.user.infrastructure..");

    @ArchTest
    public static final ArchRule noSpringDependenciesInUserFacade =
            noClass(UserFacade.class)
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..");
}
