package try1;

public interface ObserverMimic<T> {

    void onNext(T t); // onNext 함수를 통한 데이터
    void onError(Throwable t); // onError 함수를 통한 오류 (Exception 혹은 Throwable)
    void onCompleted(); // onCompleted 함수를 통한 스트림 완료 통보

}
