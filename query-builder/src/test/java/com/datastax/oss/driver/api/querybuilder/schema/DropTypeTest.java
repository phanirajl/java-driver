/*
 * Copyright DataStax, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.oss.driver.api.querybuilder.schema;

import static com.datastax.oss.driver.api.querybuilder.Assertions.assertThat;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilderDsl.dropType;

import org.junit.Test;

public class DropTypeTest {

  @Test
  public void should_generate_drop_type() {
    assertThat(dropType("bar")).hasCql("DROP TYPE bar");
  }

  @Test
  public void should_generate_drop_type_with_keyspace() {
    assertThat(dropType("foo", "bar")).hasCql("DROP TYPE foo.bar");
  }

  @Test
  public void should_generate_drop_type_if_exists() {
    assertThat(dropType("bar").ifExists()).hasCql("DROP TYPE IF EXISTS bar");
  }
}
