package dev.khusanjon;

import akka.actor.typed.ActorSystem;
import dev.khusanjon.supervision.SystemSupervisor;

public class IotMain {
    public static void main(String[] args) {
        ActorSystem.create(SystemSupervisor.create(), "iot-supervisor");
    }
}