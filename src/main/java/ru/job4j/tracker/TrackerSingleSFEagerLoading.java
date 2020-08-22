package ru.job4j.tracker;

public class TrackerSingleSFEagerLoading {
    private static final TrackerSingleSFEagerLoading INSTANCE = new TrackerSingleSFEagerLoading();
    private  final Tracker tracker = new Tracker();

    private TrackerSingleSFEagerLoading() {
    }

    public static TrackerSingleSFEagerLoading getInstance() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
