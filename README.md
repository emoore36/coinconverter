# coinconverter
A simple console app for converting D&amp;D coins to their appropriate display. Comes with both Java and Python implementations. Feel free to optimize or suggest edits.

## Installation
These files are created such that anyone who has Java and/or Python installed on their machine can easily run the project/file (respectively) on their device without any other setup.

- On PC, the most recent LTS JRE can be downloaded [here](https://www.java.com/en/download/). Java 7+ should suffice.
- On Mac, [to be updated later].
- On Linux, [to be updated later].

## Running
- To run the Java implementation, open the repo in a command terminal and type `java src\Main.java <list of coins, separated by spaces>`.
- To run the Python implementation, open the repo in a command terminal and type `py Main.py <list of coins, separated by spaces>`.

## Examples
- Java: `java src\Main.java 444cp` results in the following console output: `4gp 4cp 4sp`.
- Python: `py Main.py 44cp 44sp` results in the following console output: `4gp 8sp 4cp`.

## Notes
The above instructions and examples assume the use of a Windows OS.

For the Python implementation:
- For a Mac OS, type `python Main.py <coins to convert>`.
- For a Linux OS, type `python3 Main.py <coins to convert>`.

## Issues
- The hashing functionality of a `HashMap` might add unnecessary complexity. Considering using a different kind of ordered `Map` instead.
