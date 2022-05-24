package LeetcodeTestCase;

public class TestCaseExecutor {
    private String string = "";

    public TestCaseExecutor(TestCase... testcases) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcases.length; i++) {
            if(i !=0)sb.append("\n");
            var testcase = testcases[i];
            sb.append("%s ------> %s \n".formatted("testcase " + (i + 1), testcase.getInput()));
            var functions = testcase.getFunctions();
            for (int j = 0; j < functions.length; j++) {
                if(functions[j].isHide())continue;
                sb.append("%s         %s \n".formatted(functions[j].getTitle(), functions[j].getFn().run()));
            }

        }
        string = sb.toString();
        print();
    }

    public void print() {

        System.out.println(string);
    }
}
