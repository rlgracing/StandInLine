package com.example.standinline.controller;

import com.example.standinline.model.Response;
import com.example.standinline.service.StandInLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/line/admin")
public class StandInLineAdminController {

    private final StandInLineService standInLineService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> lineState() {
        return ResponseEntity.ok(standInLineService.getLineState());
    }

    @GetMapping(path = "/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> next() {
        return ResponseEntity.ok(standInLineService.next());
    }

    @GetMapping(path = "/next/again/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> nextAgain(@PathVariable("id") String id) {
        return ResponseEntity.ok(standInLineService.alertNextAgain(id));
    }
}
