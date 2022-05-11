package LeetcodeTestCase;

public class TestCaseFunctionGroup {
    private String title;
    private TestCaseLambdaI fn;

    public TestCaseFunctionGroup(String title, TestCaseLambdaI fn) {
        this.title = title;
        this.fn = fn;
    }

    public String getTitle() {
        return title;
    }

    public TestCaseLambdaI getFn() {
        return fn;
    }
}
