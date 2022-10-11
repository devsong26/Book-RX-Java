package try1;


import io.reactivex.rxjava3.core.Observable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Ex1 <T>{

    final String SOME_KEY = "key";

    // 비동기와 동기
    public void foo1(){
        Observable.create(s -> {
            s.onNext("Hello World!");
            s.onComplete();
        }).subscribe(hello -> System.out.println(hello));
    }

    // 메모리 내부 데이터
    public void foo2(){
        final Map<String, String> cache = new ConcurrentHashMap<>();

        Observable.create(s -> {
            s.onNext(cache.get(SOME_KEY));
            s.onComplete();
        }).subscribe(value -> System.out.println(value));
    }

    public <T> void foo3(){
        Observable.create(s -> {
            T fromCache = (T) getFromCache(SOME_KEY);
            if (fromCache != null){
                // 동기적인 방출
                s.onNext(fromCache);
                s.onComplete();
            } else {
                // 비동기로 가져온다.
                getDataAsynchronously(SOME_KEY)
                        .onResponse(v -> {
                            s.onNext(v);
                            s.onComplete();
                        })
                        .onFailure(exception -> {
                            s.onError(exception);
                        });
            }
        }).subscribe(s -> System.out.println(s));
    }

    private class RxCls {
        RxCls onResponse(Consumer consumer){
            return this;
        }

        RxCls onFailure(Consumer<Throwable> consumer){
            return this;
        }
    }

    private RxCls getDataAsynchronously(String some_key) {
        return null;
    }

    private T getFromCache(String key){
        return null;
    }



}
