/*
 * Copyright (c) 2020 Christian Chevalley (Hannover Medical School).
 *
 * This file is part of project EHRbase
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ehrbase.serialisation.attributes;

import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.serialisation.dbencoding.CompositionSerializer;
import org.ehrbase.serialisation.dbencoding.PathMap;
import org.ehrbase.serialisation.dbencoding.wrappers.json.I_DvTypeAdapter;
import org.ehrbase.serialisation.util.SnakeCase;

import java.util.Map;

import static org.ehrbase.serialisation.dbencoding.CompositionSerializer.TAG_CLASS;
/** populate the attributes for RM PartySelf */
public class PartySelfAttributes implements I_SubjectAttributes {

  PartySelf partySelf;
  CompositionSerializer compositionSerializer;

  public PartySelfAttributes(PartySelf partySelf, CompositionSerializer compositionSerializer) {
    this.partySelf = partySelf;
    this.compositionSerializer = compositionSerializer;
  }

  public Map<String, Object> toMap() {
    Map<String, Object> valuemap = PathMap.getInstance();

    valuemap.put(TAG_CLASS, partySelf.getClass().getSimpleName());
    valuemap.put(
        I_DvTypeAdapter.AT_TYPE,
        new SnakeCase(partySelf.getClass().getSimpleName()).camelToUpperSnake());

    return valuemap;
  }
}
