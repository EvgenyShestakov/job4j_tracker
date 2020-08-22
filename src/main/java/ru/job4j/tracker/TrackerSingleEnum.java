package ru.job4j.tracker;

public enum TrackerSingleEnum {
    INSTANCE;
    private  final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}

