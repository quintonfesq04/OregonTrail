package Stuff;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

class JTextFieldLimit extends DocumentFilter {
    private int limit;

    public JTextFieldLimit(int limit, int i) {
        this.limit = limit;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;

        if ((fb.getDocument().getLength() + string.length()) <= limit) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) return;

        int newLength = fb.getDocument().getLength() + text.length() - length;
        if (newLength <= limit) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
