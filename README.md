# queueWithMultiThreading
Write a function which returns numeral from 0 to 9.
A lot of process started at the same time and request number from this function. Number is unique for each thread.
When process end it's job it return this number to main process and store it's own number in some array.
When number is released then one thread without this number should get it from main thread.

When all threads are complete print array of stored ids.
