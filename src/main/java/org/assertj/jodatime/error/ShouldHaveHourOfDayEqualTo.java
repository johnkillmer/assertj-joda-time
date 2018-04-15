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
package org.assertj.jodatime.error;

import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;
import org.joda.time.DateTime;

/**
 * Creates an error message indicating that an assertion that verifies a {@link DateTime} has a hour of day
 * equal to a given one failed.
 *
 * @author John Killmer
 */
public class ShouldHaveHourOfDayEqualTo extends BasicErrorMessageFactory {

    /**
     * Creates a new </code>{@link ShouldHaveHourOfDayEqualTo }</code>.
     *
     * @param actual the actual value in the failed assertion.
     * @param expectedHourOfDay the value used in the failed assertion to compare the actual value to.
     * @return the created {@code ErrorMessageFactory}.
     */
    public static ErrorMessageFactory shouldHaveHoursEqualTo(DateTime actual, int expectedHourOfDay) {
        return new ShouldHaveHourOfDayEqualTo(actual, expectedHourOfDay);
    }

    private ShouldHaveHourOfDayEqualTo(DateTime actual, int expectedHourOfDay) {
        super("%nExpecting:%n  <%s>%nto have the hour of day equal to:%n  <%s>%nbut was:%n  <%s>", actual, expectedHourOfDay,
                actual.getHourOfDay());
    }

}
