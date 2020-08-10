import com.sun.scenario.effect.Merge;

interface SortingStrategy {
    int[] sort(int[] array);
}

class QuickSort implements SortingStrategy {
    @Override
    public int[] sort(int[] array) {
        // Quick sort algorithm
        return new int[0];
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public int[] sort(int[] array) {
        // Merge sort algorithm
        return new int[0];
    }
}

class SortStrategyContext {
    private SortingStrategy strategy;

    public SortStrategyContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] executeSort(int[] array) {
        return strategy.sort(array);
    }
}

public class Strategy {
    public static void main(String[] args) {
        int[] array = getArray();

        SortStrategyContext context = new SortStrategyContext(
                new QuickSort()
        );
        context.executeSort(array);

        context.setStrategy(new MergeSort());

        context.executeSort(array);
    }
}