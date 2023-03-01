/*
 * Copyright 2018-2023 Saad Ahmed
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
 */

import java.util.Date;

public class DateUtil {

    /**
     * @Author Saad Ahmed
     * @Date 03 March, 2023
     * Created to get day, month and year between two dates
     */

    private static DateUtil instance = null;

    /**
     * @<code>DateUtil.getInstance()</code> function returns the instance of DateUtil class
     * @return DateUtil instance
     */

    public static DateUtil getInstance() {
        if (instance == null) instance = new DateUtil();
        return instance;
    }

    /**
     * The function generates day, month and year between two dates
     * @param startDate is the beginning date
     * @param endDate is the end date
     * @param listener will be updated after generating day, month and year
     */

    public void dateToDayMonthYear(Date startDate, Date endDate, DateConversionListener listener) {
        long time = endDate.getTime() - startDate.getTime();

        long year = time / (365 * getOneDayTime());
        long leftYear = time % (365 * getOneDayTime());
        long month = leftYear / (30 * getOneDayTime());
        long leftMonth = leftYear % (30 * getOneDayTime());
        long day = leftMonth / getOneDayTime();

        listener.onYearGenerate(year);
        listener.onMonthGenerate(month);
        listener.onDayGenerate(day);
    }

    public interface DateConversionListener {
        void onDayGenerate(@NonNull Long day);
        void onMonthGenerate(@NonNull Long month);
        void onYearGenerate(@NonNull Long year);
    }

    private long getOneDayTime() {
        return 24L * 60 * 60 * 1000;
    }
}