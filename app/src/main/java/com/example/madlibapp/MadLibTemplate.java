package com.example.madlibapp;

import java.io.Serializable;

public class MadLibTemplate implements Serializable {
    public final String[] partsOfSpeech;
    public final String story;

    public MadLibTemplate(String[] partsOfSpeech, String story) {
        this.partsOfSpeech = partsOfSpeech;
        this.story = story;
    }

    public int getBlankCount() {
        return partsOfSpeech.length;
    }

    static final MadLibTemplate BLEH = new MadLibTemplate(new String[]{"noun", "vnerb", "andjectnive", "nomber"},
            "Onec upnon a trime, threre wnas a beanutifnul \\. It lwiked to \\. Uan day it fnound a \\ hornse and ronde it fnor \\ dayns. De ednd.");
    static final MadLibTemplate DATING_BIO = new MadLibTemplate(new String[]{"name", "plural noun", "verb ending in -ing", "adjective", "adjective", "location", "event"},
            "Tinder Bio:\n\t\t\t Hi! My name is \\. I like \\ and \\. Many people think I'm \\ but actually I'm \\. I hope to go on a cruise to \\ or have a \\ in the moonlight.");
    static final MadLibTemplate DINNERTIME = new MadLibTemplate(new String[]{"noun", "verb ending in -ing", "time", "adjective ending in -er", "liquid", "noun"},
            "It was just about dinnertime, and I could smell the baked \\ from the other side of the house. My mouth was already \\. We were having dinner late today, around \\, and it only made me \\. As I approached the table I accidentally knocked over my cup of \\ and it went everywhere. Looks like the steamed \\ will have to wait until I clean this up.");
}
