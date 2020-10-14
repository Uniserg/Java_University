package com.company.StringBuilder;

import java.util.Stack;

public class UndoableStringBuilder {

    private final StringBuilder stringBuilder;
    private final Stack<Action> actions;


    public UndoableStringBuilder() {
        stringBuilder = new StringBuilder();
        actions = new Stack<>();
    }

    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);
        actions.add(new DeleteAction(str.length()));
        return this;
    }

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();

        Action action = stringBuilder::reverse;

        actions.add(action);

        return this;
    }

    public UndoableStringBuilder appendCodePoint(int codePoint) {
        stringBuilder.appendCodePoint(codePoint);
        actions.add(new DeleteAction(1));
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        actions.add(() -> stringBuilder.insert(start, deleted));
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(() -> stringBuilder.insert(index, deleted));
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        actions.add(() -> stringBuilder.replace(start, end, deleted));
        return this;
    }

    public UndoableStringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        actions.add(() -> stringBuilder.delete(index, index + len));
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        actions.add(() -> stringBuilder.delete(offset, offset + str.length()));
        return this;
    }

    public void undo() {
        if (!actions.isEmpty()) {
            actions.pop().undo();
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    @FunctionalInterface
    private interface Action {
        void undo();
    }

    private class DeleteAction implements Action {
        private final int size;

        public DeleteAction(int size) {
            this.size = size;
        }

        @Override
        public void undo() {
            stringBuilder.delete(stringBuilder.length() - size, stringBuilder.length());
        }
    }
}
