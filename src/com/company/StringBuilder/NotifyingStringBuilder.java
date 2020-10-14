package com.company.StringBuilder;


public class NotifyingStringBuilder {
    private final StringBuilder stringBuilder;
    private Notifier notifier;

    public NotifyingStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    private void notifySB() {
        if (notifier != null) {
            notifier.apply(this);
        }
    }

    public NotifyingStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        notifySB();
        return this;
    }

    public NotifyingStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifySB();
        return this;
    }

    public NotifyingStringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        notifySB();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
