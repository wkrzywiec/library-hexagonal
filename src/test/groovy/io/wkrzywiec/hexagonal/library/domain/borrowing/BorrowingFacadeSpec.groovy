package io.wkrzywiec.hexagonal.library.domain.borrowing

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.BorrowingFacade
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.AvailableBook
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.MakeBookAvailableCommand
import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.outgoing.BorrowingEventPublisher
import spock.lang.Specification

class BorrowingFacadeSpec extends Specification {

    private BorrowingFacade facade
    private InMemoryBorrowingDatabase database
    private BorrowingEventPublisher eventPublisher

    def setup(){
        database = new InMemoryBorrowingDatabase()
        eventPublisher = new BorrowingEventPublisherFake()
        facade = new BorrowingFacade(database, eventPublisher)
    }

    def "Make a book available"(){
        given: "prepare a command"
        def makeBookAvailableCommand = new MakeBookAvailableCommand(100)

        when: "receive MakeBookAvailableCommand"
        facade.handle(makeBookAvailableCommand)

        then: "check database to have this book as available"
        database.availableBooks[100L] == new AvailableBook(200)
    }
}