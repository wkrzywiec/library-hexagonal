package io.wkrzywiec.hexagonal.library.domain.borrowing.application;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.ports.incoming.CancelOverdueReservations;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class OverdueReservationScheduler {

    private final CancelOverdueReservations overdueReservations;

    @Scheduled(fixedRate = 10 * 1000)
    public void checkOverdueReservations(){
        overdueReservations.cancelOverdueReservations();
    }
}
