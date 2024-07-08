package com.example.standinline.service;

import com.example.standinline.repository.StandInlineRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandInLineServiceTest {

    @Test
    void newInLine() {
        StandInLineService standInLineService = new StandInLineService(new StandInlineRepo());

        standInLineService.newInLine();
        standInLineService.newInLine();
        standInLineService.newInLine();

        assertEquals(3, standInLineService.allInLine().size());
        assertEquals(3, standInLineService.allInLine().getLast());
        assertEquals(1, standInLineService.allInLine().getFirst());
    }

    @Test
    void next() {
        StandInLineService standInLineService = new StandInLineService(new StandInlineRepo());

        standInLineService.newInLine();
        standInLineService.next();

        assertEquals(0, standInLineService.allInLine().size());
        assertEquals(1, standInLineService.allOut().size());
    }

    @Test
    void allInLine() {
        StandInLineService standInLineService = new StandInLineService(new StandInlineRepo());

        standInLineService.newInLine();
        standInLineService.newInLine();

        assertEquals(2, standInLineService.allInLine().size());
    }

    @Test
    void allOut() {
        StandInLineService standInLineService = new StandInLineService(new StandInlineRepo());

        standInLineService.newInLine();
        standInLineService.next();

        assertEquals(0, standInLineService.allInLine().size());
        assertEquals(1, standInLineService.allOut().size());
    }
}