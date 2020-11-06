package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    public static EasyStream of(List<Integer> source) {
        return new StreamBuilder().withListInteger(source).build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer integer : this.list) {
            tmp.add(fun.apply(integer));
        }
        return new StreamBuilder().withListInteger(tmp).build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> tmp = new ArrayList<>();
        for (Integer integer : this.list) {
            if (fun.test(integer)) {
                tmp.add(integer);
            }
        }
        return new StreamBuilder().withListInteger(tmp).build();
    }

    public List<Integer> collect() {
        return this.list;
    }

    public static class StreamBuilder {
        private EasyStream newStream;

        public StreamBuilder() {
            newStream = new EasyStream();
        }

        public StreamBuilder withListInteger(List<Integer> list) {
            newStream.list = list;
            return  this;
        }

        public EasyStream build() {
            return  newStream;
        }
    }
}
