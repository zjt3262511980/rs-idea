package com.dto;

import com.domain.Remuneration;

import java.util.List;

public class Remlist {
    private int yj;
    private List<Remuneration> list;

    public Remlist() {
    }

    public int getYj() {
        return yj;
    }

    public void setYj(int yj) {
        this.yj = yj;
    }

    public List<Remuneration> getList() {
        return list;
    }

    public void setList(List<Remuneration> list) {
        this.list = list;
    }

    public Remlist(int yj, List<Remuneration> list) {
        this.yj = yj;
        this.list = list;
    }
}
