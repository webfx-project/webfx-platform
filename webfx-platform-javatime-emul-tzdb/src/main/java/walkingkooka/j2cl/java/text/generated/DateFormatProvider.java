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

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-US");

  public final static String SELECTED_LOCALES = preventInlining("en-US");

// locales=en-US
// 
//   DateInstance SHORT pattern=M/d/yy
//   DateInstance MEDIUM pattern=MMM d, y
//   DateInstance LONG pattern=MMMM d, y
//   DateInstance FULL pattern=EEEE, MMMM d, y
//   DateTimeInstance SHORT, SHORT pattern=M/d/yy, h:mm a
//   DateTimeInstance SHORT, MEDIUM pattern=M/d/yy, h:mm:ss a
//   DateTimeInstance SHORT, LONG pattern=M/d/yy, h:mm:ss a z
//   DateTimeInstance SHORT, FULL pattern=M/d/yy, h:mm:ss a zzzz
//   DateTimeInstance MEDIUM, SHORT pattern=MMM d, y, h:mm a
//   DateTimeInstance MEDIUM, MEDIUM pattern=MMM d, y, h:mm:ss a
//   DateTimeInstance MEDIUM, LONG pattern=MMM d, y, h:mm:ss a z
//   DateTimeInstance MEDIUM, FULL pattern=MMM d, y, h:mm:ss a zzzz
//   DateTimeInstance LONG, SHORT pattern=MMMM d, y, h:mm a
//   DateTimeInstance LONG, MEDIUM pattern=MMMM d, y, h:mm:ss a
//   DateTimeInstance LONG, LONG pattern=MMMM d, y 'at' h:mm:ss a z
//   DateTimeInstance LONG, FULL pattern=MMMM d, y 'at' h:mm:ss a zzzz
//   DateTimeInstance FULL, SHORT pattern=EEEE, MMMM d, y, h:mm a
//   DateTimeInstance FULL, MEDIUM pattern=EEEE, MMMM d, y, h:mm:ss a
//   DateTimeInstance FULL, LONG pattern=EEEE, MMMM d, y 'at' h:mm:ss a z
//   DateTimeInstance FULL, FULL pattern=EEEE, MMMM d, y 'at' h:mm:ss a zzzz
//   TimeInstance SHORT pattern=h:mm a
//   TimeInstance MEDIUM pattern=h:mm:ss a
//   TimeInstance LONG pattern=h:mm:ss a z
//   TimeInstance FULL pattern=h:mm:ss a zzzz


  public final static String DATA = preventInlining("1,1,en-US,M/d/yy,MMM d\\, y,MMMM d\\, y,EEEE\\, MMMM d\\, y,M/d/yy\\, h:mm a,M/d/yy\\, h:mm:ss a,M/d/yy\\, h:mm:ss a z,M/d/yy\\, h:mm:ss a zzzz,MMM d\\, y\\, h:mm a,MMM d\\, y\\, h:mm:ss a,MMM d\\, y\\, h:mm:ss a z,MMM d\\, y\\, h:mm:ss a zzzz,MMMM d\\, y\\, h:mm a,MMMM d\\, y\\, h:mm:ss a,MMMM d\\, y \'at\' h:mm:ss a z,MMMM d\\, y \'at\' h:mm:ss a zzzz,EEEE\\, MMMM d\\, y\\, h:mm a,EEEE\\, MMMM d\\, y\\, h:mm:ss a,EEEE\\, MMMM d\\, y \'at\' h:mm:ss a z,EEEE\\, MMMM d\\, y \'at\' h:mm:ss a zzzz,h:mm a,h:mm:ss a,h:mm:ss a z,h:mm:ss a zzzz");

  private static String preventInlining(final String string){
    return string;
  }
}
