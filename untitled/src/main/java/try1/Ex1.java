package try1;


import io.reactivex.rxjava3.core.Observable;

public class Ex1 {

    // 비동기와 동기
    public void foo1(){
        Observable.create(s -> {
            s.onNext("Hello World!");
            s.onComplete();
        }).subscribe(hello -> System.out.println(hello));
    }

}
