package ru.job4j.tracker;

public class TrackerSingleSFLazyLoading {
    private static TrackerSingleSFLazyLoading instance;
    private  final Tracker tracker = new Tracker();

    private TrackerSingleSFLazyLoading() {
    }

    public static TrackerSingleSFLazyLoading getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSFLazyLoading();
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }
}

