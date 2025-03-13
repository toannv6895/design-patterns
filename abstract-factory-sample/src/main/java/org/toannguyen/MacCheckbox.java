package org.toannguyen;

public class MacCheckbox implements Checkbox {
    @Override
    public void toggle() {
        System.out.println("Mac checkbox toggled");
    }

    @Override
    public boolean isChecked() {
        return false;
    }
}
