package hwr.oop.examples.classes.comparability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class ComparabilityTest {

    private Train first;
    private Train second;
    private Train third;

    @BeforeEach
    void setUp() {
        first = new Train(12);
        second = new Train(13);
        third = new Train(11);
    }

    @Test
    void compareTo_FirstDrivesFasterThanSecond_FirstIsGreaterThanSecond() {
        first.accelerateTo(100);
        second.accelerateTo(90);
        int compareToResult = first.compareTo(second);
        assertThat(compareToResult).isPositive().isNotZero();
    }

    @Test
    void compareTo_FirstDrivesFasterThanSecond_SecondIsLessThanFirst() {
        first.accelerateTo(100);
        second.accelerateTo(90);
        int compareToResult = second.compareTo(first);
        assertThat(compareToResult).isNegative().isNotZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainShorter_FirstLessThanSecond() {
        Comparator<Train> comparator = new RailCarComparator();
        int result = comparator.compare(first, second);
        assertThat(result).isNegative().isNotZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainShorter_SecondTrainGreaterThanFirst() {
        Comparator<Train> comparator = new RailCarComparator();
        int result = comparator.compare(second, first);
        assertThat(result).isPositive().isNotZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainSameSizeSecondTrainSameSizeThirdTrain_AllSameSize() {
        Comparator<Train> comparator = new RailCarComparator();
        first = new Train(11);
        second = new Train(11);
        third = new Train(11);
        int result = comparator.compare(first, second);
        assertThat(result).isZero();
        result = comparator.compare(second, third);
        assertThat(result).isZero();
        result = comparator.compare(first, third);
        assertThat(result).isZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainSameSizeSecondTrainSameSizeThirdTrain_NotAllSameSize() {
        Comparator<Train> comparator = new RailCarComparator();
        int result = comparator.compare(first, second);
        assertThat(result).isNotZero();
        result = comparator.compare(second, third);
        assertThat(result).isNotZero();
        result = comparator.compare(first, third);
        assertThat(result).isNotZero();
    }

    @Test
    void compareTo_FirstTrainSameSizeSecondTrainSameSizeThirdTrain_AllSameSize() {
        first.accelerateTo(100);
        second.accelerateTo(100);
        third.accelerateTo(100);

        int result = first.compareTo(second);
        assertThat(result).isZero();
        result = second.compareTo(third);
        assertThat(result).isZero();
        result = first.compareTo(third);
        assertThat(result).isZero();
    }

    @Test
    void compareTo_FirstTrainSameSizeSecondTrainSameSizeThirdTrain_NotAllSameSize() {
        first.accelerateTo(80);
        second.accelerateTo(100);
        third.accelerateTo(50);

        int result = first.compareTo(second);
        assertThat(result).isNotZero();
        result = second.compareTo(third);
        assertThat(result).isNotZero();
        result = first.compareTo(third);
        assertThat(result).isNotZero();
    }
}
