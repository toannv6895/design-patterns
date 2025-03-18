package org.toannguyen.decorator;

import org.toannguyen.common.newer.NotificationChannel;

abstract class NotificationDecorator implements NotificationChannel {
    protected NotificationChannel wrapped;

    public NotificationDecorator(NotificationChannel wrapped) {
        this.wrapped = wrapped;
    }
}
