package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.infrastructure.BorrowingDomainConfig;
import io.wkrzywiec.hexagonal.library.infrastructure.EmailDomainConfig;
import io.wkrzywiec.hexagonal.library.infrastructure.InventoryDomainConfig;
import io.wkrzywiec.hexagonal.library.infrastructure.LibraryHexagonalConfig;
import io.wkrzywiec.hexagonal.library.infrastructure.UserDomainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		LibraryHexagonalConfig.class,
		InventoryDomainConfig.class,
		BorrowingDomainConfig.class,
		EmailDomainConfig.class,
		UserDomainConfig.class
})
public class LibraryHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryHexagonalApplication.class, args);
	}
}
