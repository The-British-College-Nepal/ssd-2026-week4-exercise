# 🛡️ SSD Interactive Lab: Exception Handling & Defensive Architecture
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University) · Sudan Pudasaini**

```
Progress: [████████████████████] 100% Completed! 🏆
```

---

# 🎓 Congratulations! You Have Mastered Week 4!

You have successfully completed the **Week 4 Exception Handling & Defensive Architecture** laboratory exercise!

---

### 🏆 Skills & Competencies Mastered:
1. **Anti-Pattern Elimination:** You replaced an expensive `while(true)` exception loop with clean, idiomatic Java and defensive null checks.
2. **Java Exception Hierarchy:** You understand the operational difference between `Error`, unchecked `RuntimeException`, and checked `Exception`.
3. **Custom Domain Exceptions:** You authored `InvalidOptionException` with message passing, cause chaining, and Javadoc standards.
4. **Contract Enforcement:** You practiced `throw` (action) vs `throws` (method declaration), validating domain bounds and protecting callers from corrupted states.
5. **Git Branching Mastery:** You executed isolated feature branches for each step, keeping your `main` branch stable and deployable.

---

### 🚀 Direct Link to Coursework (Team Project):
In your group software project, client nodes connect over network sockets. Applying what you learned today:
* You will never terminate threads on bad client inputs or malformed protocol packets.
* You will throw and catch domain exceptions like `ProtocolViolationException`, write informative error packets back to offending clients, and keep the server running 24/7!

*Great work, and see you in Week 5!*
