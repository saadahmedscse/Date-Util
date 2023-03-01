## USAGE

```java
public void getDate() {
    String start = "27-01-1995";
    String end = "01-03-2023";

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

    Date startDate = sdf.parse(start);
    Date endDate = sdf.parse(end);

    DateUtil.getInstance().dateToDayMonthYear(startDate, endDate, new DateUtil.DateConversionListener() {
        @Override
        public void onDayGenerate(@NonNull Long day) {
            System.out.println("Day " + day);
        }

        @Override
        public void onMonthGenerate(@NonNull Long month) {
            System.out.println("Month " + month);
        }

        @Override
        public void onYearGenerate(@NonNull Long year) {
            System.out.println("Year " + year);
        }
    });
}
```

## OUTPUT

```java
// Day 10
// Month 1
// Year 28
```
