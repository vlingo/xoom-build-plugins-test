// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
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
import io.vlingo.common.SerializableConsumer;

public class Test1Protocol__Proxy implements io.vlingo.maven.actortest.Test1Protocol {

  private static final String doSomethingWithRepresentation1 = "doSomethingWith(java.lang.String, java.util.List<java.lang.String>)";
  private static final String doSomethingElseWithRepresentation2 = "doSomethingElseWith(int)";

  private final Actor actor;
  private final Mailbox mailbox;

  public Test1Protocol__Proxy(final Actor actor, final Mailbox mailbox){
    this.actor = actor;
    this.mailbox = mailbox;
  }

  @Override
  public void doSomethingWith(java.lang.String arg0, java.util.List<java.lang.String> arg1) {
    if (!actor.isStopped()) {
      final SerializableConsumer<Test1Protocol> consumer = (actor) -> actor.doSomethingWith(arg0, arg1);
      if (mailbox.isPreallocated()) { mailbox.send(actor, Test1Protocol.class, consumer, null, doSomethingWithRepresentation1); }
      else { mailbox.send(new LocalMessage<>(actor, Test1Protocol.class, consumer, doSomethingWithRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, doSomethingWithRepresentation1));
    }
  }
  @Override
  public void doSomethingElseWith(int arg0) {
    if (!actor.isStopped()) {
      final SerializableConsumer<Test1Protocol> consumer = (actor) -> actor.doSomethingElseWith(arg0);
      if (mailbox.isPreallocated()) { mailbox.send(actor, Test1Protocol.class, consumer, null, doSomethingElseWithRepresentation2); }
      else { mailbox.send(new LocalMessage<>(actor, Test1Protocol.class, consumer, doSomethingElseWithRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, doSomethingElseWithRepresentation2));
    }
  }
}
