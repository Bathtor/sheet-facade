/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Lars Kroll <bathtor@googlemail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.lkroll.roll20.facade

import scalajs.js
import scalajs.js.annotation._
import scalajs.js.typedarray._

@js.native
@JSGlobalScope
object Roll20 extends js.Object {

  @js.native
  trait EventInfo extends js.Object {

    /**
      * The original attribute that triggered the event.
      * It is the full name (including RowID if in a repeating section) of the attribute that originally triggered this event.
      *
      * Note: The entire string will have been translated into lowercase and thus might not be suitable for being fed directly into getAttrs().
      */
    val sourceAttribute: String = js.native;

    /**
      * The agent that triggered the event, either player or sheetworker
      */
    val sourceType: String = js.native;
  }

  def on(event: String, callback: js.Function1[EventInfo, Unit]): Unit = js.native;
  def getAttrs(attributeNameArray: js.Array[String], callback: js.Function1[js.Dictionary[Any], Unit]): Unit =
    js.native;
  def setAttrs(values: js.Dictionary[js.Any], options: js.Object = null, callback: js.Function0[Unit] = null): Unit =
    js.native;
  def getSectionIDs(section_name: String, callback: js.Function1[js.Array[String], Unit]): Unit = js.native;
  def generateRowID(): String = js.native;
  def removeRepeatingRow(RowID: String): Unit = js.native;
  def getTranslationByKey(key: String): js.Any = js.native; // either String or false
  def getTranslationLanguage(): String = js.native;

  def getActiveCharacterId(): String = js.native;
  def getActiveRepeatingField(): String = js.native;
}
