package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public record Range(long low, long high) {

    public List<Range> split(Range range) {
        if (this.equals(range)) {
            return asList(this);
        }

        if (range.high < low || range.low > this.high) {
            // no overlap, return the range unchanged
            return asList(this);
        }

        final List<Range> ranges = new ArrayList<>();
        if (low < range.low) {
            // this range starts before the given range, add the part before
            ranges.add(new Range(low, range.low));
            if (this.high > range.high) {
                // this completely contains the given range, so given range is the common part
                ranges.add(range);
                // this is extra
                ranges.add(new Range(range.high, this.high));
            } else {
                // add the overlap
                ranges.add(new Range(range.low, this.high));
            }
            // 31, 50 vs 19, 45
        } else if (range.low < low) {
            if (range.high > this.high) {
                // the given range completely contains this range, so this range is the common part
                ranges.add(this);
            } else {
                // add the overlap
                ranges.add(new Range(this.low, range.high));
            }
        } else {
            // they start at the same point
            if (this.high > range.high) {
                // this range completely contains the given range, so the given range is the common part
                ranges.add(range);
                // add the extra
                ranges.add(new Range(range.high, this.high));
            } else if (this.high < range.high) {
                // the given range completely contains this range, so this range is the common part
                ranges.add(this);
            }
        }

        return ranges;
    }

    private boolean contains(long number) {
        return low <= number && number < high;
    }

    public boolean contains(Range range) {
        return low <= range.low && range.high <= high;
    }

    public long length() {
        return high - low;
    }

    public Range addOffset(long offset) {
        return new Range(low + offset, high + offset);
    }

    public boolean hasOverlap(Range range) {
        return range.contains(low) || this.contains(range.low);
    }
}
