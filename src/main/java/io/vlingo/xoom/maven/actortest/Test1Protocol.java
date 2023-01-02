// Copyright © 2012-2023 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.xoom.maven.actortest;

import java.util.List;

public interface Test1Protocol {
  void doSomethingWith(final String name, final List<String> texts);
  void doSomethingElseWith(final int value);
}
