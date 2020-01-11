// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.vlingo.actors.Definition;
import io.vlingo.actors.testkit.TestActor;
import io.vlingo.actors.testkit.TestWorld;
import io.vlingo.maven.actortest.Test1ProtocolActor.Test1ProtocolActorInstantiator;

public class Test1ProtocolTest {
  private TestWorld testWorld;

  @Test
  public void testProtocolProxy() {
    final TestActor<Test1Protocol> test1 = testWorld.actorFor(Test1Protocol.class, Definition.has(Test1ProtocolActor.class, Test1ProtocolActorInstantiator.Instantiator));

    test1.actor().doSomethingElseWith(1);
    assertEquals(1, Test1ProtocolActor.doSomethingElseWithValue);

    test1.actor().doSomethingWith("zero", Arrays.asList("one", "two", "three"));
    assertEquals("zeroonetwothree", Test1ProtocolActor.doSomethingWith);
  }

  @Before
  public void setUp() {
    testWorld = TestWorld.start("test-proxy");
    Test1ProtocolActor.doSomethingElseWithValue = 0;
    Test1ProtocolActor.doSomethingWith = null;
  }

  @After
  public void tearDown() {
    testWorld.terminate();
  }
}
