package com.example.standinline.service;

import com.example.standinline.repository.StandInlineRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@AllArgsConstructor
public class StandInLineService {

    private final StandInlineRepo standInlineRepo;

    public Integer newInLine() {
        return standInlineRepo.save();
    }

    public Integer next() {
        return standInlineRepo.getFirst();
    }

    public Integer nextAgain() {
        return standInlineRepo.getLastOut();
    }

    public void saveAlert(Integer position) {
        standInlineRepo.saveAlert(position);
    }

    public Integer getAlert() {
        return standInlineRepo.getAlert();
    }

    public LinkedList<Integer> allInLine() {
        return standInlineRepo.getAllInLine();
    }

    public LinkedList<Integer> allOut() {
        return standInlineRepo.getAllOut();
    }
}
