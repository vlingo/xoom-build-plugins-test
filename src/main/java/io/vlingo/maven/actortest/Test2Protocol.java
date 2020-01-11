// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.actortest;

public interface Test2Protocol {
  void doOneThing();
  void doAnotherThingUsing(final String text, final int value);
  void somethingRatherWonderful(final Test1Protocol test1);
}
