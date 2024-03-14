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

public final class DecimalFormatSymbolsProvider {

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-US");

  public final static String SELECTED_LOCALES = preventInlining("en-US");

// locales=en-US
//   decimalSeparator=.
//   digit=#
//   exponentSeparator=E
//   groupingSeparator=,
//   infinity=∞
//   internationalCurrencySymbol=USD
//   minusSign=-
//   monetaryDecimalSeparator=.
//   nan=NaN
//   patternSeparator=;
//   percent=%
//   perMill=‰
//   zeroDigit=0
// 


  public final static String DATA = preventInlining("1,1,en-US,.#E,,∞,USD,-.NaN,;%‰0");

  private static String preventInlining(final String string){
    return string;
  }
}
