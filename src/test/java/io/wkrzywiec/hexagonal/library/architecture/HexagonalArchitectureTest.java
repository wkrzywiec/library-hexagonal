package io.wkrzywiec.hexagonal.library.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "io.wkrzywiec.hexagonal.library.domain")
public class HexagonalArchitectureTest {

    @ArchTest
    public static final ArchRule noSpringDependenciesInBorrowingCoreDomain =
            noClasses().that()
                    .resideInAnyPackage(
                            "..io.wkrzywiec.hexagonal.library.borrowing.ports..",
                            "..io.wkrzywiec.hexagonal.library.borrowing.model..")
                    .and()
                    .haveNameMatching(".*Facade")
            .should()
            .dependOnClassesThat().resideInAPackage("org.springframework..");
}
