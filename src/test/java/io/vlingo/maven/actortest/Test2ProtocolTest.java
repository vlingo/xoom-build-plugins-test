// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.vlingo.actors.Definition;
import io.vlingo.actors.testkit.TestActor;
import io.vlingo.actors.testkit.TestWorld;

public class Test2ProtocolTest {
  private TestWorld testWorld;
  
  @Test
  public void testDoOneThing() {
    final TestActor<Test2Protocol> test2 = testWorld.actorFor(Definition.has(Test2ProtocolActor.class, Definition.NoParameters), Test2Protocol.class);
    
    test2.actor().doOneThing();
    assertEquals("doOneThing", Test2ProtocolActor.doOneThing);
  }
  
  @Test
  public void testDoAnotherThingUsing() {
    final TestActor<Test2Protocol> test2 = testWorld.actorFor(Definition.has(Test2ProtocolActor.class, Definition.NoParameters), Test2Protocol.class);
    
    test2.actor().doAnotherThingUsing("hello", 1);
    assertEquals("doAnotherThingUsing: hello1", Test2ProtocolActor.doAnotherThingUsing);
  }
  
  @Test
  public void testSomethingRatherWonderful() {
    final TestActor<Test1Protocol> test1 = testWorld.actorFor(Definition.has(Test1ProtocolActor.class, Definition.NoParameters), Test1Protocol.class);
    final TestActor<Test2Protocol> test2 = testWorld.actorFor(Definition.has(Test2ProtocolActor.class, Definition.NoParameters), Test2Protocol.class);
    
    test2.actor().somethingRatherWonderful(test1.actor());
    assertEquals("somethingRatherWonderful: 1testingonetwothree", Test2ProtocolActor.somethingRatherWonderful);
  }
  
  @Before
  public void setUp() {
    testWorld = TestWorld.start("test-proxy");
    
    Test1ProtocolActor.doSomethingElseWithValue = 0;
    Test1ProtocolActor.doSomethingWith = null;
    
    Test2ProtocolActor.doAnotherThingUsing = null;
    Test2ProtocolActor.doOneThing = null;
    Test2ProtocolActor.somethingRatherWonderful = null;
  }
  
  @After
  public void tearDown() {
    testWorld.terminate();
  }
}
