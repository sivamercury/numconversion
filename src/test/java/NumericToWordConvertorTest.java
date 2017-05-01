import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by avis on 30/04/17.
 */
@RunWith(JUnitParamsRunner.class)
public class NumericToWordConvertorTest {
    private NumericToWordConvertor numericToWordConvertor = new NumericToWordConvertor();

    @Test
    @Parameters({"235,two hundred thirty five",
            "12,twelve",
            "1245,one thousand two hundred forty five",
            "321245,three hundred twenty one thousand two hundred forty five",
            "-825,negative eight hundred twenty five"})
    @TestCaseName("givenNumber({0})_testConvert_returnsWord({1})")
    public void convert(int number, String expected) throws Exception {
        String actual = numericToWordConvertor.convert(number);
        assertEquals(expected, actual);
    }

}