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

public final class DateFormatProvider {

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-AU");

  public final static String SELECTED_LOCALES = preventInlining("en-AU");

// locales=en-AU
// 
//   DateInstance SHORT pattern=d/M/yy
//   DateInstance MEDIUM pattern=d MMM y
//   DateInstance LONG pattern=d MMMM y
//   DateInstance FULL pattern=EEEE, d MMMM y
//   DateTimeInstance SHORT, SHORT pattern=d/M/yy, h:mm a
//   DateTimeInstance SHORT, MEDIUM pattern=d/M/yy, h:mm:ss a
//   DateTimeInstance SHORT, LONG pattern=d/M/yy, h:mm:ss a z
//   DateTimeInstance SHORT, FULL pattern=d/M/yy, h:mm:ss a zzzz
//   DateTimeInstance MEDIUM, SHORT pattern=d MMM y, h:mm a
//   DateTimeInstance MEDIUM, MEDIUM pattern=d MMM y, h:mm:ss a
//   DateTimeInstance MEDIUM, LONG pattern=d MMM y, h:mm:ss a z
//   DateTimeInstance MEDIUM, FULL pattern=d MMM y, h:mm:ss a zzzz
//   DateTimeInstance LONG, SHORT pattern=d MMMM y, h:mm a
//   DateTimeInstance LONG, MEDIUM pattern=d MMMM y, h:mm:ss a
//   DateTimeInstance LONG, LONG pattern=d MMMM y 'at' h:mm:ss a z
//   DateTimeInstance LONG, FULL pattern=d MMMM y 'at' h:mm:ss a zzzz
//   DateTimeInstance FULL, SHORT pattern=EEEE, d MMMM y, h:mm a
//   DateTimeInstance FULL, MEDIUM pattern=EEEE, d MMMM y, h:mm:ss a
//   DateTimeInstance FULL, LONG pattern=EEEE, d MMMM y 'at' h:mm:ss a z
//   DateTimeInstance FULL, FULL pattern=EEEE, d MMMM y 'at' h:mm:ss a zzzz
//   TimeInstance SHORT pattern=h:mm a
//   TimeInstance MEDIUM pattern=h:mm:ss a
//   TimeInstance LONG pattern=h:mm:ss a z
//   TimeInstance FULL pattern=h:mm:ss a zzzz


  public final static String DATA = preventInlining("1,1,en-AU,d/M/yy,d MMM y,d MMMM y,EEEE\\, d MMMM y,d/M/yy\\, h:mm a,d/M/yy\\, h:mm:ss a,d/M/yy\\, h:mm:ss a z,d/M/yy\\, h:mm:ss a zzzz,d MMM y\\, h:mm a,d MMM y\\, h:mm:ss a,d MMM y\\, h:mm:ss a z,d MMM y\\, h:mm:ss a zzzz,d MMMM y\\, h:mm a,d MMMM y\\, h:mm:ss a,d MMMM y \'at\' h:mm:ss a z,d MMMM y \'at\' h:mm:ss a zzzz,EEEE\\, d MMMM y\\, h:mm a,EEEE\\, d MMMM y\\, h:mm:ss a,EEEE\\, d MMMM y \'at\' h:mm:ss a z,EEEE\\, d MMMM y \'at\' h:mm:ss a zzzz,h:mm a,h:mm:ss a,h:mm:ss a z,h:mm:ss a zzzz");

  private static String preventInlining(final String string){
    return string;
  }
}
