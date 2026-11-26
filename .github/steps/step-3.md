# 🛡️ SSD Interactive Lab: Exception Handling & Defensive Architecture
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University) · Sudan Pudasaini**

```
Progress: [██████████████████] Step 3 of 3 (In Progress)
```

---

## 🎉 Step 2 Completed!
Outstanding! You built a robust, documented checked exception with support for message descriptions and nested exception chaining.

---

## 🌿 Branching for Step 3

Create your feature branch for Step 3:

```bash
git checkout main
git pull origin main
git checkout -b feature/step3-menu-validation
```

---

## 📝 Step 3: Menu Validation, Contract Enforcement & Defensive Caller

Now you will wire `InvalidOptionException` into a business component: the `Menu` class.

Open [`src/main/java/exceptions/Menu.java`](src/main/java/exceptions/Menu.java).

### Your Step 3 Tasks:

1. **Implement `displayMenuOption(int opt)`:**
   * Method signature must declare `throws InvalidOptionException`:
     ```java
     public void displayMenuOption(int opt) throws InvalidOptionException
     ```
   * Validate the input option. Valid options are between `1` and `3` inclusive (`1`, `2`, `3`).
   * If `opt < 1 || opt > 3`:
     ```java
     throw new InvalidOptionException("The option must be between 1 and 3");
     ```
   * If valid, print to standard output:
     ```java
     System.out.println("Menu option " + opt + " selected");
     ```

2. **Inspect and Test `selectOption(String optStr)`:**
   * Review how `selectOption` wraps `Integer.parseInt` in a `try-catch (NumberFormatException e)` block and rethrows it as an `InvalidOptionException` with the original exception chained as the cause.

3. **Run the Defensive `Driver.java`:**
   * Open [`src/main/java/exceptions/Driver.java`](src/main/java/exceptions/Driver.java).
   * Run `Driver.main()` to observe defensive `try-catch-finally` handling invalid options without crashing the program.

4. **Verify all tests locally:**
   ```bash
   mvn test
   ```
   All tests in `Step1ArrayProcessorTest`, `Step2CustomExceptionTest`, and `Step3MenuValidationTest` must pass!

5. **Commit, Merge & Push:**
   ```bash
   git add src/main/java/exceptions/Menu.java
   git commit -m "feat: enforce option bounds validation with InvalidOptionException"
   git checkout main
   git merge feature/step3-menu-validation
   git push origin main
   ```
6. Check your GitHub Actions tab. When tests pass, you will receive your **Lab 4 Completion Badge**!
