import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * "Driver class" to exercise the test methods provided in the class
 * EntryTest.java
 *  @author Nuchem Katz
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ EntryTest.class })

public class EntryTestSuite {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EntryTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }

}