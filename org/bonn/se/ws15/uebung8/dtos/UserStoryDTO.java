package org.bonn.se.ws15.uebung8.dtos;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by NilsK on 06.11.2015.
 */
public class UserStoryDTO implements Comparable<UserStoryDTO>, Serializable {
    private final int value, effort, risk, penalty;
    private final double priority;
    private final String title;

    // Constructors

    public UserStoryDTO(String t, int v, int e, int r, int pe, double pr) {
        this.title = t;
        this.value = v;
        this.effort = e;
        this.risk = r;
        this.penalty = pe;
        this.priority = pr;
    }

    // Methods

    public int compareTo(UserStoryDTO us) {
        if (this.priority > us.priority) return -1;
        if (this.priority < us.priority) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return new DecimalFormat("#0.00").format(this.priority) + "\t" + this.title + "\t" + this.value + "\t"
                + this.effort + "\t" + this.risk + "\t" + this.penalty;
    }

    // Getter

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }

    public int getEffort() {
        return effort;
    }

    public double getPriority() {
        return priority;
    }

    public int getRisk() {
        return risk;
    }

    public int getPenalty() {
        return penalty;
    }
}