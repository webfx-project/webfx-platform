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

package walkingkooka.j2cl.java.util.timezone.generated;

public final class TimeZoneProvider {

  public final static String ANNOTATION_PROCESSOR_LOCALES_FILTER = preventInlining("en-AU");

  public final static String SELECTED_LOCALES = preventInlining("en-AU");

  public final static String DEFAULT_TIMEZONE = preventInlining("Australia/Sydney");

// Timezone ids: 357, locales: 1
// America/Adak
//   rawOffset: -36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-10:00" "GMT-09:00" "Hawaii-Aleutian Standard Time" "Hawaii-Aleutian Daylight Time"
//   default shortDisplayName: GMT-10:00
//   default shortDisplayNameDaylight: GMT-09:00
//   default longDisplayName: Hawaii-Aleutian Standard Time
//   default longDisplayNameDaylight Hawaii-Aleutian Daylight Time
// 
// America/Anchorage
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/Anguilla
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Antigua
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Araguaina
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Argentina/Buenos_Aires
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Catamarca
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/ComodRivadavia
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Cordoba
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Jujuy
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/La_Rioja
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Mendoza
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Rio_Gallegos
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Salta
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/San_Juan
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/San_Luis
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Western Argentina Standard Time" "Western Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Western Argentina Standard Time
//   default longDisplayNameDaylight Western Argentina Summer Time
// 
// America/Argentina/Tucuman
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Argentina/Ushuaia
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Aruba
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Asuncion
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PYT" "PYST" "Paraguay Standard Time" "Paraguay Summer Time"
//   default shortDisplayName: PYT
//   default shortDisplayNameDaylight: PYST
//   default longDisplayName: Paraguay Standard Time
//   default longDisplayNameDaylight Paraguay Summer Time
// 
// America/Atikokan
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Atka
//   rawOffset: -36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-10:00" "GMT-09:00" "Hawaii-Aleutian Standard Time" "Hawaii-Aleutian Daylight Time"
//   default shortDisplayName: GMT-10:00
//   default shortDisplayNameDaylight: GMT-09:00
//   default longDisplayName: Hawaii-Aleutian Standard Time
//   default longDisplayNameDaylight Hawaii-Aleutian Daylight Time
// 
// America/Bahia
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Bahia_Banderas
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Barbados
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Belem
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Belize
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Blanc-Sablon
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Boa_Vista
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Amazon Standard Time" "Amazon Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Amazon Standard Time
//   default longDisplayNameDaylight Amazon Summer Time
// 
// America/Bogota
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="COT" "COST" "Colombia Standard Time" "Colombia Summer Time"
//   default shortDisplayName: COT
//   default shortDisplayNameDaylight: COST
//   default longDisplayName: Colombia Standard Time
//   default longDisplayNameDaylight Colombia Summer Time
// 
// America/Boise
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Buenos_Aires
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Cambridge_Bay
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Campo_Grande
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Amazon Standard Time" "Amazon Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Amazon Standard Time
//   default longDisplayNameDaylight Amazon Summer Time
// 
// America/Cancun
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Caracas
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="VET" "VEST" "Venezuela Time" "Venezuela Summer Time"
//   default shortDisplayName: VET
//   default shortDisplayNameDaylight: VEST
//   default longDisplayName: Venezuela Time
//   default longDisplayNameDaylight Venezuela Summer Time
// 
// America/Catamarca
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Cayenne
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GFT" "GFST" "French Guiana Time" "French Guiana Summer Time"
//   default shortDisplayName: GFT
//   default shortDisplayNameDaylight: GFST
//   default longDisplayName: French Guiana Time
//   default longDisplayNameDaylight French Guiana Summer Time
// 
// America/Cayman
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Chicago
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Chihuahua
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Ciudad_Juarez
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Coral_Harbour
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Cordoba
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Costa_Rica
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Creston
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Cuiaba
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Amazon Standard Time" "Amazon Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Amazon Standard Time
//   default longDisplayNameDaylight Amazon Summer Time
// 
// America/Curacao
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Danmarkshavn
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "GMT" "Greenwich Mean Time" "Greenwich Mean Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: GMT
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight Greenwich Mean Time
// 
// America/Dawson
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Dawson_Creek
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Denver
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Detroit
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Dominica
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Edmonton
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Eirunepe
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACT" "ACST" "Acre Standard Time" "Acre Summer Time"
//   default shortDisplayName: ACT
//   default shortDisplayNameDaylight: ACST
//   default longDisplayName: Acre Standard Time
//   default longDisplayNameDaylight Acre Summer Time
// 
// America/El_Salvador
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Ensenada
//   rawOffset: -28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-08:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-08:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Fort_Nelson
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Fort_Wayne
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Fortaleza
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Glace_Bay
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-03:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Godthab
//   rawOffset: -7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WGT" "WGST" "West Greenland Standard Time" "West Greenland Summer Time"
//   default shortDisplayName: WGT
//   default shortDisplayNameDaylight: WGST
//   default longDisplayName: West Greenland Standard Time
//   default longDisplayNameDaylight West Greenland Summer Time
// 
// America/Goose_Bay
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-03:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Grand_Turk
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Grenada
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Guadeloupe
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Guatemala
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Guayaquil
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ECT" "ECST" "Ecuador Time" "Ecuador Summer Time"
//   default shortDisplayName: ECT
//   default shortDisplayNameDaylight: ECST
//   default longDisplayName: Ecuador Time
//   default longDisplayNameDaylight Ecuador Summer Time
// 
// America/Guyana
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GYT" "GYST" "Guyana Time" "Guyana Summer Time"
//   default shortDisplayName: GYT
//   default shortDisplayNameDaylight: GYST
//   default longDisplayName: Guyana Time
//   default longDisplayNameDaylight Guyana Summer Time
// 
// America/Halifax
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-03:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Havana
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "Cuba Standard Time" "Cuba Daylight Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: Cuba Standard Time
//   default longDisplayNameDaylight Cuba Daylight Time
// 
// America/Hermosillo
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MST" "MDT" "Mexican Pacific Standard Time" "Mexican Pacific Daylight Time"
//   default shortDisplayName: MST
//   default shortDisplayNameDaylight: MDT
//   default longDisplayName: Mexican Pacific Standard Time
//   default longDisplayNameDaylight Mexican Pacific Daylight Time
// 
// America/Indiana/Indianapolis
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indiana/Knox
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Indiana/Marengo
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indiana/Petersburg
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indiana/Tell_City
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Indiana/Vevay
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indiana/Vincennes
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indiana/Winamac
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Indianapolis
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Inuvik
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Iqaluit
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Jamaica
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Jujuy
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Juneau
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/Kentucky/Louisville
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Kentucky/Monticello
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Knox_IN
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Kralendijk
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/La_Paz
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BOT" "BOST" "Bolivia Time" "Bolivia Summer Time"
//   default shortDisplayName: BOT
//   default shortDisplayNameDaylight: BOST
//   default longDisplayName: Bolivia Time
//   default longDisplayNameDaylight Bolivia Summer Time
// 
// America/Lima
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PET" "PEST" "Peru Standard Time" "Peru Summer Time"
//   default shortDisplayName: PET
//   default shortDisplayNameDaylight: PEST
//   default longDisplayName: Peru Standard Time
//   default longDisplayNameDaylight Peru Summer Time
// 
// America/Los_Angeles
//   rawOffset: -28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-08:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-08:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Louisville
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Lower_Princes
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Maceio
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Managua
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Manaus
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Amazon Standard Time" "Amazon Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Amazon Standard Time
//   default longDisplayNameDaylight Amazon Summer Time
// 
// America/Marigot
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Martinique
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Matamoros
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Mazatlan
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MST" "MDT" "Mexican Pacific Standard Time" "Mexican Pacific Daylight Time"
//   default shortDisplayName: MST
//   default shortDisplayNameDaylight: MDT
//   default longDisplayName: Mexican Pacific Standard Time
//   default longDisplayNameDaylight Mexican Pacific Daylight Time
// 
// America/Mendoza
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Menominee
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Merida
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Metlakatla
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/Mexico_City
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Miquelon
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PMST" "PMDT" "St. Pierre & Miquelon Standard Time" "St. Pierre & Miquelon Daylight Time"
//   default shortDisplayName: PMST
//   default shortDisplayNameDaylight: PMDT
//   default longDisplayName: St. Pierre & Miquelon Standard Time
//   default longDisplayNameDaylight St. Pierre & Miquelon Daylight Time
// 
// America/Moncton
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-03:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Monterrey
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Montevideo
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="UYT" "UYST" "Uruguay Standard Time" "Uruguay Summer Time"
//   default shortDisplayName: UYT
//   default shortDisplayNameDaylight: UYST
//   default longDisplayName: Uruguay Standard Time
//   default longDisplayNameDaylight Uruguay Summer Time
// 
// America/Montreal
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Montserrat
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Nassau
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/New_York
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Nipigon
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Nome
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/Noronha
//   rawOffset: -7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="FNT" "FNST" "Fernando de Noronha Standard Time" "Fernando de Noronha Summer Time"
//   default shortDisplayName: FNT
//   default shortDisplayNameDaylight: FNST
//   default longDisplayName: Fernando de Noronha Standard Time
//   default longDisplayNameDaylight Fernando de Noronha Summer Time
// 
// America/North_Dakota/Beulah
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/North_Dakota/Center
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/North_Dakota/New_Salem
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Nuuk
//   rawOffset: -7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WGT" "WGST" "Western Greenland Time" "Western Greenland Summer Time"
//   default shortDisplayName: WGT
//   default shortDisplayNameDaylight: WGST
//   default longDisplayName: Western Greenland Time
//   default longDisplayNameDaylight Western Greenland Summer Time
// 
// America/Ojinaga
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Panama
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-05:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Pangnirtung
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Paramaribo
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="SRT" "SRST" "Suriname Time" "Suriname Summer Time"
//   default shortDisplayName: SRT
//   default shortDisplayNameDaylight: SRST
//   default longDisplayName: Suriname Time
//   default longDisplayNameDaylight Suriname Summer Time
// 
// America/Phoenix
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Port-au-Prince
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Port_of_Spain
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Porto_Acre
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACT" "ACST" "Acre Standard Time" "Acre Summer Time"
//   default shortDisplayName: ACT
//   default shortDisplayNameDaylight: ACST
//   default longDisplayName: Acre Standard Time
//   default longDisplayNameDaylight Acre Summer Time
// 
// America/Porto_Velho
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Amazon Standard Time" "Amazon Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Amazon Standard Time
//   default longDisplayNameDaylight Amazon Summer Time
// 
// America/Puerto_Rico
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Punta_Arenas
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-03:00" "GMT-03:00" "Punta Arenas Standard Time" "Punta Arenas Standard Time"
//   default shortDisplayName: GMT-03:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Punta Arenas Standard Time
//   default longDisplayNameDaylight Punta Arenas Standard Time
// 
// America/Rainy_River
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Rankin_Inlet
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Recife
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Regina
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Resolute
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Rio_Branco
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACT" "ACST" "Acre Standard Time" "Acre Summer Time"
//   default shortDisplayName: ACT
//   default shortDisplayNameDaylight: ACST
//   default longDisplayName: Acre Standard Time
//   default longDisplayNameDaylight Acre Summer Time
// 
// America/Rosario
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ART" "ARST" "Argentina Standard Time" "Argentina Summer Time"
//   default shortDisplayName: ART
//   default shortDisplayNameDaylight: ARST
//   default longDisplayName: Argentina Standard Time
//   default longDisplayNameDaylight Argentina Summer Time
// 
// America/Santa_Isabel
//   rawOffset: -28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PST" "PDT" "Northwest Mexico Standard Time" "Northwest Mexico Daylight Time"
//   default shortDisplayName: PST
//   default shortDisplayNameDaylight: PDT
//   default longDisplayName: Northwest Mexico Standard Time
//   default longDisplayNameDaylight Northwest Mexico Daylight Time
// 
// America/Santarem
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Santiago
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CLT" "CLST" "Chile Standard Time" "Chile Summer Time"
//   default shortDisplayName: CLT
//   default shortDisplayNameDaylight: CLST
//   default longDisplayName: Chile Standard Time
//   default longDisplayNameDaylight Chile Summer Time
// 
// America/Santo_Domingo
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Sao_Paulo
//   rawOffset: -10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BRT" "BRST" "Brasilia Standard Time" "Brasilia Summer Time"
//   default shortDisplayName: BRT
//   default shortDisplayNameDaylight: BRST
//   default longDisplayName: Brasilia Standard Time
//   default longDisplayNameDaylight Brasilia Summer Time
// 
// America/Scoresbysund
//   rawOffset: -3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EGT" "EGST" "East Greenland Standard Time" "East Greenland Summer Time"
//   default shortDisplayName: EGT
//   default shortDisplayNameDaylight: EGST
//   default longDisplayName: East Greenland Standard Time
//   default longDisplayNameDaylight East Greenland Summer Time
// 
// America/Shiprock
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// America/Sitka
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/St_Barthelemy
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/St_Johns
//   rawOffset: -12600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="NST" "NDT" "Newfoundland Standard Time" "Newfoundland Daylight Time"
//   default shortDisplayName: NST
//   default shortDisplayNameDaylight: NDT
//   default longDisplayName: Newfoundland Standard Time
//   default longDisplayNameDaylight Newfoundland Daylight Time
// 
// America/St_Kitts
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/St_Lucia
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/St_Thomas
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/St_Vincent
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Swift_Current
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Tegucigalpa
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-06:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Thule
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-03:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-03:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Thunder_Bay
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Tijuana
//   rawOffset: -28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-08:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-08:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Toronto
//   rawOffset: -18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-05:00" "GMT-04:00" "Eastern Standard Time" "Eastern Daylight Time"
//   default shortDisplayName: GMT-05:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Eastern Standard Time
//   default longDisplayNameDaylight Eastern Daylight Time
// 
// America/Tortola
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Vancouver
//   rawOffset: -28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-08:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-08:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Virgin
//   rawOffset: -14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-04:00" "GMT-04:00" "Atlantic Standard Time" "Atlantic Daylight Time"
//   default shortDisplayName: GMT-04:00
//   default shortDisplayNameDaylight: GMT-04:00
//   default longDisplayName: Atlantic Standard Time
//   default longDisplayNameDaylight Atlantic Daylight Time
// 
// America/Whitehorse
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-07:00" "Pacific Standard Time" "Pacific Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-07:00
//   default longDisplayName: Pacific Standard Time
//   default longDisplayNameDaylight Pacific Daylight Time
// 
// America/Winnipeg
//   rawOffset: -21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-06:00" "GMT-05:00" "Central Standard Time" "Central Daylight Time"
//   default shortDisplayName: GMT-06:00
//   default shortDisplayNameDaylight: GMT-05:00
//   default longDisplayName: Central Standard Time
//   default longDisplayNameDaylight Central Daylight Time
// 
// America/Yakutat
//   rawOffset: -32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-09:00" "GMT-08:00" "Alaska Standard Time" "Alaska Daylight Time"
//   default shortDisplayName: GMT-09:00
//   default shortDisplayNameDaylight: GMT-08:00
//   default longDisplayName: Alaska Standard Time
//   default longDisplayNameDaylight Alaska Daylight Time
// 
// America/Yellowknife
//   rawOffset: -25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT-07:00" "GMT-06:00" "Mountain Standard Time" "Mountain Daylight Time"
//   default shortDisplayName: GMT-07:00
//   default shortDisplayNameDaylight: GMT-06:00
//   default longDisplayName: Mountain Standard Time
//   default longDisplayNameDaylight Mountain Daylight Time
// 
// Asia/Aden
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Almaty
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ALMT" "ALMST" "East Kazakhstan Time" "Alma-Ata Summer Time"
//   default shortDisplayName: ALMT
//   default shortDisplayNameDaylight: ALMST
//   default longDisplayName: East Kazakhstan Time
//   default longDisplayNameDaylight Alma-Ata Summer Time
// 
// Asia/Amman
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Anadyr
//   rawOffset: 43200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ANAT" "ANAST" "Anadyr Standard Time" "Anadyr Summer Time"
//   default shortDisplayName: ANAT
//   default shortDisplayNameDaylight: ANAST
//   default longDisplayName: Anadyr Standard Time
//   default longDisplayNameDaylight Anadyr Summer Time
// 
// Asia/Aqtau
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AQTT" "AQTST" "West Kazakhstan Time" "Aqtau Summer Time"
//   default shortDisplayName: AQTT
//   default shortDisplayNameDaylight: AQTST
//   default longDisplayName: West Kazakhstan Time
//   default longDisplayNameDaylight Aqtau Summer Time
// 
// Asia/Aqtobe
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AQTT" "AQTST" "West Kazakhstan Time" "Aqtobe Summer Time"
//   default shortDisplayName: AQTT
//   default shortDisplayNameDaylight: AQTST
//   default longDisplayName: West Kazakhstan Time
//   default longDisplayNameDaylight Aqtobe Summer Time
// 
// Asia/Ashgabat
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TMT" "TMST" "Turkmenistan Standard Time" "Turkmenistan Summer Time"
//   default shortDisplayName: TMT
//   default shortDisplayNameDaylight: TMST
//   default longDisplayName: Turkmenistan Standard Time
//   default longDisplayNameDaylight Turkmenistan Summer Time
// 
// Asia/Ashkhabad
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TMT" "TMST" "Turkmenistan Standard Time" "Turkmenistan Summer Time"
//   default shortDisplayName: TMT
//   default shortDisplayNameDaylight: TMST
//   default longDisplayName: Turkmenistan Standard Time
//   default longDisplayNameDaylight Turkmenistan Summer Time
// 
// Asia/Atyrau
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+05:00" "GMT+05:00" "West Kazakhstan Time" "Atyrau Daylight Time"
//   default shortDisplayName: GMT+05:00
//   default shortDisplayNameDaylight: GMT+05:00
//   default longDisplayName: West Kazakhstan Time
//   default longDisplayNameDaylight Atyrau Daylight Time
// 
// Asia/Baghdad
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Bahrain
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Baku
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AZT" "AZST" "Azerbaijan Standard Time" "Azerbaijan Summer Time"
//   default shortDisplayName: AZT
//   default shortDisplayNameDaylight: AZST
//   default longDisplayName: Azerbaijan Standard Time
//   default longDisplayNameDaylight Azerbaijan Summer Time
// 
// Asia/Bangkok
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ICT" "ICST" "Indochina Time" "Indochina Summer Time"
//   default shortDisplayName: ICT
//   default shortDisplayNameDaylight: ICST
//   default longDisplayName: Indochina Time
//   default longDisplayNameDaylight Indochina Summer Time
// 
// Asia/Barnaul
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+07:00" "GMT+07:00" "Barnaul Standard Time" "Barnaul Daylight Time"
//   default shortDisplayName: GMT+07:00
//   default shortDisplayNameDaylight: GMT+07:00
//   default longDisplayName: Barnaul Standard Time
//   default longDisplayNameDaylight Barnaul Daylight Time
// 
// Asia/Beirut
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Bishkek
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="KGT" "KGST" "Kyrgyzstan Time" "Kirgizstan Summer Time"
//   default shortDisplayName: KGT
//   default shortDisplayNameDaylight: KGST
//   default longDisplayName: Kyrgyzstan Time
//   default longDisplayNameDaylight Kirgizstan Summer Time
// 
// Asia/Brunei
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BNT" "BNST" "Brunei Darussalam Time" "Brunei Summer Time"
//   default shortDisplayName: BNT
//   default shortDisplayNameDaylight: BNST
//   default longDisplayName: Brunei Darussalam Time
//   default longDisplayNameDaylight Brunei Summer Time
// 
// Asia/Calcutta
//   rawOffset: 19800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IST" "IDT" "India Standard Time" "India Daylight Time"
//   default shortDisplayName: IST
//   default shortDisplayNameDaylight: IDT
//   default longDisplayName: India Standard Time
//   default longDisplayNameDaylight India Daylight Time
// 
// Asia/Chita
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="YAKT" "YAKST" "Yakutsk Standard Time" "Yakutsk Summer Time"
//   default shortDisplayName: YAKT
//   default shortDisplayNameDaylight: YAKST
//   default longDisplayName: Yakutsk Standard Time
//   default longDisplayNameDaylight Yakutsk Summer Time
// 
// Asia/Choibalsan
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CHOT" "CHOST" "Choibalsan Standard Time" "Choibalsan Summer Time"
//   default shortDisplayName: CHOT
//   default shortDisplayNameDaylight: CHOST
//   default longDisplayName: Choibalsan Standard Time
//   default longDisplayNameDaylight Choibalsan Summer Time
// 
// Asia/Chongqing
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Chungking
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Colombo
//   rawOffset: 19800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IST" "IDT" "India Standard Time" "India Daylight Time"
//   default shortDisplayName: IST
//   default shortDisplayNameDaylight: IDT
//   default longDisplayName: India Standard Time
//   default longDisplayNameDaylight India Daylight Time
// 
// Asia/Dacca
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BDT" "BDST" "Bangladesh Standard Time" "Bangladesh Summer Time"
//   default shortDisplayName: BDT
//   default shortDisplayNameDaylight: BDST
//   default longDisplayName: Bangladesh Standard Time
//   default longDisplayNameDaylight Bangladesh Summer Time
// 
// Asia/Damascus
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Dhaka
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BDT" "BDST" "Bangladesh Standard Time" "Bangladesh Summer Time"
//   default shortDisplayName: BDT
//   default shortDisplayNameDaylight: BDST
//   default longDisplayName: Bangladesh Standard Time
//   default longDisplayNameDaylight Bangladesh Summer Time
// 
// Asia/Dili
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TLT" "TLST" "East Timor Time" "Timor-Leste Summer Time"
//   default shortDisplayName: TLT
//   default shortDisplayNameDaylight: TLST
//   default longDisplayName: East Timor Time
//   default longDisplayNameDaylight Timor-Leste Summer Time
// 
// Asia/Dubai
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GST" "GDT" "Gulf Standard Time" "Gulf Daylight Time"
//   default shortDisplayName: GST
//   default shortDisplayNameDaylight: GDT
//   default longDisplayName: Gulf Standard Time
//   default longDisplayNameDaylight Gulf Daylight Time
// 
// Asia/Dushanbe
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TJT" "TJST" "Tajikistan Time" "Tajikistan Summer Time"
//   default shortDisplayName: TJT
//   default shortDisplayNameDaylight: TJST
//   default longDisplayName: Tajikistan Time
//   default longDisplayNameDaylight Tajikistan Summer Time
// 
// Asia/Famagusta
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Gaza
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Harbin
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Hebron
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Ho_Chi_Minh
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ICT" "ICST" "Indochina Time" "Indochina Summer Time"
//   default shortDisplayName: ICT
//   default shortDisplayNameDaylight: ICST
//   default longDisplayName: Indochina Time
//   default longDisplayNameDaylight Indochina Summer Time
// 
// Asia/Hong_Kong
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="HKT" "HKST" "Hong Kong Standard Time" "Hong Kong Summer Time"
//   default shortDisplayName: HKT
//   default shortDisplayNameDaylight: HKST
//   default longDisplayName: Hong Kong Standard Time
//   default longDisplayNameDaylight Hong Kong Summer Time
// 
// Asia/Hovd
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="HOVT" "HOVST" "Hovd Standard Time" "Hovd Summer Time"
//   default shortDisplayName: HOVT
//   default shortDisplayNameDaylight: HOVST
//   default longDisplayName: Hovd Standard Time
//   default longDisplayNameDaylight Hovd Summer Time
// 
// Asia/Irkutsk
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IRKT" "IRKST" "Irkutsk Standard Time" "Irkutsk Summer Time"
//   default shortDisplayName: IRKT
//   default shortDisplayNameDaylight: IRKST
//   default longDisplayName: Irkutsk Standard Time
//   default longDisplayNameDaylight Irkutsk Summer Time
// 
// Asia/Istanbul
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TRT" "TRST" "Turkey Time" "Turkey Summer Time"
//   default shortDisplayName: TRT
//   default shortDisplayNameDaylight: TRST
//   default longDisplayName: Turkey Time
//   default longDisplayNameDaylight Turkey Summer Time
// 
// Asia/Jakarta
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WIB" "WIST" "Western Indonesia Time" "West Indonesia Summer Time"
//   default shortDisplayName: WIB
//   default shortDisplayNameDaylight: WIST
//   default longDisplayName: Western Indonesia Time
//   default longDisplayNameDaylight West Indonesia Summer Time
// 
// Asia/Jayapura
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WIT" "EIST" "Eastern Indonesia Time" "East Indonesia Summer Time"
//   default shortDisplayName: WIT
//   default shortDisplayNameDaylight: EIST
//   default longDisplayName: Eastern Indonesia Time
//   default longDisplayNameDaylight East Indonesia Summer Time
// 
// Asia/Jerusalem
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IST" "IDT" "Israel Standard Time" "Israel Daylight Time"
//   default shortDisplayName: IST
//   default shortDisplayNameDaylight: IDT
//   default longDisplayName: Israel Standard Time
//   default longDisplayNameDaylight Israel Daylight Time
// 
// Asia/Kabul
//   rawOffset: 16200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AFT" "AFST" "Afghanistan Time" "Afghanistan Summer Time"
//   default shortDisplayName: AFT
//   default shortDisplayNameDaylight: AFST
//   default longDisplayName: Afghanistan Time
//   default longDisplayNameDaylight Afghanistan Summer Time
// 
// Asia/Kamchatka
//   rawOffset: 43200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PETT" "PETST" "Petropavlovsk-Kamchatski Standard Time" "Petropavlovsk-Kamchatski Summer Time"
//   default shortDisplayName: PETT
//   default shortDisplayNameDaylight: PETST
//   default longDisplayName: Petropavlovsk-Kamchatski Standard Time
//   default longDisplayNameDaylight Petropavlovsk-Kamchatski Summer Time
// 
// Asia/Karachi
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PKT" "PKST" "Pakistan Standard Time" "Pakistan Summer Time"
//   default shortDisplayName: PKT
//   default shortDisplayNameDaylight: PKST
//   default longDisplayName: Pakistan Standard Time
//   default longDisplayNameDaylight Pakistan Summer Time
// 
// Asia/Kashgar
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="XJT" "XJDT" "Xinjiang Standard Time" "Xinjiang Daylight Time"
//   default shortDisplayName: XJT
//   default shortDisplayNameDaylight: XJDT
//   default longDisplayName: Xinjiang Standard Time
//   default longDisplayNameDaylight Xinjiang Daylight Time
// 
// Asia/Kathmandu
//   rawOffset: 20700000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="NPT" "NPST" "Nepal Time" "Nepal Summer Time"
//   default shortDisplayName: NPT
//   default shortDisplayNameDaylight: NPST
//   default longDisplayName: Nepal Time
//   default longDisplayNameDaylight Nepal Summer Time
// 
// Asia/Katmandu
//   rawOffset: 20700000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="NPT" "NPST" "Nepal Time" "Nepal Summer Time"
//   default shortDisplayName: NPT
//   default shortDisplayNameDaylight: NPST
//   default longDisplayName: Nepal Time
//   default longDisplayNameDaylight Nepal Summer Time
// 
// Asia/Khandyga
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="YAKT" "YAKST" "Yakutsk Standard Time" "Yakutsk Summer Time"
//   default shortDisplayName: YAKT
//   default shortDisplayNameDaylight: YAKST
//   default longDisplayName: Yakutsk Standard Time
//   default longDisplayNameDaylight Yakutsk Summer Time
// 
// Asia/Kolkata
//   rawOffset: 19800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IST" "IDT" "India Standard Time" "India Daylight Time"
//   default shortDisplayName: IST
//   default shortDisplayNameDaylight: IDT
//   default longDisplayName: India Standard Time
//   default longDisplayNameDaylight India Daylight Time
// 
// Asia/Krasnoyarsk
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="KRAT" "KRAST" "Krasnoyarsk Standard Time" "Krasnoyarsk Summer Time"
//   default shortDisplayName: KRAT
//   default shortDisplayNameDaylight: KRAST
//   default longDisplayName: Krasnoyarsk Standard Time
//   default longDisplayNameDaylight Krasnoyarsk Summer Time
// 
// Asia/Kuala_Lumpur
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MYT" "MYST" "Malaysia Time" "Malaysia Summer Time"
//   default shortDisplayName: MYT
//   default shortDisplayNameDaylight: MYST
//   default longDisplayName: Malaysia Time
//   default longDisplayNameDaylight Malaysia Summer Time
// 
// Asia/Kuching
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MYT" "MYST" "Malaysia Time" "Malaysia Summer Time"
//   default shortDisplayName: MYT
//   default shortDisplayNameDaylight: MYST
//   default longDisplayName: Malaysia Time
//   default longDisplayNameDaylight Malaysia Summer Time
// 
// Asia/Kuwait
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Macao
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Macau
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Magadan
//   rawOffset: 39600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MAGT" "MAGST" "Magadan Standard Time" "Magadan Summer Time"
//   default shortDisplayName: MAGT
//   default shortDisplayNameDaylight: MAGST
//   default longDisplayName: Magadan Standard Time
//   default longDisplayNameDaylight Magadan Summer Time
// 
// Asia/Makassar
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WITA" "CIST" "Central Indonesia Time" "Central Indonesia Summer Time"
//   default shortDisplayName: WITA
//   default shortDisplayNameDaylight: CIST
//   default longDisplayName: Central Indonesia Time
//   default longDisplayNameDaylight Central Indonesia Summer Time
// 
// Asia/Manila
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="PST" "PDT" "Philippine Standard Time" "Philippine Summer Time"
//   default shortDisplayName: PST
//   default shortDisplayNameDaylight: PDT
//   default longDisplayName: Philippine Standard Time
//   default longDisplayNameDaylight Philippine Summer Time
// 
// Asia/Muscat
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GST" "GDT" "Gulf Standard Time" "Gulf Daylight Time"
//   default shortDisplayName: GST
//   default shortDisplayNameDaylight: GDT
//   default longDisplayName: Gulf Standard Time
//   default longDisplayNameDaylight Gulf Daylight Time
// 
// Asia/Nicosia
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Asia/Novokuznetsk
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="KRAT" "KRAST" "Krasnoyarsk Standard Time" "Krasnoyarsk Summer Time"
//   default shortDisplayName: KRAT
//   default shortDisplayNameDaylight: KRAST
//   default longDisplayName: Krasnoyarsk Standard Time
//   default longDisplayNameDaylight Krasnoyarsk Summer Time
// 
// Asia/Novosibirsk
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="NOVT" "NOVST" "Novosibirsk Standard Time" "Novosibirsk Summer Time"
//   default shortDisplayName: NOVT
//   default shortDisplayNameDaylight: NOVST
//   default longDisplayName: Novosibirsk Standard Time
//   default longDisplayNameDaylight Novosibirsk Summer Time
// 
// Asia/Omsk
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="OMST" "OMSST" "Omsk Standard Time" "Omsk Summer Time"
//   default shortDisplayName: OMST
//   default shortDisplayNameDaylight: OMSST
//   default longDisplayName: Omsk Standard Time
//   default longDisplayNameDaylight Omsk Summer Time
// 
// Asia/Oral
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ORAT" "ORAST" "West Kazakhstan Time" "Oral Summer Time"
//   default shortDisplayName: ORAT
//   default shortDisplayNameDaylight: ORAST
//   default longDisplayName: West Kazakhstan Time
//   default longDisplayNameDaylight Oral Summer Time
// 
// Asia/Phnom_Penh
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ICT" "ICST" "Indochina Time" "Indochina Summer Time"
//   default shortDisplayName: ICT
//   default shortDisplayNameDaylight: ICST
//   default longDisplayName: Indochina Time
//   default longDisplayNameDaylight Indochina Summer Time
// 
// Asia/Pontianak
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WIB" "WIST" "Western Indonesia Time" "West Indonesia Summer Time"
//   default shortDisplayName: WIB
//   default shortDisplayNameDaylight: WIST
//   default longDisplayName: Western Indonesia Time
//   default longDisplayNameDaylight West Indonesia Summer Time
// 
// Asia/Pyongyang
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="KST" "KDT" "Pyongyang Time" "Korea Daylight Time"
//   default shortDisplayName: KST
//   default shortDisplayNameDaylight: KDT
//   default longDisplayName: Pyongyang Time
//   default longDisplayNameDaylight Korea Daylight Time
// 
// Asia/Qatar
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Qostanay
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="QOST" "QOSST" "Kostanay Standard Time" "Kostanay Summer Time"
//   default shortDisplayName: QOST
//   default shortDisplayNameDaylight: QOSST
//   default longDisplayName: Kostanay Standard Time
//   default longDisplayNameDaylight Kostanay Summer Time
// 
// Asia/Qyzylorda
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="QYZT" "QYZST" "East Kazakhstan Time" "Qyzylorda Summer Time"
//   default shortDisplayName: QYZT
//   default shortDisplayNameDaylight: QYZST
//   default longDisplayName: East Kazakhstan Time
//   default longDisplayNameDaylight Qyzylorda Summer Time
// 
// Asia/Rangoon
//   rawOffset: 23400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MMT" "MMST" "Myanmar Time" "Myanmar Summer Time"
//   default shortDisplayName: MMT
//   default shortDisplayNameDaylight: MMST
//   default longDisplayName: Myanmar Time
//   default longDisplayNameDaylight Myanmar Summer Time
// 
// Asia/Riyadh
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AST" "ADT" "Arabia Standard Time" "Arabia Daylight Time"
//   default shortDisplayName: AST
//   default shortDisplayNameDaylight: ADT
//   default longDisplayName: Arabia Standard Time
//   default longDisplayNameDaylight Arabia Daylight Time
// 
// Asia/Saigon
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ICT" "ICST" "Indochina Time" "Indochina Summer Time"
//   default shortDisplayName: ICT
//   default shortDisplayNameDaylight: ICST
//   default longDisplayName: Indochina Time
//   default longDisplayNameDaylight Indochina Summer Time
// 
// Asia/Sakhalin
//   rawOffset: 39600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="SAKT" "SAKST" "Sakhalin Standard Time" "Sakhalin Summer Time"
//   default shortDisplayName: SAKT
//   default shortDisplayNameDaylight: SAKST
//   default longDisplayName: Sakhalin Standard Time
//   default longDisplayNameDaylight Sakhalin Summer Time
// 
// Asia/Samarkand
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="UZT" "UZST" "Uzbekistan Standard Time" "Uzbekistan Summer Time"
//   default shortDisplayName: UZT
//   default shortDisplayNameDaylight: UZST
//   default longDisplayName: Uzbekistan Standard Time
//   default longDisplayNameDaylight Uzbekistan Summer Time
// 
// Asia/Seoul
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="KST" "KDT" "Korean Standard Time" "Korean Summer Time"
//   default shortDisplayName: KST
//   default shortDisplayNameDaylight: KDT
//   default longDisplayName: Korean Standard Time
//   default longDisplayNameDaylight Korean Summer Time
// 
// Asia/Shanghai
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "China Standard Time" "China Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: China Standard Time
//   default longDisplayNameDaylight China Summer Time
// 
// Asia/Singapore
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="SGT" "SGST" "Singapore Standard Time" "Singapore Summer Time"
//   default shortDisplayName: SGT
//   default shortDisplayNameDaylight: SGST
//   default longDisplayName: Singapore Standard Time
//   default longDisplayNameDaylight Singapore Summer Time
// 
// Asia/Srednekolymsk
//   rawOffset: 39600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="SRET" "SREDT" "Srednekolymsk Time" "Srednekolymsk Daylight Time"
//   default shortDisplayName: SRET
//   default shortDisplayNameDaylight: SREDT
//   default longDisplayName: Srednekolymsk Time
//   default longDisplayNameDaylight Srednekolymsk Daylight Time
// 
// Asia/Taipei
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CST" "CDT" "Taipei Standard Time" "Taipei Summer Time"
//   default shortDisplayName: CST
//   default shortDisplayNameDaylight: CDT
//   default longDisplayName: Taipei Standard Time
//   default longDisplayNameDaylight Taipei Summer Time
// 
// Asia/Tashkent
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="UZT" "UZST" "Uzbekistan Standard Time" "Uzbekistan Summer Time"
//   default shortDisplayName: UZT
//   default shortDisplayNameDaylight: UZST
//   default longDisplayName: Uzbekistan Standard Time
//   default longDisplayNameDaylight Uzbekistan Summer Time
// 
// Asia/Tbilisi
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GET" "GEST" "Georgia Standard Time" "Georgia Summer Time"
//   default shortDisplayName: GET
//   default shortDisplayNameDaylight: GEST
//   default longDisplayName: Georgia Standard Time
//   default longDisplayNameDaylight Georgia Summer Time
// 
// Asia/Tehran
//   rawOffset: 12600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IRST" "IRDT" "Iran Standard Time" "Iran Daylight Time"
//   default shortDisplayName: IRST
//   default shortDisplayNameDaylight: IRDT
//   default longDisplayName: Iran Standard Time
//   default longDisplayNameDaylight Iran Daylight Time
// 
// Asia/Tel_Aviv
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="IST" "IDT" "Israel Standard Time" "Israel Daylight Time"
//   default shortDisplayName: IST
//   default shortDisplayNameDaylight: IDT
//   default longDisplayName: Israel Standard Time
//   default longDisplayNameDaylight Israel Daylight Time
// 
// Asia/Thimbu
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BTT" "BTST" "Bhutan Time" "Bhutan Summer Time"
//   default shortDisplayName: BTT
//   default shortDisplayNameDaylight: BTST
//   default longDisplayName: Bhutan Time
//   default longDisplayNameDaylight Bhutan Summer Time
// 
// Asia/Thimphu
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="BTT" "BTST" "Bhutan Time" "Bhutan Summer Time"
//   default shortDisplayName: BTT
//   default shortDisplayNameDaylight: BTST
//   default longDisplayName: Bhutan Time
//   default longDisplayNameDaylight Bhutan Summer Time
// 
// Asia/Tokyo
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="JST" "JDT" "Japan Standard Time" "Japan Summer Time"
//   default shortDisplayName: JST
//   default shortDisplayNameDaylight: JDT
//   default longDisplayName: Japan Standard Time
//   default longDisplayNameDaylight Japan Summer Time
// 
// Asia/Tomsk
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+07:00" "GMT+07:00" "Tomsk Standard Time" "Tomsk Daylight Time"
//   default shortDisplayName: GMT+07:00
//   default shortDisplayNameDaylight: GMT+07:00
//   default longDisplayName: Tomsk Standard Time
//   default longDisplayNameDaylight Tomsk Daylight Time
// 
// Asia/Ujung_Pandang
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WITA" "CIST" "Central Indonesia Time" "Central Indonesia Summer Time"
//   default shortDisplayName: WITA
//   default shortDisplayNameDaylight: CIST
//   default longDisplayName: Central Indonesia Time
//   default longDisplayNameDaylight Central Indonesia Summer Time
// 
// Asia/Ulaanbaatar
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ULAT" "ULAST" "Ulaanbaatar Standard Time" "Ulaanbaatar Summer Time"
//   default shortDisplayName: ULAT
//   default shortDisplayNameDaylight: ULAST
//   default longDisplayName: Ulaanbaatar Standard Time
//   default longDisplayNameDaylight Ulaanbaatar Summer Time
// 
// Asia/Ulan_Bator
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ULAT" "ULAST" "Ulaanbaatar Standard Time" "Ulaanbaatar Summer Time"
//   default shortDisplayName: ULAT
//   default shortDisplayNameDaylight: ULAST
//   default longDisplayName: Ulaanbaatar Standard Time
//   default longDisplayNameDaylight Ulaanbaatar Summer Time
// 
// Asia/Urumqi
//   rawOffset: 21600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="XJT" "XJDT" "Xinjiang Standard Time" "Xinjiang Daylight Time"
//   default shortDisplayName: XJT
//   default shortDisplayNameDaylight: XJDT
//   default longDisplayName: Xinjiang Standard Time
//   default longDisplayNameDaylight Xinjiang Daylight Time
// 
// Asia/Ust-Nera
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="VLAT" "VLAST" "Vladivostok Standard Time" "Vladivostok Summer Time"
//   default shortDisplayName: VLAT
//   default shortDisplayNameDaylight: VLAST
//   default longDisplayName: Vladivostok Standard Time
//   default longDisplayNameDaylight Vladivostok Summer Time
// 
// Asia/Vientiane
//   rawOffset: 25200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ICT" "ICST" "Indochina Time" "Indochina Summer Time"
//   default shortDisplayName: ICT
//   default shortDisplayNameDaylight: ICST
//   default longDisplayName: Indochina Time
//   default longDisplayNameDaylight Indochina Summer Time
// 
// Asia/Vladivostok
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="VLAT" "VLAST" "Vladivostok Standard Time" "Vladivostok Summer Time"
//   default shortDisplayName: VLAT
//   default shortDisplayNameDaylight: VLAST
//   default longDisplayName: Vladivostok Standard Time
//   default longDisplayNameDaylight Vladivostok Summer Time
// 
// Asia/Yakutsk
//   rawOffset: 32400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="YAKT" "YAKST" "Yakutsk Standard Time" "Yakutsk Summer Time"
//   default shortDisplayName: YAKT
//   default shortDisplayNameDaylight: YAKST
//   default longDisplayName: Yakutsk Standard Time
//   default longDisplayNameDaylight Yakutsk Summer Time
// 
// Asia/Yangon
//   rawOffset: 23400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MMT" "MMST" "Myanmar Time" "Myanmar Summer Time"
//   default shortDisplayName: MMT
//   default shortDisplayNameDaylight: MMST
//   default longDisplayName: Myanmar Time
//   default longDisplayNameDaylight Myanmar Summer Time
// 
// Asia/Yekaterinburg
//   rawOffset: 18000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="YEKT" "YEKST" "Yekaterinburg Standard Time" "Yekaterinburg Summer Time"
//   default shortDisplayName: YEKT
//   default shortDisplayNameDaylight: YEKST
//   default longDisplayName: Yekaterinburg Standard Time
//   default longDisplayNameDaylight Yekaterinburg Summer Time
// 
// Asia/Yerevan
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AMT" "AMST" "Armenia Standard Time" "Armenia Summer Time"
//   default shortDisplayName: AMT
//   default shortDisplayNameDaylight: AMST
//   default longDisplayName: Armenia Standard Time
//   default longDisplayNameDaylight Armenia Summer Time
// 
// Australia/ACT
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Adelaide
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Australia/Brisbane
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Broken_Hill
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Australia/Canberra
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Currie
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Darwin
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Australia/Eucla
//   rawOffset: 31500000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACWST" "ACWDT" "Australian Central Western Standard Time" "Australian Central Western Daylight Time"
//   default shortDisplayName: ACWST
//   default shortDisplayNameDaylight: ACWDT
//   default longDisplayName: Australian Central Western Standard Time
//   default longDisplayNameDaylight Australian Central Western Daylight Time
// 
// Australia/Hobart
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/LHI
//   rawOffset: 37800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="LHST" "LHDT" "Lord Howe Standard Time" "Lord Howe Daylight Time"
//   default shortDisplayName: LHST
//   default shortDisplayNameDaylight: LHDT
//   default longDisplayName: Lord Howe Standard Time
//   default longDisplayNameDaylight Lord Howe Daylight Time
// 
// Australia/Lindeman
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Lord_Howe
//   rawOffset: 37800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="LHST" "LHDT" "Lord Howe Standard Time" "Lord Howe Daylight Time"
//   default shortDisplayName: LHST
//   default shortDisplayNameDaylight: LHDT
//   default longDisplayName: Lord Howe Standard Time
//   default longDisplayNameDaylight Lord Howe Daylight Time
// 
// Australia/Melbourne
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/NSW
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/North
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Australia/Perth
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AWST" "AWDT" "Australian Western Standard Time" "Australian Western Daylight Time"
//   default shortDisplayName: AWST
//   default shortDisplayNameDaylight: AWDT
//   default longDisplayName: Australian Western Standard Time
//   default longDisplayNameDaylight Australian Western Daylight Time
// 
// Australia/Queensland
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/South
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Australia/Sydney
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Tasmania
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/Victoria
//   rawOffset: 36000000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AEST" "AEDT" "Australian Eastern Standard Time" "Australian Eastern Daylight Time"
//   default shortDisplayName: AEST
//   default shortDisplayNameDaylight: AEDT
//   default longDisplayName: Australian Eastern Standard Time
//   default longDisplayNameDaylight Australian Eastern Daylight Time
// 
// Australia/West
//   rawOffset: 28800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="AWST" "AWDT" "Australian Western Standard Time" "Australian Western Daylight Time"
//   default shortDisplayName: AWST
//   default shortDisplayNameDaylight: AWDT
//   default longDisplayName: Australian Western Standard Time
//   default longDisplayNameDaylight Australian Western Daylight Time
// 
// Australia/Yancowinna
//   rawOffset: 34200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="ACST" "ACDT" "Australian Central Standard Time" "Australian Central Daylight Time"
//   default shortDisplayName: ACST
//   default shortDisplayNameDaylight: ACDT
//   default longDisplayName: Australian Central Standard Time
//   default longDisplayNameDaylight Australian Central Daylight Time
// 
// Etc/GMT
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "GMT" "Greenwich Mean Time" "Greenwich Mean Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: GMT
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight Greenwich Mean Time
// 
// Europe/Amsterdam
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Andorra
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Astrakhan
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+04:00" "GMT+04:00" "Astrakhan Standard Time" "Astrakhan Standard Time"
//   default shortDisplayName: GMT+04:00
//   default shortDisplayNameDaylight: GMT+04:00
//   default longDisplayName: Astrakhan Standard Time
//   default longDisplayNameDaylight Astrakhan Standard Time
// 
// Europe/Athens
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Belfast
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "BST" "Greenwich Mean Time" "British Summer Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: BST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight British Summer Time
// 
// Europe/Belgrade
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Berlin
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Bratislava
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Brussels
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Bucharest
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Budapest
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Busingen
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Chisinau
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Copenhagen
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Dublin
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "IST" "Greenwich Mean Time" "Irish Standard Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: IST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight Irish Standard Time
// 
// Europe/Gibraltar
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Guernsey
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "BST" "Greenwich Mean Time" "British Summer Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: BST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight British Summer Time
// 
// Europe/Helsinki
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Isle_of_Man
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "BST" "Greenwich Mean Time" "British Summer Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: BST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight British Summer Time
// 
// Europe/Istanbul
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="TRT" "TRST" "Turkey Time" "Turkey Summer Time"
//   default shortDisplayName: TRT
//   default shortDisplayNameDaylight: TRST
//   default longDisplayName: Turkey Time
//   default longDisplayNameDaylight Turkey Summer Time
// 
// Europe/Jersey
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "BST" "Greenwich Mean Time" "British Summer Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: BST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight British Summer Time
// 
// Europe/Kaliningrad
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Kiev
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Kirov
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+03:00" "GMT+03:00" "Kirov Standard Time" "Kirov Daylight Time"
//   default shortDisplayName: GMT+03:00
//   default shortDisplayNameDaylight: GMT+03:00
//   default longDisplayName: Kirov Standard Time
//   default longDisplayNameDaylight Kirov Daylight Time
// 
// Europe/Kyiv
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Lisbon
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="WET" "WEST" "Western European Standard Time" "Western European Summer Time"
//   default shortDisplayName: WET
//   default shortDisplayNameDaylight: WEST
//   default longDisplayName: Western European Standard Time
//   default longDisplayNameDaylight Western European Summer Time
// 
// Europe/Ljubljana
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/London
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "BST" "Greenwich Mean Time" "British Summer Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: BST
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight British Summer Time
// 
// Europe/Luxembourg
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Madrid
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Malta
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Mariehamn
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Minsk
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MSK" "MSD" "Moscow Standard Time" "Moscow Daylight Time"
//   default shortDisplayName: MSK
//   default shortDisplayNameDaylight: MSD
//   default longDisplayName: Moscow Standard Time
//   default longDisplayNameDaylight Moscow Daylight Time
// 
// Europe/Monaco
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Moscow
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MSK" "MSD" "Moscow Standard Time" "Moscow Daylight Time"
//   default shortDisplayName: MSK
//   default shortDisplayNameDaylight: MSD
//   default longDisplayName: Moscow Standard Time
//   default longDisplayNameDaylight Moscow Daylight Time
// 
// Europe/Nicosia
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Oslo
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Paris
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Podgorica
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Prague
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Riga
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Rome
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Samara
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="SAMT" "SAMST" "Samara Standard Time" "Samara Summer Time"
//   default shortDisplayName: SAMT
//   default shortDisplayNameDaylight: SAMST
//   default longDisplayName: Samara Standard Time
//   default longDisplayNameDaylight Samara Summer Time
// 
// Europe/San_Marino
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Sarajevo
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Saratov
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+04:00" "GMT+04:00" "Saratov Standard Time" "Saratov Standard Time"
//   default shortDisplayName: GMT+04:00
//   default shortDisplayNameDaylight: GMT+04:00
//   default longDisplayName: Saratov Standard Time
//   default longDisplayNameDaylight Saratov Standard Time
// 
// Europe/Simferopol
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MSK" "MSD" "Moscow Standard Time" "Moscow Daylight Time"
//   default shortDisplayName: MSK
//   default shortDisplayNameDaylight: MSD
//   default longDisplayName: Moscow Standard Time
//   default longDisplayNameDaylight Moscow Daylight Time
// 
// Europe/Skopje
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Sofia
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Stockholm
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Tallinn
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Tirane
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Tiraspol
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Ulyanovsk
//   rawOffset: 14400000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT+04:00" "GMT+04:00" "Ulyanovsk Standard Time" "Ulyanovsk Standard Time"
//   default shortDisplayName: GMT+04:00
//   default shortDisplayNameDaylight: GMT+04:00
//   default longDisplayName: Ulyanovsk Standard Time
//   default longDisplayNameDaylight Ulyanovsk Standard Time
// 
// Europe/Uzhgorod
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Vaduz
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Vatican
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Vienna
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Vilnius
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Volgograd
//   rawOffset: 10800000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="MSK" "MSD" "Moscow Standard Time" "Moscow Daylight Time"
//   default shortDisplayName: MSK
//   default shortDisplayNameDaylight: MSD
//   default longDisplayName: Moscow Standard Time
//   default longDisplayNameDaylight Moscow Daylight Time
// 
// Europe/Warsaw
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Zagreb
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// Europe/Zaporozhye
//   rawOffset: 7200000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="EET" "EEST" "Eastern European Standard Time" "Eastern European Summer Time"
//   default shortDisplayName: EET
//   default shortDisplayNameDaylight: EEST
//   default longDisplayName: Eastern European Standard Time
//   default longDisplayNameDaylight Eastern European Summer Time
// 
// Europe/Zurich
//   rawOffset: 3600000
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="CET" "CEST" "Central European Standard Time" "Central European Summer Time"
//   default shortDisplayName: CET
//   default shortDisplayNameDaylight: CEST
//   default longDisplayName: Central European Standard Time
//   default longDisplayNameDaylight Central European Summer Time
// 
// GMT
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="GMT" "GMT" "Greenwich Mean Time" "Greenwich Mean Time"
//   default shortDisplayName: GMT
//   default shortDisplayNameDaylight: GMT
//   default longDisplayName: Greenwich Mean Time
//   default longDisplayNameDaylight Greenwich Mean Time
// 
// UTC
//   rawOffset: 0
//   default firstDayOfWeek: 1
//   default minimalDaysInFirstWeek: 1
//   en-AU="UTC" "UTC" "Coordinated Universal Time" "Coordinated Universal Time"
//   default shortDisplayName: UTC
//   default shortDisplayNameDaylight: UTC
//   default longDisplayName: Coordinated Universal Time
//   default longDisplayNameDaylight Coordinated Universal Time
// 


  public final static String DATA = preventInlining(new StringBuilder().append("357,America/Adak,-36000000,3,-1,-3225223727,-1,-2188944802,84,-7,-16,127,44002,127,-42398,-44,-40,83,-1,-3225223727,-1,-2188944802,62,-89,-76,64,-102,16,77,54,-44,77,123,16,77,-65,84,78,3,-112,78,71,-44,78,-114,-80,78,-46,-12,79,23,48,79,91,116,79,-97,-80,79,-71,-12,80,40,48,80,84,-44,80,-80,-80,80,-12,-12,81,59,-48,81,125,116,81,-60,80,82,8,-108,82,76,-48,82,-111,20,82,-43,80,83,25,-108,83,93,-48,83,-94,20,83,-26,80,84,42,-108,84,113,112,84,-77,20,85,62,48,85,-126,108,85,-58,-80,86,10,-20,86,79,48,86,-109,108,86,-49,-48,87,27,-20,87,88,80,87,-89,12,87,-32,-48,88,47,-116,88,105,80,88,-72,12,88,-12,112,89,64,-116,89,124,-16,89,-55,12,90,5,112,90,84,44,90,-115,-16,90,-36,-84,91,22,112,91,101,44,91,-95,-112,91,-19,-84,92,42,16,92,118,44,92,-78,-112,92,-2,-84,93,59,16,93,-119,-52,93,-61,-112,94,18,76,94,76,16,94,-102,-52,94,-41,48,95,35,76,95,95,-80,95,-85,-52,95,-24,48,96,54,-20,96,112,-80,96,-65,108,96,-7,48,97,71,-20,97,121,-48,97,-45,12,98,2,80,98,91,-116,127,44002,127,-42398,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,2,976786818,-1200056952,1,1,0,GMT-10:00,GMT-09:00,Hawaii-Aleutian Standard Time,Hawaii-Aleutian Daylight Time,0,America/Anchorage,-32400000,3,-1,-3225223727,-1,-2188951224,84,-7,-20,127,50424,127,-35976,-40,-36,83,-1,-3225223727,-1,-2188951224,62,-89,-80,64,-102,12,77,54,-48,77,123,12,77,-65,80,78,3,-116,78,71,-48,78,-114,-84,78,-46,-16,79,23,44,79,91,112,79,-97,-84,79,-71,-16,80,40,44,80,84,-48,80,-80,-84,80,-12,-16,81,59,-52,81,125,112,81,-60,76,82,8,-112,82,76,-52,82,-111,16,82,-43,76,83,25,-112,83,93,-52,83,-94,16,83,-26,76,84,42,-112,84,113,108,84,-77,16,85,62,44,85,-126,104,85,-58,-84,86,10,-24,86,79,44,86,-109,104,86,-49,-52,87,27,-24,87,88,76,87,-89,8,87,-32,-52,88,47,-120,88,105,76,88,-72,8,88,-12,108,89,64,-120,89,124,-20,89,-55,8,90,5,108,90,84,40,90,-115,-20,90,-36,-88,91,22,108,91,101,40,91,-95,-116,91,-19,-88,92,42,12,92,118,40,92,-78,-116,92,-2,-88,93,59,12,93,-119,-56,93,-61,-116,94,18,72,94,76,12,94,-102,-56,94,-41,44,95,35,72,95,95,-84,95,-85,-56,95,-24,44,96,54,-24,96,112,-84,96,-65,104,96,-7,44,97,71,-24,97,121,-52,97,-45,8,98,2,76,98,91,-120,127,50424,127,-35976,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/Anguilla,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Antigua,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Araguaina,-10800000,1,-1,-1767214032,127,-11568,-12,51,-1,-1767214032,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,91,95,-52,91,-116,104,91,-27,-84,92,23,-120,92,110,-116,92,-91,72,92,-7,76,93,43,40,93,127,44,93,-74,72,94,10,76,94,60,40,94,-107,108,94,-60,-88,95,37,-52,95,77,40,100,122,-52,100,-89,104,127,-11568,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Argentina/Buenos_Aires,-10800000,5,-1,-2372097972,-1,-1567453392,77,115,16,93,127,44,93,-72,44,127,-14028,127,-15408,-16,-12,-16,-12,59,-1,-2372097972,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-14028,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Catamarca,-10800000,9,-1,-2372096212,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,95,-3,-52,96,4,-16,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,59,-1,-2372096212,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,4,-16,97,-25,-20,98,4,-56,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/ComodRivadavia,-10800000,9,-1,-2372096212,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,95,-3,-52,96,4,-16,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,59,-1,-2372096212,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,4,-16,97,-25,-20,98,4,-56,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Cordoba,-10800000,6,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,127,-15408,-16,-12,-16,-12,-16,-12,58,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Jujuy,-10800000,7,-1,-2372096328,-1,-1567453392,77,115,16,88,94,-88,89,56,-112,93,127,44,93,-72,44,127,-15672,127,-15408,-16,-12,-16,-12,-16,-12,57,-1,-2372096328,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-73,-16,88,-20,108,89,56,-112,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,127,-15672,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-16,-12,-16,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/La_Rioja,-10800000,9,-1,-2372095956,-1,-1567453392,77,115,16,88,-26,104,88,-1,-112,93,127,44,93,-72,44,95,-3,-52,96,4,-16,127,-16044,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,60,-1,-2372095956,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-26,104,88,-1,-112,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,4,-16,97,-25,-20,98,4,-56,127,-16044,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-12,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Mendoza,-10800000,9,-1,-2372095484,-1,-1567453392,77,115,16,88,94,-88,89,-58,80,93,127,44,93,-72,44,95,-6,108,96,41,-80,127,-16516,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,59,-1,-2372095484,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-77,16,88,-26,108,89,59,-16,89,111,-84,89,-58,80,89,-6,-56,95,-6,108,96,41,-80,97,-25,-20,98,4,-56,127,-16516,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-16,-12,-16,-12,-16,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Rio_Gallegos,-10800000,7,-1,-2372095388,-1,-1567453392,77,115,16,93,127,44,93,-72,44,95,-3,-52,96,4,-16,127,-16612,127,-15408,-16,-12,-16,-12,-16,-12,59,-1,-2372095388,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,4,-16,97,-25,-20,98,4,-56,127,-16612,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Salta,-10800000,7,-1,-2372096300,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,127,-15700,127,-15408,-16,-12,-16,-12,-16,-12,57,-1,-2372096300,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,127,-15700,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/San_Juan,-10800000,9,-1,-2372095556,-1,-1567453392,77,115,16,88,-26,104,88,-1,-112,93,127,44,93,-72,44,95,-3,108,96,18,16,127,-16444,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,60,-1,-2372095556,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-26,104,88,-1,-112,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,95,-3,108,96,18,16,97,-25,-20,98,4,-56,127,-16444,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-12,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/San_Luis,-10800000,11,-1,-2372096076,-1,-1567453392,77,115,16,88,98,104,89,8,-16,93,127,44,93,-72,44,95,-3,108,96,18,16,97,-16,40,98,-36,16,127,-15924,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,60,-1,-2372096076,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,98,104,88,-77,16,88,-26,108,89,8,-16,95,-3,108,96,18,16,97,-25,-20,97,-16,40,98,2,44,98,83,-112,98,-118,-84,98,-36,16,127,-15924,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-16,-12,-16,-12,-16,-12,-8,-12,-16,-12,-16,-12,0,1,1,0,ART,ARST,Western Argentina Standard Time,Western Argentina Summer Time,0,America/Argentina/Tucuman,-10800000,9,-1,-2372096348,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,95,-3,-52,96,2").append(",80,127,-15652,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,61,-1,-2372096348,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,2,80,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-15652,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-16,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Argentina/Ushuaia,-10800000,7,-1,-2372095608,-1,-1567453392,77,115,16,93,127,44,93,-72,44,95,-3,12,96,4,-16,127,-16392,127,-15408,-16,-12,-16,-12,-16,-12,59,-1,-2372095608,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,95,-3,12,96,4,-16,97,-25,-20,98,4,-56,127,-16392,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Aruba,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Asuncion,-14400000,3,-1,-1206389360,79,12,-112,79,-39,-84,127,-13840,-16,-12,-16,82,-1,-1206389360,79,12,-112,79,-39,-84,80,-89,48,80,-32,44,81,48,112,81,105,12,81,-71,80,81,-15,-20,82,66,48,82,-122,108,82,-53,16,83,15,-84,83,84,80,83,-104,-116,83,-35,48,84,33,108,84,102,16,84,-86,76,84,-18,-16,85,51,-116,85,120,48,85,-68,108,86,1,16,86,69,76,86,-119,-16,86,-50,44,87,18,-48,87,87,108,87,-100,16,87,-32,76,88,44,-48,88,105,44,88,-83,-48,88,-14,12,89,56,-112,89,111,-84,89,-63,112,90,3,-52,90,72,-48,90,-128,-84,90,-47,-80,91,9,44,91,90,-112,91,-109,-116,91,-27,-80,92,26,44,92,110,48,92,-91,76,92,-10,-80,93,48,108,93,127,48,93,-72,-20,94,7,-80,94,65,108,94,-110,-48,94,-41,12,95,14,48,95,95,-116,95,-103,80,95,-24,12,96,49,-112,96,104,-84,96,-70,16,96,-15,44,97,66,-112,97,121,-84,97,-51,-80,98,2,44,98,86,48,98,-118,-84,98,-34,-80,99,32,76,99,97,-16,99,-88,-52,99,-22,112,100,49,76,100,117,-112,100,-76,-116,100,-2,16,101,61,12,101,-122,-112,127,-13840,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,2,1035474696,-1468524798,1,1,0,PYT,PYST,Paraguay Standard Time,Paraguay Summer Time,0,America/Atikokan,-18000000,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Atka,-36000000,3,-1,-3225223727,-1,-2188944802,84,-7,-16,127,44002,127,-42398,-44,-40,83,-1,-3225223727,-1,-2188944802,62,-89,-76,64,-102,16,77,54,-44,77,123,16,77,-65,84,78,3,-112,78,71,-44,78,-114,-80,78,-46,-12,79,23,48,79,91,116,79,-97,-80,79,-71,-12,80,40,48,80,84,-44,80,-80,-80,80,-12,-12,81,59,-48,81,125,116,81,-60,80,82,8,-108,82,76,-48,82,-111,20,82,-43,80,83,25,-108,83,93,-48,83,-94,20,83,-26,80,84,42,-108,84,113,112,84,-77,20,85,62,48,85,-126,108,85,-58,-80,86,10,-20,86,79,48,86,-109,108,86,-49,-48,87,27,-20,87,88,80,87,-89,12,87,-32,-48,88,47,-116,88,105,80,88,-72,12,88,-12,112,89,64,-116,89,124,-16,89,-55,12,90,5,112,90,84,44,90,-115,-16,90,-36,-84,91,22,112,91,101,44,91,-95,-112,91,-19,-84,92,42,16,92,118,44,92,-78,-112,92,-2,-84,93,59,16,93,-119,-52,93,-61,-112,94,18,76,94,76,16,94,-102,-52,94,-41,48,95,35,76,95,95,-80,95,-85,-52,95,-24,48,96,54,-20,96,112,-80,96,-65,108,96,-7,48,97,71,-20,97,121,-48,97,-45,12,98,2,80,98,91,-116,127,44002,127,-42398,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,-36,-40,2,976786818,-1200056952,1,1,0,GMT-10:00,GMT-09:00,Hawaii-Aleutian Standard Time,Hawaii-Aleutian Daylight Time,0,America/Bahia,-10800000,1,-1,-1767216356,127,-9244,-12,61,-1,-1767216356,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,88,-75,76,88,-31,-24,89,61,-52,89,103,-56,89,-56,-20,89,-19,-88,90,78,-52,90,126,8,90,-41,76,91,6,-120,91,95,-52,91,-116,104,91,-27,-84,92,23,-120,92,110,-116,92,-91,72,92,-7,76,93,43,40,93,127,44,93,-74,72,94,10,76,94,60,40,94,-107,108,94,-60,-88,95,37,-52,95,77,40,99,-17,-84,100,33,-120,127,-9244,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Bahia_Banderas,-21600000,8,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,99,29,-60,127,-25260,-28,-24,-28,-24,-28,-32,-28,-24,63,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,89,36,94,-112,64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,-127,-92,97,-48,96,98,12,-60,98,88,-32,98,-107,68,98,-31,96,99,29,-60,99,108,124,99,-90,64,99,-12,-4,100,46,-64,100,125,124,100,-71,-32,101,5,-4,101,66,96,101,-114,124,101,-54,-32,102,22,-4,102,83,96,102,-94,28,102,-37,-32,103,42,-100,103,100,96,103,-77,28,103,-17,-128,104,59,-100,104,120,0,104,-60,28,105,0,-128,105,79,60,105,-119,0,105,-41,-68,127,-25260,-28,-24,-28,-24,-28,-24,-28,-32,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Barbados,-14400000,1,-1,-1841256091,127,-14309,-16,15,-1,-1841256091,62,-63,116,62,-13,-72,63,79,52,63,126,120,63,-48,52,64,9,-104,81,-113,-72,81,-71,-76,82,3,56,82,66,52,82,-117,-72,82,-54,-76,83,22,-40,83,82,20,127,-14309,-16,-12,-16,-12,-16,-14,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Belem,-10800000,1,-1,-1767213964,127,-11636,-12,29,-1,-1767213964,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,127,-11636,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Belize,-21600000,1,-1,-1822500432,127,-21168,-24,97,-1,-1822500432,50,41,-8,50,89,54,50,-78,120,50,-28,86,51,58,-8,51,108,-42,51,-61,120,51,-11,86,52,78,-104,52,125,-42,52,-41,24,53,6,86,53,95,-104,53,-111,118,53,-24,24,54,25,-10,54,112,-104,54,-94,118,54,-7,24,55,42,-10,55,-124,56,55,-77,118,56,12,-72,56,59,-10,56,-107,56,56,-57,22,57,29,-72,57,79,-106,57,-90,56,57,-40,22,58,49,88,58,96,-106,58,-71,-40,58,-23,22,59,66,88,59,113,-106,59,-54,-40,59,-4,-74,60,83,88,60,-123,54,60,-37,-40,61,13,-74,61,102,-8,61,-106,54,61,-17,120,62,30,-74,62,119,-8,62,-87,-42,62,-37,-72,64,-74,-44,65,-83,-104,65,-33,118,66,54,24,66,103,-10,66,-66,-104,66,-16,118,67,73,-72,67,120,-10,67,-46,56,68,1,118,68,90,-72,68,-116,-106,68,-29,56,69,21,22,69,107,-72,69,-99,-106,69,-12,56,70,38,22,70,127,88,70,-82,-106,71,7,-40,71,55,22,71,-112,88,71,-62,54,72,24,-40,72,74,-74,72,-95,88,72,-45,54,73,44,120,73,91,-74,73,-76,-8,73,-28,54,74,61,120,74,108,-74,74,-59,-8,74,-9,-42,75,78,120,75,-128,86,75,-42,-8,76,8,-42,76,98,24,76,-111,86,79,-83,-40,79,-58,-108,84,-125,88,84,-104,84,127,-21168,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-20,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-22,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Blanc-Sablon,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Boa_Vista,-14400000,1,-1,-1767211040,127,-14560,-16,33,-1,-1767211040,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,93,127,48,93,-74,76,94,10,80,94,12,-20,127,-14560,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,AMT,AMST,Amazon Standard Time,Amazon Summer Time,0,America/Bogota,-18000000,1,-1,-1739041424,127,-17776,-20,3,-1,-1739041424,89,-121,84,89,-16,80,127,-17776,-20,-16,-20,0,1,1,0,COT,COST,Colombia Standard Time,Colombia Summer Time,0,America/Boise,-25200000,2,31,-128,-80,52,-96,8,127,-27889,-32,-28,92,31,-128,-80,49,-29,40,50,49,-28,50,107,-88,50,-70,100,52,-96,8,62,-89,-92,64,-102,0,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-60,100,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,127,-27889,-32,-28,-32,-28,-32,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Buenos_Aires,-10800000,5,-1,-2372097972,-1,-1567453392,77,115,16,93,127,44,93,-72,44,127,-14028,127,-15408,-16,-12,-16,-12,59,-1,-2372097972,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-52,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-14028,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Cambridge_Bay,-25200000,5,50,-45,96,93,-119,-64,94,18,60,94,20,-44,94,76,4,0,-28,-24,-20,-24,-28,75,50,-45,96,62,-89,-92,64,-102,0,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-29,-28,80,40,32,80,108,100,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-61,-128,94,20,-44,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,0,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-20,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Campo_Grande,-14400000,1,-1,-1767212492,127,-13108,-16,91,-1,-1767212492,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,87,-95,-80,87,-55,12,88,42,48,88,86,-52,88,-75,80,88,-31,-20,89,61,-48,89,103,-52,89,-56,-16,89,-19,-84,90,78,-48,90,126,12,90,-41,80,91,6,-116,91,95,-48,91,-116,108,91,-27,-80,92,23,-116,92,110,-112,92,-91,76,92,-7,80,93,43,44,93,127,48,93,-74,76,94,10,80,94,60,44,94,-107,112,94,-60,-84,95,37,-48,95,77,44,95,-87,16,95,-43,-84,96,55,-112,96,96,-52,96,-70,16,96,-23,76,97,74,112,97,116,108,97,-53,16,97,-6,76,98,86,48,98,-126,-52,98,-34,-80,99,13,-20,99,103,48,99,-106,108,99,-17,-80,100,33,-116,100,122,-48,100,-89,108,101,3,80,101,47,-20,101,-117,-48,101,-69,12,102,20,80,102,67,-116,102,-100,-48,102,-52,12,103,37,80,103,84,-116,103,-75,-80,103,-35,12,127,-13108,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,AMT,AMST,Amazon Standard Time,Amazon Summer Time,0,America/Cancun,-18000000,4,51,-27,-104,83,-4,88,92,-33,24,101,-77,64,127,-20824,-24,-20,-24,-20,42,51,-27,-104,83,-4,88,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-33,24,92").append(",-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,89,32,94,-112,60,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,-127,-96,97,-48,92,98,12,-64,98,88,-36,98,-107,64,98,-31,92,99,29,-64,99,108,124,99,-90,64,99,-12,-4,100,46,-64,100,125,124,100,-71,-32,101,5,-4,101,66,96,101,-114,124,101,-77,64,127,-20824,-24,-20,-16,-20,-16,-20,-16,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Caracas,-14400000,5,-1,-2524505536,-1,-1826739140,74,-25,82,97,-32,28,102,93,-36,127,-16064,127,-16060,-18,-16,-18,-16,5,-1,-2524505536,-1,-1826739140,74,-25,82,97,-32,28,102,93,-36,127,-16064,127,-16060,-18,-16,-18,-16,0,1,1,0,VET,VEST,Venezuela Time,Venezuela Summer Time,0,America/Catamarca,-10800000,9,-1,-2372096212,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,95,-3,-52,96,4,-16,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,59,-1,-2372096212,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,95,-3,-52,96,4,-16,97,-25,-20,98,4,-56,127,-15788,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Cayenne,-10800000,2,-1,-1846269040,76,95,112,127,-12560,-16,-12,2,-1,-1846269040,76,95,112,127,-12560,-16,-12,0,1,1,0,GFT,GFST,French Guiana Time,French Guiana Summer Time,0,America/Cayman,-18000000,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Chicago,-21600000,3,31,-128,-88,59,121,-128,59,-38,-100,127,-21036,-24,-20,-24,177,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,51,17,0,51,69,124,51,124,-96,51,-51,-4,52,18,64,52,73,92,52,-102,-64,52,-44,124,53,35,64,53,92,-4,53,-85,-64,53,-27,124,54,52,64,54,109,-4,54,-68,-64,54,-10,124,55,71,-32,55,-127,-100,55,-48,96,56,10,28,56,88,-32,56,-110,-100,56,-31,96,57,27,28,57,105,-32,57,-93,-100,57,-11,0,58,44,28,58,125,-128,58,-73,60,59,6,0,59,63,-68,59,121,-128,59,-38,-100,60,23,0,60,80,-68,60,-97,-128,60,-39,60,61,42,-96,61,97,-68,61,-77,32,61,-20,-36,62,59,-96,62,117,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-2,-68,70,67,0,70,-121,60,70,-53,-128,71,15,-68,71,84,0,71,-104,60,71,-36,-128,72,32,-68,72,101,0,72,-85,-36,72,-16,32,73,52,92,73,120,-96,73,-68,-36,74,1,32,74,69,92,74,-119,-96,74,-51,-36,75,18,32,75,88,-4,75,-102,-96,75,-31,124,76,37,-64,76,105,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-4,77,-65,64,78,3,124,78,71,-64,78,-114,-100,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,89,64,124,89,124,-32,89,-56,-4,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,76,0,94,-102,-68,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-21036,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Chihuahua,-21600000,6,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,92,-78,-124,105,-41,-64,127,-25460,-28,-24,-28,-24,-28,-24,58,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,89,36,94,-112,64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,-127,-92,97,-48,96,98,12,-60,98,88,-32,98,-107,68,98,-31,96,99,29,-60,99,108,-128,99,-90,68,99,-11,0,100,46,-60,100,125,-128,100,-71,-28,101,6,0,101,66,100,101,-114,-128,101,-54,-28,102,23,0,102,83,100,102,-94,32,102,-37,-28,103,42,-96,103,100,100,103,-77,32,103,-17,-124,104,59,-96,104,120,4,104,-60,32,105,0,-124,105,79,64,105,-119,4,127,-25460,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Ciudad_Juarez,-25200000,7,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,92,-78,-124,105,-41,-64,105,-29,88,127,-25556,-28,-24,-28,-24,-28,-24,-28,61,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,89,36,94,-112,64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,-127,-92,97,-48,96,98,12,-60,98,88,-32,98,-107,68,98,-31,96,99,21,-28,99,111,32,99,-98,100,99,-9,-96,100,38,-28,100,-128,32,100,-81,100,101,8,-96,101,55,-28,101,-111,32,101,-64,100,102,25,-96,102,75,-124,102,-92,-64,102,-44,4,103,45,64,103,92,-124,103,-75,-64,103,-27,4,104,62,64,104,109,-124,104,-58,-64,104,-8,-92,105,81,-32,105,-127,36,105,-29,88,106,9,-92,106,98,-32,127,-25556,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Coral_Harbour,-18000000,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Cordoba,-10800000,6,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,127,-15408,-16,-12,-16,-12,-16,-12,58,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Costa_Rica,-21600000,1,-1,-1545071027,127,-20173,-24,9,-1,-1545071027,82,121,88,82,-98,20,83,1,-40,83,38,-108,88,-41,24,89,20,52,89,95,-104,89,116,-12,127,-20173,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Creston,-25200000,1,31,-128,-84,127,-26898,-28,11,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,62,-89,-92,-1,-820519140,-1,-812653140,-1,-796845540,76,37,-60,76,106,0,127,-26898,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,0,1,1,0,GMT-07:00,GMT-07:00,Mountain Standard Time,Mountain Daylight Time,0,America/Cuiaba,-14400000,1,-1,-1767212140,127,-13460,-16,89,-1,-1767212140,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,87,-95,-80,87,-55,12,88,42,48,88,86,-52,88,-75,80,88,-31,-20,89,61,-48,89,103,-52,89,-56,-16,89,-19,-84,90,78,-48,90,126,12,90,-41,80,91,6,-116,91,95,-48,91,-116,108,91,-27,-80,92,23,-116,92,110,-112,92,-91,76,92,-7,80,93,43,44,93,127,48,93,-74,76,94,10,80,94,60,44,94,-107,112,94,-60,-84,95,37,-48,95,77,44,96,55,-112,96,96,-52,96,-70,16,96,-23,76,97,74,112,97,116,108,97,-53,16,97,-6,76,98,86,48,98,-126,-52,98,-34,-80,99,13,-20,99,103,48,99,-106,108,99,-17,-80,100,33,-116,100,122,-48,100,-89,108,101,3,80,101,47,-20,101,-117,-48,101,-69,12,102,20,80,102,67,-116,102,-100,-48,102,-52,12,103,37,80,103,84,-116,103,-75,-80,103,-35,12,127,-13460,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,AMT,AMST,Amazon Standard Time,Amazon Summer Time,0,America/Curacao,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Danmarkshavn,0,2,-1,-1686091520,91,125,12,127,-4480,-12,0,34,-1,-1686091520,83,17,-108,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,125,12,127,-4480,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,0,1,1,0,GMT,GMT,Greenwich Mean Time,Greenwich Mean Time,0,America/Dawson,-25200000,3,-1,-2188996940,79,-97,-92,104,-58,-68,127,-33460,-36,-32,-28,91,-1,-2188996940,49,-24,108,50,49,-24,50,-128,-84,50,-68,-96,62,-89,-84,64,-102,8,75,18,36,75,89,4,79,-97,-92,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,121,-56,97,-45,4,98,2,72,98,91,-124,98,-118,-56,98,-28,4,99,21,-24,99,111,36,99,-98,104,99,-9,-92,100,38,-24,100,-128,36,100,-81,104,101,8,-92,101,55,-24,101,-111,36,101,-64,104,102,25,-92,102,75,-120,102,-92,-60,102,-44,8,103,45,68,103,92,-120,103,-75,-60,103,-27,8,104,62,68,104,109,-120,127,-33460,-36,-32,-36,-32,-36,-32,-36,-28,-36,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,0,1,1,0,GMT-07:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Dawson_Creek,-25200000,2,-1,-2713881544,79,0,-92,127,-28856,-32,-28,56,-1,-2713881544,49,-24,104,50,49,-28,62,-89,-88,64,-102,4,65,113,72,65,-85,4,65,-7,-56,66,51,-124,66,-126,72,66,-68,4,67,13,104,67,68,-124,67,-107,-24,67,-49,-92,68,30,104,68,88,36,68,-90,-24,68,-32,-92,69,47,104,69,105,36,69,-73,-24,69,-15,-92,70,67,8,70,124,-60,70,-53,-120,71,5,68,71,84,8,71,-115,-60,71,-36,-120,72,22,68,72,101,8,72,-98,-60,72,-16,40,73,39,68,73,120,-88,73,-68,-28,74,1,40,74,69,100,74,-119,-88,74,-51,-28,75,18,40,75,89,4,75,-102,-88,75,-31,-124,76,37,-56,76,106,4,76,-82,72,76,-14,-124,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,127,-28856,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,0,1,1,0,GMT-07:00,GMT-07:00,Mountain Standard Time,Mountain Daylight Time,0,America/Denver,-25200000,1,31,-128,-84,127,-25196,-28,99,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,50,-12,36,51,69,-128,51,124,-92,51,-111,-96,62,-89,-92,64,-102,0,75,18,36,75,89,0,75,-102,-92,75,-31,-128,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-71,-28,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,127,-25196,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Detroit,-18000000,2,-1,-2051202469,48,89,0,127,-19931,-24,-20,82,-1,-2051202469,48,89,0,62,-89,-100,64,-103,-8,65,-7,-68,66,51,120,-1,-80506740,76,105,-8,76,-82,60,76,-14,120,79,91,92,79,-97,-104,79,-71,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,12").append("0,127,-19931,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Dominica,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Edmonton,-25200000,1,-1,-1998663968,127,-27232,-28,91,-1,-1998663968,49,-24,100,50,49,-32,50,112,-28,50,-127,96,50,-2,-92,51,69,-128,51,-121,36,51,-64,-32,52,18,68,52,73,96,52,-102,-60,52,-44,-128,62,-89,-92,64,-102,0,65,113,68,65,-85,0,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-29,-28,80,40,32,80,108,100,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,127,-27232,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Eirunepe,-18000000,3,-1,-1767208832,98,42,84,101,11,48,127,-16768,-20,-16,-20,33,-1,-1767208832,57,29,-128,57,97,48,57,-90,-108,57,-22,16,66,-43,20,67,8,20,67,93,-12,67,-117,80,67,-26,-44,68,20,-112,68,112,20,68,-111,-48,74,85,116,74,116,-112,74,-14,-108,75,8,-80,75,100,-108,75,-122,80,75,-30,52,76,15,48,76,107,20,76,-104,112,86,13,20,86,62,-16,86,-110,-12,86,-68,-16,87,27,-44,87,67,48,90,78,-44,90,126,16,98,42,84,101,11,48,127,-16768,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,0,1,1,0,ACT,ACST,Acre Standard Time,Acre Summer Time,0,America/El_Salvador,-21600000,1,-1,-1546279392,127,-21408,-24,5,-1,-1546279392,86,-38,56,87,17,84,87,98,-72,87,-103,-44,127,-21408,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Ensenada,-28800000,4,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,127,-28084,-28,-32,-28,-32,96,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,56,-40,0,57,28,60,62,-61,96,64,-86,28,65,-14,64,66,92,-68,69,47,100,69,105,36,69,-73,-28,69,-15,-92,70,67,4,70,124,-60,70,-53,-124,71,5,68,71,84,4,71,-115,-60,71,-36,-124,72,22,68,72,101,4,72,-98,-60,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,-127,-88,97,-48,100,98,12,-56,98,88,-28,98,-107,72,98,-31,100,99,21,-24,99,111,36,99,-98,104,99,-9,-92,127,-28084,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,2,976786946,-1200056824,1,1,0,GMT-08:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Fort_Nelson,-25200000,2,-1,-2713880953,101,-64,104,127,-29447,-32,-28,142,-1,-2713880953,49,-24,104,50,49,-28,62,-89,-88,64,-102,4,65,113,72,65,-85,4,65,-7,-56,66,51,-124,66,-126,72,66,-68,4,67,13,104,67,68,-124,67,-107,-24,67,-49,-92,68,30,104,68,88,36,68,-90,-24,68,-32,-92,69,47,104,69,105,36,69,-73,-24,69,-15,-92,70,67,8,70,124,-60,70,-53,-120,71,5,68,71,84,8,71,-115,-60,71,-36,-120,72,22,68,72,101,8,72,-98,-60,72,-16,40,73,39,68,73,120,-88,73,-68,-28,74,1,40,74,69,100,74,-119,-88,74,-51,-28,75,18,40,75,89,4,75,-102,-88,75,-31,-124,76,37,-56,76,106,4,76,-82,72,76,-14,-124,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-29,-24,80,40,36,80,108,104,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,121,-56,97,-45,4,98,2,72,98,91,-124,98,-118,-56,98,-28,4,99,21,-24,99,111,36,99,-98,104,99,-9,-92,100,38,-24,100,-128,36,100,-81,104,101,8,-92,101,55,-24,101,-111,36,101,-64,104,127,-29447,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,0,1,1,0,GMT-07:00,GMT-07:00,Mountain Standard Time,Mountain Daylight Time,0,America/Fort_Wayne,-18000000,4,31,-128,-88,69,-73,-32,71,5,60,71,84,0,127,-20678,-24,-20,-24,-20,40,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,80,-96,62,117,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,71,5,60,71,84,0,77,54,-68,77,122,-8,77,-65,60,78,3,120,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20678,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Fortaleza,-10800000,1,-1,-1767216360,127,-9240,-12,39,-1,-1767216360,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,93,127,44,93,-74,72,94,10,76,94,15,-120,94,-107,108,94,-60,-88,127,-9240,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Glace_Bay,-14400000,1,-1,-2131646412,127,-14388,-16,81,-1,-2131646412,49,-24,88,50,49,-44,62,-89,-104,64,-103,-12,68,-90,-40,68,-32,-108,78,-46,-40,79,23,20,79,91,88,79,-97,-108,79,-29,-40,80,40,20,80,108,88,80,-80,-108,80,-12,-40,81,59,-76,81,125,88,81,-60,52,82,8,120,82,76,-76,82,-112,-8,82,-43,52,83,25,120,83,93,-76,83,-95,-8,83,-26,52,84,42,120,84,113,84,84,-78,-8,84,-7,-44,85,62,24,85,-126,84,85,-58,-104,86,10,-44,86,79,24,86,-109,84,86,-49,-72,87,27,-44,87,88,56,87,-90,-12,87,-32,-72,88,47,116,88,105,56,88,-73,-12,88,-12,88,89,64,116,89,124,-40,89,-56,-12,90,5,88,90,84,20,90,-115,-40,90,-36,-108,91,22,88,91,101,20,91,-95,120,91,-19,-108,92,41,-8,92,118,20,92,-78,120,92,-2,-108,93,58,-8,93,-119,-76,93,-61,120,94,18,52,94,75,-8,94,-102,-76,94,-41,24,95,35,52,95,95,-104,95,-85,-76,95,-24,24,96,54,-44,96,112,-104,96,-65,84,96,-7,24,97,71,-44,97,121,-72,97,-46,-12,98,2,56,98,91,116,127,-14388,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,2,976787202,-1200056568,1,1,0,GMT-04:00,GMT-03:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Godthab,-7200000,2,-1,-1686083584,106,14,-60,127,-12416,-12,-8,88,-1,-1686083584,83,17,-108,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,92,-81,-60,92,-2,-124,93,56,68,93,-119,-92,93,-64,-60,94,18,36,94,73,68,94,-102,-92,94,-44,100,95,35,36,95,92,-28,95,-85,-92,95,-27,100,96,54,-60,96,109,-28,96,-65,68,96,-10,100,97,71,-60,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-124,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,63,-92,101,-114,100,101,-56,36,102,22,-28,102,80,-92,102,-94,4,102,-39,36,103,42,-124,103,97,-92,103,-77,4,103,-20,-60,104,59,-124,104,117,68,104,-60,4,104,-3,-60,105,79,36,105,-122,68,105,-41,-92,106,14,-60,127,-12416,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,0,1,1,0,WGT,WGST,West Greenland Standard Time,West Greenland Summer Time,0,America/Goose_Bay,-14400000,3,-1,-2713895900,-1,-1096921748,75,-117,-106,127,-14500,127,-12652,-14,-16,153,-1,-2713895900,-1,-1632076148,-1,-1615145348,-1,-1096921748,59,-108,14,59,-53,42,60,28,-114,60,83,-86,60,-91,14,60,-36,42,61,48,46,61,100,-86,61,-72,-82,61,-17,-54,62,65,46,62,120,74,62,-55,-82,64,-103,-14,64,-19,-10,65,37,18,65,118,118,65,-83,-110,65,-2,-10,66,54,18,66,-121,118,66,-66,-110,67,18,-106,67,73,-78,67,-107,-42,67,-49,-110,68,30,86,68,88,18,68,-90,-42,68,-32,-110,69,47,86,69,105,18,69,-73,-42,69,-15,-110,70,66,-10,70,124,-78,70,-53,118,71,5,50,71,83,-10,71,-115,-78,71,-36,118,72,22,50,72,100,-10,72,-85,-46,72,-16,22,73,52,82,73,120,-106,73,-68,-46,74,1,22,74,69,82,74,-119,-106,74,-51,-46,75,18,22,75,88,-14,75,-117,-106,75,-102,-104,75,-31,116,76,37,-72,76,105,-12,76,-82,56,76,-14,116,77,54,-72,77,122,-12,77,-65,56,78,3,116,78,71,-72,78,-114,-108,78,-46,-40,79,23,20,79,91,88,79,-97,-108,79,-29,-40,80,40,20,80,108,88,80,-80,-108,80,-12,-40,81,59,-76,81,125,88,81,-60,52,82,8,120,82,76,-76,82,-112,-8,82,-43,52,83,25,120,83,93,-76,83,-95,-8,83,-26,52,84,42,120,84,113,84,84,-78,-8,84,-7,-44,85,62,24,85,-126,84,85,-58,-104,86,10,-44,86,79,24,86,-109,84,-1,544593660,-1,562129260,-1,576043260,-1,594180060,-1,607492860,-1,625633260,-1,638942460,-1,657082860,-1,670996860,-1,688532460,-1,702446460,-1,719982060,-1,733896060,-1,752036460,-1,765345660,-1,783486060,-1,796795260,-1,814935660,-1,828849660,-1,846385260,-1,860299260,-1,877834860,-1,891748860,-1,909284460,-1,923198460,-1,941338860,-1,954648060,-1,972788460,-1,986097660,-1,1004238060,-1,1018152060,-1,1035687660,-1,1049601660,-1,1067137260,-1,1081051260,-1,1099191660,-1,1112500860,-1,1130641260,-1,1143950460,-1,1162090860,-1,1173585660,-1,1194145260,-1,1205035260,-1,1225594860,-1,1236484860,-1,1257044460,-1,1268539260,-1,1289098860,-1,1299988860,99,-9,-108,100,38,-40,100,-128,20,127,-14500,127,-12652,127,-9052,127,-12652,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-8,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,2,976787202,-1200056568,1,1,0,GMT-04:00,GMT-03:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Grand_Turk,-18000000,4,-1,-2524504528,-1,-1827687170,101,-64,92,103,92,124,127,-17072,127,-18430,-20,-16,-20,78,-1,-2524504528,-1,-1827687170,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,98,-118,-68,98,-29,-8,99,21,-36,99,111,24,99,-98,92,99,-9,-104,100,38,-36,100,-128,24,100,-81,92,101,8,-104,101,55,-36,101,-111,24,101,-64,92,103,-75,-72,103,-28,-4,104,62,56,127,-17072,127,-18430,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Grenada,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Guadeloupe,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Guatemala,-21600000,1,-1,-1617040676,127,-21724,-24,9,-1,-1617040676,79,-86,24,79,-52,52,84,-67,24,84,-21,-108,88,-18,-72,89,45,-76,97,3,-104,97,61,84,127,-21724,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Guayaquil,-18000000,2,-1,-2524502440,-1,-1230749160,127,-19160,127,-18840,-20,4,-1,-2524502440,-1,-1230749160,89,-43,-76,89,-17,-112,127,-19160,127,-18840,-20,-16,-20,0,1,1,0,ECT,ECST,Ecuador Time,Ecuador Summer Time,0,America/Guyana,-14400000,4,-1,-1843589241,48,60,-48,80,-112,79,89,122,48,127,-13959,-16,-15,-12,-16,4,-1,-1843589241,48,60,-48,80,-112,79,89,122,48,127,-13959,-16,-15,-12,-16,0,1,1,0,GYT,GYST,Guyana Time,Guyana Summer Time,0,America/Halifax,-14400000,1,-1,-2131645536,127,-15264,-16,169,-1,-2131645536,48,-47,-80,49,22,76,49,-24,88,50,49,-44,51,3,-48,51,45,-52,51,-117,-112,51,-71,76,52,18,48,52,66,44,52,-99,80,52,-54,-84,53,37,-48,53,88,12,53,-82,80,53,-27,-52,54,60,16,54,105,12,54,-65,80,54,-10,-52,55,77,16,55,121,-84,55,-43,-112,56,0,76,56,94,16,56,-115,-84,56,-").append("26,-112,57,27,108,57,108,112,57,-93,-20,57,-12,-16,58,47,12,58,-123,80,58,-79,-20,59,19,16,59,64,12,59,-101,-16,59,-61,76,60,25,-112,60,81,12,60,-94,16,60,-39,-116,61,53,16,61,98,12,61,-75,-80,61,-19,44,62,62,48,62,117,-84,62,-89,-104,64,-103,-12,64,-24,-72,65,34,116,65,113,56,65,-86,-12,65,-7,-72,66,51,116,66,-126,56,66,-69,-12,67,-107,-40,67,-49,-108,68,30,88,68,88,20,68,-90,-40,68,-32,-108,69,47,88,69,105,20,70,66,-8,70,124,-76,70,-53,120,71,5,52,71,83,-8,71,-115,-76,71,-36,120,72,22,52,73,120,-104,73,-68,-44,74,1,24,74,69,84,74,-119,-104,74,-51,-44,75,18,24,75,88,-12,75,-102,-104,75,-31,116,76,37,-72,76,105,-12,76,-82,56,76,-14,116,77,54,-72,77,122,-12,77,-65,56,78,3,116,78,71,-72,78,-114,-108,78,-46,-40,79,23,20,79,91,88,79,-97,-108,79,-29,-40,80,40,20,80,108,88,80,-80,-108,80,-12,-40,81,59,-76,81,125,88,81,-60,52,82,8,120,82,76,-76,82,-112,-8,82,-43,52,83,25,120,83,93,-76,83,-95,-8,83,-26,52,84,42,120,84,113,84,84,-78,-8,84,-7,-44,85,62,24,85,-126,84,85,-58,-104,86,10,-44,86,79,24,86,-109,84,86,-49,-72,87,27,-44,87,88,56,87,-90,-12,87,-32,-72,88,47,116,88,105,56,88,-73,-12,88,-12,88,89,64,116,89,124,-40,89,-56,-12,90,5,88,90,84,20,90,-115,-40,90,-36,-108,91,22,88,91,101,20,91,-95,120,91,-19,-108,92,41,-8,92,118,20,92,-78,120,92,-2,-108,93,58,-8,93,-119,-76,93,-61,120,94,18,52,94,75,-8,94,-102,-76,94,-41,24,95,35,52,95,95,-104,95,-85,-76,95,-24,24,96,54,-44,96,112,-104,96,-65,84,96,-7,24,97,71,-44,97,121,-72,97,-46,-12,98,2,56,98,91,116,127,-15264,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,2,976787202,-1200056568,1,1,0,GMT-04:00,GMT-03:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Havana,-18000000,2,-1,-2524501832,-1,-1402813824,127,-19768,127,-19776,-20,110,-1,-2524501832,-1,-1402813824,55,87,-108,55,-123,80,61,-64,52,61,-30,80,62,72,-76,62,109,112,62,-45,-44,62,-11,-16,64,109,84,64,-113,112,64,-11,-44,65,23,-16,75,31,-12,75,77,80,75,-89,-76,75,-42,-16,76,29,116,76,87,-112,76,-88,-12,76,-32,16,77,54,-76,77,122,-16,77,-65,52,78,3,112,78,71,-76,78,-114,-112,78,-46,-44,79,15,48,79,91,84,79,-104,16,79,-29,-44,80,32,-16,80,108,84,80,-80,-112,80,-12,-44,81,59,-80,81,125,84,81,-60,48,82,11,20,82,68,-48,82,-127,52,82,-49,-16,83,9,-76,83,88,112,83,-89,52,83,-32,-16,84,47,-76,84,105,112,84,-72,52,84,-15,-16,85,64,-76,85,125,16,85,-55,52,86,5,-112,86,63,84,86,-114,16,86,-57,-44,87,22,-112,87,82,-12,87,-97,16,87,-37,116,88,39,-112,88,105,52,88,-78,-80,88,-12,84,89,59,52,89,124,-44,89,-61,-76,90,5,84,90,76,52,90,-115,-44,90,-44,-76,91,22,84,91,93,52,91,-95,116,91,-27,-76,92,41,-12,92,112,-44,92,-81,-44,92,-2,-108,93,56,84,93,-119,-76,93,-61,116,94,18,52,94,75,-12,94,-102,-76,94,-41,20,95,35,52,95,95,-108,95,-85,-76,95,-27,116,97,71,-44,97,121,-76,97,-48,84,98,4,-44,98,88,-44,98,-118,-76,98,-31,84,99,21,-44,99,108,116,99,-96,-12,99,-6,52,100,46,-76,100,-128,20,100,-81,84,101,8,-108,101,55,-44,101,-111,20,127,-19768,127,-19776,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976758466,-1200085304,1,1,0,CST,CDT,Cuba Standard Time,Cuba Daylight Time,0,America/Hermosillo,-25200000,7,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,127,-26632,-28,-24,-28,-24,-28,-32,-28,15,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,127,-26632,-28,-24,-28,-24,-28,-24,-28,-32,-28,-24,-28,-24,-28,-24,-28,0,1,1,0,MST,MDT,Mexican Pacific Standard Time,Mexican Pacific Daylight Time,0,America/Indiana/Indianapolis,-18000000,4,31,-128,-88,69,-73,-32,71,5,60,71,84,0,127,-20678,-24,-20,-24,-20,40,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,80,-96,62,117,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,71,5,60,71,84,0,77,54,-68,77,122,-8,77,-65,60,78,3,120,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20678,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indiana/Knox,-21600000,5,31,-128,-88,73,120,-96,74,69,92,89,64,124,96,-7,28,127,-20790,-24,-20,-24,-20,-24,93,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-2,-68,70,67,0,70,-121,60,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,32,-68,72,101,0,72,-85,-36,72,-16,32,73,52,92,73,120,-96,74,69,92,76,37,-64,76,105,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-4,77,-65,64,78,3,124,78,71,-64,78,-114,-100,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-20790,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Indiana/Marengo,-18000000,4,31,-128,-88,72,-16,32,79,-71,-36,80,40,28,127,-20723,-24,-20,-24,-20,42,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,67,-107,-32,67,-49,-100,69,47,96,69,105,28,69,-73,-32,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,22,60,72,101,0,72,-98,-68,72,-16,32,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,80,84,-68,80,-80,-104,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20723,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indiana/Petersburg,-18000000,6,31,-128,-88,75,18,32,75,-31,124,81,-60,60,96,-7,28,97,-46,-4,127,-20947,-24,-20,-24,-20,-24,-20,54,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,69,-70,120,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,22,60,72,101,0,72,-98,-68,72,-16,32,73,52,92,73,120,-96,73,-68,-36,74,1,32,74,69,92,74,-119,-96,74,-51,-36,75,18,32,75,-31,124,76,37,-64,76,105,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-4,77,-65,64,78,3,124,78,71,-64,78,-114,-100,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,97,71,-36,97,121,-64,98,2,60,98,91,120,127,-20947,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indiana/Tell_City,-21600000,5,31,-128,-88,74,-119,-96,76,105,-4,77,54,-64,96,-7,28,127,-20823,-24,-20,-24,-20,-24,38,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,69,-70,120,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,22,60,72,101,0,72,-98,-68,72,-16,32,73,52,92,73,120,-96,73,-68,-36,74,1,32,74,69,92,74,-119,-96,76,105,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-8,77,-65,60,78,3,120,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-20823,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-16,-20,-16,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Indiana/Vevay,-18000000,2,31,-128,-88,69,47,96,127,-20416,-24,-20,22,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,69,47,96,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20416,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indiana/Vincennes,-18000000,4,31,-128,-88,74,-119,-96,96,-7,28,97,-46,-4,127,-21007,-24,-20,-24,-20,40,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-70,120,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,22,60,72,101,0,72,-85,-36,72,-16,32,73,39,60,73,120,-96,73,-68,-36,74,1,32,74,69,92,74,-119,-96,77,54,-68,77,122,-8,77,-65,60,78,3,120,97,71,-36,97,121,-64,98,2,60,98,91,120,127,-21007,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-24,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indiana/Winamac,-18000000,4,31,-128,-88,72,-16,32,96,-7,28,97,121,-64,127,-20785,-24,-20,-24,-20,47,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-2,-68,70,67,0,70,-121,60,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,22,60,72,101,0,72,-98,-68,72,-16,32,77,54,-68,77,122,-8,77,-65,60,78,3,120,97,71,-36,97,121,-64,97,-46,-8,98,2,60,98,91,120,127,-20785,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-24,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Indianapolis,-18000000,4,31,-128,-88,69,-73,-32,71,5,60,71,84,0,127,-20678,-24,-20,-24,-20,40,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,80,-96,62,117,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,71,5,60,71,84,0,77,54,-68,77,122,-8,77,-65,60,78,3,120,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20678,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Inuvik,-25200000,2,68,123,-96,82,-111,8,0,-32,-28,75,68,123,-96,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-29,-24,80,40,36,80,108,104,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,0,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Iqaluit,-18000000,3,62,-24,96,93,-119,-72,94,18,60,0,-20,-24,-20,75,62,-24,96,64,-103,-8,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,-128,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,0,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Jamaica,-18000000,1,-1,-1827687170,127,-18430,-20,21,-1,-1827687170,79,-71,-36,80,40,24,80,84,-68,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,127,-18430,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Jujuy,-10800000,7,-1,-2372096328,-1,-1567453392,77,115,16,88,94,-88,89,56,-112,93,127,44,93,-72,44,127,-15672,127,-15408,-16,-12,-16,-12,-16,-12,57,-1,-2372096328,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-73,-16,88,-20,108,89,56,-112,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,127,-15672,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-16,-12,-16,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Juneau,-32400000,5,-1,-3225223727,-1,-21889549").append("39,83,25,-120,83,93,-56,84,-7,-28,127,54139,127,-32261,-32,-36,-32,-36,82,-1,-3225223727,-1,-2188954939,62,-89,-88,64,-102,4,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-71,-24,80,40,36,80,84,-56,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,44,85,-126,104,85,-58,-84,86,10,-24,86,79,44,86,-109,104,86,-49,-52,87,27,-24,87,88,76,87,-89,8,87,-32,-52,88,47,-120,88,105,76,88,-72,8,88,-12,108,89,64,-120,89,124,-20,89,-55,8,90,5,108,90,84,40,90,-115,-20,90,-36,-88,91,22,108,91,101,40,91,-95,-116,91,-19,-88,92,42,12,92,118,40,92,-78,-116,92,-2,-88,93,59,12,93,-119,-56,93,-61,-116,94,18,72,94,76,12,94,-102,-56,94,-41,44,95,35,72,95,95,-84,95,-85,-56,95,-24,44,96,54,-24,96,112,-84,96,-65,104,96,-7,44,97,71,-24,97,121,-52,97,-45,8,98,2,76,98,91,-120,127,54139,127,-32261,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/Kentucky/Louisville,-18000000,4,31,-128,-88,73,15,-100,79,-71,-36,80,40,28,127,-20582,-24,-20,-24,-20,116,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,51,-119,-64,51,-73,-36,62,59,-96,62,117,92,62,-89,-96,64,-103,-4,-1,-747251940,64,-11,-36,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-15,-100,70,67,0,70,-121,60,70,-53,-128,71,15,-68,71,84,0,71,-104,60,71,-36,-128,72,32,-68,72,101,0,72,-85,-36,72,-16,32,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,80,84,-68,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20582,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Kentucky/Monticello,-18000000,2,31,-128,-88,94,18,60,127,-20364,-24,-20,88,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-4,77,-65,64,78,3,124,78,71,-64,78,-114,-100,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,89,64,124,89,124,-32,89,-56,-4,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20364,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Knox_IN,-21600000,5,31,-128,-88,73,120,-96,74,69,92,89,64,124,96,-7,28,127,-20790,-24,-20,-24,-20,-24,93,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-2,-68,70,67,0,70,-121,60,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,32,-68,72,101,0,72,-85,-36,72,-16,32,73,52,92,73,120,-96,74,69,92,76,37,-64,76,105,-4,76,-82,64,76,-14,124,77,54,-64,77,122,-4,77,-65,64,78,3,124,78,71,-64,78,-114,-100,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-20790,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Kralendijk,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/La_Paz,-14400000,1,-1,-1192307244,127,-16356,-16,2,-1,-1205954844,-1,-1192307244,127,-16356,127,-12756,-16,0,1,1,0,BOT,BOST,Bolivia Time,Bolivia Summer Time,0,America/Lima,-18000000,2,-1,-2524503108,-1,-1938538284,127,-18492,127,-18516,-20,16,-1,-2524503108,-1,-1938538284,60,117,20,60,-106,-48,60,-39,52,61,29,112,61,97,-76,61,-91,-16,86,35,-108,86,69,80,86,-84,116,86,-50,48,88,71,116,88,105,48,90,107,84,90,-115,16,127,-18492,127,-18516,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,0,1,1,0,PET,PEST,Peru Standard Time,Peru Summer Time,0,America/Los_Angeles,-28800000,1,31,-128,-80,127,-28378,-32,127,31,-128,-80,49,-29,40,50,49,-28,50,107,-88,50,-70,100,62,-89,-88,64,-102,4,-1,-687967140,66,87,-28,67,13,100,67,68,-124,67,-107,-28,67,-49,-92,68,30,100,68,88,36,68,-90,-28,68,-32,-92,69,47,100,69,105,36,69,-73,-28,69,-15,-92,70,67,4,70,124,-60,70,-53,-124,71,5,68,71,84,4,71,-115,-60,71,-36,-124,72,22,68,72,101,4,72,-98,-60,72,-16,36,73,39,68,73,120,-92,73,-68,-28,74,1,36,74,69,100,74,-119,-92,74,-51,-28,75,18,36,75,89,4,75,-102,-92,75,-31,-124,76,37,-56,76,106,4,76,-82,72,76,-14,-124,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-71,-24,80,40,36,80,84,-56,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,121,-56,97,-45,4,98,2,72,98,91,-124,127,-28378,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,2,976786946,-1200056824,1,1,0,GMT-08:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Louisville,-18000000,4,31,-128,-88,73,15,-100,79,-71,-36,80,40,28,127,-20582,-24,-20,-24,-20,116,31,-128,-88,49,-29,32,50,49,-36,50,107,-96,50,-70,92,51,-119,-64,51,-73,-36,62,59,-96,62,117,92,62,-89,-96,64,-103,-4,-1,-747251940,64,-11,-36,67,13,96,67,68,124,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-15,-100,70,67,0,70,-121,60,70,-53,-128,71,15,-68,71,84,0,71,-104,60,71,-36,-128,72,32,-68,72,101,0,72,-85,-36,72,-16,32,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,80,84,-68,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-20582,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Lower_Princes,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Maceio,-10800000,1,-1,-1767217028,127,-8572,-12,41,-1,-1767217028,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,91,95,-52,91,-116,104,93,127,44,93,-74,72,94,10,76,94,15,-120,94,-107,108,94,-60,-88,127,-8572,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Managua,-21600000,8,-1,-2524500892,-1,-1121105688,79,92,24,80,82,20,89,89,72,89,-67,84,89,-30,120,92,6,84,127,-20708,127,-20712,-24,-20,-24,-20,-24,-20,-24,16,-1,-2524500892,-1,-1121105688,79,92,24,80,82,20,82,-127,56,82,-90,84,83,9,-72,83,46,-44,89,89,72,89,-67,84,89,-30,120,92,6,84,96,115,56,96,-76,-44,97,3,-96,97,61,88,127,-20708,127,-20712,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Manaus,-14400000,1,-1,-1767211196,127,-14404,-16,31,-1,-1767211196,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,90,78,-48,90,126,12,127,-14404,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,AMT,AMST,Amazon Standard Time,Amazon Summer Time,0,America/Marigot,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Martinique,-14400000,1,-1,-1851537340,127,-14660,-16,3,-1,-1851537340,83,17,-112,83,83,44,127,-14660,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Matamoros,-21600000,1,51,-27,-104,-26,-24,35,51,-27,-104,87,88,64,87,-90,-4,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,89,32,94,-112,60,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,-127,-96,97,-48,92,98,12,-64,98,88,-36,98,-107,64,98,-31,92,99,21,-32,99,111,28,99,-98,96,99,-9,-100,-26,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Mazatlan,-25200000,7,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,127,-25540,-28,-24,-28,-24,-28,-32,-28,63,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,62,-61,88,66,92,-68,77,-108,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,89,36,94,-112,64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,-127,-92,97,-48,96,98,12,-60,98,88,-32,98,-107,68,98,-31,96,99,29,-60,99,108,-128,99,-90,68,99,-11,0,100,46,-60,100,125,-128,100,-71,-28,101,6,0,101,66,100,101,-114,-128,101,-54,-28,102,23,0,102,83,100,102,-94,32,102,-37,-28,103,42,-96,103,100,100,103,-77,32,103,-17,-124,104,59,-96,104,120,4,104,-60,32,105,0,-124,105,79,64,105,-119,4,105,-41,-64,127,-25540,-28,-24,-28,-24,-28,-24,-28,-32,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,0,1,1,0,MST,MDT,Mexican Pacific Standard Time,Mexican Pacific Daylight Time,0,America/Mendoza,-10800000,9,-1,-2372095484,-1,-1567453392,77,115,16,88,94,-88,89,-58,80,93,127,44,93,-72,44,95,-6,108,96,41,-80,127,-16516,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,59,-1,-2372095484,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-77,16,88,-26,108,89,59,-16,89,111,-84,89,-58,80,89,-6,-56,95,-6,108,96,41,-80,97,-25,-20,98,4,-56,127,-16516,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-16,-12,-16,-12,-16,-8,-12,-16,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Menominee,-21600000,3,-1,-2659759773,77,54,-64,79,91,92,127,-21027,-24,-20,-24,83,-1,-2659759773,49,-29,32,50,49,-36,50,107,-96,50,-70,92,62,-89,-96,64,-103,-4,64,-24,-64,65,34,124,75,-102,-96,75,-31,124,77,54,-64,79,-97").append(",-100,79,-71,-32,80,40,28,80,84,-64,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,89,64,124,89,124,-32,89,-56,-4,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,76,0,94,-102,-68,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-21027,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Merida,-21600000,3,51,-27,-104,83,-4,88,84,125,84,127,-21508,-24,-20,-24,57,51,-27,-104,83,-4,88,84,125,84,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,89,32,94,-112,60,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,-127,-96,97,-48,92,98,12,-64,98,88,-36,98,-107,64,98,-31,92,99,29,-64,99,108,124,99,-90,64,99,-12,-4,100,46,-64,100,125,124,100,-71,-32,101,5,-4,101,66,96,101,-114,124,101,-54,-32,102,22,-4,102,83,96,102,-94,28,102,-37,-32,103,42,-100,103,100,96,103,-77,28,103,-17,-128,104,59,-100,104,120,0,104,-60,28,105,0,-128,105,79,60,105,-119,0,105,-41,-68,127,-21508,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Metlakatla,-32400000,5,-1,-3225223727,-1,-2188955622,102,25,-88,103,-75,-56,103,-46,-88,127,54822,127,-31578,-32,-36,-32,-36,45,-1,-3225223727,-1,-2188955622,62,-89,-88,64,-102,4,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-71,-24,80,40,36,80,84,-56,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,102,25,-88,102,75,-116,102,-92,-56,102,-44,12,103,45,72,103,92,-116,103,-46,-88,103,-27,12,104,62,72,104,109,-116,104,-58,-56,127,54822,127,-31578,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/Mexico_City,-21600000,4,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,127,-23796,-28,-24,-28,-24,68,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,61,11,24,61,63,-108,62,7,120,62,49,-44,63,-92,-72,63,-40,20,66,-16,120,67,47,116,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,89,32,94,-112,60,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,-127,-96,97,-48,92,98,12,-64,98,88,-36,98,-107,64,98,-31,92,99,29,-64,99,108,124,99,-90,64,99,-12,-4,100,46,-64,100,125,124,100,-71,-32,101,5,-4,101,66,96,101,-114,124,101,-54,-32,102,22,-4,102,83,96,102,-94,28,102,-37,-32,103,42,-100,103,100,96,103,-77,28,103,-17,-128,104,59,-100,104,120,0,104,-60,28,105,0,-128,105,79,60,105,-119,0,105,-41,-68,127,-23796,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Miquelon,-10800000,2,-1,-1850328920,83,26,-16,127,-13480,-16,-12,46,-1,-1850328920,83,26,-16,86,-49,-76,87,27,-48,87,88,52,87,-90,-16,87,-32,-76,88,47,112,88,105,52,88,-73,-16,88,-12,84,89,64,112,89,124,-44,89,-56,-16,90,5,84,90,84,16,90,-115,-44,90,-36,-112,91,22,84,91,101,16,91,-95,116,91,-19,-112,92,41,-12,92,118,16,92,-78,116,92,-2,-112,93,58,-12,93,-119,-80,93,-61,116,94,18,48,94,75,-12,94,-102,-80,94,-41,20,95,35,48,95,95,-108,95,-85,-80,95,-24,20,96,54,-48,96,112,-108,96,-65,80,96,-7,20,97,71,-48,97,121,-76,97,-46,-16,98,2,52,98,91,112,127,-13480,-16,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,2,976787266,-1200056504,1,1,0,PMST,PMDT,St. Pierre & Miquelon Standard Time,St. Pierre & Miquelon Daylight Time,0,America/Moncton,-14400000,2,-1,-2715882052,41,112,20,127,-15548,-20,-16,148,-1,-2715882052,41,112,20,49,-24,88,50,49,-44,58,4,-76,58,38,-48,58,-115,52,58,-81,80,59,21,-76,59,55,-48,59,-98,52,59,-64,80,60,38,-76,60,72,-48,60,-81,52,60,-47,80,61,52,-76,61,97,80,61,-70,-12,61,-23,-48,62,62,52,62,116,-16,62,-89,-104,64,-103,-12,64,-24,-72,65,34,116,65,113,56,65,-86,-12,65,-7,-72,66,51,116,66,-126,56,66,-69,-12,67,13,88,67,68,116,67,-107,-40,67,-49,-108,68,30,88,68,88,20,68,-90,-40,68,-32,-108,69,47,88,69,105,20,69,-73,-40,69,-15,-108,70,66,-8,70,124,-76,70,-53,120,71,15,-76,71,83,-8,71,-104,52,71,-36,120,72,32,-76,72,100,-8,72,-85,-44,72,-16,24,73,52,84,73,120,-104,73,-68,-44,74,1,24,74,69,84,74,-119,-104,74,-51,-44,75,18,24,75,88,-12,75,-102,-104,75,-31,116,76,37,-72,76,105,-12,76,-82,56,76,-14,116,77,54,-72,77,122,-12,77,-65,56,78,3,116,78,71,-72,78,-114,-108,78,-46,-40,79,23,20,79,-29,-40,80,40,20,80,108,88,80,-80,-108,80,-12,-40,81,59,-76,81,125,88,81,-60,52,82,8,120,82,76,-76,82,-112,-8,82,-43,52,83,25,120,83,93,-76,83,-95,-8,83,-26,52,84,42,120,84,113,84,84,-78,-8,84,-7,-44,85,62,24,85,-126,84,85,-58,-104,86,10,-44,86,79,24,86,-109,84,86,-49,-72,87,27,-44,87,88,56,87,-90,-12,87,-32,-72,88,47,116,88,105,56,88,-73,-12,88,-12,88,89,64,116,89,124,-40,89,-56,-12,-1,733896060,-1,752036460,-1,765345660,-1,783486060,-1,796795260,-1,814935660,-1,828849660,-1,846385260,-1,860299260,-1,877834860,-1,891748860,-1,909284460,-1,923198460,-1,941338860,-1,954648060,-1,972788460,-1,986097660,-1,1004238060,-1,1018152060,-1,1035687660,-1,1049601660,-1,1067137260,-1,1081051260,-1,1099191660,-1,1112500860,-1,1130641260,-1,1143950460,-1,1162090860,97,121,-72,97,-46,-12,98,2,56,98,91,116,127,-15548,-20,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,2,976787202,-1200056568,1,1,0,GMT-04:00,GMT-03:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Monterrey,-21600000,1,51,-27,-104,127,-24076,-24,57,51,-27,-104,87,88,64,87,-90,-4,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,89,32,94,-112,60,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,-127,-96,97,-48,92,98,12,-64,98,88,-36,98,-107,64,98,-31,92,99,29,-64,99,108,124,99,-90,64,99,-12,-4,100,46,-64,100,125,124,100,-71,-32,101,5,-4,101,66,96,101,-114,124,101,-54,-32,102,22,-4,102,83,96,102,-94,28,102,-37,-32,103,42,-100,103,100,96,103,-77,28,103,-17,-128,104,59,-100,104,120,0,104,-60,28,105,0,-128,105,79,60,105,-119,0,105,-41,-68,127,-24076,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Montevideo,-10800000,3,-1,-1567455309,52,-44,-48,63,27,12,127,-13491,-16,-14,-12,85,-1,-1567455309,52,-44,-48,53,25,108,53,94,14,53,-94,76,53,-26,-18,54,43,44,58,57,46,58,114,-20,58,-63,-82,58,-5,108,59,74,46,59,-125,-20,59,-46,-82,60,12,108,60,93,-50,60,-108,-20,60,-26,78,61,29,108,61,100,78,61,-88,-116,61,-9,78,62,49,12,62,95,-114,63,27,12,63,60,-54,71,-26,-20,72,40,-118,72,64,44,72,82,-120,75,10,44,75,75,-56,76,-71,12,76,-1,-118,77,-66,-52,77,-47,-120,78,-48,44,78,-17,-88,79,-68,108,79,-47,102,80,19,10,80,61,12,80,97,-56,81,78,12,81,106,-24,81,-47,76,81,-13,104,82,95,12,82,123,-24,82,-112,-20,83,9,-88,87,46,-116,87,75,8,87,-74,-84,87,-42,40,88,47,108,88,92,8,88,-75,76,88,-25,40,89,64,108,89,111,-88,89,-58,76,89,-8,40,96,39,12,96,109,-16,96,-73,116,96,-15,48,97,61,84,97,121,-80,97,-56,116,98,2,48,98,80,-12,98,-118,-80,98,-39,116,99,21,-48,99,97,-12,99,-98,80,99,-22,116,100,38,-48,100,117,-108,100,-81,80,100,-2,20,101,55,-48,101,-122,-108,101,-64,80,127,-13491,-16,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-14,-12,-10,-12,-10,-12,-8,-12,-8,-12,-10,-12,-8,-12,-8,-12,-6,-10,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,UYT,UYST,Uruguay Standard Time,Uruguay Summer Time,0,America/Montreal,-18000000,1,-1,-2366736148,127,-19052,-20,173,-1,-2366736148,49,-24,92,50,49,-40,50,107,-14,50,-70,80,51,1,60,51,56,80,51,-114,-4,51,-67,24,52,23,124,52,70,-72,52,-97,-4,52,-49,56,53,37,-36,53,90,88,53,-82,92,53,-30,-40,54,54,-36,54,107,88,54,-65,92,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,108,124,57,-93,-104,57,-12,-4,58,46,-72,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,64,-103,-8,64,-24,-68,65,34,120,65,113,52,65,-86,-16,65,-7,-76,66,51,112,66,-126,52,66,-45,-112,67,13,92,67,92,24,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-15,-104,70,66,-4,70,124,-72,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-19052,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Montserrat,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Nassau,-18000000,1,-1,-2366736148,127,-19052,-20,173,-1,-2366736148,49,-24,92,50,49,-40,50,107,-14,50,-70,80,51,1,60,51,56,80,51,-114,-4,51,-67,24,52,23,124,52,70,-72,52,-97,-4,52,-49,56,53,37,-36,53,90,88,53,-82,92,53,-30,-40,54,54,-36,54,107,88,54,-65,92,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,108,124,57,-93,-104,57,-12,-4,58,46,-72,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,64,-103,-8,64,-24,-68,65,34,120,65,113,52,65,-86,-16,65,-7,-76,66,51,112,66,-126,52,66,-45,-112,67,13,92,67,92,24,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-15,-104,70,66,-4,70,124,-72,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-19052,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/New_York,-18000000,1,31,-128,-92,127,-17762,-20,177,31,-128,-92,49,-29,28,50,49,-40,50,107,-100,50,-70,88,50,-12,28,51,69,120,51,-121,28,51,-64,-40,52,18,60,52,73,88,52,-102,-68,52,-44,120,53,35,60,53,92,-8,53,-85,-68,53,-27,120,54,52,60,54,109,-8,54,-68,-68,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,105,-36,57,-93,-104,57,-12,-4,58,44,24,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,61,-20,-40,62,59,-100,62,117,88,62,-89,-100,64,-103,-8,64,-24,-68,65,34,120,65,113,60,65,-86,-8,65,-7,-68,66,51,120,66,-126,60,66,-69,-8,67,13,92,67,68,120,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-2,-72,70,66,-4,70,-121,56,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,1").append("20,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-71,-36,80,40,24,80,84,-68,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-17762,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Nipigon,-18000000,1,-1,-2366736148,127,-19052,-20,173,-1,-2366736148,49,-24,92,50,49,-40,50,107,-14,50,-70,80,51,1,60,51,56,80,51,-114,-4,51,-67,24,52,23,124,52,70,-72,52,-97,-4,52,-49,56,53,37,-36,53,90,88,53,-82,92,53,-30,-40,54,54,-36,54,107,88,54,-65,92,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,108,124,57,-93,-104,57,-12,-4,58,46,-72,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,64,-103,-8,64,-24,-68,65,34,120,65,113,52,65,-86,-16,65,-7,-76,66,51,112,66,-126,52,66,-45,-112,67,13,92,67,92,24,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-15,-104,70,66,-4,70,124,-72,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-19052,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Nome,-32400000,3,-1,-3225223727,-1,-2188947502,84,-7,-16,127,46702,127,-39698,-44,-36,84,-1,-3225223727,-1,-2188947502,62,-89,-76,64,-102,16,77,54,-44,77,123,16,77,-65,84,78,3,-112,78,71,-44,78,-114,-80,78,-46,-12,79,23,48,79,91,116,79,-97,-80,79,-71,-12,80,40,48,80,84,-44,80,-80,-80,80,-12,-12,81,59,-48,81,125,116,81,-60,80,82,8,-108,82,76,-48,82,-111,20,82,-43,80,83,25,-108,83,93,-48,83,-94,20,83,-26,80,84,42,-108,84,113,112,84,-77,20,84,-7,-16,85,62,44,85,-126,104,85,-58,-84,86,10,-24,86,79,44,86,-109,104,86,-49,-52,87,27,-24,87,88,76,87,-89,8,87,-32,-52,88,47,-120,88,105,76,88,-72,8,88,-12,108,89,64,-120,89,124,-20,89,-55,8,90,5,108,90,84,40,90,-115,-20,90,-36,-88,91,22,108,91,101,40,91,-95,-116,91,-19,-88,92,42,12,92,118,40,92,-78,-116,92,-2,-88,93,59,12,93,-119,-56,93,-61,-116,94,18,72,94,76,12,94,-102,-56,94,-41,44,95,35,72,95,95,-84,95,-85,-56,95,-24,44,96,54,-24,96,112,-84,96,-65,104,96,-7,44,97,71,-24,97,121,-52,97,-45,8,98,2,76,98,91,-120,127,46702,127,-39698,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-44,-40,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/Noronha,-7200000,1,-1,-1767217820,127,-7780,-8,39,-1,-1767217820,57,29,116,57,97,36,57,-90,-120,57,-22,4,66,-43,8,67,8,8,67,93,-24,67,-117,68,67,-26,-56,68,20,-124,68,112,8,68,-111,-60,74,85,104,74,116,-124,74,-14,-120,75,8,-92,75,100,-120,75,-122,68,75,-30,40,76,15,36,76,107,8,76,-104,100,86,13,8,86,62,-28,86,-110,-24,86,-68,-28,87,27,-56,87,67,36,87,-95,-88,87,-55,4,88,42,40,88,86,-60,93,127,40,93,-74,68,94,10,72,94,12,-28,94,-107,104,94,-60,-92,127,-7780,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,-4,-8,0,1,1,0,FNT,FNST,Fernando de Noronha Standard Time,Fernando de Noronha Summer Time,0,America/North_Dakota/Beulah,-21600000,2,31,-128,-84,99,111,32,127,-24427,-28,-24,96,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,62,-89,-92,64,-102,0,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-71,-28,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,98,-118,-60,98,-28,0,99,21,-28,99,-98,96,99,-9,-100,127,-24427,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/North_Dakota/Center,-21600000,2,31,-128,-84,89,-55,0,127,-24312,-28,-24,90,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,62,-89,-92,64,-102,0,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-71,-28,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,18,60,94,76,0,94,-102,-68,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-24312,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/North_Dakota/New_Salem,-21600000,2,31,-128,-84,95,-85,-64,127,-24339,-28,-24,90,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,62,-89,-92,64,-102,0,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-71,-28,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-24339,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Nuuk,-7200000,2,-1,-1686083584,106,14,-60,127,-12416,-12,-8,88,-1,-1686083584,83,17,-108,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,92,-81,-60,92,-2,-124,93,56,68,93,-119,-92,93,-64,-60,94,18,36,94,73,68,94,-102,-92,94,-44,100,95,35,36,95,92,-28,95,-85,-92,95,-27,100,96,54,-60,96,109,-28,96,-65,68,96,-10,100,97,71,-60,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-124,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,63,-92,101,-114,100,101,-56,36,102,22,-28,102,80,-92,102,-94,4,102,-39,36,103,42,-124,103,97,-92,103,-77,4,103,-20,-60,104,59,-124,104,117,68,104,-60,4,104,-3,-60,105,79,36,105,-122,68,105,-41,-92,106,14,-60,127,-12416,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,0,1,1,0,WGT,WGST,Western Greenland Time,Western Greenland Summer Time,0,America/Ojinaga,-21600000,6,51,-27,-100,54,-50,-72,56,-92,-104,57,97,60,92,-78,-124,105,-41,-64,127,-25060,-28,-24,-28,-24,-28,-24,60,51,-27,-100,54,-50,-72,56,-92,-104,56,-29,-104,57,28,-104,57,97,60,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,89,36,94,-112,64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,-127,-92,97,-48,96,98,12,-60,98,88,-32,98,-107,68,98,-31,96,99,21,-28,99,111,32,99,-98,100,99,-9,-96,100,38,-28,100,-128,32,100,-81,100,101,8,-96,101,55,-28,101,-111,32,101,-64,100,102,25,-96,102,75,-124,102,-92,-64,102,-44,4,103,45,64,103,92,-124,103,-75,-64,103,-27,4,104,62,64,104,109,-124,104,-58,-64,104,-8,-92,105,81,-32,105,-127,36,106,9,-96,106,98,-36,127,-25060,-28,-24,-28,-24,-28,-24,-20,-24,-20,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Panama,-18000000,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,2,-1,-2524502512,-1,-1946918424,127,-19088,127,-19176,-20,0,1,1,0,GMT-05:00,GMT-05:00,Eastern Standard Time,Eastern Daylight Time,0,America/Pangnirtung,-18000000,3,62,-24,96,93,-119,-72,94,18,60,0,-20,-24,-20,75,62,-24,96,64,-103,-8,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,-128,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,0,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-24,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Paramaribo,-10800000,4,-1,-1861906760,-1,-1104524348,-1,-765317964,85,120,46,127,-13240,127,-13252,127,-13236,-14,-12,4,-1,-1861906760,-1,-1104524348,-1,-765317964,85,120,46,127,-13240,127,-13252,127,-13236,-14,-12,0,1,1,0,SRT,SRST,Suriname Time,Suriname Summer Time,0,America/Phoenix,-25200000,1,31,-128,-84,127,-26898,-28,11,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,62,-89,-92,-1,-820519140,-1,-812653140,-1,-796845540,76,37,-60,76,106,0,127,-26898,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,0,1,1,0,GMT-07:00,GMT-07:00,Mountain Standard Time,Mountain Daylight Time,0,America/Port-au-Prince,-18000000,2,-1,-2524504240,-1,-1670483460,127,-17360,127,-17340,-20,48,-1,-2524504240,-1,-1670483460,84,-72,52,84,-7,-48,85,62,20,85,-126,80,85,-58,-108,86,10,-48,86,79,20,86,-109,80,86,-41,-108,87,27,-48,87,88,56,87,-90,-8,87,-32,-72,88,47,120,88,105,56,88,-73,-8,88,-12,88,89,64,120,89,124,-40,89,-56,-8,90,5,88,90,84,24,90,-115,-40,90,-36,-104,91,22,88,91,101,24,91,-95,120,91,-19,-104,92,41,-8,92,118,24,96,112,-108,96,-65,80,96,-7,20,97,71,-48,100,38,-36,100,-128,24,100,-81,92,101,8,-104,101,55,-36,101,-111,24,101,-64,92,102,25,-104,102,-45,-4,103,45,56,103,92,124,103,-75,-72,127,-17360,127,-17340,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Port_of_Spain,-14400000,1,-1").append(",-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Porto_Acre,-18000000,3,-1,-1767209328,98,42,84,101,11,48,127,-16272,-20,-16,-20,31,-1,-1767209328,57,29,-128,57,97,48,57,-90,-108,57,-22,16,66,-43,20,67,8,20,67,93,-12,67,-117,80,67,-26,-44,68,20,-112,68,112,20,68,-111,-48,74,85,116,74,116,-112,74,-14,-108,75,8,-80,75,100,-108,75,-122,80,75,-30,52,76,15,48,76,107,20,76,-104,112,86,13,20,86,62,-16,86,-110,-12,86,-68,-16,87,27,-44,87,67,48,98,42,84,101,11,48,127,-16272,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,0,1,1,0,ACT,ACST,Acre Standard Time,Acre Summer Time,0,America/Porto_Velho,-14400000,1,-1,-1767210264,127,-15336,-16,29,-1,-1767210264,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,127,-15336,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,0,1,1,0,AMT,AMST,Amazon Standard Time,Amazon Summer Time,0,America/Puerto_Rico,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Punta_Arenas,-10800000,12,-1,-2524504580,-1,-1892661435,48,-13,-44,-1,-1619205435,50,-114,112,-1,-1335986235,57,-102,-108,62,-47,-112,62,-24,116,65,22,-48,65,122,-112,102,-81,44,127,-17020,127,-16965,-20,127,-16965,-16,127,-16965,-20,-16,-20,-16,-20,-16,-12,115,-1,-2524504580,-1,-1892661435,48,-13,-44,-1,-1619205435,50,-114,112,-1,-1335986235,55,61,80,55,118,-76,55,-58,48,55,-1,-108,56,79,16,56,-120,116,56,-41,-16,57,17,84,57,97,48,57,-102,-108,62,-47,-112,62,-24,116,65,103,112,65,122,-112,76,-11,16,77,44,44,77,-123,112,77,-76,-84,77,-2,48,78,55,-20,78,-122,-80,78,-64,108,79,17,-48,79,72,-20,79,-107,16,79,-47,108,80,34,-48,80,89,-20,80,-85,80,80,-27,12,81,51,-48,81,109,-116,81,-68,80,81,-10,12,82,71,112,82,126,-116,82,-49,-16,83,7,12,83,88,112,83,-110,44,83,-32,-16,84,26,-84,84,105,112,84,-93,44,84,-15,-16,85,43,-84,85,125,16,85,-76,44,86,5,-112,86,60,-84,86,-114,16,86,-46,76,87,22,-112,87,80,76,87,-97,16,87,-40,-52,88,42,48,88,97,76,88,-88,48,88,-23,-52,89,59,48,89,116,-20,89,-61,-80,89,-3,108,90,76,48,90,-123,-20,90,-44,-80,91,14,108,91,95,-48,91,-106,-20,91,-24,80,92,39,76,92,112,-48,92,-86,-116,92,-12,16,93,58,-20,93,-127,-48,93,-69,-116,94,12,-16,94,68,12,94,-107,112,94,-52,-116,95,29,-16,95,85,12,95,-90,112,95,-32,44,96,46,-16,96,104,-84,96,-73,112,96,-15,44,97,66,-112,97,121,-84,97,-53,16,98,10,12,98,83,-112,98,-115,76,98,-36,16,99,29,-84,99,100,-112,99,-77,76,99,-38,-80,100,57,44,100,104,112,100,-63,-84,100,-13,-112,101,74,44,101,124,16,102,99,12,102,-123,48,127,-17020,127,-16965,-20,127,-16965,-16,127,-16965,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,0,1,1,0,GMT-03:00,GMT-03:00,Punta Arenas Standard Time,Punta Arenas Standard Time,0,America/Rainy_River,-21600000,1,-1,-2602258284,127,-23316,-24,127,-1,-2602258284,48,-39,-8,49,17,20,49,-24,96,50,49,-36,60,30,-32,60,80,-68,62,-89,-96,64,-103,-4,64,-18,0,65,39,-68,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,-64,67,70,-68,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,32,-68,72,101,0,72,-98,-68,74,1,32,74,56,60,75,-102,-96,75,-31,-128,76,37,-64,76,106,0,76,-82,64,76,-14,-128,77,54,-64,77,123,0,77,-65,64,78,3,-128,78,71,-64,78,-114,-96,78,-46,-32,79,23,32,79,91,96,79,-97,-96,79,-29,-32,80,40,32,80,108,96,80,-80,-96,80,-12,-32,81,59,-64,81,125,96,81,-60,64,82,8,-128,82,76,-64,82,-111,0,82,-43,64,83,25,-128,83,93,-64,83,-94,0,83,-26,64,84,42,-128,84,113,96,84,-77,0,84,-7,-32,85,62,32,85,-126,96,85,-58,-96,86,10,-32,86,79,32,86,-109,96,86,-49,-64,87,27,-32,87,88,64,87,-89,0,87,-32,-64,88,47,-128,88,105,64,88,-72,0,88,-12,96,89,64,-128,89,124,-32,89,-55,0,90,5,96,90,84,32,90,-115,-32,90,-36,-96,91,22,96,91,101,32,91,-95,-128,91,-19,-96,92,42,0,92,118,32,92,-78,-128,92,-2,-96,93,59,0,93,-119,-64,93,-61,-128,94,18,64,94,76,0,94,-102,-64,94,-41,32,95,35,64,95,95,-96,95,-85,-64,95,-24,32,96,54,-32,96,112,-96,96,-65,96,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-23316,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Rankin_Inlet,-21600000,3,70,-97,-128,94,18,60,94,76,0,0,-24,-20,-24,73,70,-97,-128,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-29,-32,80,40,28,80,108,96,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,89,64,124,89,124,-32,89,-56,-4,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,-102,-68,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,0,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Recife,-10800000,1,-1,-1767217224,127,-8376,-12,39,-1,-1767217224,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,85,108,74,116,-120,74,-14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,93,127,44,93,-74,72,94,10,76,94,12,-24,94,-107,108,94,-60,-88,127,-8376,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Regina,-21600000,2,-1,-2030202084,72,101,4,127,-25116,-28,-24,52,-1,-2030202084,49,-24,100,50,49,-32,56,91,124,56,-107,56,56,-29,-4,57,29,-72,57,108,124,57,-90,56,57,-9,-100,58,46,-72,58,-128,28,58,-71,-40,60,17,-68,60,85,-8,60,-102,60,60,-37,-40,61,34,-68,61,102,-8,61,-83,-36,61,-14,24,62,54,92,62,122,-104,62,-89,-92,64,-102,0,64,-29,-124,65,39,-64,65,113,68,65,-85,0,65,-7,-60,66,51,-128,66,-126,68,66,-68,0,67,13,100,67,68,-128,67,-107,-28,67,-49,-96,68,30,100,68,88,32,68,-90,-28,68,-32,-96,69,47,100,69,105,32,69,-73,-28,69,-15,-96,70,67,4,70,124,-64,70,-53,-124,71,5,64,71,-36,-124,72,32,-64,72,101,4,127,-25116,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Resolute,-21600000,5,65,-96,96,94,18,60,94,76,0,97,71,-36,97,121,-64,0,-24,-20,-24,-20,-24,71,65,-96,96,78,-46,-32,79,23,28,79,91,96,79,-97,-100,79,-29,-32,80,40,28,80,108,96,80,-80,-100,80,-12,-32,81,59,-68,81,125,96,81,-60,60,82,8,-128,82,76,-68,82,-111,0,82,-43,60,83,25,-128,83,93,-68,83,-94,0,83,-26,60,84,42,-128,84,113,92,84,-77,0,84,-7,-36,85,62,32,85,-126,92,85,-58,-96,86,10,-36,86,79,32,86,-109,92,86,-49,-64,87,27,-36,87,88,64,87,-90,-4,87,-32,-64,88,47,124,88,105,64,88,-73,-4,88,-12,96,89,64,124,89,124,-32,89,-56,-4,90,5,96,90,84,28,90,-115,-32,90,-36,-100,91,22,96,91,101,28,91,-95,-128,91,-19,-100,92,42,0,92,118,28,92,-78,-128,92,-2,-100,93,59,0,93,-119,-68,93,-61,-128,94,-102,-68,94,-41,32,95,35,60,95,95,-96,95,-85,-68,95,-24,32,96,54,-36,96,112,-96,96,-65,92,96,-7,32,97,-46,-4,98,2,64,98,91,124,0,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Rio_Branco,-18000000,3,-1,-1767209328,98,42,84,101,11,48,127,-16272,-20,-16,-20,31,-1,-1767209328,57,29,-128,57,97,48,57,-90,-108,57,-22,16,66,-43,20,67,8,20,67,93,-12,67,-117,80,67,-26,-44,68,20,-112,68,112,20,68,-111,-48,74,85,116,74,116,-112,74,-14,-108,75,8,-80,75,100,-108,75,-122,80,75,-30,52,76,15,48,76,107,20,76,-104,112,86,13,20,86,62,-16,86,-110,-12,86,-68,-16,87,27,-44,87,67,48,98,42,84,101,11,48,127,-16272,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,0,1,1,0,ACT,ACST,Acre Standard Time,Acre Summer Time,0,America/Rosario,-10800000,6,-1,-1567453392,77,115,16,88,-25,40,89,61,-48,93,127,44,93,-72,44,127,-15408,-16,-12,-16,-12,-16,-12,58,-1,-1567453392,56,-86,-112,56,-41,-20,57,33,-48,57,85,-116,57,-79,112,57,-34,108,58,58,80,58,103,76,58,-61,48,58,-16,44,59,76,16,59,121,108,59,-43,80,60,2,76,60,94,48,60,-117,44,60,-25,16,61,20,12,61,111,-16,61,-99,76,61,-53,16,62,77,-20,62,123,-80,63,113,76,63,-115,112,64,-46,-20,65,35,48,74,59,-116,74,87,-80,74,116,-116,74,-54,16,74,-3,108,75,82,-16,75,-122,76,75,-37,-48,76,27,44,76,95,112,76,-90,76,76,-22,-112,77,46,-52,77,115,16,79,-64,44,79,-28,-24,87,-78,-20,87,-42,40,88,42,44,88,94,-88,88,-75,76,88,-25,40,89,61,-48,89,111,-88,89,-58,76,89,-6,-56,97,-25,-20,98,4,-56,98,86,44,98,-115,72,127,-15408,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-8,-12,-8,-12,-8,-12,-8,-16,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,ART,ARST,Argentina Standard Time,Argentina Summer Time,0,America/Santa_Isabel,-28800000,4,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,127,-28084,-28,-32,-28,-32,96,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,56,-40,0,57,28,60,62,-61,96,64,-86,28,65,-14,64,66,92,-68,69,47,100,69,105,36,69,-73,-28,69,-15,-92,70,67,4,70,124,-60,70,-53,-124,71,5,68,71,84,4,71,-115,-60,71,-36,-124,72,22,68,72,101,4,72,-98,-60,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,-127,-88,97,-48,100,98,12,-56,98,88,-28,98,-107,72,98,-31,100,99,21,-24,99,111,36,99,-98,104,99,-9,-92,127,-28084,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,2,976786946,-1200056824,1,1,0,PST,PDT,Northwest Mexico Standard Time,Northwest Mexico Daylight Time,0,America/Santarem,-10800000,2,-1,-1767212472,98,42,80,127,-13128,-16,-12,30,-1,-1767212472,57,29,124,57,97,44,57,-90,-112,57,-22,12,66,-43,16,67,8,16,67,93,-16,67,-117,76,67,-26,-48,68,20,-116,68,112,16,68,-111,-52,74,85,112,74,116,-116,74,-14,-112,75,8,-84,75,100,-112,75,-122,76,75,-30,48,76,15,44,76,107,16,76,-104,108,86,13,16,86,62,-20,86,-110,-16,86,-68,-20,87,27,-48,87,67,44,98,42,80,127,-13128,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Santiago,-14400000,10,-1,-1892661435,48,-13,-44,-1,-1619205435,50,-114,112,-1,-1335986235,57,-102,-108,62,-47,-112,62,-24,116,65,22,-52,65,122,-112,127,-16965,-20,127,-16965,-16,127,-16965,-20,-16,-20,-16,-20,-16,132,-1,-1892661435,48,-13,-44,-1,-1619205435,50,-114,112,-1,-1335986235,55,61,80,55,118,-76,55,-58,48,55,-1,-108,56,79,16,56,-120,116,56,-41,-16,57,17,84,57,97,48,57,-102,-108,62,-47,-112,62,-24,116,65,5,-16,65,22,-52,65,103,112,65,122,-112,76,-11,16,77,44,44,77,-123,112,77,-76,-84,77,-2,48,78,55,-20,78,-122,-80,78,-64,108,79,17,-48,79,72,-20,79,-107,16,79,-47,108,80,34,-48,80,89,-20,80,-85,80,80,-27,12,81,51,-48,81,109,-116,81,-68,80,81,-10,12,82,71,112,82,126,-116,82,-49,-16,83,7,12,83,88,112,83,-110,44,83,-32,-16,84,26,-84,84,105,112,84,-93,44,84,-15,-16,85,43,-84,85,125,16,85,-76,44,86,5,-112,86,60,-84,86,-114,16,86,-46,76,87,22,-112,87,80,76,87,-97,16,87,-40,-52,88,42,48,88,97,76,88,-88,48,88,-23,-52,89,59,48,89,116,-20,89,-61,-80,89,-3,108,90,76,48,90,-123,-20,90,-44,-80,91,14,108,91,95,-48,91,-106,-20,91,-24,80,92,39,76,92,112,-48,92,-86,-116,92,-12,16,93,58,-20,93,-127,-48,93,-69,-116,94,12,-16,94,68,12,94,-107,112,94,-52,-116,95,29,-16,95,85,12,95,-90,112,95,-32,44,96,46,-16,96,104,-84,96,-73,112,96,-15,44,97,66,-112,97,121,-84,97,-53,16,98,10,12,98,83,-112,98,-115,76,98,-36,16,99,29,-84,99,100,-112,99,-77,76,99,-38,-80,100,57,44,100,104,112,100,-63,-84,100,-13,-112,101,74,44,101,124,16,102,99,12,102,-123,48,102,-21,-116,103,13,-80,103,116,12,103,-106,48,103,-17,108,104,41,48,104,119,-20,104,-79,-80,105,0,108,105,58,48,105,-120,-20,105,-59,80,106,17,108,106,75,48,106,-100,-116,106,-42,80,127,-16965,-20,127,-16965,-16,127,-16965,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-12,-16,-20,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,2,1220069128,-1732704510,1,1,0,CLT,CLST,Chile Standard Time,Chile Summer Time,0,America/Santo_Domingo,-14400000,5,-1,-2524504824,-1,-1159773600,80,40,20,94,18,56,94,31,88,127,-16776,127,-16800,-20,-16,-20,-16,17,-1,-2524504824,-1,-1159773600,75,-31,116,76,14,-48,77,122,-12,77,-89,50,78,3,116,78,36,18,78,-114,-108,78,-83,82,79,23,20,79,54,-110,79,-97,-108,79,-65,114,80,40,20,94,18,56,94,31,88,127,-16776,127,-16800,-20,-16,-20,-18,-20,-18,-20,-18,-20,-18,-20,-18,-20,-16,-20,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Sao_Paulo,-10800000,1,-1,-1767214412,127,-11188,-12,91,-1,-1767214412,57,29,120,57,97,40,57,-90,-116,57,-22,8,66,-43,12,67,8,12,67,93,-20,67,-117,72,67,-26,-52,68,20,-120,68,112,12,68,-111,-56,74,67,-52,74,116,-120,74,-").append("14,-116,75,8,-88,75,100,-116,75,-122,72,75,-30,44,76,15,40,76,107,12,76,-104,104,86,13,12,86,62,-24,86,-110,-20,86,-68,-24,87,27,-52,87,67,40,87,-95,-84,87,-55,8,88,42,44,88,86,-56,88,-75,76,88,-31,-24,89,61,-52,89,103,-56,89,-56,-20,89,-19,-88,90,78,-52,90,126,8,90,-41,76,91,6,-120,91,95,-52,91,-116,104,91,-27,-84,92,23,-120,92,110,-116,92,-91,72,92,-7,76,93,43,40,93,127,44,93,-74,72,94,10,76,94,60,40,94,-107,108,94,-60,-88,95,37,-52,95,77,40,95,-87,12,95,-43,-88,96,55,-116,96,96,-56,96,-70,12,96,-23,72,97,74,108,97,116,104,97,-53,12,97,-6,72,98,86,44,98,-126,-56,98,-34,-84,99,13,-24,99,103,44,99,-106,104,99,-17,-84,100,33,-120,100,122,-52,100,-89,104,101,3,76,101,47,-24,101,-117,-52,101,-69,8,102,20,76,102,67,-120,102,-100,-52,102,-52,8,103,37,76,103,84,-120,103,-75,-84,103,-35,8,127,-11188,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,-8,-12,0,1,1,0,BRT,BRST,Brasilia Standard Time,Brasilia Summer Time,0,America/Scoresbysund,-3600000,2,-1,-1686090728,83,-105,104,127,-5272,-8,-4,37,-1,-1686090728,83,17,-112,83,83,48,83,-105,104,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-5272,-8,-4,-8,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,0,-4,2,1048070082,-1367849016,1,1,0,EGT,EGST,East Greenland Standard Time,East Greenland Summer Time,0,America/Shiprock,-25200000,1,31,-128,-84,127,-25196,-28,99,31,-128,-84,49,-29,36,50,49,-32,50,107,-92,50,-70,96,50,-12,36,51,69,-128,51,124,-92,51,-111,-96,62,-89,-92,64,-102,0,75,18,36,75,89,0,75,-102,-92,75,-31,-128,76,37,-60,76,106,0,76,-82,68,76,-14,-128,77,54,-60,77,123,0,77,-65,68,78,3,-128,78,71,-60,78,-114,-96,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-71,-28,80,40,32,80,84,-60,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,127,-25196,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,America/Sitka,-32400000,3,-1,-3225223727,-1,-2188954727,84,-7,-28,127,53927,127,-32473,-32,-36,84,-1,-3225223727,-1,-2188954727,62,-89,-88,64,-102,4,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-71,-24,80,40,36,80,84,-56,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,44,85,-126,104,85,-58,-84,86,10,-24,86,79,44,86,-109,104,86,-49,-52,87,27,-24,87,88,76,87,-89,8,87,-32,-52,88,47,-120,88,105,76,88,-72,8,88,-12,108,89,64,-120,89,124,-20,89,-55,8,90,5,108,90,84,40,90,-115,-20,90,-36,-88,91,22,108,91,101,40,91,-95,-116,91,-19,-88,92,42,12,92,118,40,92,-78,-116,92,-2,-88,93,59,12,93,-119,-56,93,-61,-116,94,18,72,94,76,12,94,-102,-56,94,-41,44,95,35,72,95,95,-84,95,-85,-56,95,-24,44,96,54,-24,96,112,-84,96,-65,104,96,-7,44,97,71,-24,97,121,-52,97,-45,8,98,2,76,98,91,-120,127,53927,127,-32473,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/St_Barthelemy,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/St_Johns,-12600000,1,-1,-1096921748,127,-12652,-14,187,-1,-1664130548,-1,-1650137348,-1,-1632076148,-1,-1615145348,-1,-1598650148,-1,-1590100148,-1,-1567286948,-1,-1551565748,-1,-1535837348,-1,-1520116148,-1,-1503782948,-1,-1488666548,-1,-1472333348,-1,-1457216948,-1,-1440883748,-1,-1425767348,-1,-1409434148,-1,-1394317748,-1,-1377984548,-1,-1362263348,-1,-1346534948,-1,-1330813748,-1,-1314480548,-1,-1299364148,-1,-1283030948,-1,-1267914548,-1,-1251581348,-1,-1236464948,-1,-1220131748,-1,-1205015348,-1,-1188682148,-1,-1172960948,-1,-1156627748,-1,-1141511348,-1,-1125178148,-1,-1110061748,-1,-1096921748,59,8,-22,59,74,-122,59,-108,14,59,-53,42,60,28,-114,60,83,-86,60,-91,14,60,-36,42,61,48,46,61,100,-86,61,-72,-82,61,-17,-54,62,65,46,62,120,74,62,-55,-82,64,-103,-14,64,-19,-10,65,37,18,65,118,118,65,-83,-110,65,-2,-10,66,54,18,66,-121,118,66,-66,-110,67,18,-106,67,73,-78,67,-107,-42,67,-49,-110,68,30,86,68,88,18,68,-90,-42,68,-32,-110,69,47,86,69,105,18,69,-73,-42,69,-15,-110,70,66,-10,70,124,-78,70,-53,118,71,5,50,71,83,-10,71,-115,-78,71,-36,118,72,22,50,72,100,-10,72,-85,-46,72,-16,22,73,52,82,73,120,-106,73,-68,-46,74,1,22,74,69,82,74,-119,-106,74,-51,-46,75,18,22,75,88,-14,75,-102,-106,75,-31,114,76,37,-74,76,105,-14,76,-82,54,76,-14,114,77,54,-74,77,122,-14,77,-65,54,78,3,114,78,71,-74,78,-114,-110,78,-46,-42,79,23,18,79,91,86,79,-97,-110,79,-29,-42,80,40,18,80,108,86,80,-80,-110,80,-12,-42,81,59,-78,81,125,86,81,-60,50,82,8,118,82,76,-78,82,-112,-10,82,-43,50,83,25,118,83,93,-78,83,-95,-10,83,-26,50,84,42,118,84,113,82,84,-78,-10,84,-7,-46,85,62,22,85,-126,82,85,-58,-106,86,10,-46,86,79,22,86,-109,82,-1,544591860,-1,562127460,-1,576041460,-1,594178260,-1,607491060,-1,625631460,-1,638940660,-1,657081060,-1,670995060,-1,688530660,-1,702444660,-1,719980260,-1,733894260,-1,752034660,-1,765343860,-1,783484260,-1,796793460,-1,814933860,-1,828847860,-1,846383460,-1,860297460,-1,877833060,-1,891747060,-1,909282660,-1,923196660,-1,941337060,-1,954646260,-1,972786660,-1,986095860,-1,1004236260,-1,1018150260,-1,1035685860,-1,1049599860,-1,1067135460,-1,1081049460,-1,1099189860,-1,1112499060,-1,1130639460,-1,1143948660,-1,1162089060,-1,1173583860,-1,1194143460,-1,1205033460,-1,1225593060,-1,1236483060,-1,1257042660,-1,1268537460,-1,1289097060,-1,1299987060,99,-9,-110,100,38,-42,100,-128,18,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,127,-9052,127,-12652,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-6,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,-10,-14,2,976787234,-1200056536,1,1,0,NST,NDT,Newfoundland Standard Time,Newfoundland Daylight Time,0,America/St_Kitts,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/St_Lucia,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/St_Thomas,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/St_Vincent,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Swift_Current,-21600000,2,-1,-2030201320,78,-46,-28,127,-25880,-28,-24,22,-1,-2030201320,49,-24,100,50,49,-32,62,-89,-92,64,-102,0,64,-24,-60,65,39,-64,65,113,68,65,-85,0,65,-7,-60,66,51,-128,66,-126,68,66,-68,0,70,-53,-124,71,15,-64,71,-36,-124,72,32,-64,72,101,4,72,-98,-64,72,-16,36,73,39,64,78,-46,-28,127,-25880,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Tegucigalpa,-21600000,1,-1,-1538503868,127,-20932,-24,7,-1,-1538503868,86,-38,56,87,17,84,87,98,-72,87,-103,-44,97,6,56,97,40,-76,127,-20932,-24,-20,-24,-20,-24,-20,-24,0,1,1,0,GMT-06:00,GMT-06:00,Central Standard Time,Central Daylight Time,0,America/Thule,-14400000,1,-1,-1686079492,127,-16508,-16,37,-1,-1686079492,88,-15,-72,89,53,-12,89,122,56,89,-66,116,90,5,88,90,84,20,90,-115,-40,90,-36,-108,91,22,88,91,101,20,91,-95,120,91,-19,-108,92,41,-8,92,118,20,92,-78,120,92,-2,-108,93,58,-8,93,-119,-76,93,-61,120,94,18,52,94,75,-8,94,-102,-76,94,-41,24,95,35,52,95,95,-104,95,-85,-76,95,-24,24,96,54,-44,96,112,-104,96,-65,84,96,-7,24,97,71,-44,97,121,-72,97,-46,-12,98,2,56,98,91,116,127,-16508,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,-12,-16,2,976787202,-1200056568,1,1,0,GMT-04:00,GMT-03:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Thunder_Bay,-18000000,1,-1,-2366736148,127,-19052,-20,173,-1,-2366736148,49,-24,92,50,49,-40,50,107,-14,50,-70,80,51,1,60,51,56,80,51,-114,-4,51,-67,24,52,23,124,52,70,-72,52,-97,-4,52,-49,56,53,37,-36,53,90,88,53,-82,92,53,-30,-40,54,54,-36,54,107,88,54,-65,92,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,108,124,57,-93,-104,57,-12,-4,58,46,-72,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,64,-103,-8,64,-24,-68,65,34,120,65,113,52,65,-86,-16,65,-7,-76,66,51,112,66,-126,52,66,-45,-112,67,13,92,67,92,24,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-15,-104,70,66,-4,70,124,-72,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,105,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-19052,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Tijuana,-28800000,4,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,127,-28084,-28,-32,-28,-32,96,51,-27,-100,52,-9,92,54,-50,-68,56,-92,-100,56,-40,0,57,28,60,62,-61,96,64,-86,28,65,-14,64,66,92,-68,69,47,100,69,105,36,69,-73,-28,69,-15,-92,70,67,4,70,124,-60,70,-53,-124,71,5,68,71,84,4,71,-115,-60,71,-36,-124,72,22,68,72,101,4,72,-98,-60,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,-127,-88,97,-48,100,98,12,-56,98,88,-28,98,-107,72,98,-31,100,99,21,-24,99,111,36,99,-98,104,99,-9,-92,127,-28084,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,2,976786946,-1200056824,1,1,0,GMT-08:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Toronto,-18000000,1,-1,-2366736148,127,-19052,-20,173,-1,-2366736148,49,-24,92,50,49,-40,50,107,-14,50,-70,80,51,1,60,51,56,80,51,-114,-4,51,-67,24,52,23,124,52,70,-72,52,-97,-4,52,-49,56,53,37,-36,53,90,88,53,-82,92,53,-30,-40,54,54,-36,54,107,88,54,-65,92,54,-10,120,55,71,-36,55,-127,-104,55,-48,92,56,10,24,56,88,-36,56,-110,-104,56,-31,92,57,27,24,57,108,124,57,-93,-104,57,-12,-4,58,46,-72,58,125,124,58,-73,56,59,5,-4,59,63,-72,59,-114,124,59,-56,56,60,22,-4,60,80,-72,60,-97,124,60,-39,56,61,42,-100,61,97,-72,61,-77,28,64,-103,-8,64,-24,-68,65,34,120,65,113,52,65,-86,-16,65,-7,-76,66,51,112,66,-126,52,66,-45,-112,67,13,92,67,92,24,67,-107,-36,67,-49,-104,68,30,92,68,88,24,68,-90,-36,68,-32,-104,69,47,92,69,105,24,69,-73,-36,69,-15,-104,70,66,-4,70,124,-72,70,-53,124,71,15,-72,71,83,-4,71,-104,56,71,-36,124,72,32,-72,72,100,-4,72,-85,-40,72,-16,28,73,52,88,73,120,-100,73,-68,-40,74,1,28,74,69,88,74,-119,-100,74,-51,-40,75,18,28,75,88,-8,75,-102,-100,75,-31,120,76,37,-68,76,105,-8,76,-82,60,76,-14,120,77,54,-68,77,122,-8,77,-65,60,78,3,120,78,71,-68,78,-114,-104,78,-46,-36,79,23,24,79,91,92,79,-97,-104,79,-29,-36,80,40,24,80,108,92,80,-80,-104,80,-12,-36,81,59,-72,81,125,92,81,-60,56,82,8,124,82,76,-72,82,-112,-4,82,-43,56,83,25,124,83,93,-72,83,-95,-4,83,-26,56,84,42,124,84,113,88,84,-78,-4,84,-7,-40,85,62,28,85,-126,88,85,-58,-100,86,10,-40,86,79,28,86,-109,88,86,-49,-68,87,27,-40,87,88,60,87,-90,-8,87,-32,-68,88,47,120,88,1").append("05,60,88,-73,-8,88,-12,92,89,64,120,89,124,-36,89,-56,-8,90,5,92,90,84,24,90,-115,-36,90,-36,-104,91,22,92,91,101,24,91,-95,124,91,-19,-104,92,41,-4,92,118,24,92,-78,124,92,-2,-104,93,58,-4,93,-119,-72,93,-61,124,94,18,56,94,75,-4,94,-102,-72,94,-41,28,95,35,56,95,95,-100,95,-85,-72,95,-24,28,96,54,-40,96,112,-100,96,-65,88,96,-7,28,97,71,-40,97,121,-68,97,-46,-8,98,2,60,98,91,120,127,-19052,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,-16,-20,2,976787138,-1200056632,1,1,0,GMT-05:00,GMT-04:00,Eastern Standard Time,Eastern Daylight Time,0,America/Tortola,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Vancouver,-28800000,1,-1,-2713880852,127,-29548,-32,131,-1,-2713880852,49,-24,104,50,49,-28,62,-89,-88,64,-102,4,64,-24,-56,65,34,-124,65,113,72,65,-85,4,65,-7,-56,66,51,-124,66,-126,72,66,-68,4,67,13,104,67,68,-124,67,-107,-24,67,-49,-92,68,30,104,68,88,36,68,-90,-24,68,-32,-92,69,47,104,69,105,36,69,-73,-24,69,-15,-92,70,67,8,70,124,-60,70,-53,-120,71,5,68,71,84,8,71,-115,-60,71,-36,-120,72,22,68,72,101,8,72,-98,-60,72,-16,40,73,39,68,73,120,-88,73,-68,-28,74,1,40,74,69,100,74,-119,-88,74,-51,-28,75,18,40,75,89,4,75,-102,-88,75,-31,-124,76,37,-56,76,106,4,76,-82,72,76,-14,-124,77,54,-56,77,123,4,77,-65,72,78,3,-124,78,71,-56,78,-114,-92,78,-46,-24,79,23,36,79,91,104,79,-97,-92,79,-29,-24,80,40,36,80,108,104,80,-80,-92,80,-12,-24,81,59,-60,81,125,104,81,-60,68,82,8,-120,82,76,-60,82,-111,8,82,-43,68,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,121,-56,97,-45,4,98,2,72,98,91,-124,127,-29548,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,2,976786946,-1200056824,1,1,0,GMT-08:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Virgin,-14400000,1,-1,-2233035335,127,-15865,-16,3,-1,-2233035335,62,-58,-80,64,-103,-12,127,-15865,-16,-12,-16,0,1,1,0,GMT-04:00,GMT-04:00,Atlantic Standard Time,Atlantic Daylight Time,0,America/Whitehorse,-25200000,3,-1,-2188997988,75,-123,-92,104,-58,-68,127,-32412,-36,-32,-28,91,-1,-2188997988,49,-24,108,50,49,-24,50,-128,-84,50,-68,-96,62,-89,-84,64,-102,8,75,18,36,75,89,4,75,-123,-92,83,25,-120,83,93,-60,83,-94,8,83,-26,68,84,42,-120,84,113,100,84,-77,8,84,-7,-28,85,62,40,85,-126,100,85,-58,-88,86,10,-28,86,79,40,86,-109,100,86,-49,-56,87,27,-28,87,88,72,87,-89,4,87,-32,-56,88,47,-124,88,105,72,88,-72,4,88,-12,104,89,64,-124,89,124,-24,89,-55,4,90,5,104,90,84,36,90,-115,-24,90,-36,-92,91,22,104,91,101,36,91,-95,-120,91,-19,-92,92,42,8,92,118,36,92,-78,-120,92,-2,-92,93,59,8,93,-119,-60,93,-61,-120,94,18,68,94,76,8,94,-102,-60,94,-41,40,95,35,68,95,95,-88,95,-85,-60,95,-24,40,96,54,-28,96,112,-88,96,-65,100,96,-7,40,97,71,-28,97,121,-56,97,-45,4,98,2,72,98,91,-124,98,-118,-56,98,-28,4,99,21,-24,99,111,36,99,-98,104,99,-9,-92,100,38,-24,100,-128,36,100,-81,104,101,8,-92,101,55,-24,101,-111,36,101,-64,104,102,25,-92,102,75,-120,102,-92,-60,102,-44,8,103,45,68,103,92,-120,103,-75,-60,103,-27,8,104,62,68,104,109,-120,127,-32412,-36,-32,-36,-32,-36,-32,-36,-28,-36,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,-32,-28,0,1,1,0,GMT-07:00,GMT-07:00,Pacific Standard Time,Pacific Daylight Time,0,America/Winnipeg,-21600000,1,-1,-2602258284,127,-23316,-24,127,-1,-2602258284,48,-39,-8,49,17,20,49,-24,96,50,49,-36,60,30,-32,60,80,-68,62,-89,-96,64,-103,-4,64,-18,0,65,39,-68,65,113,64,65,-86,-4,65,-7,-64,66,51,124,66,-126,64,66,-69,-4,67,13,-64,67,70,-68,67,-107,-32,67,-49,-100,68,30,96,68,88,28,68,-90,-32,68,-32,-100,69,47,96,69,105,28,69,-73,-32,69,-15,-100,70,67,0,70,124,-68,70,-53,-128,71,5,60,71,84,0,71,-115,-68,71,-36,-128,72,32,-68,72,101,0,72,-98,-68,74,1,32,74,56,60,75,-102,-96,75,-31,-128,76,37,-64,76,106,0,76,-82,64,76,-14,-128,77,54,-64,77,123,0,77,-65,64,78,3,-128,78,71,-64,78,-114,-96,78,-46,-32,79,23,32,79,91,96,79,-97,-96,79,-29,-32,80,40,32,80,108,96,80,-80,-96,80,-12,-32,81,59,-64,81,125,96,81,-60,64,82,8,-128,82,76,-64,82,-111,0,82,-43,64,83,25,-128,83,93,-64,83,-94,0,83,-26,64,84,42,-128,84,113,96,84,-77,0,84,-7,-32,85,62,32,85,-126,96,85,-58,-96,86,10,-32,86,79,32,86,-109,96,86,-49,-64,87,27,-32,87,88,64,87,-89,0,87,-32,-64,88,47,-128,88,105,64,88,-72,0,88,-12,96,89,64,-128,89,124,-32,89,-55,0,90,5,96,90,84,32,90,-115,-32,90,-36,-96,91,22,96,91,101,32,91,-95,-128,91,-19,-96,92,42,0,92,118,32,92,-78,-128,92,-2,-96,93,59,0,93,-119,-64,93,-61,-128,94,18,64,94,76,0,94,-102,-64,94,-41,32,95,35,64,95,95,-96,95,-85,-64,95,-24,32,96,54,-32,96,112,-96,96,-65,96,96,-7,32,97,71,-36,97,121,-64,97,-46,-4,98,2,64,98,91,124,127,-23316,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,-20,-24,2,976787074,-1200056696,1,1,0,GMT-06:00,GMT-05:00,Central Standard Time,Central Daylight Time,0,America/Yakutat,-32400000,2,-1,-3225223727,-1,-2188953665,127,52865,127,-33535,-36,84,-1,-3225223727,-1,-2188953665,62,-89,-84,64,-102,8,77,54,-52,77,123,8,77,-65,76,78,3,-120,78,71,-52,78,-114,-88,78,-46,-20,79,23,40,79,91,108,79,-97,-88,79,-71,-20,80,40,40,80,84,-52,80,-80,-88,80,-12,-20,81,59,-56,81,125,108,81,-60,72,82,8,-116,82,76,-56,82,-111,12,82,-43,72,83,25,-116,83,93,-56,83,-94,12,83,-26,72,84,42,-116,84,113,104,84,-77,12,84,-7,-24,85,62,44,85,-126,104,85,-58,-84,86,10,-24,86,79,44,86,-109,104,86,-49,-52,87,27,-24,87,88,76,87,-89,8,87,-32,-52,88,47,-120,88,105,76,88,-72,8,88,-12,108,89,64,-120,89,124,-20,89,-55,8,90,5,108,90,84,40,90,-115,-20,90,-36,-88,91,22,108,91,101,40,91,-95,-116,91,-19,-88,92,42,12,92,118,40,92,-78,-116,92,-2,-88,93,59,12,93,-119,-56,93,-61,-116,94,18,72,94,76,12,94,-102,-56,94,-41,44,95,35,72,95,95,-84,95,-85,-56,95,-24,44,96,54,-24,96,112,-84,96,-65,104,96,-7,44,97,71,-24,97,121,-52,97,-45,8,98,2,76,98,91,-120,127,52865,127,-33535,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,-32,-36,2,976786882,-1200056888,1,1,0,GMT-09:00,GMT-08:00,Alaska Standard Time,Alaska Daylight Time,0,America/Yellowknife,-25200000,1,58,-38,0,0,-28,77,58,-38,0,62,-89,-92,64,-102,0,78,-46,-28,79,23,32,79,91,100,79,-97,-96,79,-29,-28,80,40,32,80,108,100,80,-80,-96,80,-12,-28,81,59,-64,81,125,100,81,-60,64,82,8,-124,82,76,-64,82,-111,4,82,-43,64,83,25,-124,83,93,-64,83,-94,4,83,-26,64,84,42,-124,84,113,96,84,-77,4,84,-7,-32,85,62,36,85,-126,96,85,-58,-92,86,10,-32,86,79,36,86,-109,96,86,-49,-60,87,27,-32,87,88,68,87,-89,0,87,-32,-60,88,47,-128,88,105,68,88,-72,0,88,-12,100,89,64,-128,89,124,-28,89,-55,0,90,5,100,90,84,32,90,-115,-28,90,-36,-96,91,22,100,91,101,32,91,-95,-124,91,-19,-96,92,42,4,92,118,32,92,-78,-124,92,-2,-96,93,59,4,93,-119,-64,93,-61,-124,94,18,64,94,76,4,94,-102,-64,94,-41,36,95,35,64,95,95,-92,95,-85,-64,95,-24,36,96,54,-32,96,112,-92,96,-65,96,96,-7,36,97,71,-32,97,121,-60,97,-45,0,98,2,68,98,91,-128,0,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,-24,-28,2,976787010,-1200056760,1,1,0,GMT-07:00,GMT-06:00,Mountain Standard Time,Mountain Daylight Time,0,Asia/Aden,10800000,1,-1,-719636812,127,11212,12,1,-1,-719636812,127,11212,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Almaty,21600000,4,-1,-1441170468,56,109,76,88,-15,-112,89,95,-44,127,18468,20,24,20,24,50,-1,-1441170468,56,109,76,83,-104,104,83,-35,4,84,33,72,84,101,-28,84,-86,40,84,-18,-60,85,51,104,85,119,-80,85,-69,-16,86,0,48,86,68,112,86,-120,-80,86,-52,-16,87,17,48,87,85,112,87,-103,-80,87,-35,-16,88,34,48,88,102,112,88,-83,80,89,53,-44,89,95,-44,89,122,16,89,-66,80,90,2,-112,90,70,-48,90,-117,16,90,-49,80,91,19,-112,91,87,-48,91,-98,-80,91,-19,112,92,39,48,92,117,-16,92,-81,-80,92,-2,112,93,56,48,93,-119,-112,93,-64,-80,94,18,16,94,73,48,94,-102,-112,94,-44,80,95,35,16,95,92,-48,95,-85,-112,95,-27,80,96,54,-80,127,18468,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,0,1,1,0,ALMT,ALMST,East Kazakhstan Time,Alma-Ata Summer Time,0,Asia/Amman,10800000,2,-1,-1230776624,105,-42,-40,127,8624,8,12,86,-1,-1230776624,79,105,120,79,-107,84,79,-28,-40,80,30,52,80,109,-72,80,-89,20,80,-10,-8,81,59,-12,81,127,-40,81,-71,52,82,8,88,82,65,-76,85,-68,88,86,0,-12,86,70,88,86,-118,-108,86,-50,-40,87,19,20,87,87,88,87,-98,52,87,-18,24,88,38,-76,88,114,-40,88,-81,52,88,-9,-8,89,53,20,89,126,-104,89,-64,52,90,4,120,90,72,-76,90,-116,-8,90,-53,-12,91,24,24,91,84,120,91,-96,-104,91,-33,-104,92,41,24,92,104,24,92,-79,-104,92,-16,-104,93,91,-40,93,123,-72,93,-62,56,94,6,-40,94,74,-72,94,-113,88,94,-45,-104,95,23,-40,95,92,24,95,-86,-40,95,-28,-104,96,48,-72,96,111,-72,96,-77,-8,96,-8,56,97,70,-8,97,-128,-72,97,-49,120,98,9,56,98,90,-104,98,-111,-72,98,-29,24,99,26,56,99,107,-104,99,-91,88,99,-12,24,100,45,-40,101,26,20,101,62,-40,101,-112,56,101,-57,88,102,24,-72,102,82,120,102,-95,56,102,-38,-8,103,41,-72,103,99,120,103,-78,56,103,-21,-8,104,58,-72,104,116,120,104,-59,-40,104,-4,-8,105,78,88,105,122,-8,127,8624,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,0,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Anadyr,43200000,7,-1,-1441194596,56,109,48,84,33,44,88,-15,120,89,95,-68,99,26,-40,99,-93,92,127,42596,48,52,48,44,48,44,48,61,-1,-1441194596,56,109,48,83,-104,76,83,-36,-24,84,101,-52,84,-86,16,84,-18,-84,85,51,80,85,119,-104,85,-69,-40,86,0,24,86,68,88,86,-120,-104,86,-52,-40,87,17,24,87,85,88,87,-103,-104,87,-35,-40,88,34,24,88,102,88,88,-83,56,89,53,-68,89,95,-68,89,121,-8,89,-66,56,90,2,120,90,70,-72,90,-118,-8,90,-49,56,91,19,120,91,87,-72,91,-98,-104,91,-19,88,92,39,24,92,117,-40,92,-81,-104,92,-2,88,93,56,24,93,-119,120,93,-64,-104,94,17,-8,94,73,24,94,-102,120,94,-44,56,95,34,-8,95,92,-72,95,-85,120,95,-27,56,96,54,-104,96,109,-72,96,-65,24,96,-10,56,97,71,-104,97,126,-72,97,-48,24,98,9,-40,98,88,-104,98,-110,88,98,-31,24,99,108,60,99,-93,92,127,42596,48,52,56,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,44,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,44,48,0,1,1,0,ANAT,ANAST,Anadyr Standard Time,Anadyr Summer Time,0,Asia/Aqtau,18000000,8,-1,-1441164064,56,109,80,83,-35,12,84,33,72,88,-15,-108,89,95,-40,90,-49,84,96,54,-72,127,12064,16,20,24,20,16,20,16,20,47,-1,-1441164064,56,109,80,83,-35,12,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,89,122,20,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-104,91,87,-40,91,-98,-72,91,-19,120,92,39,56,92,117,-8,92,-81,-72,92,-2,120,93,56,56,93,-119,-104,93,-64,-72,94,18,24,94,73,56,94,-102,-104,94,-44,88,95,35,24,95,92,-40,95,-85,-104,95,-27,88,127,12064,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,24,20,24,20,24,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,0,1,1,0,AQTT,AQTST,West Kazakhstan Time,Aqtau Summer Time,0,Asia/Aqtobe,18000000,6,-1,-1441165720,56,109,80,83,-35,8,84,33,72,88,-15,-108,89,95,-40,127,13720,16,20,24,20,16,20,48,-1,-1441165720,56,109,80,83,-104,108,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,89,122,20,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-108,91,87,-44,91,-98,-76,91,-19,116,92,39,52,92,117,-12,92,-81,-76,92,-2,116,93,56,52,93,-119,-108,93,-64,-76,94,18,20,94,73,52,94,-102,-108,94,-44,84,95,35,20,95,92,-44,95,-85,-108,95,-27,84,96,54,-76,127,13720,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,0,1,1,0,AQTT,AQTST,West Kazakhstan Time,Aqtobe Summer Time,0,Asia/Ashgabat,18000000,4,-1,-1441166012,56,109,80,88,-15,-108,89,95,-40,127,14012,16,20,16,20,24,-1,-1441166012,56,109,80,83,-104,108,83,-35,8,84,33,76,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,127,14012,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,0,1,1,0,TMT,TMST,Turkmenistan Standard Time,Turkmenistan Summer Time,0,Asia/Ashkhabad,18000000,4,-1,-1441166012,56,109,80,88,-15,-108,89,95,-40,127,14012,16,20,16,20,24,-1,-1441166012,56,109,80,83,-104,108,83,-35,8,84,33,76,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,127,14012,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,0,1,1,0,TMT,TMST,Turkmenistan Standard Time,Turkmenistan Summer Time,0,Asia/Atyrau,18000000,8,-1,-1441164464,56,109,84,83,-35,12,84,33,72,88,-15,-108,89,95,-40,93,56,52,96,54,-72,127,12464,12,20,24,20,16,20,16,20,46,-1,-1441164464,56,109,84,83,-35,12,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,89,122,20,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-108,91,87,-44,91,-98,-76,91,-19,116,92,39,52,92,117,-12,92,-81,-76,92,-2,116,93,-119,-104,93,-64,-72,94,18,24,94,73,56,94,-102,-104,94,-44,88,95,35,24,95,92,-40,95,-85,-104,95,-27,88,127,12464,12,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,").append("20,24,20,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,16,20,16,20,16,20,16,20,0,1,1,0,GMT+05:00,GMT+05:00,West Kazakhstan Time,Atyrau Daylight Time,0,Asia/Baghdad,10800000,2,-1,-2524532260,-1,-1641005856,127,10660,127,10656,12,54,-1,-2524532260,-1,-1641005856,84,44,-108,84,101,-16,84,-87,-44,84,-18,-48,85,51,116,85,120,16,85,-68,84,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,87,-35,-8,88,34,56,88,102,120,88,-83,88,88,-14,0,89,54,-96,89,123,64,89,-65,-32,90,4,32,90,72,-64,90,-115,0,90,-47,-96,91,21,-32,91,90,-128,91,-97,32,91,-29,-64,92,40,0,92,108,-96,92,-80,-32,92,-11,-128,93,57,-64,93,126,96,93,-61,0,94,7,-96,94,75,-32,94,-112,-128,94,-44,-64,95,25,96,95,93,-96,95,-94,64,95,-26,-32,96,43,-128,96,111,-64,96,-76,96,96,-8,-96,97,61,64,97,-127,-128,97,-58,32,127,10660,127,10656,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Bahrain,10800000,2,-1,-1577935568,78,-34,-80,127,12368,16,12,2,-1,-1577935568,78,-34,-80,127,12368,16,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Baku,14400000,4,-1,-1441163964,70,-75,-108,88,-15,-104,89,-66,92,127,11964,12,16,12,16,64,-1,-1441163964,70,-75,-108,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,87,-35,-8,88,34,56,88,102,120,88,-83,88,89,53,-36,89,122,28,91,-98,-60,91,-19,-124,92,39,64,92,118,0,92,-81,-64,92,-2,-128,93,56,64,93,-119,-96,93,-64,-64,94,18,32,94,73,64,94,-102,-96,94,-44,96,95,35,32,95,92,-32,95,-85,-96,95,-27,96,96,54,-64,96,109,-32,96,-65,64,96,-10,96,97,71,-64,97,126,-32,97,-48,64,98,10,0,98,88,-64,98,-110,-128,98,-31,64,99,27,0,99,108,96,99,-93,-128,99,-12,-32,100,44,0,100,125,96,100,-73,32,101,5,-32,101,63,-96,101,-114,96,101,-56,32,102,22,-32,127,11964,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,0,1,1,0,AZT,AZST,Azerbaijan Standard Time,Azerbaijan Summer Time,0,Asia/Bangkok,25200000,1,-1,-1570084924,127,24124,28,1,-1,-1570084924,127,24124,28,0,1,1,0,ICT,ICST,Indochina Time,Indochina Summer Time,0,Asia/Barnaul,25200000,8,-1,-1579844100,56,109,72,88,-15,-116,89,95,-48,91,43,32,99,-93,112,101,-114,76,102,80,-112,127,20100,24,28,24,28,24,28,24,28,66,-1,-1579844100,56,109,72,83,-104,100,83,-35,0,84,33,68,84,101,-32,84,-86,36,84,-18,-64,85,51,100,85,119,-84,85,-69,-20,86,0,44,86,68,108,86,-120,-84,86,-52,-20,87,17,44,87,85,108,87,-103,-84,87,-35,-20,88,34,44,88,102,108,88,-83,76,89,53,-48,89,95,-48,89,122,12,89,-66,76,90,2,-116,90,70,-52,90,-117,12,90,-49,76,91,19,-116,91,43,32,91,87,-48,91,-98,-80,91,-19,112,92,39,48,92,117,-16,92,-81,-80,92,-2,112,93,56,48,93,-119,-112,93,-64,-80,94,18,16,94,73,48,94,-102,-112,94,-44,80,95,35,16,95,92,-48,95,-85,-112,95,-27,80,96,54,-80,96,109,-48,96,-65,48,96,-10,80,97,71,-80,97,126,-48,97,-48,48,98,9,-16,98,88,-80,98,-110,112,98,-31,48,99,26,-16,99,108,80,99,-93,112,101,-114,76,102,80,-112,127,20100,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,32,28,32,28,32,28,32,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,0,1,1,0,GMT+07:00,GMT+07:00,Barnaul Standard Time,Barnaul Daylight Time,0,Asia/Beirut,7200000,1,-1,-2840149320,127,8520,8,67,-1,-2840149320,50,-13,-8,51,67,20,51,127,24,51,-61,-76,52,4,-8,52,78,116,52,-105,-8,52,-49,20,70,-52,120,71,5,-44,71,85,88,71,-114,-76,71,-34,56,72,23,-108,72,103,120,72,-96,-44,72,-16,88,73,41,-76,78,-26,-104,79,12,116,79,91,-8,79,-107,84,79,-28,-40,80,30,52,80,109,-72,80,-89,20,80,-10,-8,81,48,84,81,127,-40,81,-71,52,82,8,88,82,65,-76,85,62,-72,85,125,-76,85,-57,-104,86,6,-108,86,80,120,86,-113,116,86,-39,88,87,24,84,87,110,56,87,-95,-108,87,-18,-40,88,42,116,88,116,88,88,-77,84,88,-3,56,89,60,52,89,-122,120,89,-64,-12,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-30,-12,92,39,56,92,107,116,92,-81,-72,92,-13,-12,93,56,56,93,-119,-108,93,-64,-72,94,18,20,127,8520,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048057986,-1367861112,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Bishkek,21600000,4,-1,-1441169904,56,109,76,88,-15,-112,96,-95,-120,127,17904,20,24,20,24,50,-1,-1441169904,56,109,76,83,-104,104,83,-35,4,84,33,72,84,101,-28,84,-86,40,84,-18,-60,85,51,104,85,119,-80,85,-69,-16,86,0,48,86,68,112,86,-120,-80,86,-52,-16,87,17,48,87,85,112,87,-103,-80,87,-35,-16,88,34,48,88,102,112,88,-83,80,89,42,-16,89,127,76,89,-66,72,90,7,-52,90,70,-56,90,-112,76,90,-49,72,91,24,-52,91,87,-56,91,-95,76,91,-30,-24,92,39,54,92,117,-14,92,-81,-74,92,-2,114,93,56,54,93,-119,-110,93,-64,-74,94,18,18,94,73,54,94,-102,-110,94,-44,86,95,35,18,95,92,-42,95,-85,-110,95,-27,86,96,54,-78,96,109,-42,127,17904,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,0,1,1,0,KGT,KGST,Kyrgyzstan Time,Kirgizstan Summer Time,0,Asia/Brunei,28800000,4,-1,-1383463280,57,-56,34,62,-86,0,64,-110,-4,127,26480,30,32,36,32,18,-1,-1383463280,57,-56,34,59,57,-32,-1,-1074586800,59,-61,32,-1,-1042964400,60,76,0,-1,-1011428400,60,-44,-32,-1,-979892400,61,93,-64,-1,-948356400,61,-25,0,-1,-916734000,62,111,-32,-1,-885198000,62,-86,0,64,-110,-4,127,26480,30,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,36,32,0,1,1,0,BNT,BNST,Brunei Darussalam Time,Brunei Summer Time,0,Asia/Calcutta,19800000,3,-1,-3645237208,-1,-3155694800,-1,-2019705670,127,21208,127,21200,127,19270,22,7,-1,-3645237208,-1,-3155694800,-1,-2019705670,62,118,74,62,-53,6,62,-13,-22,64,-97,102,127,21208,127,21200,127,19270,22,26,22,26,22,0,1,1,0,IST,IDT,India Standard Time,India Daylight Time,0,Asia/Chita,32400000,7,-1,-1579419232,56,109,64,88,-15,-124,89,95,-56,99,-93,100,101,-114,64,102,80,-120,127,27232,32,36,32,36,40,32,36,65,-1,-1579419232,56,109,64,83,-104,92,83,-36,-8,84,33,60,84,101,-40,84,-86,28,84,-18,-72,85,51,92,85,119,-92,85,-69,-28,86,0,36,86,68,100,86,-120,-92,86,-52,-28,87,17,36,87,85,100,87,-103,-92,87,-35,-28,88,34,36,88,102,100,88,-83,68,89,53,-56,89,95,-56,89,122,4,89,-66,68,90,2,-124,90,70,-60,90,-117,4,90,-49,68,91,19,-124,91,87,-60,91,-98,-92,91,-19,100,92,39,36,92,117,-28,92,-81,-92,92,-2,100,93,56,36,93,-119,-124,93,-64,-92,94,18,4,94,73,36,94,-102,-124,94,-44,68,95,35,4,95,92,-60,95,-85,-124,95,-27,68,96,54,-92,96,109,-60,96,-65,36,96,-10,68,97,71,-92,97,126,-60,97,-48,36,98,9,-28,98,88,-92,98,-110,100,98,-31,36,99,26,-28,99,108,68,99,-93,100,101,-114,64,102,80,-120,127,27232,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,32,36,0,1,1,0,YAKT,YAKST,Yakutsk Standard Time,Yakutsk Summer Time,0,Asia/Choibalsan,28800000,4,-1,-2032933080,81,-37,-92,84,-86,32,98,10,60,127,27480,28,32,36,32,51,-1,-2032933080,81,-37,-92,84,-86,32,84,-18,-72,85,51,92,85,119,-104,85,-69,-36,86,0,24,86,68,92,86,-120,-104,86,-52,-36,87,17,24,87,85,92,87,-103,-104,87,-35,-36,88,34,24,88,102,92,88,-83,56,88,-15,124,89,53,-72,89,121,-4,89,-66,56,90,2,124,90,70,-72,90,-118,-4,90,-49,56,91,19,124,91,87,-72,91,-98,-100,91,-30,-40,92,39,28,92,107,88,92,-81,-100,92,-13,-40,94,85,-28,94,-113,-96,94,-45,-28,95,24,32,95,92,100,95,-96,-96,95,-28,-28,96,41,32,96,109,100,96,-79,-96,96,-11,-28,97,60,-64,98,10,60,101,-57,-88,102,11,-36,102,80,40,102,-108,92,127,27480,28,32,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,32,36,32,36,32,0,1,1,0,CHOT,CHOST,Choibalsan Standard Time,Choibalsan Summer Time,0,Asia/Chongqing,28800000,1,-1,-2177481943,127,29143,32,29,-1,-2177481943,50,112,-96,50,-80,-68,61,-65,-96,61,-15,-36,62,43,64,62,-126,60,62,-92,0,64,-113,60,64,-18,-32,65,34,-4,65,108,-128,65,-73,124,65,-5,-64,66,53,28,66,-124,-96,66,-114,-68,86,81,-120,86,-125,100,86,-46,40,87,11,-28,87,93,72,87,-108,100,87,-27,-56,88,31,-124,88,110,72,88,-88,4,88,-10,-56,89,48,-124,127,29143,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Chungking,28800000,1,-1,-2177481943,127,29143,32,29,-1,-2177481943,50,112,-96,50,-80,-68,61,-65,-96,61,-15,-36,62,43,64,62,-126,60,62,-92,0,64,-113,60,64,-18,-32,65,34,-4,65,108,-128,65,-73,124,65,-5,-64,66,53,28,66,-124,-96,66,-114,-68,86,81,-120,86,-125,100,86,-46,40,87,11,-28,87,93,72,87,-108,100,87,-27,-56,88,31,-124,88,110,72,88,-88,4,88,-10,-56,89,48,-124,127,29143,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Colombo,19800000,5,-1,-2840159964,-1,-2019705572,91,-77,74,91,-19,8,96,-3,-54,127,19164,127,19172,22,26,24,22,8,-1,-2840159964,-1,-2019705572,62,-102,74,62,-13,-24,64,-97,-50,91,-77,74,91,-19,8,96,-3,-54,127,19164,127,19172,22,24,26,22,26,24,22,0,1,1,0,IST,IDT,India Standard Time,India Daylight Time,0,Asia/Dacca,21600000,5,-1,-2524543300,-1,-891582800,62,-53,6,62,-13,-22,67,-49,102,127,21700,127,21200,26,22,26,24,7,-1,-2524543300,-1,-891582800,62,-53,6,62,-13,-22,67,-49,102,98,-79,-124,98,-6,-92,127,21700,127,21200,26,22,26,24,28,24,0,1,1,0,BDT,BDST,Bangladesh Standard Time,Bangladesh Summer Time,0,Asia/Damascus,10800000,2,-1,-1577931912,105,-42,-44,127,8712,8,12,120,-1,-1577931912,50,-5,-32,51,58,-36,51,-124,96,51,-61,92,52,12,-32,52,75,-36,52,-107,96,52,-42,-4,73,120,-128,73,-78,-100,74,2,32,74,59,28,74,-117,96,74,-60,-68,75,20,64,75,77,60,75,-102,-128,75,-42,124,76,38,0,76,95,92,76,-81,64,76,-24,-100,77,56,32,77,113,124,77,-63,0,77,-6,92,78,73,-32,78,-125,60,78,-45,32,79,12,124,79,92,0,79,-107,92,79,-28,-32,80,30,60,80,109,-64,80,-89,28,80,-9,0,81,48,92,81,127,-32,81,-83,-4,82,8,-64,82,54,-36,84,-83,64,84,-18,-36,85,54,-128,85,120,28,86,52,-64,86,-116,-36,86,-62,-128,87,29,-4,87,81,0,87,-89,60,87,-33,-32,88,36,-36,88,105,32,88,-83,92,88,-15,-8,89,54,-108,89,125,-40,89,-65,-44,90,1,-40,90,70,116,90,-116,-8,90,-47,-108,91,21,-40,91,90,116,91,-97,24,91,-29,-76,92,39,-104,92,108,-108,92,-80,24,92,-11,116,93,57,-72,93,126,84,93,-62,-8,94,7,-108,94,75,-40,94,-112,116,94,-44,-72,95,25,84,95,93,-104,95,-94,52,95,-26,-40,96,43,116,96,111,-72,96,-76,84,96,-8,-104,97,57,-44,97,-128,-72,97,-46,20,98,11,-40,98,90,-12,98,-111,-72,98,-29,20,99,28,-40,99,107,-108,99,-91,88,99,-12,20,100,45,-40,100,124,-108,100,-74,88,101,5,20,101,62,-40,101,-112,52,101,-57,88,102,24,-76,102,79,-40,102,-95,52,102,-38,-8,103,41,-76,103,99,120,103,-78,52,103,-21,-8,104,58,-76,104,116,120,104,-59,-44,104,-4,-8,105,78,84,105,-123,120,127,8712,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,0,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Dhaka,21600000,5,-1,-2524543300,-1,-891582800,62,-53,6,62,-13,-22,67,-49,102,127,21700,127,21200,26,22,26,24,7,-1,-2524543300,-1,-891582800,62,-53,6,62,-13,-22,67,-49,102,98,-79,-124,98,-6,-92,127,21700,127,21200,26,22,26,24,28,24,0,1,1,0,BDT,BDST,Bangladesh Standard Time,Bangladesh Summer Time,0,Asia/Dili,32400000,4,-1,-1830414140,62,-84,60,80,-9,-100,94,2,64,127,30140,32,36,32,36,4,-1,-1830414140,62,-84,60,80,-9,-100,94,2,64,127,30140,32,36,32,36,0,1,1,0,TLT,TLST,East Timor Time,Timor-Leste Summer Time,0,Asia/Dubai,14400000,1,-1,-1577936472,127,13272,16,1,-1,-1577936472,127,13272,16,0,1,1,0,GST,GDT,Gulf Standard Time,Gulf Daylight Time,0,Asia/Dushanbe,18000000,3,-1,-1441168512,56,109,76,88,-15,-112,127,16512,20,24,20,23,-1,-1441168512,56,109,76,83,-104,104,83,-35,4,84,33,72,84,101,-28,84,-86,40,84,-18,-60,85,51,104,85,119,-80,85,-69,-16,86,0,48,86,68,112,86,-120,-80,86,-52,-16,87,17,48,87,85,112,87,-103,-80,87,-35,-16,88,34,48,88,102,112,88,-83,80,89,46,84,127,16512,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,20,0,1,1,0,TJT,TJST,Tajikistan Time,Tajikistan Summer Time,0,Asia/Famagusta,7200000,3,-1,-1518920148,102,-114,116,103,42,-124,127,8148,8,12,8,87,-1,-1518920148,80,102,-8,80,-85,52,80,-4,56,81,52,20,81,117,88,81,-74,-12,81,-3,-40,82,66,116,82,-122,88,82,-54,-108,83,17,120,83,83,20,83,-105,88,83,-37,-108,84,31,-40,84,100,20,84,-88,88,84,-20,-108,85,48,-40,85,119,-76,85,-69,-8,86,0,52,86,68,120,86,-120,-76,86,-52,-8,87,17,52,87,85,120,87,-103,-76,87,-35,-8,88,34,52,88,102,120,88,-83,84,88,-15,-104,89,53,-44,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-30,-12,92,39,56,92,107,116,92,-81,-72,92,-2,-124,93,56,68,93,-119,-92,93,-64,-60,94,18,36,94,73,68,94,-102,-92,94,-44,100,95,35,36,95,92,-28,95,-85,-92,95,-27,100,96,54,-60,96,109,-28,96,-65,68,96,-10,100,97,71,-60,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-124,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,63,-92,101,-114,100,101,-56,36,102,22,-28,102,80,-92,103,42,-124,103,97,-92,103,-77,4,127,8148,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Time,Eastern European Summer Time,0,Asia/Gaza,7200000,1,-1,-2185409872,127,8272,8,123,-1,-2185409872,61,-65,-64,61,-19,-128,61,-1,32,63,10,-32,63,67,-128,63,-109,-64,63,-52,-64,64,29,0,64,91,64,64,-91,-32,64,-28,32,65,46,-64,70,-49,-40,71,5,-44,71,85,88,71,-114,-76,71,-34,60,72,23,64,72,103,124,72,-96,-128,72,-16,92,73,41,96,73,121,60,73,-78,64,74,2,28,74,59,32,74,-117,92,74,-60,96,75,20,60,75,77,64,75,-99,28,75,-42,-128,76,37,-4,76,51,20,79,-3,-8,80,34,-76,80,105,-104,80,-101,116,83,62,24,83,77,-40,85,64,-104,85,106,-104,85,-63,56,85,-11,-76,86,86,-40,86,-128,-44,86,-45,88,87,11,-12,87,90,-72,87,-111,-44,87,-21,24,88,26,84,88,102,120,88,-96,52,88,-18,-8,89,43,84,89,122,24,89,-74,116,90,4,120,90,62,-12,90,-116,-8,90,-60,-44,91,21,120,91,79,-12,91,-96,-104,91,-33,-104,92,41,24,92,104,24,92,-79,-104,92,-16,-104,93,63,88,93,-125,-108,93,-54,120,94,14,-76,94,82,-8,94,-105,52,94,-37,120,95,31,-76,95,99,-8,95,-88,52,95,-20,120,96,43,120,96,116,-8,96,-75,124,96,-8,-104,97,57,-44,97,-127,120,97,-65,92,98,9,56,98,66,-12,98,-111,-72,98,-50,24,-1,1269640860,99,77,-12,-1,1301608860,99,-45,20,100,45,-40,100,111,120,100,-74,88,100,-6,-108,101,62,-40,101,-115,-108,101,-57,-72,102,22,24,102,80,60,102,-95,-104,102,-40,-68,103,42,24,103,97,60,103,-78,-104,103,-21,-8,104,59,20,104,116,-40,104,-61,-104,104,-3,88,105,78,88,105,-122,56,105,-41,60,106,14,96,106,95,-68,106,-103,-128,106,-24,60,127,8272,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1043372162,-1372546936,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Harbin,28800000,1,-1,-2177481943,127,29143,32,29,-1,-2177481943,50,112,-96,50,-80,-68,61,-65,-96,61,-15,-36,62,43,64,62,-126,60,62,-92,0,64,-113,60,64,-18,-32,65,34,-4,65,108,-128,65,-73,124,65,-5,-64,66,53,28,66,-124,-96,66,-114,-68,86,81,-120,86,-125,100,86,-46,40,87,11,-28,87,93,72,87,-108,100,87,-27,-56,88,31,-124,88,110,72,88,-88,4,88,-10,-56,89,48,-124,127,29143,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Hebron,7200000,1,-1,-2185410023,127,8423,8,125,-1,-2185410023,61,-65,-64,61,-19,-128,61,-1,32,63,10,-32,63,67,-128,63,-109,-64,63,-52,-64,64,29,0,64,91,64,64,-91,-32,64,-28,32,65,46,-64,70,-49,-4").append("0,71,5,-44,71,85,88,71,-114,-76,71,-34,60,72,23,64,72,103,124,72,-96,-128,72,-16,92,73,41,96,73,121,60,73,-78,64,74,2,28,74,59,32,74,-117,92,74,-60,96,75,20,60,75,77,64,75,-99,28,75,-42,-128,76,37,-4,76,51,20,79,-3,-8,80,34,-76,80,105,-104,80,-101,116,83,62,24,83,77,-40,85,64,-104,85,106,-104,85,-63,56,85,-11,-76,86,86,-40,86,-128,-44,86,-45,88,87,11,-12,87,90,-72,87,-111,-44,87,-21,24,88,26,84,88,102,120,88,-96,52,88,-18,-8,89,43,84,89,122,24,89,-74,116,90,4,120,90,62,-12,90,-116,-8,90,-60,-44,91,21,120,91,79,-12,91,-96,-104,91,-33,-104,92,41,24,92,104,24,92,-79,-104,92,-16,-104,93,63,88,93,-125,-108,93,-54,120,94,14,-76,94,82,-8,94,-105,52,94,-37,120,95,31,-76,95,99,-8,95,-88,52,95,-20,120,96,43,120,96,116,-8,96,-75,124,96,-8,-104,97,57,-44,97,-127,120,97,-65,92,98,9,56,98,68,20,98,-111,-72,98,-50,24,99,26,56,99,77,-12,-1,1301608860,99,-45,20,99,-35,-8,99,-23,-108,100,45,-40,100,111,120,100,-74,88,100,-6,-108,101,62,-40,101,-115,-108,101,-57,-72,102,22,24,102,80,60,102,-95,-104,102,-40,-68,103,42,24,103,97,60,103,-78,-104,103,-21,-8,104,59,20,104,116,-40,104,-61,-104,104,-3,88,105,78,88,105,-122,56,105,-41,60,106,14,96,106,95,-68,106,-103,-128,106,-24,60,127,8423,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1043372162,-1372546936,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Ho_Chi_Minh,25200000,8,-1,-1851577590,63,33,-96,64,79,28,64,-113,60,65,103,68,69,-47,32,72,58,0,80,125,-64,127,25590,28,32,36,28,32,28,32,28,8,-1,-1851577590,63,33,-96,64,79,28,64,-113,60,65,103,68,69,-47,32,72,58,0,80,125,-64,127,25590,28,32,36,28,32,28,32,28,0,1,1,0,ICT,ICST,Indochina Time,Indochina Summer Time,0,Asia/Hong_Kong,28800000,3,42,-75,100,62,-106,30,64,-84,36,127,27402,32,36,32,69,42,-75,100,62,77,-52,62,118,76,62,-106,30,64,-84,36,64,-27,-32,65,57,-18,65,107,-50,65,-62,110,65,-4,46,66,64,110,66,122,46,66,-56,-18,67,2,-82,67,81,110,67,-117,46,67,-39,-18,68,22,78,68,101,14,68,-98,-50,68,-19,-118,69,34,14,69,118,10,69,-86,-114,70,1,42,70,51,14,70,-119,-86,70,-66,46,71,18,42,71,70,-82,71,-102,-86,71,-49,46,72,35,42,72,87,-82,72,-82,74,72,-32,46,73,54,-54,73,104,-82,73,-65,74,73,-13,-50,74,71,-54,74,124,78,74,-48,74,75,15,78,75,83,-118,75,-105,-50,75,-36,10,76,32,78,76,103,42,76,-85,110,76,-17,-86,77,51,-18,77,120,42,77,-68,110,78,0,-86,78,68,-18,78,-119,42,78,-51,110,79,20,74,79,88,-114,79,-100,-54,79,-73,14,80,37,74,80,105,-114,80,-83,-54,80,-14,14,81,54,74,82,-106,14,82,-46,106,127,27402,32,36,34,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,HKT,HKST,Hong Kong Standard Time,Hong Kong Summer Time,0,Asia/Hovd,25200000,2,-1,-2032927596,81,-37,-88,127,21996,24,28,50,-1,-2032927596,81,-37,-88,84,-86,36,84,-18,-64,85,51,100,85,119,-96,85,-69,-28,86,0,32,86,68,100,86,-120,-96,86,-52,-28,87,17,32,87,85,100,87,-103,-96,87,-35,-28,88,34,32,88,102,100,88,-83,64,88,-15,-124,89,53,-64,89,122,4,89,-66,64,90,2,-124,90,70,-64,90,-117,4,90,-49,64,91,19,-124,91,87,-64,91,-98,-92,91,-30,-32,92,39,36,92,107,96,92,-81,-92,92,-13,-32,94,85,-20,94,-113,-88,94,-45,-20,95,24,40,95,92,108,95,-96,-88,95,-28,-20,96,41,40,96,109,108,96,-79,-88,96,-11,-20,97,60,-56,101,-57,-84,102,11,-32,102,80,44,102,-108,96,127,21996,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,0,1,1,0,HOVT,HOVST,Hovd Standard Time,Hovd Summer Time,0,Asia/Irkutsk,28800000,6,-1,-1575874625,56,109,68,88,-15,-120,89,95,-52,99,-93,104,101,-114,68,127,25025,28,32,28,32,36,32,64,-1,-1575874625,56,109,68,83,-104,96,83,-36,-4,84,33,64,84,101,-36,84,-86,32,84,-18,-68,85,51,96,85,119,-88,85,-69,-24,86,0,40,86,68,104,86,-120,-88,86,-52,-24,87,17,40,87,85,104,87,-103,-88,87,-35,-24,88,34,40,88,102,104,88,-83,72,89,53,-52,89,95,-52,89,122,8,89,-66,72,90,2,-120,90,70,-56,90,-117,8,90,-49,72,91,19,-120,91,87,-56,91,-98,-88,91,-19,104,92,39,40,92,117,-24,92,-81,-88,92,-2,104,93,56,40,93,-119,-120,93,-64,-88,94,18,8,94,73,40,94,-102,-120,94,-44,72,95,35,8,95,92,-56,95,-85,-120,95,-27,72,96,54,-88,96,109,-56,96,-65,40,96,-10,72,97,71,-88,97,126,-56,97,-48,40,98,9,-24,98,88,-88,98,-110,104,98,-31,40,99,26,-24,99,108,72,99,-93,104,101,-114,68,127,25025,28,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,28,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,IRKT,IRKST,Irkutsk Standard Time,Irkutsk Summer Time,0,Asia/Istanbul,10800000,5,-1,-2840147752,-1,-1869875816,82,30,-44,85,-125,-68,102,-114,20,127,6952,127,7016,8,12,8,12,113,-1,-2840147752,-1,-1869875816,48,-36,-40,49,22,52,50,-13,-8,51,67,20,51,127,24,51,-61,-76,52,4,-8,52,78,116,53,41,24,53,93,-12,53,-83,120,53,-26,-44,61,-54,-8,61,-17,84,62,4,88,62,114,-108,62,-70,-104,64,-100,-44,64,-11,88,65,35,20,65,110,120,65,-83,116,65,-10,-8,66,53,-12,66,124,-40,66,-66,116,67,7,-8,67,73,-108,67,-109,24,67,-46,20,73,-107,88,74,70,84,74,-112,-104,74,-60,-76,79,104,92,79,-94,28,79,-39,64,80,42,-100,80,94,-64,80,-77,28,80,-25,-96,81,59,-100,81,117,96,81,-66,-36,81,-3,-32,84,-41,-100,84,-17,56,85,-125,-68,85,-61,124,85,-1,-36,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,53,-36,89,122,28,89,-66,92,90,2,-100,90,70,-36,90,-120,124,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-28,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,64,4,101,-114,100,101,-56,36,102,28,36,102,80,-92,127,6952,127,7016,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,0,1,1,0,TRT,TRST,Turkey Time,Turkey Summer Time,0,Asia/Jakarta,25200000,7,-1,-1451719200,-1,-1172906400,62,-73,34,64,-105,28,65,-5,-62,67,13,-128,74,93,-30,127,25632,127,26400,30,36,30,32,30,28,7,-1,-1451719200,-1,-1172906400,62,-73,34,64,-105,28,65,-5,-62,67,13,-128,74,93,-30,127,25632,127,26400,30,36,30,32,30,28,0,1,1,0,WIB,WIST,Western Indonesia Time,West Indonesia Summer Time,0,Asia/Jayapura,32400000,3,-1,-1172913768,64,5,-4,74,93,-38,127,33768,36,38,36,3,-1,-1172913768,64,5,-4,74,93,-38,127,33768,36,38,36,0,1,1,0,WIT,EIST,Eastern Indonesia Time,East Indonesia Summer Time,0,Asia/Jerusalem,7200000,2,-1,-2840149254,-1,-1641003640,127,8454,127,8440,8,103,-1,-2840149254,-1,-1641003640,61,-65,-64,61,-19,-128,61,-1,32,63,10,-32,63,67,-128,63,-109,-64,63,-52,-64,64,29,0,64,91,64,64,-91,-32,64,-28,32,65,46,-64,66,4,32,66,42,0,66,64,-32,66,-124,-64,66,-55,-64,67,8,0,67,65,0,67,-117,64,67,-33,64,68,27,-96,68,95,-32,68,-95,-128,68,-37,64,69,65,-96,69,99,-64,69,-54,32,69,-20,64,70,80,0,70,124,-96,70,-53,96,71,2,-128,79,-3,-8,80,34,-76,80,105,-104,80,-101,116,83,62,24,83,77,-40,85,64,-104,85,106,-104,85,-63,56,85,-11,-76,86,86,-40,86,-128,-44,86,-45,88,87,11,-12,87,90,-72,87,-111,-44,87,-21,24,88,26,84,88,102,120,88,-96,52,88,-18,-8,89,43,84,89,122,24,89,-74,116,90,4,120,90,62,-12,90,-116,-8,90,-60,-44,91,21,120,91,79,-12,91,-104,-72,91,-34,20,92,35,-40,92,102,52,92,-84,88,92,-20,20,93,58,32,93,115,-36,93,-57,-32,94,9,120,94,78,-36,94,-115,-40,94,-45,-100,95,27,-104,95,92,28,95,-94,-8,95,-23,28,96,40,24,96,111,-64,96,-73,92,96,-8,64,97,61,60,97,-128,-64,97,-64,124,98,9,64,98,80,-36,98,-111,-64,98,-42,-68,99,26,64,99,89,-4,99,-91,96,99,-22,92,100,45,-32,100,112,60,100,-74,96,101,5,-36,101,62,-32,101,-114,92,127,8454,127,8440,8,12,8,12,8,12,8,12,8,12,8,12,8,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1038653570,-1367828344,1,1,0,IST,IDT,Israel Standard Time,Israel Daylight Time,0,Asia/Kabul,16200000,2,-1,-2524538208,64,51,-48,127,16608,16,18,2,-1,-2524538208,64,51,-48,127,16608,16,18,0,1,1,0,AFT,AFST,Afghanistan Time,Afghanistan Summer Time,0,Asia/Kamchatka,43200000,6,-1,-1487759676,56,109,52,88,-15,120,89,95,-68,99,26,-40,99,-93,92,127,38076,44,48,44,48,44,48,62,-1,-1487759676,56,109,52,83,-104,80,83,-36,-20,84,33,48,84,101,-52,84,-86,16,84,-18,-84,85,51,80,85,119,-104,85,-69,-40,86,0,24,86,68,88,86,-120,-104,86,-52,-40,87,17,24,87,85,88,87,-103,-104,87,-35,-40,88,34,24,88,102,88,88,-83,56,89,53,-68,89,95,-68,89,121,-8,89,-66,56,90,2,120,90,70,-72,90,-118,-8,90,-49,56,91,19,120,91,87,-72,91,-98,-104,91,-19,88,92,39,24,92,117,-40,92,-81,-104,92,-2,88,93,56,24,93,-119,120,93,-64,-104,94,17,-8,94,73,24,94,-102,120,94,-44,56,95,34,-8,95,92,-72,95,-85,120,95,-27,56,96,54,-104,96,109,-72,96,-65,24,96,-10,56,97,71,-104,97,126,-72,97,-48,24,98,9,-40,98,88,-104,98,-110,88,98,-31,24,99,108,60,99,-93,92,127,38076,44,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,44,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,52,48,44,48,0,1,1,0,PETT,PETST,Petropavlovsk-Kamchatski Standard Time,Petropavlovsk-Kamchatski Summer Time,0,Asia/Karachi,18000000,2,-1,-1988166492,67,-49,106,127,16092,22,20,10,-1,-1988166492,62,-13,-22,64,-97,102,67,-49,106,94,-42,-20,95,27,40,98,33,-116,98,90,-24,98,-104,-52,98,-29,-56,127,16092,22,26,22,20,24,20,24,20,24,20,0,1,1,0,PKT,PKST,Pakistan Standard Time,Pakistan Summer Time,0,Asia/Kashgar,21600000,1,-1,-1325483420,127,21020,24,1,-1,-1325483420,127,21020,24,0,1,1,0,XJT,XJDT,Xinjiang Standard Time,Xinjiang Daylight Time,0,Asia/Kathmandu,20700000,2,-1,-1577943676,86,35,106,127,20476,22,23,2,-1,-1577943676,86,35,106,127,20476,22,23,0,1,1,0,NPT,NPST,Nepal Time,Nepal Summer Time,0,Asia/Katmandu,20700000,2,-1,-1577943676,86,35,106,127,20476,22,23,2,-1,-1577943676,86,35,106,127,20476,22,23,0,1,1,0,NPT,NPST,Nepal Time,Nepal Summer Time,0,Asia/Khandyga,32400000,8,-1,-1579424533,56,109,64,88,-15,-124,89,95,-56,95,-60,-100,99,-93,96,99,-29,20,101,-114,64,127,32533,32,36,32,36,40,44,40,36,66,-1,-1579424533,56,109,64,83,-104,92,83,-36,-8,84,33,60,84,101,-40,84,-86,28,84,-18,-72,85,51,92,85,119,-92,85,-69,-28,86,0,36,86,68,100,86,-120,-92,86,-52,-28,87,17,36,87,85,100,87,-103,-92,87,-35,-28,88,34,36,88,102,100,88,-83,68,89,53,-56,89,95,-56,89,122,4,89,-66,68,90,2,-124,90,70,-60,90,-117,4,90,-49,68,91,19,-124,91,87,-60,91,-98,-92,91,-19,100,92,39,36,92,117,-28,92,-81,-92,92,-2,100,93,56,36,93,-119,-124,93,-64,-92,94,18,4,94,73,36,94,-102,-124,94,-44,68,95,35,4,95,92,-60,95,-85,-124,95,-60,-100,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-10,64,97,71,-96,97,126,-64,97,-48,32,98,9,-32,98,88,-96,98,-110,96,98,-31,32,99,26,-32,99,108,64,99,-93,96,99,-29,20,101,-114,64,127,32533,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,36,0,1,1,0,YAKT,YAKST,Yakutsk Standard Time,Yakutsk Summer Time,0,Asia/Kolkata,19800000,3,-1,-3645237208,-1,-3155694800,-1,-2019705670,127,21208,127,21200,127,19270,22,7,-1,-3645237208,-1,-3155694800,-1,-2019705670,62,118,74,62,-53,6,62,-13,-22,64,-97,102,127,21208,127,21200,127,19270,22,26,22,26,22,0,1,1,0,IST,IDT,India Standard Time,India Daylight Time,0,Asia/Krasnoyarsk,25200000,6,-1,-1577513486,56,109,72,88,-15,-116,89,95,-48,99,-93,108,101,-114,72,127,22286,24,28,24,28,32,28,64,-1,-1577513486,56,109,72,83,-104,100,83,-35,0,84,33,68,84,101,-32,84,-86,36,84,-18,-64,85,51,100,85,119,-84,85,-69,-20,86,0,44,86,68,108,86,-120,-84,86,-52,-20,87,17,44,87,85,108,87,-103,-84,87,-35,-20,88,34,44,88,102,108,88,-83,76,89,53,-48,89,95,-48,89,122,12,89,-66,76,90,2,-116,90,70,-52,90,-117,12,90,-49,76,91,19,-116,91,87,-52,91,-98,-84,91,-19,108,92,39,44,92,117,-20,92,-81,-84,92,-2,108,93,56,44,93,-119,-116,93,-64,-84,94,18,12,94,73,44,94,-102,-116,94,-44,76,95,35,12,95,92,-52,95,-85,-116,95,-27,76,96,54,-84,96,109,-52,96,-65,44,96,-10,76,97,71,-84,97,126,-52,97,-48,44,98,9,-20,98,88,-84,98,-110,108,98,-31,44,99,26,-20,99,108,76,99,-93,108,101,-114,72,127,22286,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,0,1,1,0,KRAT,KRAST,Krasnoyarsk Standard Time,Krasnoyarsk Summer Time,0,Asia/Kuala_Lumpur,28800000,6,-1,-2038200925,-1,-1073028000,-1,-894180000,62,-86,2,64,-110,-4,83,-1,-128,127,24925,28,127,26400,30,36,30,32,6,-1,-2038200925,57,-56,36,-1,-894180000,62,-86,2,64,-110,-4,83,-1,-128,127,24925,28,127,26400,30,36,30,32,0,1,1,0,MYT,MYST,Malaysia Time,Malaysia Summer Time,0,Asia/Kuching,28800000,4,-1,-1383463280,57,-56,34,62,-86,0,64,-110,-4,127,26480,30,32,36,32,18,-1,-1383463280,57,-56,34,59,57,-32,-1,-1074586800,59,-61,32,-1,-1042964400,60,76,0,-1,-1011428400,60,-44,-32,-1,-979892400,61,93,-64,-1,-948356400,61,-25,0,-1,-916734000,62,111,-32,-1,-885198000,62,-86,0,64,-110,-4,127,26480,30,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,127,30000,32,36,32,0,1,1,0,MYT,MYST,Malaysia Time,Malaysia Summer Time,0,Asia/Kuwait,10800000,1,-1,-719636812,127,11212,12,1,-1,-719636812,127,11212,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Macao,28800000,3,-1,-2056692850,62,-108,-4,64,-102,28,127,27250,32,36,32,71,-1,-2056692850,62,-108,-4,62,-59,-72,63,17,20,63,78,-104,63,-121,-12,64,-102,28,64,-23,-100,65,34,-4,65,110,92,65,-62,-68,65,-4,124,66,64,-68,66,122,28,66,-56,-36,67,2,-100,67,81,92,67,-117,28,67,-38,60,68,22,60,68,100,-4,68,-98,-68,68,-19,124,69,33,-4,69,117,-4,69,-86,124,70,1,28,70,50,-4,70,-119,-86,70,-66,46,71,18,42,71,70,-82,71,-102,-86,71,-49,46,72,35,42,72,87,-82,72,-82,74,72,-32,46,73,54,-54,73,104,-82,73,-65,74,73,-13,-50,74,71,-54,74,124,78,74,-48,74,75,15,78,75,83,-122,75,-105,-50,75,-36,6,76,32,78,76,103,42,76,-85,110,76,-17,-86,77,51,-18,77,120,42,77,-68,110,78,0,-86,78,68,-18,78,-119,42,78,-51,110,79,20,74,79,88,-114,79,-100,-54,79,-73,14,80,37,74,80,105,-114,80,-83,-54,80,-14,14,81,54,74,82,-106,14,82,-46,106,127,27250,32,36,40,36,40,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Macau,28800000,3,-1,-2056692850,62,-108,-4,64,-102,28,127,27250,32,36,32,71,-1,-2056692850,62,-108,-4,62,-59,-72,63,17,20,63,78,-104,63,-121,-12,64,-102,28,64,-23,-100,65,34,-4,65,110,92,65,-62,-68,65,-4,124,66,64,-68,66,122,28,66,-56,-36,67,2,-100,67,81,92,67,-117,28,67,-38,60,68,22,60,68,100,-4,68,-98,-68,68,-19,124,69,33,-4,69,117,-4,69,-86,124,70,1,28,70,50,-4,70,-119,-86,70,-66,46,71,18,42,71,70,-82,71,-102,-86,71,-49,46,72,35,42,72,87,-82,72,-82,74,72,-32,46,73,54,-54,73,104,-82,73,-65,74,73,-13,-50,74,71,-54,74,124,78,74,-48,74,75,15,78,75,83,-122,75,-105,-50,75,-36,6,76,32,78,76,103,42,76,-85,110,76,-17,-86,77,51,-18,77,120,42,77,-68,110,78,0,-86,78,68,-18,78,-119,42,78,-51,110,79,20,74,79,88,-114,79,-100,-54,79,-73,14,80,37,74,80,105,-114,80,-83,-54,80,-14,14,81,54,74,82,-106,14,82,-46,106,127,27250,32,36,40,36,40,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Magadan,39600000,7,-1,-1441188192,56,109,56,88,-15,124,89,95,-64,99,-93,92,101,-114,56,102,91,0,127,36192,40,44,40,44,48,40,44,65,-1,-1441188192,56,109,56,83,-104,84,83,-36,-16,84,33,52,84,101,-48,84,-86,20,84,-18,-80,85,51,84,85,119,-100,85,-69,-36,86,0,28,86,68,92,86,-120,-100,86,-52,-36").append(",87,17,28,87,85,92,87,-103,-100,87,-35,-36,88,34,28,88,102,92,88,-83,60,89,53,-64,89,95,-64,89,121,-4,89,-66,60,90,2,124,90,70,-68,90,-118,-4,90,-49,60,91,19,124,91,87,-68,91,-98,-100,91,-19,92,92,39,28,92,117,-36,92,-81,-100,92,-2,92,93,56,28,93,-119,124,93,-64,-100,94,17,-4,94,73,28,94,-102,124,94,-44,60,95,34,-4,95,92,-68,95,-85,124,95,-27,60,96,54,-100,96,109,-68,96,-65,28,96,-10,60,97,71,-100,97,126,-68,97,-48,28,98,9,-36,98,88,-100,98,-110,92,98,-31,28,99,26,-36,99,108,60,99,-93,92,101,-114,56,102,91,0,127,36192,40,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,40,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,40,44,0,1,1,0,MAGT,MAGST,Magadan Standard Time,Magadan Summer Time,0,Asia/Makassar,28800000,3,-1,-1172908656,62,-89,96,64,-105,28,127,28656,32,36,32,3,-1,-1172908656,62,-89,96,64,-105,28,127,28656,32,36,32,0,1,1,0,WITA,CIST,Central Indonesia Time,Central Indonesia Summer Time,0,Asia/Manila,28800000,4,-1,-3944621040,-1,-2229321840,62,-59,-64,64,28,-36,127,-57360,127,29040,32,36,32,10,-1,-3944621040,-1,-2229321840,59,-43,32,59,-9,-100,62,-59,-64,64,28,-36,69,42,64,69,72,60,81,-7,-96,82,62,60,127,-57360,127,29040,32,36,32,36,32,36,32,36,32,0,1,1,0,PST,PDT,Philippine Standard Time,Philippine Summer Time,0,Asia/Muscat,14400000,1,-1,-1577936472,127,13272,16,1,-1,-1577936472,127,13272,16,0,1,1,0,GST,GDT,Gulf Standard Time,Gulf Daylight Time,0,Asia/Nicosia,7200000,1,-1,-1518920008,127,8008,8,51,-1,-1518920008,80,102,-8,80,-85,52,80,-4,56,81,52,20,81,117,88,81,-74,-12,81,-3,-40,82,66,116,82,-122,88,82,-54,-108,83,17,120,83,83,20,83,-105,88,83,-37,-108,84,31,-40,84,100,20,84,-88,88,84,-20,-108,85,48,-40,85,119,-76,85,-69,-8,86,0,52,86,68,120,86,-120,-76,86,-52,-8,87,17,52,87,85,120,87,-103,-76,87,-35,-8,88,34,52,88,102,120,88,-83,84,88,-15,-104,89,53,-44,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-30,-12,92,39,56,92,107,116,92,-81,-72,92,-2,-124,93,56,68,93,-119,-92,127,8008,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Asia/Novokuznetsk,25200000,6,-1,-1441259328,56,109,72,88,-15,-116,89,95,-48,99,26,-20,99,-93,112,127,20928,24,28,24,28,24,28,62,-1,-1441259328,56,109,72,83,-104,100,83,-35,0,84,33,68,84,101,-32,84,-86,36,84,-18,-64,85,51,100,85,119,-84,85,-69,-20,86,0,44,86,68,108,86,-120,-84,86,-52,-20,87,17,44,87,85,108,87,-103,-84,87,-35,-20,88,34,44,88,102,108,88,-83,76,89,53,-48,89,95,-48,89,122,12,89,-66,76,90,2,-116,90,70,-52,90,-117,12,90,-49,76,91,19,-116,91,87,-52,91,-98,-84,91,-19,108,92,39,44,92,117,-20,92,-81,-84,92,-2,108,93,56,44,93,-119,-116,93,-64,-84,94,18,12,94,73,44,94,-102,-116,94,-44,76,95,35,12,95,92,-52,95,-85,-116,95,-27,76,96,54,-84,96,109,-52,96,-65,44,96,-10,76,97,71,-84,97,126,-52,97,-48,44,98,9,-20,98,88,-84,98,-110,108,98,-31,44,99,108,80,99,-93,112,127,20928,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,0,1,1,0,KRAT,KRAST,Krasnoyarsk Standard Time,Krasnoyarsk Summer Time,0,Asia/Novosibirsk,25200000,8,-1,-1579476700,56,109,72,88,-15,-116,89,95,-48,90,23,-128,99,-93,112,101,-114,76,102,125,48,127,19900,24,28,24,28,24,28,24,28,66,-1,-1579476700,56,109,72,83,-104,100,83,-35,0,84,33,68,84,101,-32,84,-86,36,84,-18,-64,85,51,100,85,119,-84,85,-69,-20,86,0,44,86,68,108,86,-120,-84,86,-52,-20,87,17,44,87,85,108,87,-103,-84,87,-35,-20,88,34,44,88,102,108,88,-83,76,89,53,-48,89,95,-48,89,122,12,89,-66,76,90,2,-116,90,23,-128,90,70,-48,90,-117,16,90,-49,80,91,19,-112,91,87,-48,91,-98,-80,91,-19,112,92,39,48,92,117,-16,92,-81,-80,92,-2,112,93,56,48,93,-119,-112,93,-64,-80,94,18,16,94,73,48,94,-102,-112,94,-44,80,95,35,16,95,92,-48,95,-85,-112,95,-27,80,96,54,-80,96,109,-48,96,-65,48,96,-10,80,97,71,-80,97,126,-48,97,-48,48,98,9,-16,98,88,-80,98,-110,112,98,-31,48,99,26,-16,99,108,80,99,-93,112,101,-114,76,102,125,48,127,19900,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,32,28,32,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,0,1,1,0,NOVT,NOVST,Novosibirsk Standard Time,Novosibirsk Summer Time,0,Asia/Omsk,21600000,6,-1,-1582088010,56,109,76,88,-15,-112,89,95,-44,99,-93,112,101,-114,76,127,17610,20,24,20,24,28,24,64,-1,-1582088010,56,109,76,83,-104,104,83,-35,4,84,33,72,84,101,-28,84,-86,40,84,-18,-60,85,51,104,85,119,-80,85,-69,-16,86,0,48,86,68,112,86,-120,-80,86,-52,-16,87,17,48,87,85,112,87,-103,-80,87,-35,-16,88,34,48,88,102,112,88,-83,80,89,53,-44,89,95,-44,89,122,16,89,-66,80,90,2,-112,90,70,-48,90,-117,16,90,-49,80,91,19,-112,91,87,-48,91,-98,-80,91,-19,112,92,39,48,92,117,-16,92,-81,-80,92,-2,112,93,56,48,93,-119,-112,93,-64,-80,94,18,16,94,73,48,94,-102,-112,94,-44,80,95,35,16,95,92,-48,95,-85,-112,95,-27,80,96,54,-80,96,109,-48,96,-65,48,96,-10,80,97,71,-80,97,126,-48,97,-48,48,98,9,-16,98,88,-80,98,-110,112,98,-31,48,99,26,-16,99,108,80,99,-93,112,101,-114,76,127,17610,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,0,1,1,0,OMST,OMSST,Omsk Standard Time,Omsk Summer Time,0,Asia/Oral,18000000,8,-1,-1441164324,56,109,84,83,-35,8,84,33,72,87,-35,-12,89,95,-40,89,122,20,96,54,-72,127,12324,12,20,24,20,16,20,16,20,46,-1,-1441164324,56,109,84,83,-104,108,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,88,34,56,88,102,120,88,-83,88,88,-15,-104,89,53,-40,89,95,-40,89,-66,88,90,2,-104,90,70,-40,90,-117,24,90,-49,88,91,19,-104,91,87,-40,91,-98,-72,91,-19,120,92,39,56,92,117,-8,92,-81,-72,92,-2,120,93,56,56,93,-119,-104,93,-64,-72,94,18,24,94,73,56,94,-102,-104,94,-44,88,95,35,24,95,92,-40,95,-85,-104,95,-27,88,127,12324,12,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,0,1,1,0,ORAT,ORAST,West Kazakhstan Time,Oral Summer Time,0,Asia/Phnom_Penh,25200000,1,-1,-1570084924,127,24124,28,1,-1,-1570084924,127,24124,28,0,1,1,0,ICT,ICST,Indochina Time,Indochina Summer Time,0,Asia/Pontianak,25200000,7,-1,-1172906240,62,-93,66,64,-105,28,65,-5,-62,67,13,-128,74,93,-30,87,53,32,127,26240,30,36,30,32,30,32,28,7,-1,-1172906240,62,-93,66,64,-105,28,65,-5,-62,67,13,-128,74,93,-30,87,53,32,127,26240,30,36,30,32,30,32,28,0,1,1,0,WIB,WIST,Western Indonesia Time,West Indonesia Summer Time,0,Asia/Pyongyang,32400000,4,-1,-1948782180,46,-117,126,101,-4,28,103,112,-36,127,30180,34,36,34,36,4,-1,-1948782180,46,-117,126,101,-4,28,103,112,-36,127,30180,34,36,34,36,0,1,1,0,KST,KDT,Pyongyang Time,Korea Daylight Time,0,Asia/Qatar,10800000,2,-1,-1577935568,78,-34,-80,127,12368,16,12,2,-1,-1577935568,78,-34,-80,127,12368,16,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Qostanay,21600000,7,-1,-1441167268,56,109,80,83,-35,8,84,33,72,88,-15,-108,89,95,-40,96,54,-76,127,15268,16,20,24,20,16,20,24,47,-1,-1441167268,56,109,80,83,-104,108,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,89,122,20,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-108,91,87,-44,91,-98,-76,91,-19,116,92,39,52,92,117,-12,92,-81,-76,92,-2,116,93,56,52,93,-119,-108,93,-64,-76,94,18,20,94,73,52,94,-102,-108,94,-44,84,95,35,20,95,92,-44,95,-85,-108,95,-27,84,127,15268,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,0,1,1,0,QOST,QOSST,Kostanay Standard Time,Kostanay Summer Time,0,Asia/Qyzylorda,18000000,10,-1,-1441167712,56,109,80,83,-35,8,84,33,72,88,-15,-108,89,53,-40,89,95,-44,89,122,16,96,54,-76,103,-57,40,127,15712,16,20,24,20,16,20,24,20,24,20,46,-1,-1441167712,56,109,80,83,-104,108,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,95,-44,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-108,91,87,-44,91,-98,-76,91,-19,116,92,39,52,92,117,-12,92,-81,-76,92,-2,116,93,56,52,93,-119,-108,93,-64,-76,94,18,20,94,73,52,94,-102,-108,94,-44,84,95,35,20,95,92,-44,95,-85,-108,95,-27,84,103,-57,40,127,15712,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,0,1,1,0,QYZT,QYZST,East Kazakhstan Time,Qyzylorda Summer Time,0,Asia/Rangoon,23400000,3,-1,-1577946287,62,-59,-58,64,97,124,127,23087,26,36,26,3,-1,-1577946287,62,-59,-58,64,97,124,127,23087,26,36,26,0,1,1,0,MMT,MMST,Myanmar Time,Myanmar Summer Time,0,Asia/Riyadh,10800000,1,-1,-719636812,127,11212,12,1,-1,-719636812,127,11212,12,0,1,1,0,AST,ADT,Arabia Standard Time,Arabia Daylight Time,0,Asia/Saigon,25200000,8,-1,-1851577590,63,33,-96,64,79,28,64,-113,60,65,103,68,69,-47,32,72,58,0,80,125,-64,127,25590,28,32,36,28,32,28,32,28,8,-1,-1851577590,63,33,-96,64,79,28,64,-113,60,65,103,68,69,-47,32,72,58,0,80,125,-64,127,25590,28,32,36,28,32,28,32,28,0,1,1,0,ICT,ICST,Indochina Time,Indochina Summer Time,0,Asia/Sakhalin,39600000,8,-1,-2031039048,64,-116,60,88,-15,124,89,95,-64,92,39,28,99,-93,96,101,-114,60,102,80,-128,127,34248,36,44,40,44,40,44,40,44,64,-1,-2031039048,64,-116,60,83,-104,84,83,-36,-16,84,33,52,84,101,-48,84,-86,20,84,-18,-80,85,51,84,85,119,-100,85,-69,-36,86,0,28,86,68,92,86,-120,-100,86,-52,-36,87,17,28,87,85,92,87,-103,-100,87,-35,-36,88,34,28,88,102,92,88,-83,60,89,53,-64,89,95,-64,89,121,-4,89,-66,60,90,2,124,90,70,-68,90,-118,-4,90,-49,60,91,19,124,91,87,-68,91,-98,-100,91,-19,92,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,94,18,0,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-10,64,97,71,-96,97,126,-64,97,-48,32,98,9,-32,98,88,-96,98,-110,96,98,-31,32,99,26,-32,99,108,64,99,-93,96,101,-114,60,102,80,-128,127,34248,36,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,40,44,48,44,48,44,48,44,48,44,48,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,0,1,1,0,SAKT,SAKST,Sakhalin Standard Time,Sakhalin Summer Time,0,Asia/Samarkand,18000000,4,-1,-1441168073,56,109,80,83,-35,8,84,33,72,127,16073,16,20,24,20,22,-1,-1441168073,56,109,80,83,-104,108,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,88,-15,-108,89,53,-44,127,16073,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,0,1,1,0,UZT,UZST,Uzbekistan Standard Time,Uzbekistan Summer Time,0,Asia/Seoul,32400000,4,-1,-1948782472,46,-117,126,69,33,-4,73,22,30,127,30472,34,36,34,36,28,-1,-1948782472,46,-117,126,66,7,92,66,46,88,66,122,28,66,-74,120,67,2,60,67,62,-8,67,-104,60,67,-57,120,69,33,-4,69,-69,-66,69,-21,90,70,74,-98,70,124,122,70,-51,-34,71,2,90,71,86,94,71,-118,-38,71,-34,-34,72,19,90,72,103,94,72,-101,-38,73,22,30,86,-36,-92,87,22,100,87,101,36,87,-98,-28,127,30472,34,36,40,36,40,36,40,36,40,36,34,38,34,38,34,38,34,38,34,38,34,38,34,36,40,36,40,36,0,1,1,0,KST,KDT,Korean Standard Time,Korean Summer Time,0,Asia/Shanghai,28800000,1,-1,-2177481943,127,29143,32,29,-1,-2177481943,50,112,-96,50,-80,-68,61,-65,-96,61,-15,-36,62,43,64,62,-126,60,62,-92,0,64,-113,60,64,-18,-32,65,34,-4,65,108,-128,65,-73,124,65,-5,-64,66,53,28,66,-124,-96,66,-114,-68,86,81,-120,86,-125,100,86,-46,40,87,11,-28,87,93,72,87,-108,100,87,-27,-56,88,31,-124,88,110,72,88,-88,4,88,-10,-56,89,48,-124,127,29143,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,China Standard Time,China Summer Time,0,Asia/Singapore,28800000,6,-1,-2038200925,-1,-1073028000,-1,-894180000,62,-86,2,64,-110,-4,83,-1,-128,127,24925,28,127,26400,30,36,30,32,6,-1,-2038200925,57,-56,36,-1,-894180000,62,-86,2,64,-110,-4,83,-1,-128,127,24925,28,127,26400,30,36,30,32,0,1,1,0,SGT,SGST,Singapore Standard Time,Singapore Summer Time,0,Asia/Srednekolymsk,39600000,6,-1,-1441188892,56,109,56,88,-15,124,89,95,-64,99,-93,92,101,-114,56,127,36892,40,44,40,44,48,44,64,-1,-1441188892,56,109,56,83,-104,84,83,-36,-16,84,33,52,84,101,-48,84,-86,20,84,-18,-80,85,51,84,85,119,-100,85,-69,-36,86,0,28,86,68,92,86,-120,-100,86,-52,-36,87,17,28,87,85,92,87,-103,-100,87,-35,-36,88,34,28,88,102,92,88,-83,60,89,53,-64,89,95,-64,89,121,-4,89,-66,60,90,2,124,90,70,-68,90,-118,-4,90,-49,60,91,19,124,91,87,-68,91,-98,-100,91,-19,92,92,39,28,92,117,-36,92,-81,-100,92,-2,92,93,56,28,93,-119,124,93,-64,-100,94,17,-4,94,73,28,94,-102,124,94,-44,60,95,34,-4,95,92,-68,95,-85,124,95,-27,60,96,54,-100,96,109,-68,96,-65,28,96,-10,60,97,71,-100,97,126,-68,97,-48,28,98,9,-36,98,88,-100,98,-110,92,98,-31,28,99,26,-36,99,108,60,99,-93,92,101,-114,56,127,36892,40,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,40,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,0,1,1,0,SRET,SREDT,Srednekolymsk Time,Srednekolymsk Daylight Time,0,Asia/Taipei,28800000,3,-1,-2335248360,60,82,96,64,-106,96,127,29160,32,36,32,41,-1,-2335248360,60,82,96,64,-106,96,64,-18,-32,65,34,-4,65,108,-128,65,-73,124,65,-5,-64,66,53,28,66,-124,-96,66,-67,-4,67,13,-128,67,70,-36,67,-106,96,67,-49,-68,68,8,-64,68,100,-100,68,-99,64,68,-19,124,69,38,32,69,118,92,69,-81,0,69,-13,-100,70,56,64,70,124,-36,70,-63,32,71,5,-68,71,74,0,71,-114,-100,71,-46,-32,72,23,124,72,115,0,72,-96,-68,72,-5,-32,73,41,-100,79,-39,-128,80,30,28,80,98,96,80,-90,-4,82,-88,96,82,-54,-36,127,29160,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,CST,CDT,Taipei Standard Time,Taipei Summer Time,0,Asia/Tashkent,18000000,3,-1,-1441168631,56,109,76,88,-15,-112,127,16631,20,24,20,23,-1,-1441168631,56,109,76,83,-104,104,83,-35,4,84,33,72,84,101,-28,84,-86,40,84,-18,-60,85,51,104,85,119,-80,85,-69,-16,86,0,48,86,68,112,86,-120,-80,86,-52,-16,87,17,48,87,85,112,87,-103,-80,87,-35,-16,88,34,48,88,102,112,88,-83,80,89,53,-44,127,16631,20,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,20,0,1,1,0,UZT,UZST,Uzbekistan Standard Time,Uzbekistan Summer Time,0,Asia/Tbilisi,14400000,6,-1,-1441162751,70,-75,-108,88,-15,-104,90,-49,80,96,7,108,96,109,-36,127,10751,12,16,12,16,12,16,48,-1,-1441162751,70,-75,-108,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,87,-35,-8,88,34,56,88,102,120,88,-83,88,89,53,-36,89,122,20,89,-66,80,90,2,-108,90,70,-48,90,-117,20,91,19,-112,91,87,-52,91,-98,-80,92,117,-20,92,-81,-80,92,-2,108,93,56,48,93,-119,-116,93,-64,-80,94,18,12,94,73,48,94,-102,-116,94,-44,80,95,35,12,95,92,-48,95,-85,-116,95,-27,80,96,7,108,96,54,-68,96,109,-36,127,10751,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,0,1,1,0,GET,GEST,Georgia Standard Time,Georgia Summer Time,0,Asia/Tehran,12600000,3,-1,-1090466744,81,-64,-82,82,100,-112,127,12344,14,16,14,70,-1,-1090466744,81,112,-50,81,-64,-82,81,-6,-48,82,44,-80,82,100,-112,82,-101,82,82,-58,110,83,11,114,83,81,46,88,-3,-14,89,51,46,89,119,114,89,-68,110,90,0,82,90,69,78,90,-119,50,90,-50,46,91,18,18,91,87,14,91,-102,-14,91,-33,-18,92,36,50,92,105,46,92,-83,18,92,-14,14,93,53,-14,93,122,-18,93,-66,-46,94,3,-50,94,72,18,94,-115,14,94,-48,-14,95,21,-18,95,89,-46,95,-98,-50,95,-30,-78,96,39,-82,96,107,-14,96,-80,-18,98,6,-110,98,75,-114,98,-113,-46,98,-44,-50,99,24,-78,99,93,-82,99,-95,-110,99,-26,-114,100,42,114,100,111,110,100,-77,-78,100,-8,-82,101,60,-110,101,-127,-114,101,-59,114,102,10,110,102,78,82,102,-109,78,102,-41,-110,103,28,-114,103,96,114,103,-91,110,103,-23,82,104,46,78,104,114,50,104,-73,46,104,-5,114,105,64,110,105,-124,82,105,-55,78,127,12344,14,18,").append("16,20,16,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,18,14,0,1,1,0,IRST,IRDT,Iran Standard Time,Iran Daylight Time,0,Asia/Tel_Aviv,7200000,2,-1,-2840149254,-1,-1641003640,127,8454,127,8440,8,103,-1,-2840149254,-1,-1641003640,61,-65,-64,61,-19,-128,61,-1,32,63,10,-32,63,67,-128,63,-109,-64,63,-52,-64,64,29,0,64,91,64,64,-91,-32,64,-28,32,65,46,-64,66,4,32,66,42,0,66,64,-32,66,-124,-64,66,-55,-64,67,8,0,67,65,0,67,-117,64,67,-33,64,68,27,-96,68,95,-32,68,-95,-128,68,-37,64,69,65,-96,69,99,-64,69,-54,32,69,-20,64,70,80,0,70,124,-96,70,-53,96,71,2,-128,79,-3,-8,80,34,-76,80,105,-104,80,-101,116,83,62,24,83,77,-40,85,64,-104,85,106,-104,85,-63,56,85,-11,-76,86,86,-40,86,-128,-44,86,-45,88,87,11,-12,87,90,-72,87,-111,-44,87,-21,24,88,26,84,88,102,120,88,-96,52,88,-18,-8,89,43,84,89,122,24,89,-74,116,90,4,120,90,62,-12,90,-116,-8,90,-60,-44,91,21,120,91,79,-12,91,-104,-72,91,-34,20,92,35,-40,92,102,52,92,-84,88,92,-20,20,93,58,32,93,115,-36,93,-57,-32,94,9,120,94,78,-36,94,-115,-40,94,-45,-100,95,27,-104,95,92,28,95,-94,-8,95,-23,28,96,40,24,96,111,-64,96,-73,92,96,-8,64,97,61,60,97,-128,-64,97,-64,124,98,9,64,98,80,-36,98,-111,-64,98,-42,-68,99,26,64,99,89,-4,99,-91,96,99,-22,92,100,45,-32,100,112,60,100,-74,96,101,5,-36,101,62,-32,101,-114,92,127,8454,127,8440,8,12,8,12,8,12,8,12,8,12,8,12,8,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1038653570,-1367828344,1,1,0,IST,IDT,Israel Standard Time,Israel Daylight Time,0,Asia/Thimbu,21600000,2,-1,-706341516,87,18,-86,127,21516,22,24,2,-1,-706341516,87,18,-86,127,21516,22,24,0,1,1,0,BTT,BTST,Bhutan Time,Bhutan Summer Time,0,Asia/Thimphu,21600000,2,-1,-706341516,87,18,-86,127,21516,22,24,2,-1,-706341516,87,18,-86,127,21516,22,24,0,1,1,0,BTT,BTST,Bhutan Time,Bhutan Summer Time,0,Asia/Tokyo,32400000,1,33,-76,-100,127,33539,36,9,33,-76,-100,65,-4,28,66,45,-4,66,122,28,66,-74,124,67,15,-68,67,62,-4,67,-104,60,67,-57,124,127,33539,36,40,36,40,36,40,36,40,36,0,1,1,0,JST,JDT,Japan Standard Time,Japan Summer Time,0,Asia/Tomsk,25200000,8,-1,-1578807591,56,109,72,88,-15,-116,89,95,-48,94,-33,-20,99,-93,112,101,-114,76,102,104,48,127,20391,24,28,24,28,24,28,24,28,66,-1,-1578807591,56,109,72,83,-104,100,83,-35,0,84,33,68,84,101,-32,84,-86,36,84,-18,-64,85,51,100,85,119,-84,85,-69,-20,86,0,44,86,68,108,86,-120,-84,86,-52,-20,87,17,44,87,85,108,87,-103,-84,87,-35,-20,88,34,44,88,102,108,88,-83,76,89,53,-48,89,95,-48,89,122,12,89,-66,76,90,2,-116,90,70,-52,90,-117,12,90,-49,76,91,19,-116,91,87,-52,91,-98,-84,91,-19,108,92,39,44,92,117,-20,92,-81,-84,92,-2,108,93,56,44,93,-119,-116,93,-64,-84,94,18,12,94,73,44,94,-102,-116,94,-44,76,94,-33,-20,95,35,16,95,92,-48,95,-85,-112,95,-27,80,96,54,-80,96,109,-48,96,-65,48,96,-10,80,97,71,-80,97,126,-48,97,-48,48,98,9,-16,98,88,-80,98,-110,112,98,-31,48,99,26,-16,99,108,80,99,-93,112,101,-114,76,102,104,48,127,20391,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,32,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,24,28,0,1,1,0,GMT+07:00,GMT+07:00,Tomsk Standard Time,Tomsk Daylight Time,0,Asia/Ujung_Pandang,28800000,3,-1,-1172908656,62,-89,96,64,-105,28,127,28656,32,36,32,3,-1,-1172908656,62,-89,96,64,-105,28,127,28656,32,36,32,0,1,1,0,WITA,CIST,Central Indonesia Time,Central Indonesia Summer Time,0,Asia/Ulaanbaatar,28800000,2,-1,-2032931252,81,-37,-92,127,25652,28,32,50,-1,-2032931252,81,-37,-92,84,-86,32,84,-18,-68,85,51,96,85,119,-100,85,-69,-32,86,0,28,86,68,96,86,-120,-100,86,-52,-32,87,17,28,87,85,96,87,-103,-100,87,-35,-32,88,34,28,88,102,96,88,-83,60,88,-15,-128,89,53,-68,89,122,0,89,-66,60,90,2,-128,90,70,-68,90,-117,0,90,-49,60,91,19,-128,91,87,-68,91,-98,-96,91,-30,-36,92,39,32,92,107,92,92,-81,-96,92,-13,-36,94,85,-24,94,-113,-92,94,-45,-24,95,24,36,95,92,104,95,-96,-92,95,-28,-24,96,41,36,96,109,104,96,-79,-92,96,-11,-24,97,60,-60,101,-57,-88,102,11,-36,102,80,40,102,-108,92,127,25652,28,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,ULAT,ULAST,Ulaanbaatar Standard Time,Ulaanbaatar Summer Time,0,Asia/Ulan_Bator,28800000,2,-1,-2032931252,81,-37,-92,127,25652,28,32,50,-1,-2032931252,81,-37,-92,84,-86,32,84,-18,-68,85,51,96,85,119,-100,85,-69,-32,86,0,28,86,68,96,86,-120,-100,86,-52,-32,87,17,28,87,85,96,87,-103,-100,87,-35,-32,88,34,28,88,102,96,88,-83,60,88,-15,-128,89,53,-68,89,122,0,89,-66,60,90,2,-128,90,70,-68,90,-117,0,90,-49,60,91,19,-128,91,87,-68,91,-98,-96,91,-30,-36,92,39,32,92,107,92,92,-81,-96,92,-13,-36,94,85,-24,94,-113,-92,94,-45,-24,95,24,36,95,92,104,95,-96,-92,95,-28,-24,96,41,36,96,109,104,96,-79,-92,96,-11,-24,97,60,-60,101,-57,-88,102,11,-36,102,80,40,102,-108,92,127,25652,28,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,ULAT,ULAST,Ulaanbaatar Standard Time,Ulaanbaatar Summer Time,0,Asia/Urumqi,21600000,1,-1,-1325483420,127,21020,24,1,-1,-1325483420,127,21020,24,0,1,1,0,XJT,XJDT,Xinjiang Standard Time,Xinjiang Daylight Time,0,Asia/Ust-Nera,36000000,8,-1,-1579426374,56,109,64,83,-104,92,88,-15,124,89,95,-64,99,-93,92,99,-29,16,101,-114,60,127,34374,32,36,44,40,44,48,44,40,65,-1,-1579426374,56,109,64,83,-104,92,83,-36,-16,84,33,52,84,101,-48,84,-86,20,84,-18,-80,85,51,84,85,119,-100,85,-69,-36,86,0,28,86,68,92,86,-120,-100,86,-52,-36,87,17,28,87,85,92,87,-103,-100,87,-35,-36,88,34,28,88,102,92,88,-83,60,89,53,-64,89,95,-64,89,121,-4,89,-66,60,90,2,124,90,70,-68,90,-118,-4,90,-49,60,91,19,124,91,87,-68,91,-98,-100,91,-19,92,92,39,28,92,117,-36,92,-81,-100,92,-2,92,93,56,28,93,-119,124,93,-64,-100,94,17,-4,94,73,28,94,-102,124,94,-44,60,95,34,-4,95,92,-68,95,-85,124,95,-27,60,96,54,-100,96,109,-68,96,-65,28,96,-10,60,97,71,-100,97,126,-68,97,-48,28,98,9,-36,98,88,-100,98,-110,92,98,-31,28,99,26,-36,99,108,60,99,-93,92,99,-29,16,101,-114,60,127,34374,32,36,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,40,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,48,44,40,0,1,1,0,VLAT,VLAST,Vladivostok Standard Time,Vladivostok Summer Time,0,Asia/Vientiane,25200000,1,-1,-1570084924,127,24124,28,1,-1,-1570084924,127,24124,28,0,1,1,0,ICT,ICST,Indochina Time,Indochina Summer Time,0,Asia/Vladivostok,36000000,6,-1,-1487321251,56,109,60,88,-15,-128,89,95,-60,99,-93,96,101,-114,60,127,31651,36,40,36,40,44,40,64,-1,-1487321251,56,109,60,83,-104,88,83,-36,-12,84,33,56,84,101,-44,84,-86,24,84,-18,-76,85,51,88,85,119,-96,85,-69,-32,86,0,32,86,68,96,86,-120,-96,86,-52,-32,87,17,32,87,85,96,87,-103,-96,87,-35,-32,88,34,32,88,102,96,88,-83,64,89,53,-60,89,95,-60,89,122,0,89,-66,64,90,2,-128,90,70,-64,90,-117,0,90,-49,64,91,19,-128,91,87,-64,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,94,18,0,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-10,64,97,71,-96,97,126,-64,97,-48,32,98,9,-32,98,88,-96,98,-110,96,98,-31,32,99,26,-32,99,108,64,99,-93,96,101,-114,60,127,31651,36,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,36,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,0,1,1,0,VLAT,VLAST,Vladivostok Standard Time,Vladivostok Summer Time,0,Asia/Yakutsk,32400000,6,-1,-1579423138,56,109,64,88,-15,-124,89,95,-56,99,-93,100,101,-114,64,127,31138,32,36,32,36,40,36,64,-1,-1579423138,56,109,64,83,-104,92,83,-36,-8,84,33,60,84,101,-40,84,-86,28,84,-18,-72,85,51,92,85,119,-92,85,-69,-28,86,0,36,86,68,100,86,-120,-92,86,-52,-28,87,17,36,87,85,100,87,-103,-92,87,-35,-28,88,34,36,88,102,100,88,-83,68,89,53,-56,89,95,-56,89,122,4,89,-66,68,90,2,-124,90,70,-60,90,-117,4,90,-49,68,91,19,-124,91,87,-60,91,-98,-92,91,-19,100,92,39,36,92,117,-28,92,-81,-92,92,-2,100,93,56,36,93,-119,-124,93,-64,-92,94,18,4,94,73,36,94,-102,-124,94,-44,68,95,35,4,95,92,-60,95,-85,-124,95,-27,68,96,54,-92,96,109,-60,96,-65,36,96,-10,68,97,71,-92,97,126,-60,97,-48,36,98,9,-28,98,88,-92,98,-110,100,98,-31,36,99,26,-28,99,108,68,99,-93,100,101,-114,64,127,31138,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,32,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,40,36,0,1,1,0,YAKT,YAKST,Yakutsk Standard Time,Yakutsk Summer Time,0,Asia/Yangon,23400000,3,-1,-1577946287,62,-59,-58,64,97,124,127,23087,26,36,26,3,-1,-1577946287,62,-59,-58,64,97,124,127,23087,26,36,26,0,1,1,0,MMT,MMST,Myanmar Time,Myanmar Summer Time,0,Asia/Yekaterinburg,18000000,7,-1,-1688270553,-1,-1592610305,56,109,80,88,-15,-108,89,95,-40,99,-93,116,101,-114,80,127,14553,127,13505,16,20,16,20,24,20,65,-1,-1688270553,-1,-1592610305,56,109,80,83,-104,108,83,-35,8,84,33,76,84,101,-24,84,-86,44,84,-18,-56,85,51,108,85,119,-76,85,-69,-12,86,0,52,86,68,116,86,-120,-76,86,-52,-12,87,17,52,87,85,116,87,-103,-76,87,-35,-12,88,34,52,88,102,116,88,-83,84,89,53,-40,89,95,-40,89,122,20,89,-66,84,90,2,-108,90,70,-44,90,-117,20,90,-49,84,91,19,-108,91,87,-44,91,-98,-76,91,-19,116,92,39,52,92,117,-12,92,-81,-76,92,-2,116,93,56,52,93,-119,-108,93,-64,-76,94,18,20,94,73,52,94,-102,-108,94,-44,84,95,35,20,95,92,-44,95,-85,-108,95,-27,84,96,54,-76,96,109,-44,96,-65,52,96,-10,84,97,71,-76,97,126,-44,97,-48,52,98,9,-12,98,88,-76,98,-110,116,98,-31,52,99,26,-12,99,108,84,99,-93,116,101,-114,80,127,14553,127,13505,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,16,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,24,20,0,1,1,0,YEKT,YEKST,Yekaterinburg Standard Time,Yekaterinburg Summer Time,0,Asia/Yerevan,14400000,4,-1,-1441162680,70,-75,-108,88,-15,-104,91,87,-36,127,10680,12,16,12,16,60,-1,-1441162680,70,-75,-108,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,87,-35,-8,88,34,56,88,102,120,88,-83,88,89,53,-36,89,122,28,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,92,39,56,92,117,-8,92,-81,-72,92,-2,120,93,56,56,93,-119,-104,93,-64,-72,94,18,24,94,73,56,94,-102,-104,94,-44,88,95,35,24,95,92,-40,95,-85,-104,95,-27,88,96,54,-72,96,109,-40,96,-65,56,96,-10,88,97,71,-72,97,126,-40,97,-48,56,98,9,-8,98,88,-72,98,-110,120,98,-31,56,99,26,-8,99,108,88,99,-93,120,99,-12,-40,127,10680,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,0,1,1,0,AMT,AMST,Armenia Standard Time,Armenia Summer Time,0,Australia/ACT,36000000,1,-1,-2364113092,127,36292,40,86,-1,-2364113092,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,34,96,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,11,-96,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,36292,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Adelaide,34200000,2,-1,-2364110060,39,-60,92,127,33260,36,38,87,-1,-2364110060,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,78,-114,98,78,-69,2,79,22,-30,79,70,34,79,-97,98,79,-50,-94,80,39,-30,80,87,34,80,-80,98,80,-30,66,81,59,-126,81,106,-62,81,-60,2,81,-13,66,82,76,-126,82,123,-62,82,-43,2,83,4,66,83,93,-126,83,-116,-62,83,-26,2,84,23,-30,84,113,34,84,-96,98,84,-7,-94,85,40,-30,85,-126,34,85,-79,98,86,10,-94,86,63,34,86,-112,-126,86,-57,-94,87,27,-94,87,82,-62,87,-90,-62,87,-37,66,88,47,66,88,99,-62,88,-73,-62,88,-25,2,89,64,66,89,119,98,89,-56,-62,89,-6,-94,90,83,-30,90,-120,98,90,-36,98,91,19,-126,91,100,-30,91,-98,-94,91,-19,98,92,39,34,92,117,-30,92,-81,-94,92,-2,98,93,56,34,93,-119,-126,93,-64,-94,94,18,2,94,73,34,94,-102,-126,94,-44,66,95,35,2,95,92,-62,95,-85,-126,95,-27,66,96,54,-94,96,109,-62,96,-65,34,96,-8,-30,97,71,-94,97,126,-62,97,-48,34,98,12,-126,98,80,-62,98,-107,2,98,-39,66,127,33260,36,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,2,1215867496,-1468487070,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Australia/Brisbane,36000000,1,-1,-2366791928,127,36728,40,17,-1,-2366791928,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,127,36728,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,0,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Broken_Hill,34200000,3,-1,-2364110748,38,84,120,39,-60,92,127,33948,40,36,38,88,-1,-2364110748,38,84,120,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,78,-114,98,78,-69,2,79,22,-30,79,70,34,79,-97,98,79,-50,-94,80,39,-30,80,87,34,80,-80,98,80,-30,66,81,59,-126,81,106,-62,81,-60,2,81,-13,66,82,76,-126,82,123,-62,82,-43,2,83,4,66,83,93,-126,83,-116,-62,83,-26,2,84,34,98,84,113,34,84,-96,98,84,-7,-94,85,40,-30,85,-126,34,85,-79,98,86,10,-94,86,63,34,86,-112,-126,86,-57,-94,87,27,-94,87,82,-62,87,-90,-62,87,-37,66,88,47,66,88,94,-126,88,-73,-62,88,-25,2,89,64,66,89,111,-126,89,-56,-62,89,-6,-94,90,83,-30,90,-125,34,90,-36,98,91,11,-94,91,100,-30,91,-98,-94,91,-19,98,92,39,34,92,117,-30,92,-81,-94,92,-2,98,93,56,34,93,-119,-126,93,-64,-94,94,18,2,94,73,34,94,-102,-126,94,-44,66,95,35,2,95,92,-62,95,-85,-126,95,-27,66,96,54,-94,96,109,-62,96,-65,34,96,-8,-30,97,71,-94,97,126,-62,97,-48,34,98,12,-126,98,80,-62,98,-107,2,98,-39,66,127,33948,40,36,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,2,1215867496,-1468487070,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Australia/Canberra,36000000,1,-1,-2364113092,127,36292,40,86,-1,-2364113092,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,34,96,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,11,-96,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96").append(",-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,36292,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Currie,36000000,1,-1,-2345795356,127,35356,40,98,-1,-2345795356,49,22,32,49,87,-64,49,-87,32,49,-40,96,50,49,-96,50,96,-32,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,76,95,64,76,-93,-128,76,-14,64,77,36,32,77,122,-64,77,-84,-96,78,3,64,78,55,-64,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,31,-64,84,113,32,84,-88,64,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,57,-32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,99,-64,88,-73,-64,88,-15,-128,89,56,96,89,122,0,89,-64,-32,90,2,-128,90,73,96,90,-117,0,90,-47,-32,91,19,-128,91,90,96,91,-98,-96,91,-27,-128,92,39,32,92,110,0,92,-81,-96,92,-10,-128,93,56,32,93,127,0,93,-64,-96,93,-6,96,94,73,32,94,-110,-96,94,-44,64,95,27,32,95,92,-64,95,-93,-96,95,-27,64,96,44,32,96,109,-64,96,-76,-96,96,-8,-32,97,61,32,97,126,-64,97,-56,64,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,35356,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Darwin,34200000,2,-1,-2364108200,39,-60,92,127,31400,36,38,10,-1,-2364108200,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,127,31400,36,38,42,38,42,38,42,38,42,38,0,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Australia/Eucla,31500000,1,-1,-2337928528,127,30928,35,19,-1,-2337928528,49,56,-91,49,87,-59,62,-104,-59,62,-71,101,62,-3,-91,63,65,-27,80,39,-27,80,87,37,84,-7,-91,85,40,-27,89,72,37,89,111,-123,97,84,-59,97,126,-59,97,-48,37,98,9,-27,98,88,-91,98,-110,101,127,30928,35,39,35,39,35,39,35,39,35,39,35,39,35,39,35,39,35,39,35,0,1,1,0,ACWST,ACWDT,Australian Central Western Standard Time,Australian Central Western Daylight Time,0,Australia/Hobart,36000000,1,-1,-2345795356,127,35356,40,98,-1,-2345795356,49,22,32,49,87,-64,49,-87,32,49,-40,96,50,49,-96,50,96,-32,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,76,95,64,76,-93,-128,76,-14,64,77,36,32,77,122,-64,77,-84,-96,78,3,64,78,55,-64,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,31,-64,84,113,32,84,-88,64,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,57,-32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,99,-64,88,-73,-64,88,-15,-128,89,56,96,89,122,0,89,-64,-32,90,2,-128,90,73,96,90,-117,0,90,-47,-32,91,19,-128,91,90,96,91,-98,-96,91,-27,-128,92,39,32,92,110,0,92,-81,-96,92,-10,-128,93,56,32,93,127,0,93,-64,-96,93,-6,96,94,73,32,94,-110,-96,94,-44,64,95,27,32,95,92,-64,95,-93,-96,95,-27,64,96,44,32,96,109,-64,96,-76,-96,96,-8,-32,97,61,32,97,126,-64,97,-56,64,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,35356,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/LHI,37800000,2,-1,-2364114980,83,-116,-72,127,38180,40,42,59,-1,-2364114980,83,-116,-72,83,-27,-2,84,23,-38,84,113,30,84,-96,90,84,-7,-98,85,40,-38,85,-126,30,85,-79,90,86,10,-98,86,63,28,86,-112,126,86,-57,-100,87,27,-98,87,82,-68,87,-90,-66,87,-37,60,88,47,62,88,94,124,88,-73,-66,88,-26,-4,89,64,62,89,111,124,89,-56,-66,89,-6,-100,90,83,-34,90,-125,28,90,-36,94,91,11,-100,91,100,-34,91,-98,-100,91,-19,94,92,39,28,92,117,-34,92,-81,-100,92,-2,94,93,56,28,93,-119,126,93,-64,-100,93,-6,94,94,73,28,94,-102,126,94,-44,60,95,34,-2,95,92,-68,95,-85,126,95,-27,60,96,54,-98,96,109,-68,96,-65,30,96,-8,-36,97,71,-98,97,126,-68,97,-48,30,98,12,124,98,80,-66,98,-108,-4,98,-39,62,127,38180,40,42,46,42,46,42,46,42,46,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,2,1215863460,-1468491103,1,1,0,LHST,LHDT,Lord Howe Standard Time,Lord Howe Daylight Time,0,Australia/Lindeman,36000000,1,-1,-2366790956,127,35756,40,21,-1,-2366790956,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,127,35756,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,0,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Lord_Howe,37800000,2,-1,-2364114980,83,-116,-72,127,38180,40,42,59,-1,-2364114980,83,-116,-72,83,-27,-2,84,23,-38,84,113,30,84,-96,90,84,-7,-98,85,40,-38,85,-126,30,85,-79,90,86,10,-98,86,63,28,86,-112,126,86,-57,-100,87,27,-98,87,82,-68,87,-90,-66,87,-37,60,88,47,62,88,94,124,88,-73,-66,88,-26,-4,89,64,62,89,111,124,89,-56,-66,89,-6,-100,90,83,-34,90,-125,28,90,-36,94,91,11,-100,91,100,-34,91,-98,-100,91,-19,94,92,39,28,92,117,-34,92,-81,-100,92,-2,94,93,56,28,93,-119,126,93,-64,-100,93,-6,94,94,73,28,94,-102,126,94,-44,60,95,34,-2,95,92,-68,95,-85,126,95,-27,60,96,54,-98,96,109,-68,96,-65,30,96,-8,-36,97,71,-98,97,126,-68,97,-48,30,98,12,124,98,80,-66,98,-108,-4,98,-39,62,127,38180,40,42,46,42,46,42,46,42,46,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,42,44,2,1215863460,-1468491103,1,1,0,LHST,LHDT,Lord Howe Standard Time,Lord Howe Daylight Time,0,Australia/Melbourne,36000000,1,-1,-2364111592,127,34792,40,86,-1,-2364111592,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,23,-32,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,25,0,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,99,-64,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,19,-128,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,34792,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/NSW,36000000,1,-1,-2364113092,127,36292,40,86,-1,-2364113092,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,34,96,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,11,-96,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,36292,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/North,34200000,2,-1,-2364108200,39,-60,92,127,31400,36,38,10,-1,-2364108200,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,127,31400,36,38,42,38,42,38,42,38,42,38,0,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Australia/Perth,28800000,1,-1,-2337925404,127,27804,32,19,-1,-2337925404,49,56,-88,49,87,-56,62,-104,-56,62,-71,104,62,-3,-88,63,65,-24,80,39,-24,80,87,40,84,-7,-88,85,40,-24,89,72,40,89,111,-120,97,84,-56,97,126,-56,97,-48,40,98,9,-24,98,88,-88,98,-110,104,127,27804,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,AWST,AWDT,Australian Western Standard Time,Australian Western Daylight Time,0,Australia/Queensland,36000000,1,-1,-2366791928,127,36728,40,17,-1,-2366791928,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,127,36728,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,0,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/South,34200000,2,-1,-2364110060,39,-60,92,127,33260,36,38,87,-1,-2364110060,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,78,-114,98,78,-69,2,79,22,-30,79,70,34,79,-97,98,79,-50,-94,80,39,-30,80,87,34,80,-80,98,80,-30,66,81,59,-126,81,106,-62,81,-60,2,81,-13,66,82,76,-126,82,123,-62,82,-43,2,83,4,66,83,93,-126,83,-116,-62,83,-26,2,84,23,-30,84,113,34,84,-96,98,84,-7,-94,85,40,-30,85,-126,34,85,-79,98,86,10,-94,86,63,34,86,-112,-126,86,-57,-94,87,27,-94,87,82,-62,87,-90,-62,87,-37,66,88,47,66,88,99,-62,88,-73,-62,88,-25,2,89,64,66,89,119,98,89,-56,-62,89,-6,-94,90,83,-30,90,-120,98,90,-36,98,91,19,-126,91,100,-30,91,-98,-94,91,-19,98,92,39,34,92,117,-30,92,-81,-94,92,-2,98,93,56,34,93,-119,-126,93,-64,-94,94,18,2,94,73,34,94,-102,-126,94,-44,66,95,35,2,95,92,-62,95,-85,-126,95,-27,66,96,54,-94,96,109,-62,96,-65,34,96,-8,-30,97,71,-94,97,126,-62,97,-48,34,98,12,-126,98,80,-62,98,-107,2,98,-39,66,127,33260,36,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,2,1215867496,-1468487070,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Australia/Sydney,36000000,1,-1,-2364113092,127,36292,40,86,-1,-2364113092,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,34,96,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,94,-128,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,11,-96,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,36292,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Tasmania,36000000,1,-1,-2345795356,127,35356,40,98,-1,-2345795356,49,22,32,49,87,-64,49,-87,32,49,-40,96,50,49,-96,50,96,-32,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,76,95,64,76,-93,-128,76,-14,64,77,36,32,77,122,-64,77,-84,-96,78,3,64,78,55,-64,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,31,-64,84,113,32,84,-88,64,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,57,-32,86,-112,-128,86,-57,-96,87,27,-96,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,99,-64,88,-73,-64,88,-15,-128,89,56,96,89,122,0,89,-64,-32,90,2,-128,90,73,96,90,-117,0,90,-47,-32,91,19,-128,91,90,96,91,-98,-96,91,-27,-128,92,39,32,92,110,0,92,-81,-96,92,-10,-128,93,56,32,93,127,0,93,-64,-96,93,-6,96,94,73,32,94,-110,-96,94,-44,64,95,27,32,95,92,-64,95,-93,-96,95,-27,64,96,44,32,96,109,-64,96,-76,-96,96,-8,-32,97,61,32,97,126,-64,97,-56,64,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,35356,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/Victoria,36000000,1,-1,-2364111592,127,34792,40,86,-1,-2364111592,49,56,-96,49,87,-64,62,-104,-64,62,-71,96,62,-3,-96,63,65,-32,63,-120,-64,63,-54,96,78,-114,96,78,-69,0,79,22,-32,79,70,32,79,-97,96,79,-50,-96,80,39,-32,80,87,32,80,-80,96,80,-30,64,81,59,-128,81,106,-64,81,-60,0,81,-13,64,82,76,-128,82,123,-64,82,-43,0,83,4,64,83,93,-128,83,-116,-64,83,-26,0,84,23,-32,84,113,32,84,-96,96,84,-7,-96,85,40,-32,85,-126,32,85,-79,96,86,10,-96,86,63,32,86,-112,-128,86,-57,-96,87,25,0,87,82,-64,87,-90,-64,87,-37,64,88,47,64,88,99,-64,88,-73,-64,88,-25,0,89,64,64,89,111,-128,89,-56,-64,89,-6,-96,90,83,-32,90,-125,32,90,-36,96,91,19,-128,91,100,-32,91,-98,-96,91,-19,96,92,39,32,92,117,-32,92,-81,-96,92,-2,96,93,56,32,93,-119,-128,93,-64,-96,93,-6,96,94,73,32,94,-102,-128,94,-44,64,95,35,0,95,92,-64,95,-85,-128,95,-27,64,96,54,-96,96,109,-64,96,-65,32,96,-8,-32,97,71,-96,97,126,-64,97,-48,32,98,12,-128,98,80,-64,98,-107,0,98,-39,64,127,34792,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,40,44,2,1215867528,-1468487038,1,1,0,AEST,AEDT,Australian Eastern Standard Time,Australian Eastern Daylight Time,0,Australia/West,28800000,1,-1,-2337925404,127,27804,32,19,-1,-2337925404,49,56,-88,49,87,-56,62,-104,-56,62,-71,104,62,-3,-88,63,65,-24,80,39,-24,80,87,40,84,-7,-88,85,40,-24,89,72,40,89,111,-120,97,84,-56,97,126,-56,97,-48,40,98,9,-24,98,88,-88,98,-110,104,127,27804,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,36,32,0,1,1,0,AWST,AWDT,Australian Western Standard Time,Australian Western Daylight Time,0,Australia/Yancowinna,34200000,3,-1,-2364110748,38,84,120,39,-60,92,127,33948,40,36,38,88,-1,-2364110748,38,84,120,39,-60,92,49,56,-94,49,87,-62,62,-104,-62,62,-71,98,62,-3,-94,63,65,-30,63,-120,-62,63,-54,98,78,-114,98,78,-69,2,79,22,-30,79").append(",70,34,79,-97,98,79,-50,-94,80,39,-30,80,87,34,80,-80,98,80,-30,66,81,59,-126,81,106,-62,81,-60,2,81,-13,66,82,76,-126,82,123,-62,82,-43,2,83,4,66,83,93,-126,83,-116,-62,83,-26,2,84,34,98,84,113,34,84,-96,98,84,-7,-94,85,40,-30,85,-126,34,85,-79,98,86,10,-94,86,63,34,86,-112,-126,86,-57,-94,87,27,-94,87,82,-62,87,-90,-62,87,-37,66,88,47,66,88,94,-126,88,-73,-62,88,-25,2,89,64,66,89,111,-126,89,-56,-62,89,-6,-94,90,83,-30,90,-125,34,90,-36,98,91,11,-94,91,100,-30,91,-98,-94,91,-19,98,92,39,34,92,117,-30,92,-81,-94,92,-2,98,93,56,34,93,-119,-126,93,-64,-94,94,18,2,94,73,34,94,-102,-126,94,-44,66,95,35,2,95,92,-62,95,-85,-126,95,-27,66,96,54,-94,96,109,-62,96,-65,34,96,-8,-30,97,71,-94,97,126,-62,97,-48,34,98,12,-126,98,80,-62,98,-107,2,98,-39,66,127,33948,40,36,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,38,42,2,1215867496,-1468487070,1,1,0,ACST,ACDT,Australian Central Standard Time,Australian Central Daylight Time,0,Etc/GMT,0,0,0,0,0,0,1,1,0,GMT,GMT,Greenwich Mean Time,Greenwich Mean Time,0,Europe/Amsterdam,3600000,4,36,6,0,48,18,96,50,55,-116,61,-69,72,127,1050,0,4,0,4,104,36,6,0,48,18,96,48,-36,-36,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,50,55,-116,50,96,-4,50,-78,92,50,-28,60,51,66,-68,51,119,-4,51,-52,92,52,4,-4,52,78,124,52,-105,-4,52,-42,-4,53,24,-100,53,95,124,53,-93,-68,53,-25,-4,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,97,-24,57,-90,40,57,-25,-56,58,49,72,58,117,-120,58,-71,-56,58,-5,104,59,66,72,59,-117,-56,59,-54,-56,60,15,8,60,83,72,60,-108,-24,60,-37,-56,61,37,72,61,118,-88,61,-101,104,61,-69,72,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,36,64,86,4,64,-108,-92,64,-16,-124,65,37,100,81,117,100,81,-73,4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,1050,0,4,8,4,8,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Andorra,3600000,2,-1,-2177453164,65,34,-64,127,364,0,4,28,-1,-2177453164,65,34,-64,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,364,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Astrakhan,14400000,8,-1,-1441249932,56,109,84,87,-35,-8,88,-15,-100,89,122,24,99,-93,124,101,-114,88,102,80,-100,127,11532,12,16,12,16,12,16,12,16,62,-1,-1441249932,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,102,80,-100,127,11532,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,0,1,1,0,GMT+04:00,GMT+04:00,Astrakhan Standard Time,Astrakhan Standard Time,0,Europe/Athens,7200000,3,-1,-1686101632,62,60,-108,63,-51,-36,127,5692,8,4,8,57,-1,-1686101632,57,-123,120,57,-102,116,62,51,-8,62,60,-108,63,11,68,63,66,-68,63,-119,56,63,-51,-36,68,54,-104,68,101,20,80,102,-104,80,-68,24,80,-17,-128,81,51,-64,81,117,96,81,-73,96,81,-3,-32,82,63,-124,82,-122,124,82,-54,60,83,15,-104,83,83,20,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,5692,8,12,8,12,8,4,8,4,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Belfast,0,3,-1,-3852662325,76,-14,92,78,-114,-120,127,-75,0,4,0,161,-1,-3852662325,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-75,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,BST,Greenwich Mean Time,British Summer Time,0,Europe/Belgrade,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Berlin,3600000,1,-1,-2422054408,127,3208,4,63,-1,-2422054408,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,105,-128,64,-105,-96,64,-84,68,64,-29,100,65,37,100,65,105,72,65,118,100,65,-120,-64,65,-83,-124,65,-9,4,66,54,4,66,124,-28,66,-66,-124,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3208,4,8,4,8,4,8,4,8,4,8,4,8,4,8,12,8,4,8,4,8,12,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Bratislava,3600000,3,-1,-2469401864,65,58,8,65,89,-120,127,3464,4,0,4,63,-1,-2469401864,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,-102,68,64,-21,-92,65,37,4,65,58,8,65,89,-120,65,110,-124,65,-83,-124,65,-9,4,66,54,4,66,124,-124,66,-66,-124,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3464,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Brussels,3600000,4,36,6,0,48,18,96,50,55,-116,61,-69,72,127,1050,0,4,0,4,104,36,6,0,48,18,96,48,-36,-36,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,50,55,-116,50,96,-4,50,-78,92,50,-28,60,51,66,-68,51,119,-4,51,-52,92,52,4,-4,52,78,124,52,-105,-4,52,-42,-4,53,24,-100,53,95,124,53,-93,-68,53,-25,-4,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,97,-24,57,-90,40,57,-25,-56,58,49,72,58,117,-120,58,-71,-56,58,-5,104,59,66,72,59,-117,-56,59,-54,-56,60,15,8,60,83,72,60,-108,-24,60,-37,-56,61,37,72,61,118,-88,61,-101,104,61,-69,72,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,36,64,86,4,64,-108,-92,64,-16,-124,65,37,100,81,117,100,81,-73,4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,1050,0,4,8,4,8,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Bucharest,7200000,1,-1,-1213148664,127,6264,8,57,-1,-1213148664,57,115,-40,57,-90,24,57,-22,88,58,46,-104,58,117,120,58,-71,-72,58,-3,-8,59,66,56,59,-122,120,59,-54,-72,60,14,-8,60,83,56,60,-105,120,60,-37,-72,61,31,-8,61,100,56,82,-101,88,82,-54,-108,83,17,116,83,83,24,83,-105,96,83,-37,-96,84,31,-32,84,100,32,84,-88,96,84,-20,-96,85,48,-32,85,119,-64,85,-68,0,86,0,64,86,68,-128,86,-120,-64,86,-51,0,87,17,64,87,85,-128,87,-103,-64,87,-34,0,88,34,64,88,102,-128,88,-83,96,88,-15,-104,89,53,-40,89,122,24,89,-66,88,90,2,-104,90,70,-40,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-19,116,92,39,68,92,118,4,92,-81,-60,92,-2,-124,127,6264,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Budapest,3600000,1,-1,-2498260580,127,4580,4,71,-1,-2498260580,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,50,113,-124,50,-86,-28,50,-9,4,51,54,4,62,52,88,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,97,56,64,-91,-36,64,-34,36,65,37,96,65,105,68,65,-83,-124,65,-15,-60,66,54,4,66,124,-28,66,-66,-124,69,57,-68,69,107,-104,69,-62,68,69,-12,36,70,80,4,70,124,-92,70,-40,-124,71,5,36,83,17,124,83,83,28,83,-105,92,83,-37,-100,84,31,-36,84,100,28,84,-88,92,84,-20,-100,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4580,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Busingen,3600000,2,-1,-3675198848,-1,-2385246586,127,2048,127,1786,4,40,-1,-3675198848,-1,-2385246586,62,62,-128,62,120,64,62,-57,0,63,0,-64,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2048,127,1786,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Chisinau,7200000,6,-1,-2840147720,-1,-1637114100,-1,-1213148664,62,89,-44,64,3,24,88,118,56,127,6920,127,6900,127,6264,8,4,12,8,63,-1,-2840147720,-1,-1637114100,-1,-1213148664,57,115,-40,57,-90,24,57,-22,88,58,46,-104,58,117,120,58,-71,-72,58,-3,-8,59,66,56,59,-122,120,59,-54,-72,60,14,-8,60,83,56,60,-105,120,60,-37,-72,61,31,-8,61,100,56,61,-37,-40,62,89,-44,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,3,24,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,118,56,88,-83,96,88,-15,-96,89,53,-32,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-19,116,92,39,64,92,118,0,92,-81,-64,92,-2,-128,127,6920,127,6900,127,6264,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048090754,-1367811960,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Copenhagen,3600000,1,-1,-2422054408,127,3208,4,63,-1,-2422054408,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,105,-128,64,-105,-96,64,-84,68,64,-29,100,65,37,100,65,105,72,65,118,100,65,-120,-64,65,-83,-124,65,-9,4,66,54,4,66,124,-28,66,-66,-124,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3208,4,8,4,8,4,8,4,8,4,8,4,8,4,8,12,8,4,8,4,8,12,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Dublin,0,1,-1,-1680471279,127,-1521,0,146,-1,-1691962479,-1,-1680471279,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,5").append("5,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,65,37,8,65,97,104,65,-72,8,65,-9,8,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-1521,127,2079,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,IST,Greenwich Mean Time,Irish Standard Time,0,Europe/Gibraltar,3600000,2,-1,-2821649916,70,-58,40,127,-1284,0,4,118,-1,-2821649916,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-1284,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Guernsey,0,3,-1,-3852662325,76,-14,92,78,-114,-120,127,-75,0,4,0,161,-1,-3852662325,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-75,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,BST,Greenwich Mean Time,British Summer Time,0,Europe/Helsinki,7200000,1,-1,-1535938789,127,5989,8,37,-1,-1535938789,62,-69,88,63,0,88,83,-105,96,83,-37,-96,84,31,-32,84,100,32,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,5989,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Isle_of_Man,0,3,-1,-3852662325,76,-14,92,78,-114,-120,127,-75,0,4,0,161,-1,-3852662325,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-75,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,BST,Greenwich Mean Time,British Summer Time,0,Europe/Istanbul,10800000,5,-1,-2840147752,-1,-1869875816,82,30,-44,85,-125,-68,102,-114,20,127,6952,127,7016,8,12,8,12,113,-1,-2840147752,-1,-1869875816,48,-36,-40,49,22,52,50,-13,-8,51,67,20,51,127,24,51,-61,-76,52,4,-8,52,78,116,53,41,24,53,93,-12,53,-83,120,53,-26,-44,61,-54,-8,61,-17,84,62,4,88,62,114,-108,62,-70,-104,64,-100,-44,64,-11,88,65,35,20,65,110,120,65,-83,116,65,-10,-8,66,53,-12,66,124,-40,66,-66,116,67,7,-8,67,73,-108,67,-109,24,67,-46,20,73,-107,88,74,70,84,74,-112,-104,74,-60,-76,79,104,92,79,-94,28,79,-39,64,80,42,-100,80,94,-64,80,-77,28,80,-25,-96,81,59,-100,81,117,96,81,-66,-36,81,-3,-32,84,-41,-100,84,-17,56,85,-125,-68,85,-61,124,85,-1,-36,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,53,-36,89,122,28,89,-66,92,90,2,-100,90,70,-36,90,-120,124,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-28,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,64,4,101,-114,100,101,-56,36,102,28,36,102,80,-92,127,6952,127,7016,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,0,1,1,0,TRT,TRST,Turkey Time,Turkey Summer Time,0,Europe/Jersey,0,3,-1,-3852662325,76,-14,92,78,-114,-120,127,-75,0,4,0,161,-1,-3852662325,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-75,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,BST,Greenwich Mean Time,British Summer Time,0,Europe/Kaliningrad,7200000,6,-1,-2422056120,64,88,-8,64,-32,-72,87,-35,-4,99,-93,-128,101,-114,92,127,4920,4,8,12,8,12,8,78,-1,-2422056120,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,96,24,64,-91,-44,64,-32,-72,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,88,34,64,88,102,-128,88,-83,96,88,-15,-96,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-128,92,39,64,92,118,0,92,-81,-64,92,-2,-128,93,56,64,93,-119,-96,93,-64,-64,94,18,32,94,73,64,94,-102,-96,94,-44,96,95,35,32,95,92,-32,95,-85,-96,95,-27,96,96,54,-64,96,109,-32,96,-65,64,96,-10,96,97,71,-64,97,126,-32,97,-48,64,98,10,0,98,88,-64,98,-110,-128,98,-31,64,99,27,0,99,108,96,99,-93,-128,101,-114,92,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,12,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,0,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Kiev,7200000,5,-1,-1441159324,56,109,88,62,114,52,63,-107,-100,88,-117,56,127,7324,8,12,4,12,8,40,-1,-1441159324,56,109,88,62,114,52,63,11,68,63,66,100,63,-119,68,63,-107,-100,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-117,56,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-124,92,39,68,92,118,4,127,7324,8,12,8,4,8,4,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Kirov,10800000,7,50,-114,96,56,109,84,87,-35,-8,88,-15,-100,89,122,24,99,-93,124,101,-114,88,127,11928,12,16,12,16,12,16,12,61,50,-114,96,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,127,11928,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,0,1,1,0,GMT+03:00,GMT+03:00,Kirov Standard Time,Kirov Daylight Time,0,Europe/Kyiv,7200000,5,-1,-1441159324,56,109,88,62,114,52,63,-107,-100,88,-117,56,127,7324,8,12,4,12,8,40,-1,-1441159324,56,109,88,62,114,52,63,11,68,63,66,100,63,-119,68,63,-107,-100,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-117,56,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-124,92,39,68,92,118,4,127,7324,8,12,8,4,8,4,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Lisbon,0,5,46,-117,-96,75,-110,-88,81,46,-128,89,-66,100,91,-98,-60,127,-2205,0,4,0,4,0,141,46,-117,-96,48,-18,-36,49,33,-32,49,78,-36,49,-92,92,49,-40,28,50,45,60,50,96,-100,50,-74,28,50,-23,-36,51,63,92,51,114,-68,51,-56,60,53,31,92,53,99,60,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,28,55,-51,-100,56,12,-100,56,-34,-100,57,29,-100,57,97,-36,57,-90,28,58,117,124,58,-71,-68,58,-5,92,59,66,60,59,-117,-68,59,-54,-68,60,14,-4,60,83,60,60,-108,-36,60,-37,-68,61,37,60,61,118,-100,61,-101,92,61,-17,92,62,51,-100,62,120,60,62,-76,60,62,-61,-8,62,-19,-8,63,8,60,63,60,-68,63,73,-40,63,123,-72,63,-109,92,63,-59,60,63,-44,-8,64,4,56,64,27,-36,64,77,-68,64,93,120,64,-116,-72").append(",64,-92,92,64,-32,-68,65,36,-4,65,105,72,65,-83,-120,65,-15,-56,66,54,8,66,122,72,66,-66,-120,67,2,-56,67,71,8,67,-117,72,67,-46,40,68,22,104,68,90,-88,68,-98,-24,68,-29,40,69,39,104,69,107,-88,69,-81,-24,69,-12,40,70,56,104,70,127,72,70,-61,-120,71,7,-56,71,76,8,71,-112,72,71,-44,-120,72,24,-56,72,93,8,72,-95,72,72,-27,-120,73,41,-56,73,110,8,73,-76,-24,73,-7,40,74,61,104,74,-127,-88,74,-59,-24,75,10,40,75,78,104,75,-110,-88,81,46,-128,81,114,-64,81,-73,0,81,-3,-32,82,66,32,82,-122,96,82,-54,-92,83,14,-32,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,104,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-19,-124,92,39,68,92,118,4,127,-2205,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,0,4,8,4,0,4,8,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,0,4,0,2,1048070146,-1367848952,1,1,0,WET,WEST,Western European Standard Time,Western European Summer Time,0,Europe/Ljubljana,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/London,0,3,-1,-3852662325,76,-14,92,78,-114,-120,127,-75,0,4,0,161,-1,-3852662325,48,-28,104,49,22,72,49,93,40,49,-103,-24,49,-32,104,50,39,-88,50,107,-120,50,-80,40,50,-12,8,51,67,40,51,127,40,51,-61,-56,52,5,8,52,78,-120,52,-104,8,52,-49,40,53,29,-24,53,90,72,53,-87,8,53,-24,8,54,49,-120,54,112,-120,54,-73,104,54,-7,8,55,69,40,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,103,40,57,-90,40,57,-19,8,58,49,72,58,122,-56,58,-71,-56,59,0,-88,59,66,72,59,-117,-56,59,-54,-56,60,20,72,60,83,72,60,-102,40,60,-37,-56,61,37,72,61,118,-88,61,-101,104,62,62,36,62,98,-28,62,-68,36,62,-21,100,63,68,-92,63,118,-124,63,-51,36,64,12,36,64,86,4,64,125,4,64,-100,-120,64,-29,104,65,37,8,65,97,104,65,107,-28,65,-104,-124,65,-72,8,65,-23,-24,66,64,-120,66,122,72,66,-55,8,67,8,8,67,78,-24,67,-112,-120,67,-41,104,68,27,-88,68,98,-120,68,-92,40,68,-29,40,69,42,8,69,107,-88,69,-75,40,69,-12,40,70,64,72,70,127,72,70,-58,40,71,7,-56,71,81,72,71,-112,72,71,-39,-56,72,24,-56,72,95,-88,72,-95,72,72,-30,-24,73,52,72,73,107,104,73,-68,-56,73,-10,-120,74,69,72,74,124,104,74,-51,-56,75,4,-24,75,86,72,75,-115,104,75,-34,-56,76,21,-24,76,105,-24,76,-109,-24,78,-114,-120,78,-61,8,79,23,8,79,75,-120,79,-97,-120,79,-44,8,80,40,8,80,92,-120,80,-80,-120,80,-25,-88,81,57,8,81,112,40,81,-63,-120,81,-8,-88,82,76,-88,82,-127,40,82,-43,40,83,9,-88,83,93,-88,83,-105,100,83,-26,36,84,31,-28,84,110,-92,84,-88,100,84,-9,36,85,48,-28,85,-126,68,85,-68,4,86,10,-60,86,68,-124,86,-109,68,86,-51,4,87,27,-60,87,85,-124,87,-92,68,87,-34,4,88,47,100,88,102,-124,88,-73,-28,88,-15,-92,89,64,100,89,122,36,89,-56,-28,90,2,-92,90,81,100,90,-117,36,90,-39,-28,91,19,-92,91,98,100,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-75,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,0,4,0,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,2,1048070146,-1367848952,1,1,0,GMT,BST,Greenwich Mean Time,British Summer Time,0,Europe/Luxembourg,3600000,4,36,6,0,48,18,96,50,55,-116,61,-69,72,127,1050,0,4,0,4,104,36,6,0,48,18,96,48,-36,-36,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,50,55,-116,50,96,-4,50,-78,92,50,-28,60,51,66,-68,51,119,-4,51,-52,92,52,4,-4,52,78,124,52,-105,-4,52,-42,-4,53,24,-100,53,95,124,53,-93,-68,53,-25,-4,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,40,55,-51,-88,56,12,-88,56,83,-120,56,-107,40,56,-34,-88,57,29,-88,57,97,-24,57,-90,40,57,-25,-56,58,49,72,58,117,-120,58,-71,-56,58,-5,104,59,66,72,59,-117,-56,59,-54,-56,60,15,8,60,83,72,60,-108,-24,60,-37,-56,61,37,72,61,118,-88,61,-101,104,61,-69,72,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,36,64,86,4,64,-108,-92,64,-16,-124,65,37,100,81,117,100,81,-73,4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,1050,0,4,8,4,8,4,8,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Madrid,3600000,2,40,-87,64,61,-93,60,127,-884,0,4,82,40,-87,64,49,-24,-4,50,42,64,50,110,124,50,-77,32,53,31,92,53,95,-128,54,49,124,54,112,-128,54,-73,92,54,-7,0,55,66,-128,55,-124,32,55,-51,-100,56,12,-96,60,42,-68,60,83,64,60,-105,124,60,-95,-8,60,-36,24,61,102,-32,61,-93,60,62,-58,-104,62,-13,-4,63,73,-40,63,-120,-36,63,-46,88,64,17,92,64,90,-40,64,-103,-36,64,-29,88,65,34,92,66,-124,-72,66,-66,124,79,-34,120,80,32,28,80,102,-8,80,-88,-100,80,-22,56,81,46,124,81,117,88,81,-74,-4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,-884,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Malta,3600000,1,-1,-2403478684,127,3484,4,89,-1,-2403478684,48,-23,-100,49,22,56,49,90,124,49,-97,24,49,-37,28,50,42,56,50,96,-4,50,-78,88,50,-15,92,51,53,-104,61,-60,-4,63,11,68,63,66,100,63,-119,68,63,-51,36,64,12,36,64,86,4,64,-108,60,64,-40,-28,65,37,4,65,97,92,65,-83,124,65,-28,-92,66,54,4,75,-92,-4,75,-44,56,76,48,28,76,92,-68,76,-72,-100,76,-27,60,77,67,-68,77,112,92,77,-52,60,77,-8,-36,78,82,28,78,-127,92,78,-35,60,79,12,124,79,80,92,79,-108,-100,79,-31,28,80,24,-100,80,105,-92,80,-93,96,80,-14,36,81,43,-32,81,122,-92,81,-76,96,82,3,36,82,60,-32,82,-117,-92,82,-59,96,83,15,68,83,80,-128,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3484,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Mariehamn,7200000,1,-1,-1535938789,127,5989,8,37,-1,-1535938789,62,-69,88,63,0,88,83,-105,96,83,-37,-96,84,31,-32,84,100,32,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,5989,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Minsk,10800000,7,-1,-2840147416,-1,-1441158600,56,109,88,62,82,-76,63,-17,-104,88,-15,-100,99,-93,-128,127,6616,127,6600,8,12,4,12,8,12,67,-1,-2840147416,-1,-1441158600,56,109,88,62,82,-76,63,11,68,63,66,100,63,-119,68,63,-51,-124,63,-17,-104,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-128,92,39,64,92,118,0,92,-81,-64,92,-2,-128,93,56,64,93,-119,-96,93,-64,-64,94,18,32,94,73,64,94,-102,-96,94,-44,96,95,35,32,95,92,-32,95,-85,-96,95,-27,96,96,54,-64,96,109,-32,96,-65,64,96,-10,96,97,71,-64,97,126,-32,97,-48,64,98,10,0,98,88,-64,98,-110,-128,98,-31,64,99,27,0,99,108,96,99,-93,-128,127,6616,127,6600,8,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,0,1,1,0,MSK,MSD,Moscow Standard Time,Moscow Daylight Time,0,Europe/Monaco,3600000,4,-1,-1855958961,61,-60,-8,64,3,120,64,-108,-92,127,561,0,4,0,4,102,-1,-1855958961,48,-19,-68,49,22,-100,49,87,-36,49,-95,-68,49,-37,28,50,42,60,50,96,-4,50,-78,-68,50,-28,60,51,66,-68,51,119,-4,51,-52,92,52,4,-4,52,78,124,52,-91,28,52,-42,-4,53,24,-100,53,95,124,53,-93,-68,53,-25,-4,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,28,55,-51,-100,56,12,-100,56,83,124,56,-107,28,56,-34,-100,57,29,-100,57,97,-36,57,-90,28,57,-25,-68,58,49,60,58,117,124,58,-71,-68,58,-5,92,59,66,60,59,-117,-68,59,-54,-68,60,14,-4,60,83,60,60,-108,-36,60,-37,-68,61,37,60,61,118,-100,61,-101,104,61,-60,-8,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,19,-4,64,86,4,64,-108,-92,80,-22,64,81,46,124,81,117,100,81,-73,4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,561,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Moscow,10800000,8,-1,-1688265017,50,-114,96,52,75,-44,56,109,88,88,-15,-100,89,95,-32,99,-93,124,101,-114,88,127,9017,127,9079,12,8,12,8,12,16,12,76,-1,-1688265017,-1,-1656819079,-1,-1641353479,-1,-1627965079,-1,-1618716679,-1,-1596429079,50,-114,96,50,-97,-112,51,109,112,51,122,44,51,-73,-84,51,-62,-16,52,75,-44,56,109,88,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-83,92,89,53,-32,89,95,-32,89,122,28,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,127,9017,127,9079,127,12679,127,9079,127,16279,127,12679,127,16279,16,12,16,20,16,12,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,0,1,1,0,MSK,MSD,Moscow Standard Time,Moscow Daylight Time,0,Europe/Nicosia,7200000,1,-1,-1518920008,127,8008,8,51,-1,-1518920008,80,102,-8,80,-85,52,80,-4,56,81,52,20,81,117,88,81,-74,-12,81,-3,-40,82,66,116,82,-122,88,82,-54,-108,83,17,120,83,83,20,83,-105,88,83,-37,-108,84,31,-40,84,100,20,84,-88,88,84,-20,-108,85,48,-40,85,119,-76,85,-69,-8,86,0,52,86,68,120,86,-120,-76,86,-52,-8,87,17,52,87,85,120,87,-103,-76,87,-35,-8,88,34,52,88,102,120,88,-83,84,88,-15,-104,89,53,-44,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-30,-12,92,39,56,92,107,116,92,-81,-72,92,-2,-124,93,56,68,93,-119,-92,127,8008,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Oslo,3600000,1,-1,-2422054408,127,3208,4,63,-1,-2422054408,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,105,-128,64,-105,-96,64,-84,68,64,-29,100,65,37,100,65,105,72,65,118,100,65,-120,-64,65,-83,-124,65,-9,4,66,54,4,66,124,-28,66,-66,-124,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3208,4,8,4,8,4,8,4,8,4,8,4,8,4,8,12,8,4,8,4,8,12,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Paris,3600000,4,-1,-1855958961,61,-60,-8,64,3,120,64,-108,-92,127,561,0,4,0,4,102,-1,-1855958961,48,-19,-68,49,22,-100,49,87,-36,49,-95,-68,49,-37,28,50,42,60,50,96,-4,50,-78,-68,50,-28,60,51,66,-68,51,119,-4,51,-52,92,52,4,-4,52,78,124,52,-91,28,52,-42,-4,53,24,-100,53,95,124,53,-93,-68,53,-25,-4,54,49,124,54,112,124,54,-73,92,54,-8,-4,55,66,124,55,-124,28,55,-51,-100,56,12,-100,56,83,124,56,-107,28,56,-34,-100,57,29,-100,57,97,-36,57,-90,28,57,-25,-68,58,49,60,58,117,124,58,-71,-68,58,-5,92,59,66,60,59,-117,-68,59,-54,-68,60,14,-4,60,83,60,60,-108,-36,60,-37,-68,61,37,60,61,118,-100,61,-101,104,61,-60,-8,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,19,-4,64,86,4,64,-108,-92,80,-22,64,81,46,124,81,117,100,81,-73,4,81,-3,-28,82,66,36,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,561,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Podgorica,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Prague,3600000,3,-1,-2469401864,65,58,8,65,89,").append("-120,127,3464,4,0,4,63,-1,-2469401864,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,-102,68,64,-21,-92,65,37,4,65,58,8,65,89,-120,65,110,-124,65,-83,-124,65,-9,4,66,54,4,66,124,-124,66,-66,-124,82,-122,100,82,-54,-92,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3464,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,0,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Riga,7200000,5,-1,-1377308194,61,-40,24,62,83,-44,64,21,-36,87,-35,-4,127,5794,8,12,4,12,8,54,-1,-1632008194,-1,-1618702594,-1,-1601681794,-1,-1597275394,-1,-1377308194,61,-40,24,62,83,-44,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,21,-36,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,88,34,64,88,102,-128,88,-83,96,88,-15,-96,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-29,0,92,39,68,92,118,4,92,-81,-60,92,-2,-124,93,56,68,93,-119,-92,94,73,68,94,-102,-92,94,-44,100,95,35,36,127,5794,127,9394,127,5794,127,9394,127,5794,8,12,8,4,8,4,8,4,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Rome,3600000,1,36,-45,-36,127,2996,4,89,36,-45,-36,48,-23,-100,49,22,56,49,90,124,49,-97,24,49,-37,28,50,42,56,50,96,-4,50,-78,88,50,-15,92,51,53,-104,61,-60,-4,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,36,64,86,4,64,-108,60,64,-40,-28,65,37,4,65,97,92,65,-83,124,65,-28,-92,66,54,4,75,-92,-4,75,-44,56,76,48,28,76,92,-68,76,-72,-100,76,-27,60,77,67,-68,77,112,92,77,-52,60,77,-8,-36,78,82,28,78,-127,92,78,-35,60,79,12,124,79,104,92,79,-108,-4,79,-18,60,80,29,124,80,121,92,80,-91,-4,81,1,-36,81,46,124,81,-121,-68,81,-74,-4,82,18,-36,82,66,28,82,-101,92,82,-54,-100,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2996,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Samara,14400000,8,50,-114,96,56,109,84,87,-35,-8,88,-15,-100,89,53,-32,89,61,-64,99,26,-8,99,-93,124,127,12020,12,16,12,8,12,16,12,16,60,50,-114,96,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,88,34,60,88,102,124,88,-83,92,89,61,-64,89,122,24,89,-66,88,90,2,-104,90,70,-40,90,-117,24,90,-49,88,91,19,-104,91,87,-40,91,-98,-72,91,-19,120,92,39,56,92,117,-8,92,-81,-72,92,-2,120,93,56,56,93,-119,-104,93,-64,-72,94,18,24,94,73,56,94,-102,-104,94,-44,88,95,35,24,95,92,-40,95,-85,-104,95,-27,88,96,54,-72,96,109,-40,96,-65,56,96,-10,88,97,71,-72,97,126,-40,97,-48,56,98,9,-8,98,88,-72,98,-110,120,98,-31,56,99,108,92,99,-93,124,127,12020,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,0,1,1,0,SAMT,SAMST,Samara Standard Time,Samara Summer Time,0,Europe/San_Marino,3600000,1,36,-45,-36,127,2996,4,89,36,-45,-36,48,-23,-100,49,22,56,49,90,124,49,-97,24,49,-37,28,50,42,56,50,96,-4,50,-78,88,50,-15,92,51,53,-104,61,-60,-4,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,36,64,86,4,64,-108,60,64,-40,-28,65,37,4,65,97,92,65,-83,124,65,-28,-92,66,54,4,75,-92,-4,75,-44,56,76,48,28,76,92,-68,76,-72,-100,76,-27,60,77,67,-68,77,112,92,77,-52,60,77,-8,-36,78,82,28,78,-127,92,78,-35,60,79,12,124,79,104,92,79,-108,-4,79,-18,60,80,29,124,80,121,92,80,-91,-4,81,1,-36,81,46,124,81,-121,-68,81,-74,-4,82,18,-36,82,66,28,82,-101,92,82,-54,-100,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2996,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Sarajevo,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Saratov,14400000,8,50,-114,96,56,109,84,87,85,120,88,-15,-100,89,122,24,99,-93,124,101,-114,88,102,-81,28,127,11058,12,16,12,16,12,16,12,16,62,50,-114,96,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,102,-81,28,127,11058,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,0,1,1,0,GMT+04:00,GMT+04:00,Saratov Standard Time,Saratov Standard Time,0,Europe/Simferopol,10800000,10,-1,-2840148984,-1,-1441160160,56,109,88,62,-127,-12,63,-47,56,88,-117,60,90,-104,52,92,39,68,101,63,-96,101,-114,88,127,8184,127,8160,8,12,4,12,8,12,8,16,12,74,-1,-2840148984,-1,-1441160160,56,109,88,62,-127,-12,63,11,68,63,66,100,63,-119,68,63,-51,-124,63,-47,56,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,-117,60,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-104,52,90,-49,92,91,19,-100,91,87,-36,91,-98,-76,91,-19,-128,92,118,4,92,-81,-60,92,-2,-124,93,56,68,93,-119,-92,93,-64,-60,94,18,36,94,73,68,94,-102,-92,94,-44,100,95,35,36,95,92,-28,95,-85,-92,95,-27,100,96,54,-60,96,109,-28,96,-65,68,96,-10,100,97,71,-60,97,126,-28,97,-48,68,98,10,4,98,88,-60,98,-110,-124,98,-31,68,99,27,4,99,108,100,99,-93,-124,99,-12,-28,100,44,4,100,125,100,100,-73,36,101,5,-28,101,63,-96,101,-114,88,127,8184,127,8160,8,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,16,12,0,1,1,0,MSK,MSD,Moscow Standard Time,Moscow Daylight Time,0,Europe/Skopje,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Sofia,7200000,4,-1,-2840146396,-1,-2369527016,63,11,68,64,86,8,127,5596,127,7016,8,4,8,48,-1,-2840146396,-1,-2369527016,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,8,82,-122,84,82,-54,-8,83,17,116,83,83,120,83,-103,-12,83,-37,-100,84,34,116,84,100,32,84,-88,96,84,-20,-96,85,48,-32,85,119,-64,85,-68,0,86,0,64,86,68,-128,86,-120,-64,86,-51,0,87,17,64,87,85,-128,87,-103,-64,87,-34,0,88,34,64,88,102,-128,88,-83,96,88,-15,-104,89,53,-44,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-19,116,92,39,68,92,118,4,92,-81,-60,92,-2,-124,127,5596,127,7016,8,4,8,4,8,4,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Stockholm,3600000,1,-1,-2422054408,127,3208,4,63,-1,-2422054408,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,105,-128,64,-105,-96,64,-84,68,64,-29,100,65,37,100,65,105,72,65,118,100,65,-120,-64,65,-83,-124,65,-9,4,66,54,4,66,124,-28,66,-66,-124,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3208,4,8,4,8,4,8,4,8,4,8,4,8,4,8,12,8,4,8,4,8,12,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Tallinn,7200000,7,-1,-1638322740,50,-114,92,-1,-1535938740,61,-40,120,62,112,84,64,13,-8,87,-35,-4,127,5940,4,127,5940,8,12,4,12,8,53,-1,-1638322740,49,-24,-92,50,34,100,50,-114,92,-1,-1535938740,61,-40,120,62,112,84,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,13,-8,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,88,34,64,88,102,-128,88,-83,96,88,-15,-96,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-128,92,39,64,92,118,0,92,-81,-64,92,-2,-124,93,56,68,93,-119,-92,94,-44,100,95,35,36,95,92,-28,95,-85,-92,127,5940,4,8,4,127,5940,8,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Tirane,3600000,1,-1,-1767230360,127,4760,4,53,-1,-1767230360,61,-59,92,63,11,68,63,66,100,63,70,-28,79,-27,-4,80,30,-104,80,109,-68,80,-89,120,80,-9,92,81,49,24,81,-126,124,81,-71,-104,82,10,-100,82,66,24,82,-109,28,82,-54,-104,83,27,-100,83,85,88,83,-95,-36,83,-37,-104,84,44,-4,84,102,-72,84,-80,-100,84,-18,-40,85,51,124,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4760,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Tiraspol,7200000,6,-1,-2840147720,-1,-1637114100,-1,-1213148664,62,89,-44,64,3,24,88,118,56,127,6920,127,6900,127,6264,8,4,12,8,63,-1,-2840147720,-1,-1637114100,-1,-1213148664,57,115,-40,57,-90,24,57,-22,88,58,46,-104,58,117,120,58,-71,-72,58,-3,-8,59,66,56,59,-122,120,59,-54,-72,60,14,-8,60,83,56,60,-105,120,60,-37,-72,61,31,-8,61,100,56,61,-37,-40,62,89,-44,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,3,24,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,118,56,88,-83,96,88,-15,-96,89,53,-32,89,122,24,89,-66,84,90,2,-104,90,70,-44,90,-117,24,90,-49,84,91,19,-104,91,87,-44,91,-98,-72,91,-19,116,92,39,64,92,118,0,92,-81,-64,92,-2,-128,127,6920,127,6900,127,6264,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048090754,-1367811960,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Ulyanovsk,14400000,8,50,-114,96,56,109,84,87,-35,-8,88,-15,-100,89,95,-32,99,-93,124,101,-114,88,102,80,-100,127,11616,12,16,12,8,12,16,12,16,64,50,-114,96,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,85,120,87,-103,-72,88,34,60,88,102,124,88,-83,92,89,53,-32,89,95,-32,89,122,28,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,102,80,-100,127,11616,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,0,1,1,0,GMT+04:00,GMT+04:00,Ulyanovsk Standard Time,Ulyanovsk Standard Time,0,Europe/Uzhgorod,7200000,5,-1,-1441159324,56,109,88,62,114,52,63,-107,-100,88,-117,56,127,7324,8,12,4,12,8,40,-1,-1441159324,56,109,88,62,114,52,63,11,68,63,66,100,63,-119,68,63,-107,-100,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-117,56,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-124,92,39,68,92,118,4,127,7324,8,12,8,4,8,4,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Vaduz,3600000,2,-1,-3675198848,-1,-2385246586,127,2048,127,1786,4,40,-1,-3675198848,-1,-2385246586,62,62,-128,62,120,64,62,-57,0,63,0,-64,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2048,127,1786,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Vatican,3600000,1,36,-45,-36,127,2996,4,89,36,-45,-36,48,-23,-100,49,22,56,49,90,124,49,-97,24,49,-37,28,50,42,56,50,96,-4,50,-78,88,50,-15,92,51,53,-104,61,-60,-4,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,12,").append("36,64,86,4,64,-108,60,64,-40,-28,65,37,4,65,97,92,65,-83,124,65,-28,-92,66,54,4,75,-92,-4,75,-44,56,76,48,28,76,92,-68,76,-72,-100,76,-27,60,77,67,-68,77,112,92,77,-52,60,77,-8,-36,78,82,28,78,-127,92,78,-35,60,79,12,124,79,104,92,79,-108,-4,79,-18,60,80,29,124,80,121,92,80,-91,-4,81,1,-36,81,46,124,81,-121,-68,81,-74,-4,82,18,-36,82,66,28,82,-101,92,82,-54,-100,83,17,-124,83,83,36,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2996,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Vienna,3600000,1,-1,-2422055121,127,3921,4,59,-1,-2422055121,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,34,100,50,-9,4,51,51,100,61,-88,-28,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,86,4,64,89,-60,64,-29,100,65,37,100,65,105,68,65,-83,-124,65,-9,4,66,54,4,83,17,124,83,83,24,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,3921,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Vilnius,7200000,11,-1,-2840146876,-1,-1672536240,-1,-1585100136,51,27,-68,51,61,24,61,-41,92,62,81,52,63,-6,120,87,-35,-4,92,-81,-60,93,-119,-92,127,6076,127,5040,127,5736,4,8,4,12,4,12,8,4,8,51,-1,-2840146876,-1,-1672536240,-1,-1585100136,51,27,-68,51,61,24,61,-41,92,62,81,52,63,11,68,63,66,100,63,-119,68,63,-51,-124,63,-6,120,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,88,34,64,88,102,-128,88,-83,96,88,-15,-96,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-128,92,39,64,92,118,0,92,-2,-124,93,56,68,95,92,-28,95,-85,-92,95,-27,100,96,54,-60,127,6076,127,5040,127,5736,4,8,4,12,8,4,8,4,8,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,12,8,4,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Volgograd,10800000,9,-1,-1577761060,56,109,84,87,85,120,88,-15,-100,89,122,24,99,-93,124,101,-114,88,103,-78,-4,104,-37,-104,127,10660,12,16,12,16,12,16,12,16,12,63,-1,-1577761060,56,109,84,83,-104,112,83,-35,12,84,33,80,84,101,-20,84,-86,48,84,-18,-52,85,51,112,85,119,-72,85,-69,-8,86,0,56,86,68,120,86,-120,-72,86,-52,-8,87,17,56,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-83,92,88,-15,-100,89,-66,92,90,2,-100,90,70,-36,90,-117,28,90,-49,92,91,19,-100,91,87,-36,91,-98,-68,91,-19,124,92,39,60,92,117,-4,92,-81,-68,92,-2,124,93,56,60,93,-119,-100,93,-64,-68,94,18,28,94,73,60,94,-102,-100,94,-44,92,95,35,28,95,92,-36,95,-85,-100,95,-27,92,96,54,-68,96,109,-36,96,-65,60,96,-10,92,97,71,-68,97,126,-36,97,-48,60,98,9,-4,98,88,-68,98,-110,124,98,-31,60,99,26,-4,99,108,92,99,-93,124,101,-114,88,103,-78,-4,104,-37,-104,127,10660,12,16,20,16,20,16,20,16,20,16,20,16,20,16,20,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,0,1,1,0,MSK,MSD,Moscow Standard Time,Moscow Daylight Time,0,Europe/Warsaw,3600000,3,-1,-1717032240,50,34,100,52,30,24,127,5040,4,8,4,83,-1,-1717032240,48,-36,-40,49,22,60,49,96,36,49,-103,-28,49,-24,-92,50,113,-128,50,-85,64,52,30,24,61,-56,4,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,18,-128,64,96,28,64,-91,-40,64,-29,92,65,37,100,65,115,-60,65,-83,-124,65,-9,4,66,54,4,66,124,-28,66,-66,-124,70,-40,-128,71,5,32,71,73,96,71,-115,-96,71,-23,-128,72,24,-64,72,93,0,72,-95,64,72,-6,-128,73,41,-64,73,-125,0,73,-78,64,74,11,-128,74,58,-64,74,-106,-96,74,-61,64,81,117,96,81,-73,0,81,-3,-32,82,66,32,82,-122,96,82,-54,-96,83,17,-128,83,83,32,83,-105,96,83,-37,-96,84,31,-32,84,100,32,84,-88,96,84,-20,-96,85,48,-32,85,119,-64,85,-68,0,86,0,64,86,68,-128,86,-120,-64,86,-51,0,87,17,64,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,5040,4,8,4,8,4,8,12,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Zagreb,3600000,1,-1,-2713915320,127,4920,4,39,-1,-2713915320,62,56,120,63,11,68,63,66,100,63,-119,68,63,-51,-124,64,17,-60,64,99,-124,64,-108,-92,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,4920,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,Europe/Zaporozhye,7200000,5,-1,-1441159324,56,109,88,62,114,52,63,-107,-100,88,-117,56,127,7324,8,12,4,12,8,40,-1,-1441159324,56,109,88,62,114,52,63,11,68,63,66,100,63,-119,68,63,-107,-100,83,-104,116,83,-35,16,84,33,84,84,101,-16,84,-86,52,84,-18,-48,85,51,116,85,119,-68,85,-69,-4,86,0,60,86,68,124,86,-120,-68,86,-52,-4,87,17,60,87,85,124,87,-103,-68,87,-35,-4,88,34,60,88,102,124,88,-117,56,89,53,-32,89,122,32,89,-66,96,90,2,-96,90,70,-32,90,-117,32,90,-49,96,91,19,-96,91,87,-32,91,-98,-64,91,-19,-124,92,39,68,92,118,4,127,7324,8,12,8,4,8,4,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,16,12,8,12,8,12,8,12,8,12,8,12,8,12,8,2,1048070274,-1367848824,1,1,0,EET,EEST,Eastern European Standard Time,Eastern European Summer Time,0,Europe/Zurich,3600000,2,-1,-3675198848,-1,-2385246586,127,2048,127,1786,4,40,-1,-3675198848,-1,-2385246586,62,62,-128,62,120,64,62,-57,0,63,0,-64,83,-105,100,83,-37,-92,84,31,-28,84,100,36,84,-88,100,84,-20,-92,85,48,-28,85,119,-60,85,-68,4,86,0,68,86,68,-124,86,-120,-60,86,-51,4,87,17,68,87,85,-124,87,-103,-60,87,-34,4,88,34,68,88,102,-124,88,-83,100,88,-15,-92,89,53,-28,89,122,36,89,-66,100,90,2,-92,90,70,-28,90,-117,36,90,-49,100,91,19,-92,91,87,-28,91,-98,-60,91,-19,-124,92,39,68,92,118,4,127,2048,127,1786,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,8,4,2,1048070210,-1367848888,1,1,0,CET,CEST,Central European Standard Time,Central European Summer Time,0,GMT,0,0,0,0,0,0,1,1,0,GMT,GMT,Greenwich Mean Time,Greenwich Mean Time,0,UTC,0,0,0,0,0,0,1,1,0,UTC,UTC,Coordinated Universal Time,Coordinated Universal Time,0").toString());

  private static String preventInlining(final String string){
    return string;
  }
}
