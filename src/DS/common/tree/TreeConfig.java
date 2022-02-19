package common.tree;

public class TreeConfig {
    private char nullChar = 'n';

    public TreeConfig() {
    }

    public TreeConfig(char nullChar) {
        this.nullChar = nullChar;
    }

    public void setNullChar(char nullChar) {
        this.nullChar = nullChar;
    }
    public char getNullChar() {
        return nullChar;
    }




}
