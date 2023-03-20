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

    public <T> Collection<T> createInstance(boolean knownSize, IterationOrder order, boolean allowDuplicates) {
        if (knownSize && order == IterationOrder.INSERTION) {
            return new ArrayList<>();
        }
        if (!knownSize && order == IterationOrder.INSERTION) {
            return new LinkedList<>();
        }
        if (!knownSize && !allowDuplicates) {
            return new HashSet<>();
        }
        if (!knownSize && !allowDuplicates && order == IterationOrder.NATURAL) {
            return new TreeSet<>();
        }
        throw new IllegalArgumentException("Invalid parameters");
    }
}
