package org.paumard.lambda;

@FunctionalInterface
public interface Predicate<T> {

    public boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    static <K> Predicate<K> isEqueal(K k) {
        return s -> s.equals(k);
    }
}
