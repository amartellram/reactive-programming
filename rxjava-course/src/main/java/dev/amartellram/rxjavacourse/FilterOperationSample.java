package dev.amartellram.rxjavacourse;

import dev.amartellram.rxjavacourse.utility.datasets.GreekAlphabet;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterOperationSample {

    private static Logger log = LoggerFactory.getLogger(DemoModuleEventSequenceSample.class);

    public static void main(String[] args) {

        //Filter
        Observable<String> greekAlphabet = GreekAlphabet.greekAlphabetInEnglishObservable()
                .filter(nextLetter -> !nextLetter.equals("delta"));

        greekAlphabet.subscribe(
                nextLetter -> log.info("onNext - {}", nextLetter),
                throwable -> log.error(throwable.getMessage(), throwable),
                () -> log.info("onComplete")
        );

        System.exit(0);

    }
}
