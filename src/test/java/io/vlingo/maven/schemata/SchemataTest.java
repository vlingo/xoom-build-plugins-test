// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.maven.schemata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import schemata.event.SchemaDefined;

import static junit.framework.TestCase.assertNotNull;

public class SchemataTest {

    @Test
    public void pulledSchemaIsCompiled() {
     SchemaDefined event = new SchemaDefined();
     assertNotNull(event);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
