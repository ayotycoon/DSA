package TestSuite;

public class TestCaseFunctionGroup {
    private String title;
    private TestCaseLambdaI fn;
    private boolean hide = false;

    public TestCaseFunctionGroup(String title, TestCaseLambdaI fn) {
        this.title = title;
        this.fn = fn;
    }

    public TestCaseFunctionGroup(String title, TestCaseLambdaI fn, boolean hide) {
        this.title = title;
        this.fn = fn;
        this.hide = hide;
    }

    public String getTitle() {
        return title;
    }

    public TestCaseLambdaI getFn() {
        return fn;
    }

    public boolean isHide() {
        return hide;
    }
}
