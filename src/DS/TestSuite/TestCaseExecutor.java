package TestSuite;

public class TestCaseExecutor {
    private String string = "";

    public TestCaseExecutor(TestCase... testcases) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcases.length; i++) {
            if (i != 0) sb.append("\n");
            var testcase = testcases[i];
            sb.append("%s --> %s | ".formatted("TC " + (i + 1), testcase.getInput()));
            var functions = testcase.getFunctions();
            for (int j = 0; j < functions.length; j++) {
                if (functions[j].isHide()) continue;
                String functionOutput = functions[j].getFn().run();
                if(testcase.getOutput() == null)sb.append("%s         %s | ".formatted(functions[j].getTitle(), functionOutput));
                else sb.append("%s         %s => %s | ".formatted(functions[j].getTitle(), functionOutput, functionOutput.equals(testcase.getOutput()) ? "✅":"❌"));
            }

        }
        string = sb.toString();
        print();
    }

    public void print() {

        System.out.println(string);
    }
}
