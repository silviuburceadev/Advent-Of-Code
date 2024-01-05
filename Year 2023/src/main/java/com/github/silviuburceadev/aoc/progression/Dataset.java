package com.github.silviuburceadev.aoc.progression;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public record Dataset(List<Integer> values) {

    public Dataset(Integer... values) {
        this(asList(values));
    }

    public Dataset(String line) {
        this(stream(line.split("\\s+")).map(Integer::valueOf).toList());
    }

    public boolean isConstant() {
        final Integer firstElem = values.get(0);
        return values.stream().allMatch(v -> v.equals(firstElem));
    }

    public Dataset getProgression() {
        final List<Integer> progression = new ArrayList<>();
        for (int i = 1; i < values.size(); i++) {
            final Integer diff = values.get(i) - values.get(i - 1);
            progression.add(diff);
        }
        return new Dataset(progression);
    }

    public int getNextValue() {
        final Dataset progression = getProgression();
        if (progression.isConstant()) {
            return values.get(values.size() - 1) + progression.values.get(0);
        } else {
            return values.get(values.size() - 1) + progression.getNextValue();
        }
    }

    public int getPreviousValue() {
        return 0;
    }
}
