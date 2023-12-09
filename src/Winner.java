public class Winner {
    private String value;
    private boolean switcher;

    public Winner() {
        this.value = ""; // Initialize the value to an empty string or any default value you prefer
        this.switcher = false;
    }

    public String getValue() {
        return value;
    }

    public boolean getSwitcher() {
        return switcher;
    }

    public void setValue(String value, boolean switcher) {
        this.value = value;
        this.switcher = switcher;
    }

}