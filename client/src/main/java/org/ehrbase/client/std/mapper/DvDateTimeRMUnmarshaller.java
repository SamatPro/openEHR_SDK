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

package org.ehrbase.client.std.mapper;

import com.nedap.archie.datetime.DateTimeParsers;
import com.nedap.archie.rm.datavalues.quantity.datetime.DvDateTime;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class DvDateTimeRMUnmarshaller extends AbstractRMUnmarshaller<DvDateTime> {

    @Override
    public Class<DvDateTime> getRMClass() {
        return DvDateTime.class;
    }

    @Override
    public void handle(String termLoop, DvDateTime child, Map<String, String> values) {

        String s = values.get(termLoop);
        if (StringUtils.isNotBlank(s)) {
            child.setValue(DateTimeParsers.parseDateTimeValue(StringUtils.strip(s, "\"")));
            consumedPath.add(termLoop);
        }
    }
}
