package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is (nullValue()));
    }

    @Test
    public  void  whenTrackerSingletonEnum() {
        TrackerSingleEnum trackerSingleEnumOne = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum trackerSingleEnumTwo = TrackerSingleEnum.INSTANCE;
        assertSame(trackerSingleEnumOne, trackerSingleEnumTwo);
    }

    @Test
    public  void  TrackerSingleSFEagerLoading() {
        TrackerSingleSFEagerLoading trackerSingleSFEagerLoadingOne = TrackerSingleSFEagerLoading.getInstance();
        TrackerSingleSFEagerLoading trackerSingleSFEagerLoadingTwo = TrackerSingleSFEagerLoading.getInstance();
        assertSame(trackerSingleSFEagerLoadingOne, trackerSingleSFEagerLoadingTwo);
    }

    @Test
    public  void  TrackerSingleSFLazyLoading() {
        TrackerSingleSFLazyLoading trackerSingleSFLazyLoadingOne = TrackerSingleSFLazyLoading.getInstance();
        TrackerSingleSFLazyLoading trackerSingleSFLazyLoadingTwo = TrackerSingleSFLazyLoading.getInstance();
        assertSame(trackerSingleSFLazyLoadingOne,  trackerSingleSFLazyLoadingTwo);
    }

    @Test
    public  void  TrackerSingleSCLazyLoading() {
        TrackerSingleSCLazyLoading trackerSingleSCLazyLoadingOne = TrackerSingleSCLazyLoading.getInstance();
        TrackerSingleSCLazyLoading trackerSingleSCLazyLoadingTwo = TrackerSingleSCLazyLoading.getInstance();
        assertSame(trackerSingleSCLazyLoadingOne, trackerSingleSCLazyLoadingTwo);
    }

}