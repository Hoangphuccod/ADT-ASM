public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement() {
        studentStack = new StudentStack();
    }

    public void addStudent(Student student) {
        if (studentStack.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student already exists!");
        }
    }

    public void editStudent(String id, String newName, double newMarks) {
        if (studentStack.editStudent(id, newName, newMarks)) {
            System.out.println("Student edited successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void deleteStudent(String id) {
        if (studentStack.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void searchStudent(String id) {
        Student student = studentStack.searchStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayStudents() {
        studentStack.displayStudents();
    }

    public void generateRandomStudents(int count) {
        studentStack.generateRandomStudents(count);
        System.out.println(count + " students generated.\n");

        long startTimeBubbleSort = System.nanoTime();
        studentStack.bubbleSort(studentStack.studentStack);
        long endTimeBubbleSort = System.nanoTime();
        long bubbleSortTime = endTimeBubbleSort - startTimeBubbleSort;

        long startTimeQuickSort = System.nanoTime();
        studentStack.quickSort(studentStack.studentStack);
        long endTimeQuickSort = System.nanoTime();
        long quickSortTime = endTimeQuickSort - startTimeQuickSort;

        long startTimeMergeSort = System.nanoTime();
        studentStack.mergeSort(studentStack.studentStack);
        long endTimeMergeSort = System.nanoTime();
        long mergeSortTime = endTimeMergeSort - startTimeMergeSort;

        studentStack.displayStudents();
        System.out.println("\nQuick Sort Time: " + quickSortTime + " nanoseconds");
        System.out.println("\nMerge Sort Time: " + mergeSortTime + " nanoseconds");
        System.out.println("\nBubble Sort Time: " + bubbleSortTime + " nanoseconds");
    }
}