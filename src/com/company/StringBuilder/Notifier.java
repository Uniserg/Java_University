package com.company.StringBuilder;

@FunctionalInterface
interface Notifier {
    void apply(NotifyingStringBuilder stringBuilder);
}
