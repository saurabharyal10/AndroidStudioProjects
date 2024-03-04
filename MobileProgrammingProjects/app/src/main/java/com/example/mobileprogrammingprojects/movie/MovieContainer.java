package com.example.mobileprogrammingprojects.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieContainer {
    @SerializedName("page")
    @Expose
    int page;
    @SerializedName("results")
    @Expose
    List<Results> resultList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResultList() {
        return resultList;
    }

    public void setResultList(List<Results> resultList) {
        this.resultList = resultList;
    }
}
