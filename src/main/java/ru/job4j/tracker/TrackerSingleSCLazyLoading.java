package ru.job4j.tracker;

public class TrackerSingleSCLazyLoading {
    private  final Tracker tracker = new Tracker();

    private TrackerSingleSCLazyLoading() {
    }

    public static TrackerSingleSCLazyLoading getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleSCLazyLoading INSTANCE = new TrackerSingleSCLazyLoading();
    }

    public Tracker getTracker() {
        return tracker;
    }
}
