package TestSuite;

public class TestCase<O>{
    private String input = null;
    private String output = null;
    private TestCaseFunctionGroup[] functions = null;

    public TestCase(String input, TestCaseFunctionGroup... functions){
        this.input = input;
        this.functions = functions;
    }
    public TestCase(String input,String output, TestCaseFunctionGroup... functions){
        this.input = input;
        this.output = output;
        this.functions = functions;
    }

    public String getInput(){
        return input;
    }
    public String getOutput(){
        return output;
    }

    public TestCaseFunctionGroup[] getFunctions() {
        return functions;
    }
}
