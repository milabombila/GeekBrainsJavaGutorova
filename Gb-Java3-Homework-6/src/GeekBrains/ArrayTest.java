package GeekBrains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

class ArrayTest {

    //    Few tests doesn't pass, just to check how it works.
    @Test
    void refactorTestCorrectInput() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 6, 7}, changingArrays.refactorArray(new int[]{4, 1, 2, 3, 6, 7}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 6, 7}, changingArrays.refactorArray(new int[]{1, 2, 3, 4, 5, 3, 2, 4, 1, 2, 3, 6, 7}));
        Assertions.assertArrayEquals(new int[]{4, 6, 7}, changingArrays.refactorArray(new int[]{4, 1, 2, 3, 3, 4, 4, 4, 6, 7}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 6, 7}, changingArrays.refactorArray(new int[]{1, 2, 1222, 4, 23, 34, 1, 4, 1, 2, 3, 6, 7}));
        Assertions.assertArrayEquals(new int[]{}, changingArrays.refactorArray(new int[]{1, 2, 3, 4, 4, 4, 4, 4}));
        Assertions.assertArrayEquals(new int[]{1, 3, 4, 5}, changingArrays.refactorArray(new int[]{1, 2, 3, 4, 4, 4, 4, 4}));
    }

    @Test
    void refactorTestException() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.refactorArray(new int[]{1, 2, 3, 6, 7});
            }
        });
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.refactorArray(new int[]{1, 2, 5, 1, 1, 1, 2, 3});
            }
        });
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.refactorArray(null);
            }
        });

    }

    @Test
    void checkArrayTestInput() {
        Assertions.assertEquals(true, changingArrays.arrayCheckForOneAndFour(new int[]{1, 4}));
        Assertions.assertEquals(true, changingArrays.arrayCheckForOneAndFour(new int[]{1, 4, 1, 1, 1, 1, 4, 4, 1}));
        Assertions.assertEquals(false, changingArrays.arrayCheckForOneAndFour(new int[]{1, 1, 1, 1, 1}));
        Assertions.assertEquals(false, changingArrays.arrayCheckForOneAndFour(new int[]{4, 4, 4, 4, 4}));

    }

    @Test
    void arrayCheckTestException() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.arrayCheckForOneAndFour(new int[]{1, 1, 3, 4, 5});
            }
        });
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.arrayCheckForOneAndFour(new int[]{0, 1, 3, 4, 5});
            }
        });

    }
    @ParameterizedTest
    @NullSource
    void arrayCheckTestExceptionForNull(int[] arr) {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                changingArrays.arrayCheckForOneAndFour(arr);
            }
        });
    }

}