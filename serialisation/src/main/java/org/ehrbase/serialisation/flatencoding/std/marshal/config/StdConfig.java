/*
 *
 *  *  Copyright (c) 2020  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *  *  This file is part of Project EHRbase
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *  http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *
 */

package org.ehrbase.serialisation.flatencoding.std.marshal.config;

import com.nedap.archie.rm.RMObject;
import org.ehrbase.serialisation.walker.Context;
import org.ehrbase.util.reflection.ClassDependent;

import java.util.Map;

/** Defines how terminal RMObjects will be marshalled to flat json */
public interface StdConfig<T extends RMObject> extends ClassDependent<T> {

  /**
   * @param currentTerm current flat term path
   * @param rmObject The {@link RMObject} to flatten
   * @param context
   * @return Map containing the flat representation of {@code rmObject}
   */
  Map<String, Object> buildChildValues(
      String currentTerm, T rmObject, Context<Map<String, Object>> context);
}
