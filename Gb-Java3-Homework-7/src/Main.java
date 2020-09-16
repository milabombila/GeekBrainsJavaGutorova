/**
 * Java3. HomeWork7
 * @author Yury Mitroshin
 * @version dated March 19, 2018
 * @link https://github.com/yurchess
 */

import myTesting.TestsHandler;

public class Main {
    public static void main(String[] args) {
        /**
         * Task1
         */
        ClassForTesting classForTesting = new ClassForTesting();
        TestsHandler.start(classForTesting.getClass());

        /**
         * Task2
         */
        System.out.println();
        ClassExplorer.outClassInfo(String.class);
    }
}
