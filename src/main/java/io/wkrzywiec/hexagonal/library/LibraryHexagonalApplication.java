package io.wkrzywiec.hexagonal.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		LibraryHexagonalConfig.class,
		InventoryDomainConfig.class,
		BorrowingDomainConfig.class,
		EmailDomainConfig.class
})
public class LibraryHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryHexagonalApplication.class, args);
	}
}
