package LeetcodeTestCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCase<O>{
    private String input = null;
    private TestCaseFunctionGroup[] functions = null;

    public TestCase(String input, TestCaseFunctionGroup... functions){
        this.input = input;
        this.functions = functions;
    }

    public String getInput(){
        return input;
    }

    public TestCaseFunctionGroup[] getFunctions() {
        return functions;
    }
}
