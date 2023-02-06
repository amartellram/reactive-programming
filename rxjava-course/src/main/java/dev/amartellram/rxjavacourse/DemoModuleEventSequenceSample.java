package dev.amartellram.rxjavacourse;

import dev.amartellram.rxjavacourse.utility.GateBasedSynchronization;
import dev.amartellram.rxjavacourse.utility.datasets.GreekAlphabet;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoModuleEventSequenceSample {

    private static Logger log = LoggerFactory.getLogger(DemoModuleEventSequenceSample.class);
    public static void main(String[] args) {

        GateBasedSynchronization gate = new GateBasedSynchronization();

        Observable.fromArray(GreekAlphabet.greekLetters)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull String onNextLetter) {
                        log.info("onNext - {}", onNextLetter);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        log.error("onError - {}", throwable.getMessage());
                        gate.openGate("onError");
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                        gate.openGate("onComplete");
                    }
                });

        System.exit(0);
    }
}
