package try1;

public interface SubscriberMimic<T> extends ObserverMimic<T>, SubscriptionMimic {

    void onNext(T t);
    void onError(Throwable t);
    void onCompleted();

    void unsubscribe();
    void setProducer(ProducerMimic p);

}
