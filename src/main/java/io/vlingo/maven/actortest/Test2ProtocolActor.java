// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

import java.util.Arrays;

import io.vlingo.actors.Actor;
import io.vlingo.actors.ActorInstantiator;

public class Test2ProtocolActor extends Actor implements Test2Protocol {
  public static String doOneThing;
  public static String doAnotherThingUsing;
  public static String somethingRatherWonderful;

  @Override
  public void doOneThing() {
    doOneThing = "doOneThing";
  }

  @Override
  public void doAnotherThingUsing(final String text, final int value) {
    doAnotherThingUsing = "doAnotherThingUsing: " + text + value;
  }

  @Override
  public void somethingRatherWonderful(final Test1Protocol test1) {
    test1.doSomethingElseWith(1);
    test1.doSomethingWith("testing", Arrays.asList("one", "two", "three"));
    somethingRatherWonderful = "somethingRatherWonderful: " + Test1ProtocolActor.doSomethingElseWithValue + Test1ProtocolActor.doSomethingWith;
  }

  public static class Test2ProtocolActorInstantiator implements ActorInstantiator<Test2ProtocolActor> {
    public static Test2ProtocolActorInstantiator Instantiator = new Test2ProtocolActorInstantiator();

    @Override
    public Test2ProtocolActor instantiate() {
      return new Test2ProtocolActor();
    }

    @Override
    public Class<Test2ProtocolActor> type() {
      return Test2ProtocolActor.class;
    }
  }
}
