package com.example.standinline.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class StandInlineRepo {

    private LinkedList<Integer> line = new LinkedList<>();
    private LinkedList<Integer> out = new LinkedList<>();
    private LinkedList<Integer> alert = new LinkedList<>();

    public Integer save() {
        try {
            Integer counter = line.getLast();
            line.add(counter + 1);

        } catch (NoSuchElementException nse) {
            if(out.size() > 0) {
                line.add(out.getLast() + 1);
            } else {
                line.add(1);
            }
        }

        return line.getLast();
    }

    public void saveAlert(Integer position) {
        alert.add(position);
    }

    public Integer getFirst() {
        try {
            out.add(line.removeFirst());
            return out.getLast();
        } catch (NoSuchElementException nse) {
            return out.getLast();
        }
    }

    public Integer getLastOut() {
        try {
            return out.getLast();
        } catch (NoSuchElementException nse) {
            return 0;
        }
    }

    public LinkedList<Integer> getAllInLine() {
        return line;
    }

    public LinkedList<Integer> getAllOut() {
        return out;
    }

    public Integer getAlert() {
        try {
            return alert.remove();
        } catch (NoSuchElementException nse) {
            return 0;
        }
    }

}
