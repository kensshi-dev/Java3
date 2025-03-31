# JAVA 3
# **Date Class Implementation in Java**  

## **Project Overview**  
This project implements a `Date` class in Java to represent and manipulate dates. The class supports:  
**Date validation** (including leap years)  
**Day of the week calculation**  
**Date difference in days**  
**Date comparison & sorting**  
**Readable date formatting**  

The program demonstrates these features with a `Main` class that tests various operations.  

---

1. **Compile the Java files:**  
   ```bash
   javac Date.java Main.java
   ```  

2. **Run the program:**  
   ```bash
   java Main
   ```  

### **Expected Output**  
The program will:  
- Create valid and invalid `Date` objects.  
- Update a date and print it.  
- Compute the day of the week.  
- Calculate the difference between two dates.  
- Sort a list of dates and display them.  

---

## **Class Structure**  

### **`Date.java`**  
| Method | Description |  
|--------|-------------|  
| `isValidDate()` | Checks if the date is valid (e.g., `February 30` → invalid). |  
| `updateDate(int d, int m, int y)` | Updates the date after validation. |  
| `getDayOfWeek()` | Returns the day (e.g., `"Monday"`). |  
| `calculateDifference(Date other)` | Returns the difference in days between two dates. |  
| `printDate()` | Prints the date in `"Month Day, Year"` format (e.g., `"January 1, 2023"`). |  
| `compareTo(Date other)` | Enables sorting by year → month → day. |  

### **`Main.java**  
Demonstrates:  
- Creating `Date` objects.  
- Testing validation, updates, and calculations.  
- Sorting a list of dates using `Collections.sort()`.  

---

## **Example Code **  

### **1. Creating a Valid Date**  
```java
Date today = new Date(15, 10, 2023); // October 15, 2023
if (today.isValidDate()) {
    System.out.println("Date is valid!");
}
```

### **2. Calculating Day of the Week**  
```java
System.out.println(today.getDayOfWeek()); // Output: "Sunday"
```

---

## **Repository Structure**  
```
java-date-class/  
├── Date.java          # Date class implementation  
├── Main.java          # Demo program  
└── README.md          # This file  
```

---
