package com.example.testproj;

import java.util.ArrayList;

public class Podcast {
    private String podName;
    private String category;
    private String podDescription;
    private String podSummary;
    private String podLength;
    private String channelName;
    private int podYear;

    //constructor
    public Podcast(String podName, String category, String podDescription, String podSummary, String podLength, String channelName, int podYear) {
        this.podName = podName;
        this.category = category;
        this.podDescription = podDescription;
        this.podSummary = podSummary;
        this.podLength = podLength;
        this.channelName = channelName;
        this.podYear = podYear;
    }

    //getters and setters

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPodDescription() {
        return podDescription;
    }

    public void setPodDescription(String podDescription) {
        this.podDescription = podDescription;
    }

    public String getPodSummary() {
        return podSummary;
    }

    public void setPodSummary(String podSummary) {
        this.podSummary = podSummary;
    }

    public String getPodLength() {
        return podLength;
    }

    public void setPodLength(String podLength) {
        this.podLength = podLength;
    }

    public void setPodYear(int podYear) {
        this.podYear = podYear;
    }

    public String getChannelName(){
        return channelName;
    }

    public void setChannelName(String channelName){
        this.channelName = channelName;
    }

    public int getPodYear(){
        return podYear;
    }

    public void setPodYear(){
        this.podYear = podYear;
    }

    //create method to call list of podcasts

    public static ArrayList<Podcast> getPodcasts() {
        ArrayList<Podcast> podcasts = new ArrayList<>();
        //add data to arraylist
        podcasts.add(new Podcast("The Stress Mastery Podcast: Living Right with Bill Cortright (#1467 How to Get Out of a Health Rut)", "Wellbeing", "The journey of this process enhances all areas of your life. It bring prosperity, focus and balance but most important it will bring you to a state of peace. Once you achieve Stress Mastery your outer environment, the outside circumstances and events that take place in your life, will no longer disturb the inner environment of your true self.", "This week our topic is Getting Unstuck. Today’s Health Huddles we are discussing How to Get Out of a Health Rut. Many of our health habits were set for us through the Stages of Development. Some of these habits may support our health while others are detrimental. To move out of a health rut we must get clear what is our Health-WHY? Today we reveal the WHY to get and stay healthy.", "37:32 mins", "Bill Cortright", 2020));
        podcasts.add(new Podcast("Test W1", "Wellbeing", "Hi", "testing wellbeing 1", "20:20 mins", "MCU", 2016));
        podcasts.add(new Podcast("Test W2", "Wellbeing", "meditation", "ways to effectively manage stress", "59:50 mins", "JackBlack", 2018));
        podcasts.add(new Podcast("Test FL1", "Financial Literacy", "investment banking", "become an invesment banker", "27:30 mins", "fish", 2021));
        podcasts.add(new Podcast("Test FL2", "Financial Literacy", "maths", "derivatives and investing", "12:38 mins", "loki", 2020));
        podcasts.add(new Podcast("Test FL3", "Financial Literacy", "property", "how to invest in the Sydney housing market", "61:42 mins", "houseAreYou", 2022));
        podcasts.add(new Podcast("Test T1", "Technology", "AI", "How does AI learn and what does the future hold for humanity?", "38:39 mins", "AImbot", 2019));
        podcasts.add(new Podcast("Test T2", "Technology", "Excel", "Excel for beginners", "22:01 mins", "ExcelMaster", 2021));
        podcasts.add(new Podcast("Test T3", "Technology", "Machine Learning", "Capabilities of Robots in 2050", "43:56 mins", "RobotsInDisguise", 2022));

        return podcasts;
    }

    public static Podcast matchPodcast(String name) {
        ArrayList<Podcast> podcast = Podcast.getPodcasts();
        //for:each loop iterating through the podcast names to find a match
        for (Podcast podcast1 : podcast){
            if (podcast1.getPodName().equalsIgnoreCase(name)){
                return podcast1;
            }
        }
        //if no match is found in the loop, return null
        return null;
    }
}
