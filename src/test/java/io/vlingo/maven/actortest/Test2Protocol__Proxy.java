// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

import io.vlingo.actors.Actor;
import io.vlingo.actors.DeadLetter;
import io.vlingo.actors.LocalMessage;
import io.vlingo.actors.Mailbox;

public class Test2Protocol__Proxy implements io.vlingo.maven.actortest.Test2Protocol {

  private static final String doOneThingRepresentation1 = "doOneThing()";
  private static final String doAnotherThingUsingRepresentation2 = "doAnotherThingUsing(java.lang.String, int)";
  private static final String somethingRatherWonderfulRepresentation3 = "somethingRatherWonderful(io.vlingo.maven.actortest.Test1Protocol)";

  private final Actor actor;
  private final Mailbox mailbox;

  public Test2Protocol__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  @Override
  public void doOneThing() {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<Test2Protocol> consumer = (actor) -> actor.doOneThing();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Test2Protocol.class, consumer, null, doOneThingRepresentation1); }
      else { mailbox.send(new LocalMessage<Test2Protocol>(actor, Test2Protocol.class, consumer, doOneThingRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, doOneThingRepresentation1));
    }
  }
  @Override
  public void doAnotherThingUsing(java.lang.String arg0, int arg1) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<Test2Protocol> consumer = (actor) -> actor.doAnotherThingUsing(arg0, arg1);
      if (mailbox.isPreallocated()) { mailbox.send(actor, Test2Protocol.class, consumer, null, doAnotherThingUsingRepresentation2); }
      else { mailbox.send(new LocalMessage<Test2Protocol>(actor, Test2Protocol.class, consumer, doAnotherThingUsingRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, doAnotherThingUsingRepresentation2));
    }
  }
  @Override
  public void somethingRatherWonderful(io.vlingo.maven.actortest.Test1Protocol arg0) {
    if (!actor.isStopped()) {
      final java.util.function.Consumer<Test2Protocol> consumer = (actor) -> actor.somethingRatherWonderful(arg0);
      if (mailbox.isPreallocated()) { mailbox.send(actor, Test2Protocol.class, consumer, null, somethingRatherWonderfulRepresentation3); }
      else { mailbox.send(new LocalMessage<Test2Protocol>(actor, Test2Protocol.class, consumer, somethingRatherWonderfulRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, somethingRatherWonderfulRepresentation3));
    }
  }
}
