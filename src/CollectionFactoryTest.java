import java.util.Collection;

import enumerations.IterationOrder;
import factories.CollectionFactory;

public class CollectionFactoryTest {
    public static void main(String[] args) {
        CollectionFactory collectionFactory = CollectionFactory.getInstance();

        Collection<String> collection1 = collectionFactory.createInstance(true, IterationOrder.INSERTION, false);
        collection1.add("foo");
        collection1.add("bar");
        collection1.add("baz");
        System.out.println("collection1: " + collection1 + " " + collection1.getClass());

        Collection<Integer> collection2 = collectionFactory.createInstance(false, IterationOrder.INSERTION, false);
        collection2.add(42);
        collection2.add(13);
        System.out.println("collection2: " + collection2+ " " + collection2.getClass());

        Collection<String> collection3 = collectionFactory.createInstance(false, IterationOrder.ANY, false);
        collection3.add("foo");
        collection3.add("bar");
        collection3.add("baz");
        System.out.println("collection3: " + collection3+ " " + collection3.getClass());

        Collection<String> collection4 = collectionFactory.createInstance(false, IterationOrder.NATURAL, false);
        collection4.add("baz");
        collection4.add("foo");
        collection4.add("bar");
        collection4.add("bat");
        System.out.println("collection4: " + collection4+ " " + collection4.getClass());

        try {
            Collection<String> collection5 = collectionFactory.createInstance(true, IterationOrder.NATURAL, true);
            System.out.println("collection5: " + collection5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}