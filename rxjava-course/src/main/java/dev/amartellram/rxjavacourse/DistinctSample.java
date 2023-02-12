package dev.amartellram.rxjavacourse;

import dev.amartellram.rxjavacourse.utility.datasets.GreekAlphabet;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistinctSample {

    private static Logger log = LoggerFactory.getLogger(DistinctSample.class);

    public static void main(String[] args) {
        Observable<String> greekAlphabet = GreekAlphabet.greekAlphabetInEnglishObservable()
                .repeat(3);

        greekAlphabet.distinct().subscribe(nextLetter -> log.info("onNext - {}", nextLetter),
                throwable -> log.error(throwable.getMessage(), throwable),
                () -> log.info("onComplete"));

        System.exit(0);
    }
}
