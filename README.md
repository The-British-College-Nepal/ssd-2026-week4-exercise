# 🛡️ SSD Interactive Lab: Exception Handling & Defensive Architecture
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University) · Sudan Pudasaini**

```
Progress: [██████░░░░░░░░░░░░] Step 1 of 3 (In Progress)
```

---

> [!IMPORTANT]
> ### 🏷️ Repository Creation & Naming Convention
> Before writing any code, you must create your own copy of this lab repository:
> 1. Click the green **"Use this template"** ➡️ **"Create a new repository"** button at the top right of this page (or click **Fork**).
> 2. **Owner:** Select **`The-British-College-Nepal`** (or your own GitHub account).
> 3. **Repository Name:** You **MUST** strictly follow this exact naming format:
>    ```text
>    <your-name>-ssd-2026-week4-exercise
>    ```
>    * ✅ **Correct Examples:**
>      * `sudan-ssd-2026-week4-exercise`
>      * `crystal-ssd-2026-week4-exercise`
>      * `garima-ssd-2026-week4-exercise`
>      * `sujal-ssd-2026-week4-exercise`
>      * `roshan-ssd-2026-week4-exercise`
>    * ❌ **Incorrect Examples:** `week4`, `my-lab4`, `exercise4`, `ExceptionsLab`.
> 4. **Visibility:** Select **Public**.
> 5. Click **"Create repository"**.
> 6. Clone your newly created repository to your laptop/lab machine:
>    ```bash
>    git clone https://github.com/The-British-College-Nepal/<your-name>-ssd-2026-week4-exercise.git
>    cd <your-name>-ssd-2026-week4-exercise
>    ```

---

## 🎯 Welcome to Your Week 4 Interactive Lab!

Welcome! In software engineering, writing code that runs smoothly on the "happy path" is only half the battle. Professional software must be **robust, fault-tolerant, and defensive**—surviving unexpected user inputs, corrupted network packets, and missing files without crashing.

In this interactive lab, you will explore the Java Exception handling framework:
1. **Analyze and eliminate an egregious anti-pattern:** using exceptions for normal loop termination.
2. **Build custom domain-specific checked exceptions:** extending `Exception` with full message passing and cause chaining.
3. **Enforce contracts with `throw` and `throws`:** validating business bounds and catching exceptions defensively.

Just like GitHub Skills:
1. You work on your dedicated feature branch.
2. Verify your code with JUnit 5 unit tests locally.
3. Merge your branch into `main` and push to GitHub.
4. GitHub Actions automatically tests your code.
5. When your tests pass, **this README automatically updates to reveal Step 2!**

---

## 🌿 The Git Branching Rule for Week 4

> [!IMPORTANT]
> ### 📢 In-Lab Policy: Work in a Feature Branch!
> Never commit directly to `main`. Create an isolated feature branch for Step 1, verify your tests locally, and merge into `main` only when ready.

Open your terminal inside your cloned repository and switch to a new branch (or run `./start_exercise.sh`):

```bash
# 1. Ensure your local main is up to date
git checkout main
git pull origin main

# 2. Create and switch to your Step 1 feature branch
git checkout -b feature/step1-array-processor

# 3. Confirm you are on your new branch (look for the * asterisk)
git branch
```

---

## 📝 Step 1: Eliminating the Loop Exception Anti-Pattern

Open [`src/main/java/exceptions/ArrayProcessor.java`](src/main/java/exceptions/ArrayProcessor.java) in your IDE.

Look at the initial implementation of `getArrayLength`:

```java
public int getArrayLength(Object[] a) {
    int count = 0;
    try {
        while (true) {
            Object t = a[count];
            count++;
        }
    } catch (Exception e) {
        // Anti-pattern: used to find end of array!
    }
    return count;
}
```

### Why is this code considered a severe defect?
1. **Extreme Performance Penalty:** Constructing an exception object causes the JVM to capture the entire execution call stack frame by frame. Running this in a loop can be **up to 100x slower** than standard iteration.
2. **Masks Real Bugs:** If `a` is `null`, accessing `a[count]` throws a `NullPointerException`. The catch block swallows it silently, giving the caller a fake count of `0` instead of alerting them to the null state!
3. **Violates Software Conventions:** Exceptions should represent *exceptional conditions*, never everyday control flow iteration.

### Your Step 1 Tasks:
1. **Refactor `getArrayLength(Object[] a)`:**
   * Remove the `while (true)` loop and the `try-catch` block entirely.
   * If `a` is `null`, defensively return `0`.
   * Otherwise, return `a.length`.
2. **Verify locally:**
   ```bash
   mvn test -Dtest=Step1ArrayProcessorTest
   ```
3. **Commit, Merge & Push:**
   ```bash
   git add src/main/java/exceptions/ArrayProcessor.java
   git commit -m "refactor: eliminate loop exception anti-pattern in ArrayProcessor"
   git checkout main
   git merge feature/step1-array-processor
   git push origin main
   ```
4. Once pushed, check your GitHub Actions tab. When tests pass, pull `main` locally to see **Step 2**!
   ```bash
   git pull origin main
   ```
