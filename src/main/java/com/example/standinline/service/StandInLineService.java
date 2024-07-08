package com.example.standinline.service;

import com.example.standinline.model.Response;
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

    public Response next() {
        Integer position = standInlineRepo.getFirst();

        standInlineRepo.saveAlert(position);

        return Response.builder()
                .position(position.toString())
                .inline(standInlineRepo.getAllInLine())
                .out(standInlineRepo.getAllOut())
                .alert(position.toString())
                .build();
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

    public Response getLineState() {
        return Response.builder()
                .position(standInlineRepo.getLastOut().toString())
                .inline(standInlineRepo.getAllInLine())
                .out(standInlineRepo.getAllOut())
                .build();
    }

    public Response alertNext() {
        return Response.builder()
                .position(standInlineRepo.getLastOut().toString())
                .out(standInlineRepo.getAllOut())
                .alert(standInlineRepo.getAlert().toString())
                .build();
    }

    public Response alertNextAgain(String position) {
        standInlineRepo.saveAlert(Integer.parseInt(position));

        return Response.builder()
                .position(standInlineRepo.getLastOut().toString())
                .alert(position)
                .build();
    }
}
