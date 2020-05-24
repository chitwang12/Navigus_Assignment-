package com.example.myapplication;

import android.widget.ImageView;
import android.widget.TextView;

public class AdminDoc {
    String docUrl;
    int currentViewers,pastViewers;

    public AdminDoc(String docUrl, int currentViewers, int pastViewers) {
        this.docUrl = docUrl;
        this.currentViewers = currentViewers;
        this.pastViewers = pastViewers;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public int getCurrentViewers() {
        return currentViewers;
    }

    public void setCurrentViewers(int currentViewers) {
        this.currentViewers = currentViewers;
    }

    public int getPastViewers() {
        return pastViewers;
    }

    public void setPastViewers(int pastViewers) {
        this.pastViewers = pastViewers;
    }
}
