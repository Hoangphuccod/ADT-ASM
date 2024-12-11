import java.util.Random;
public class StudentStack {
    MyStack<Student> studentStack;

    public StudentStack() {
        studentStack = new MyStack<>();
    }

    public void pushStudent(Student student) {
        studentStack.push(student);
    }

    public Student popStudent() {
        return studentStack.pop();
    }
    public void generateRandomStudents(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String id = "S" + (10000 + random.nextInt(90000));
            String name = generateRandomName(random);
            double marks = Math.round((1 + random.nextDouble() * 9) * 10.0) / 10.0;
            pushStudent(new Student(id, name, marks));
        }
    }

    private String generateRandomName(Random random) {
        int length = 5 + random.nextInt(6);
        StringBuilder name = new StringBuilder();
        name.append((char) ('A' + random.nextInt(26)));
        for (int i = 1; i < length; i++) {
            name.append((char) ('a' + random.nextInt(26)));
        }
        return name.toString();
    }
    public boolean addStudent(Student student) {
        MyStack<Student> tempStack = new MyStack<>();
        boolean studentExists = false;

        while (!studentStack.isEmpty()) {
            Student existingStudent = studentStack.pop();
            if (existingStudent.getId().equals(student.getId())) {
                studentExists = true;
            }
            tempStack.push(existingStudent);
        }

        if (!studentExists) {
            studentStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return !studentExists;
    }

    public boolean deleteStudent(String id) {
        MyStack<Student> tempStack = new MyStack<>();
        boolean studentFound = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                studentFound = true;
                break;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return studentFound;
    }

    public Student searchStudent(String id) {
        MyStack<Student> tempStack = new MyStack<>();
        Student foundStudent = null;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                foundStudent = student;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return foundStudent;
    }

    public boolean editStudent(String id, String newName, double newMarks) {
        MyStack<Student> tempStack = new MyStack<>();
        boolean studentFound = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                studentFound = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return studentFound;
    }

    public MyStack<Student> cloneStack() {
        MyStack<Student> tempStack = new MyStack<>();
        MyStack<Student> clonedStack = new MyStack<>();

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            Student student = tempStack.pop();
            studentStack.push(student);
            clonedStack.push(student);
        }

        return clonedStack;
    }
    public void quickSort(MyStack<Student> stack) {
        if (stack.size() <= 1) return;

        Random random = new Random();
        int randomIndex = random.nextInt(stack.size());
        MyStack<Student> tempStack = new MyStack<>();

        Student pivot = null;
        for (int i = 0; i <= randomIndex; i++) {
            pivot = stack.pop();
            tempStack.push(pivot);
        }

        MyStack<Student> left = new MyStack<>();
        MyStack<Student> right = new MyStack<>();

        while (!stack.isEmpty()) {
            Student student = stack.pop();
            if (student.getMarks() <= pivot.getMarks()) {
                left.push(student);
            } else {
                right.push(student);
            }
        }

        quickSort(left);
        quickSort(right);

        while (!right.isEmpty()) stack.push(right.pop());
        stack.push(pivot);
        while (!left.isEmpty()) stack.push(left.pop());
        while (!tempStack.isEmpty()) stack.push(tempStack.pop());
    }

    public void bubbleSort(MyStack<Student> stack) {
        Student[] students = stack.toArray(new Student[0]);
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        stack.clear();
        for (int i = students.length - 1; i >= 0; i--) {
            stack.push(students[i]);
        }
    }

    public MyStack<Student> mergeSort(MyStack<Student> stack) {
        if (stack.size() <= 1) return stack;

        MyStack<Student> left = new MyStack<>();
        MyStack<Student> right = new MyStack<>();

        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            left.push(stack.pop());
        }

        while (!stack.isEmpty()) {
            right.push(stack.pop());
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private MyStack<Student> merge(MyStack<Student> left, MyStack<Student> right) {
        MyStack<Student> result = new MyStack<>();
        MyStack<Student> temp = new MyStack<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek().getMarks() <= right.peek().getMarks()) {
                temp.push(left.pop());
            } else {
                temp.push(right.pop());
            }
        }

        while (!left.isEmpty()) temp.push(left.pop());
        while (!right.isEmpty()) temp.push(right.pop());

        while (!temp.isEmpty()) result.push(temp.pop());

        return result;
    }
    public void displayStudents() {
        MyStack<Student> tempStack = new MyStack<>();

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
    }
}
