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

public final class DecimalFormatProvider {

  // constants used by parse.

  public final static int PARSE_NONE = 0;
  public final static int PARSE_INTEGER_ONLY = 1;
  public final static int PARSE_BIG_DECIMAL = 2;

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-AU");

  public final static String SELECTED_LOCALES = preventInlining("en-AU");

// locales=en-AU
//   
//   Currency decimalSeparatorAlwaysShown=false
//   Currency groupingSize=3
//   Currency groupingUsed=true
//   Currency maximumFractionDigits=2
//   Currency minimumFractionDigits=2
//   Currency maximumIntegerDigits=2147483647
//   Currency minimumIntegerDigits=1
//   Currency multiplier=1
//   Currency negativePrefix=-$
//   Currency negativeSuffix=
//   Currency parse=0
//   Currency pattern=¤#,##0.00
//   Currency positivePrefix=$
//   Currency positiveSuffix=
//   Currency roundingMode=HALF_EVEN
//   
//   Instance decimalSeparatorAlwaysShown=false
//   Instance groupingSize=3
//   Instance groupingUsed=true
//   Instance maximumFractionDigits=3
//   Instance minimumFractionDigits=0
//   Instance maximumIntegerDigits=2147483647
//   Instance minimumIntegerDigits=1
//   Instance multiplier=1
//   Instance negativePrefix=-
//   Instance negativeSuffix=
//   Instance parse=0
//   Instance pattern=#,##0.###
//   Instance positivePrefix=
//   Instance positiveSuffix=
//   Instance roundingMode=HALF_EVEN
//   
//   Integer decimalSeparatorAlwaysShown=false
//   Integer groupingSize=3
//   Integer groupingUsed=true
//   Integer maximumFractionDigits=0
//   Integer minimumFractionDigits=0
//   Integer maximumIntegerDigits=2147483647
//   Integer minimumIntegerDigits=1
//   Integer multiplier=1
//   Integer negativePrefix=-
//   Integer negativeSuffix=
//   Integer parse=1
//   Integer pattern=#,##0
//   Integer positivePrefix=
//   Integer positiveSuffix=
//   Integer roundingMode=HALF_EVEN
//   
//   Number decimalSeparatorAlwaysShown=false
//   Number groupingSize=3
//   Number groupingUsed=true
//   Number maximumFractionDigits=3
//   Number minimumFractionDigits=0
//   Number maximumIntegerDigits=2147483647
//   Number minimumIntegerDigits=1
//   Number multiplier=1
//   Number negativePrefix=-
//   Number negativeSuffix=
//   Number parse=0
//   Number pattern=#,##0.###
//   Number positivePrefix=
//   Number positiveSuffix=
//   Number roundingMode=HALF_EVEN
//   
//   Percent decimalSeparatorAlwaysShown=false
//   Percent groupingSize=3
//   Percent groupingUsed=true
//   Percent maximumFractionDigits=0
//   Percent minimumFractionDigits=0
//   Percent maximumIntegerDigits=2147483647
//   Percent minimumIntegerDigits=1
//   Percent multiplier=100
//   Percent negativePrefix=-
//   Percent negativeSuffix=%
//   Percent parse=0
//   Percent pattern=#,##0%
//   Percent positivePrefix=
//   Percent positiveSuffix=%
//   Percent roundingMode=HALF_EVEN
//   


  public final static String DATA = preventInlining("1,1,en-AU,03,12,2,2147483647,1,1,-$,,0,¤#\\,##0.00,$,,HALF_EVEN,03,13,0,2147483647,1,1,-,,0,#\\,##0.###,,,HALF_EVEN,03,10,0,2147483647,1,1,-,,1,#\\,##0,,,HALF_EVEN,03,13,0,2147483647,1,1,-,,0,#\\,##0.###,,,HALF_EVEN,03,10,0,2147483647,1,100,-,%,0,#\\,##0%,,%,HALF_EVEN");

  private static String preventInlining(final String string){
    return string;
  }
}
