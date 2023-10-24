package ro.fasttrackit.course15.tdd;

import java.util.List;

public class TDD {
    public int find(List<Integer> list, Integer number) {
        if (list == null || number == null) {
            return -1;
        }
        return list.indexOf(number);
    }
}
