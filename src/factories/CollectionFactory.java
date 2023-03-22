package factories;

import enumerations.IterationOrder;

import java.util.*;

public class CollectionFactory {
    private static CollectionFactory instance = null;

    private CollectionFactory() {
    }

    public static CollectionFactory getInstance() {
        if (instance == null) {
            instance = new CollectionFactory();
        }
        return instance;
    }

    public <T> Collection<T> createInstance(int size, IterationOrder order, boolean allowDuplicates) {
        if (size != -1 && order == IterationOrder.INSERTION) {
            return new ArrayList<>();
        }
        if (size == -1 && order == IterationOrder.INSERTION) {
            return new LinkedList<>();
        }
        if (size == -1 && !allowDuplicates) {
            return new HashSet<>();
        }
        if (size == -1 && !allowDuplicates && order == IterationOrder.NATURAL) {
            return new TreeSet<>();
        }
        throw new IllegalArgumentException("Invalid parameters");
    }
}
