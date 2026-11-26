# 🛡️ SSD Interactive Lab: Exception Handling & Defensive Architecture
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University) · Sudan Pudasaini**

```
Progress: [████████████░░░░░░] Step 2 of 3 (In Progress)
```

---

## 🎉 Step 1 Completed!
Excellent work refactoring `ArrayProcessor`! You eliminated the expensive loop termination anti-pattern and added defensive null handling.

---

## 🌿 Branching for Step 2

Create your feature branch for Step 2:

```bash
git checkout main
git pull origin main
git checkout -b feature/step2-custom-exception
```

---

## 📝 Step 2: Building Custom Domain Exceptions

Standard Java exceptions like `IllegalArgumentException` or `Exception` are often too generic to describe business domain logic. In professional systems (and in your SSD team project), you define **custom exceptions** that encapsulate domain-specific errors.

Open [`src/main/java/exceptions/InvalidOptionException.java`](src/main/java/exceptions/InvalidOptionException.java).

### Your Step 2 Tasks:

1. **Verify Class Inheritance:**
   * Ensure `InvalidOptionException` extends `java.lang.Exception`:
     ```java
     public class InvalidOptionException extends Exception
     ```
   * *Notice:* Because it extends `Exception` (and not `RuntimeException`), it is a **Checked Exception**. Callers are strictly required by the Java compiler to handle it via `try-catch` or declare it via `throws`.

2. **Implement Required Constructors:**
   * Default no-arg constructor:
     ```java
     public InvalidOptionException() {
         super();
     }
     ```
   * Constructor with error message:
     ```java
     public InvalidOptionException(String message) {
         super(message);
     }
     ```
   * Constructor with message and nested cause (exception chaining):
     ```java
     public InvalidOptionException(String message, Throwable cause) {
         super(message, cause);
     }
     ```

3. **Complete Javadoc Documentation:**
   * Add a complete class-level Javadoc comment including your name in an `@author` tag:
     ```java
     /**
      * Custom checked exception thrown when an invalid menu choice is submitted.
      * 
      * @author Sudan Pudasaini
      */
     ```

4. **Verify locally:**
   ```bash
   mvn test -Dtest=Step1ArrayProcessorTest,Step2CustomExceptionTest
   ```

5. **Commit, Merge & Push:**
   ```bash
   git add src/main/java/exceptions/InvalidOptionException.java
   git commit -m "feat: implement InvalidOptionException with message passing and cause chaining"
   git checkout main
   git merge feature/step2-custom-exception
   git push origin main
   ```
6. Check GitHub Actions! Pull `main` when finished to unlock **Step 3**.
