// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

import java.util.List;

import io.vlingo.actors.Actor;

public class Test1ProtocolActor extends Actor implements Test1Protocol {
  public static int doSomethingElseWithValue;
  public static String doSomethingWith;
  
  @Override
  public void doSomethingWith(String name, List<String> texts) {
    final StringBuilder builder = new StringBuilder();
    
    builder.append(name);
    
    for (final String text : texts) {
      builder.append(text);
    }

    doSomethingWith = builder.toString();
  }

  @Override
  public void doSomethingElseWith(int value) {
    doSomethingElseWithValue = value;
  }
}
