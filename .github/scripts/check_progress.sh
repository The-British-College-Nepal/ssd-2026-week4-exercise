#!/usr/bin/env bash
# Automated Evaluation & Step Advancement Script for SSD Week 4 Lab
# Evaluates Unit Tests and advances README.md upon successful merge to main

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
STEP_FILE="$REPO_ROOT/.github/current_step.txt"
STEPS_DIR="$REPO_ROOT/.github/steps"
README_FILE="$REPO_ROOT/README.md"

cd "$REPO_ROOT"

# Determine current step (defaults to 1)
CURRENT_STEP=1
if [ -f "$STEP_FILE" ]; then
  CURRENT_STEP=$(cat "$STEP_FILE" | tr -d '[:space:]')
fi

echo "============================================================"
echo "🤖 SSD Interactive Lab Evaluator — Week 4 (Exceptions)"
echo "   Current Step: $CURRENT_STEP"
echo "============================================================"

ADVANCED=false

if [ "$CURRENT_STEP" = "1" ]; then
  echo "🔍 Evaluating Step 1: ArrayProcessor Anti-Pattern Refactoring..."
  if mvn -B test -Dtest=Step1ArrayProcessorTest; then
    echo "✅ Step 1 tests passed!"
    echo "2" > "$STEP_FILE"
    cp "$STEPS_DIR/step-2.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 2: Custom Checked Exceptions (InvalidOptionException)"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 1 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great job refactoring the loop exception anti-pattern into clean defensive Java! Your repository has been updated with instructions for **Step 2: Custom Checked Exceptions (InvalidOptionException)**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull origin main\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 1 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 1 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review \`src/main/java/exceptions/ArrayProcessor.java\`:" >> "$GITHUB_STEP_SUMMARY"
      echo "* Eliminate the \`while (true)\` loop that relies on \`ArrayIndexOutOfBoundsException\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Use defensive programming: if \`a == null\` return \`0\`, otherwise return \`a.length\`." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "2" ]; then
  echo "🔍 Evaluating Step 2: Custom Checked Exceptions..."
  if mvn -B test -Dtest=Step1ArrayProcessorTest,Step2CustomExceptionTest; then
    echo "✅ Step 2 tests passed!"
    echo "3" > "$STEP_FILE"
    cp "$STEPS_DIR/step-3.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 3: Menu Validation, Throws & Defensive Caller"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 2 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great work implementing and documenting your custom checked exception! Your repository has been updated with instructions for **Step 3: Menu Validation, Throws & Defensive Caller**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull origin main\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 2 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 2 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review \`src/main/java/exceptions/InvalidOptionException.java\`:" >> "$GITHUB_STEP_SUMMARY"
      echo "* Ensure it extends \`java.lang.Exception\` (Checked Exception)." >> "$GITHUB_STEP_SUMMARY"
      echo "* Provide constructor accepting \`String message\` and calling \`super(message)\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Provide constructor accepting \`String message, Throwable cause\` and calling \`super(message, cause)\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Include Javadoc comment with \`@author\` tag." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "3" ]; then
  echo "🔍 Evaluating Step 3: Menu Validation & Defensive Execution..."
  if mvn -B test; then
    echo "✅ Step 3 tests passed! Exercise fully completed!"
    echo "completed" > "$STEP_FILE"
    cp "$STEPS_DIR/completed.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Exercise Completed"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🏆 100% Complete! All Steps Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "You have successfully completed Week 4: Exception Handling & Defensive Architecture! Your README has been updated to the completion badge." >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 3 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 3 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your validation logic in \`src/main/java/exceptions/Menu.java\`:" >> "$GITHUB_STEP_SUMMARY"
      echo "* In \`displayMenuOption(int opt)\`, if \`opt < 1 || opt > 3\`, throw \`new InvalidOptionException(\"The option must be between 1 and 3\")\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Method signature MUST declare \`throws InvalidOptionException\`." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

else
  echo "🎉 Lab was already completed. Verifying all tests remain green..."
  mvn -B test
  if [ -n "$GITHUB_STEP_SUMMARY" ]; then
    echo "## ✅ All Tests Passing (Lab Complete)" >> "$GITHUB_STEP_SUMMARY"
  fi
fi

# If the step advanced, commit and push changes back to the student repo
if [ "$ADVANCED" = "true" ]; then
  echo "🚀 Committing updated README and advancing step to: $NEXT_STEP"
  git config user.name "github-actions[bot]"
  git config user.email "github-actions[bot]@users.noreply.github.com"
  git add "$README_FILE" "$STEP_FILE"
  git commit -m "🤖 [GitHub Skills] Advance to $NEXT_STEP [skip ci]"
  git push origin main
  echo "✅ Step successfully unlocked!"
fi
