//#1 - Sort 10 schools around your house by distance:
we can use insertion sort. Why? the input is only small. Only 10. 
It really fast on small data. It could be this 10 school
is already pre sorted.

//#2 - eBay sorts listings by the current Bid amount:
We can use radix or counting sort. Because a bid is always in numbers. 
And the numbers also already fix length and pre determined in range.

//#3 - Sport scores on ESPN
: We can use quick sort. Its going to be the most efficient.

//#4 - Massive database (can't fit all into memory) needs to sort through past year's user data
. Probbably need to sort externally. And by some sort of date usinng scheduler maybe.
in that case we can use merge sort.

//#5 - Almost sorted Udemy review data needs to update and add 2 new reviews
. In this case we can use insertion sort. Why? because we assuming most of the previous data is 
already sorted. So we only need to add 2 new data.

//#6 - Temperature Records for the past 50 years in Canada
. Radix and counting sort. Again its numbers and between a small range.
We also can use quick sort.

//#7 - Large user name database needs to be sorted. Data is very random.
Maybe we can use merge sort, if we have enough memory.
or we can use quick sort, if that database is not large enough.

//#8 - You want to teach sorting for the first time
Bubble sort and selection sort
