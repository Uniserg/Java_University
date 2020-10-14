package com.company.StringBuilder;

public class myNotifier implements Notifier {
    @Override
    public void apply(NotifyingStringBuilder stringBuilder) {
        System.out.println("Changed: " + stringBuilder.toString());
    }
}
