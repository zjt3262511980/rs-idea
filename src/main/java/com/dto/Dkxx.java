package com.dto;

import java.util.List;

public class Dkxx {
    private List<String> beonlit;
    private List<String> punStatus;
    private List<String> punout;

    public Dkxx(List<String> beonlit, List<String> punStatus, List<String> punout) {
        this.beonlit = beonlit;
        this.punStatus = punStatus;
        this.punout = punout;
    }

    public Dkxx() {
    }

    public List<String> getBeonlit() {
        return beonlit;
    }

    public void setBeonlit(List<String> beonlit) {
        this.beonlit = beonlit;
    }

    public List<String> getPunStatus() {
        return punStatus;
    }

    public void setPunStatus(List<String> punStatus) {
        this.punStatus = punStatus;
    }

    public List<String> getPunout() {
        return punout;
    }

    public void setPunout(List<String> punout) {
        this.punout = punout;
    }
}
