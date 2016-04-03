/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.jodatime.api.datetime;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

/**
 * Tests specific to {@link org.assertj.jodatime.api.DateTimeAssert#isNotEqualTo(org.joda.time.DateTime)} that can't be
 * done in {@link org.assertj.core.api.AbstractAssert#isNotEqualTo(Object)} tests.
 * 
 * @author Joel Costigliola
 */
public class DateTimeAssert_isNotEqualTo_Test extends DateTimeAssertBaseTest {

  @Test
  public void isNotEqualTo_should_compare_datetimes_in_actual_timezone() {
    DateTime utcDateTime = new DateTime(2013, 6, 10, 2, 0, DateTimeZone.UTC);
    DateTimeZone cestTimeZone = DateTimeZone.forID("Europe/Berlin");
    DateTime cestDateTime = new DateTime(2013, 6, 10, 2, 0, cestTimeZone);
    // datetime are not equals because they are in different timezone
    assertThat(utcDateTime).as("in UTC time zone").isNotEqualTo(cestDateTime);
    assertThat(cestDateTime).as("in CEST time zone").isNotEqualTo(utcDateTime);
  }

  @Test
  public void should_handle_null_actual_gracefully() {
    // GIVEN
    DateTime nullDateTime = null;
    // THEN
    assertThat(nullDateTime).isNotEqualTo(DateTime.now());
  }

  @Test
  public void should_fail_if_both_actual_and_expected_are_null() {
    // GIVEN
    DateTime nullDateTime = null;
    // THEN
    try {
      assertThat(nullDateTime).isNotEqualTo(nullDateTime);
    } catch (AssertionError e) {
      return;
    }
    fail("Should have thrown AssertionError");
  }
  
}
