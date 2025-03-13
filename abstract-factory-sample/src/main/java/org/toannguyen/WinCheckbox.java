package org.toannguyen;

public class WinCheckbox implements Checkbox {
    @Override
    public void toggle() {
        System.out.println("WinCheckbox toggle");
    }

    @Override
    public boolean isChecked() {
        return true;
    }
}
