package com.example.madlibapp;

import java.io.Serializable;

public class MadLib implements Serializable {
    MadLibTemplate template;
    String[] blanks;

    public MadLib(MadLibTemplate template) {
        this.template = template;
        blanks = new String[template.partsOfSpeech.length];
    }

    public void setBlank(String value, int index) {
        blanks[index] = value;
    }

    public String getCompleteStory() {
        String out = template.story;
        for (String blank : blanks) {
            out = out.replaceFirst("\\\\", blank);
        }
        return out;
    }
}
