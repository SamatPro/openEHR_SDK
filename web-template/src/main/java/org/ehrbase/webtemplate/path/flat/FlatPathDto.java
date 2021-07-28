/*
 *  Copyright (c) 2021  Stefan Spiska (Vitasystems GmbH) and Hannover Medical School
 *
 *  This file is part of Project EHRbase
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.ehrbase.webtemplate.path.flat;

import org.apache.commons.lang3.StringUtils;
import org.ehrbase.webtemplate.parser.FlatPath;

public class FlatPathDto {

  private String name;
  private FlatPathDto child;
  private String attributeName;
  private Integer count;

  public FlatPathDto() {}

  public FlatPathDto(FlatPathDto flatPathDto) {
    this.name = flatPathDto.getName();
    this.child = flatPathDto.getChild();
    this.attributeName = flatPathDto.getAttributeName();
    this.count = flatPathDto.getCount();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FlatPathDto getChild() {
    return child;
  }

  public void setChild(FlatPathDto child) {
    this.child = child;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String format() {
    StringBuilder sb = new StringBuilder();

    sb.append(name);

    if (child != null) {
      sb.append('/').append(child.format());
    }

    if(count != null){
      sb.append(':').append(count);
    }

    if (attributeName != null) {
      sb.append('|').append(attributeName);
    }

    return sb.toString();
  }
}
