package dev.khusanjon.supervision;

import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class SystemSupervisor extends AbstractBehavior<Void> {

    public static Behavior<Void> create() {
        return Behaviors.setup(SystemSupervisor::new);
    }

    private SystemSupervisor(ActorContext<Void> context) {
        super(context);
        context.getLog().info("SystemSupervisor has started.");
    }

    @Override
    public Receive<Void> createReceive() {
        return newReceiveBuilder()
                .onSignal(PostStop.class, signal -> onPostStop())
                .build();
    }

    private Behavior<Void> onPostStop() {
        System.out.println("SystemSupervisor has stopped.");
        return this;
    }
}
