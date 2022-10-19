package pessoa;

public enum FUSOHORARIO {
    BR("-3"),
    S("-4"),
    FR("+2");

    private String gmt;

    private FUSOHORARIO(String gmt) {
        this.gmt = gmt;
    }

    public String getGmt() {
        return gmt;
    }
}
