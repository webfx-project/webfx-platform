/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.j2cl.java.text.generated;

public final class DateFormatSymbolsProvider {

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-AU");

  public final static String SELECTED_LOCALES = preventInlining("en-AU");

// locales=en-AU
//   ampm=am, pm
//   eras=BC, AD
//   months=January, February, March, April, May, June, July, August, September, October, November, December, 
//   shortMonths=Jan, Feb, Mar, Apr, May, June, July, Aug, Sept, Oct, Nov, Dec, 
//   shortWeekdays=Sun, Mon, Tue, Wed, Thu, Fri, Sat
//   weekdays=Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
// 


  public final static String DATA = preventInlining("1,1,en-AU,2,am,pm,2,BC,AD,13,January,February,March,April,May,June,July,August,September,October,November,December,,13,Jan,Feb,Mar,Apr,May,June,July,Aug,Sept,Oct,Nov,Dec,,7,Sun,Mon,Tue,Wed,Thu,Fri,Sat,7,Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday");

  private static String preventInlining(final String string){
    return string;
  }
}
